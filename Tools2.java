import java.util.*;
import java.sql.*;
import java.io.*;

class NameGeneratorUtility{
private NameGeneratorUtility(){}
public static String getClassName(String tableName){
String className=tableName.substring(0,1).toUpperCase();
char g;
//first  char is been capitalized
int i=1;
while(i<tableName.length()){
g=tableName.charAt(i);
if(g=='_'){
i++;
while(i<tableName.length()){
if(g!='_'){
className=className+String.valueOf(g).toUpperCase();
break;
}
i++;
}
}
else{
className=className+String.valueOf(g);
}
i++;
}
return className;
}
public static String getPropertyName(String columnName){
String propertyName=columnName.substring(0,1).toLowerCase();
char g;
int i=1;
while(i<columnName.length()){
g=columnName.charAt(i);
if(g=='_'){
i++;
while(i<columnName.length()){
g=columnName.charAt(i);
if(g!='_'){
propertyName=propertyName+String.valueOf(g).toUpperCase();
break;
}
i++;
}
}
else{
propertyName=propertyName+String.valueOf(g);
}
i++;
}
return propertyName;
}
public static String getSetterName(String propertyName){
String setterName;
setterName="set" + String.valueOf(propertyName.charAt(0)).toUpperCase();
setterName=setterName+propertyName.substring(1);
return setterName; 
}

public static String getGetterName(String propertyName){
String getterName;
getterName="get" + String.valueOf(propertyName.charAt(0)).toUpperCase();
getterName=getterName+propertyName.substring(1);
return getterName; 
}


}
class Column {
    public String name;
    public String dataType;
    public boolean isPrimaryKey;
    public boolean isAutoIncrement;
}

class Table {
    public String name;
    public List<Column> columns = new ArrayList<Column>();
}

class Database {
    public List<Table> table = new ArrayList<Table>();
}

class DatabaseUtility {

private static Map<String,String> mysqlJavaTypesMap;
static{
mysqlJavaTypesMap=new HashMap<String,String>();
mysqlJavaTypesMap.put("INT","Integer");
mysqlJavaTypesMap.put("INTEGER","Integer");
mysqlJavaTypesMap.put("CHAR","String");
mysqlJavaTypesMap.put("DATE","java.sql.Date");
mysqlJavaTypesMap.put("DECIMAL","java.math.BigDecimal");
mysqlJavaTypesMap.put("DOUBLE","Double");
mysqlJavaTypesMap.put("BOOLEAN","Boolean");
mysqlJavaTypesMap.put("BOOL","Boolean");
mysqlJavaTypesMap.put("BIGINT","Long");
mysqlJavaTypesMap.put("VARCHAR","String ");
}

private DatabaseUtility(){}
    
public static String getJavaType(String columnType){
return mysqlJavaTypesMap.get(columnType.toUpperCase());
}

public static String getDefaultValue(String javaType){
if(javaType.equals("Long") || javaType.equals("long")) return "(long)0";
if(javaType.equals("Integer") || javaType.equals("int")) return "(int)0";
if(javaType.equals("Short") || javaType.equals("short")) return "(short)0";
if(javaType.equals("Byte") || javaType.equals("byte")) return "(byte)0";
if(javaType.equals("Double") || javaType.equals("double")) return "(double)0.0";
if(javaType.equals("Float") || javaType.equals("float")) return "(float)0.0f";
if(javaType.equals("Character") || javaType.equals("char")) return "(char)0";
if(javaType.equals("Boolean") || javaType.equals("boolean")) return "false";
if(javaType.equals("String")) return "\"\"";
if(javaType.equals("java.math.BigDecimal")) return "new java.math.BigDecimal(\"0.0\")";
return null;
}

public static Database getDatabase(String driver, String connectionString, String username, String password){
        Database database = new Database();
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            // Establish Connection
            Class.forName(driver);
            connection = DriverManager.getConnection(connectionString, username, password);

            // Database analysis using DatabaseMetaData
            DatabaseMetaData databaseMetaData;
            String types[] = {"TABLE"};

            databaseMetaData = connection.getMetaData();

            // Fetch all tables
            resultSet = databaseMetaData.getTables(null, null, null, types);
            while (resultSet.next()) {
                Table table = new Table();
                table.name = resultSet.getString("TABLE_NAME").trim();
                database.table.add(table);
            }

            // Fetch names of all columns of a table
            for (Table t : database.table) {
                resultSet = databaseMetaData.getColumns(null, null, t.name, null);
                while (resultSet.next()) {
                    Column column = new Column();
                    column.name = resultSet.getString("COLUMN_NAME").trim();
                    column.dataType = resultSet.getString("TYPE_NAME").trim();
                    String isAuto = resultSet.getString("IS_AUTOINCREMENT").trim();
                    column.isAutoIncrement = isAuto.equalsIgnoreCase("yes");
                    t.columns.add(column);
                }
            }

            // Fetch primary key columns
            for (Table t : database.table) {
                resultSet = databaseMetaData.getPrimaryKeys(null, null, t.name);
                while (resultSet.next()) {
                    String primaryKeyColumnName = resultSet.getString("COLUMN_NAME").trim();
                    for (Column c : t.columns) {
                        if (c.name.equalsIgnoreCase(primaryKeyColumnName)) {
                            c.isPrimaryKey = true;
                            break;
                        }
                    }
                }
            }
        } catch (Exception exception) {
            System.out.println(exception);
            System.exit(0);
        } 
        return database;
    }
    // Method to create DTO
public static void createDTO(Table table,String folderName){
String classFileName = NameGeneratorUtility.getClassName(table.name);
String classFilePath = folderName+File.separator+classFileName+".java";
String javaType;
String propertyName;
String defaultValue;
String setterName;
String getterName;

try{
File file = new File(classFilePath);
RandomAccessFile randomAccessFile;
randomAccessFile = new RandomAccessFile(file,"rw");
randomAccessFile.writeBytes("import java.io.*;\r\n");
randomAccessFile.writeBytes("public class " + classFileName+" implements Serializable\r\n");
randomAccessFile.writeBytes("{\r\n");

//code to generate properties starts here
for(Column c:table.columns){
  propertyName=NameGeneratorUtility.getPropertyName(c.name);
  javaType=getJavaType(c.dataType);
  randomAccessFile.writeBytes("private "+javaType+" "+propertyName+";\r\n");
}
//ends here

//code to generate constructer starts here
randomAccessFile.writeBytes("public "+classFileName+"()\r\n");
randomAccessFile.writeBytes("{\r\n");
for(Column c:table.columns){
  propertyName=NameGeneratorUtility.getPropertyName(c.name);
  javaType=getJavaType(c.dataType);
  defaultValue=getDefaultValue(javaType);
  randomAccessFile.writeBytes("this." + propertyName + "=" +defaultValue+";\r\n");
}
randomAccessFile.writeBytes("}\r\n"); // Closing brace for constructor
//ends here

//code to generate setter and getter

for(Column c:table.columns){
  propertyName=NameGeneratorUtility.getPropertyName(c.name);
  javaType=getJavaType(c.dataType);

  setterName=NameGeneratorUtility.getSetterName(propertyName);
  randomAccessFile.writeBytes("public void " + setterName + "(" +javaType+" " + propertyName+")\r\n");
  randomAccessFile.writeBytes("{\r\n");
  randomAccessFile.writeBytes("this."+propertyName+"="+propertyName+";\r\n"); // Remove semicolon
  randomAccessFile.writeBytes("}\r\n");

  getterName=NameGeneratorUtility.getGetterName(propertyName);
  randomAccessFile.writeBytes("public "+javaType+" "+getterName+"()\r\n");
  randomAccessFile.writeBytes("{\r\n");
  randomAccessFile.writeBytes("return this."+propertyName+";\r\n");
  randomAccessFile.writeBytes("}\r\n");
}

//code to generat equals method

randomAccessFile.writeBytes("public boolean equals(Object obj) {\r\n");
randomAccessFile.writeBytes("if (this == obj){\r\n");
randomAccessFile.writeBytes("return true;\r\n");
randomAccessFile.writeBytes("}\r\n");
randomAccessFile.writeBytes("if (obj == null ){\r\n");
randomAccessFile.writeBytes("return false;\r\n");
randomAccessFile.writeBytes("}\r\n");
randomAccessFile.writeBytes("return false;\r\n");
randomAccessFile.writeBytes("}\r\n");

//ends here

randomAccessFile.writeBytes("}\r\n");
randomAccessFile.close();
}catch(IOException ioException){
System.out.println(ioException);
System.exit(0);
}
}
}

class Tools2{
    public static void main(String[] args)throws SQLException {
        String driver = args[0];
        String connectionString = args[1];
        String username = args[2];
        String password = args[3];
        String folderName = args[4];
File folderPath = new File(folderName);
if(folderPath.exists()==false){
System.out.println(folderPath+"does not exit");
return ;
}
if(folderPath.isDirectory()==false){
System.out.println(folderPath+"is not a drectory");
return ;
}
// code to check;
Database database;
database = DatabaseUtility.getDatabase(driver,connectionString,username,password);

for(Table table:database.table){
DatabaseUtility.createDTO(table,folderName);
}
}
}
