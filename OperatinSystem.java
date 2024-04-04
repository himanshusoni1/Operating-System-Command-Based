import java.util.*;
import java.text.*;
import java.awt.Graphics;
import java.awt.*;

public class Operating_System {

    static String pasw;
    int pass_req = 0;

    void help() {

    }

    void menu() {
        int sto;
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO COMMAND BASED OS");
        for (;;) {
            System.out.println("MENU :");
            System.out.println("1: CONTACTS");
            System.out.println("2: NOTES");
            System.out.println("3: HELP");
            System.out.println("4: CALENDER");
            System.out.println("5: GAMES");
            System.out.println("6: DICTIONARY");
            System.out.println("7: CALCULATOR");
            System.out.println("8: SETTINGS");
            System.out.println("9: SHUT DOWN");
            sto = sc.nextInt();
            if (sto == 1) {
                contacts();
            } else if (sto == 2) {
                notepad();
            } else if (sto == 3) {
                help();
            } else if (sto == 4) {
                calender();
            } else if (sto == 5) {
                games();
            } else if (sto == 6) {
                dictionary();
            } else if (sto == 7) {
                calculator();
            } else if (sto == 8) {
                settings();
            } else {
                System.out.println("Byeee...");
                break;
            }
        }
    }

    void AboutOS() {

    }

    void settings() {
        int ch;
        Scanner sc = new Scanner(System.in);
        ScreenSaver ob1 = new ScreenSaver();
        System.out.println("1: ABOUT OS");
        System.out.println("2: ENABLE SCREENSAVER");
        System.out.println("3: CHANGE PASSWORD");
        ch = sc.nextInt();
        switch (ch) {
            case 1:
                AboutOS();
                break;
            case 2:
                ob1.screenenable();
                break;
            case 3:
                password_change();
                break;
            default:
                menu();
                break;
        }
    }

    void contacts() {

    }

    void dictionary() {

    }

    void games() {
        Cross_Zero ob1 = new Cross_Zero();
        ChessGame ob2 = new ChessGame();
        Searching_Puzzle ob3 = new Searching_Puzzle();
        MindReader ob4 = new MindReader();
        Scanner sc = new Scanner(System.in);
        int sto;
        System.out.println("WELCOME TO GAME MENU...  ");
        System.out.println("ENTER YOUR CHOICE : ");
        System.out.println("1: TICTACTOE");
        System.out.println("2: CHESS");
        System.out.println("3: SEARCHING WORDS");
        System.out.println("4: MIND READER");
        System.out.println("5: RETURN TO MAIN MENU");
        sto = sc.nextInt();
        if (sto == 1) {
            ob1.CrossZero();
        } else if (sto == 2) {
            ob2.chessplay();
        } else if (sto == 3) {
            ob3.searching_words();
        } else if (sto == 4) {
            ob4.mindread();
        } else {
            System.out.println("CLOSING GAME MENU...");
            for (double i = 0.01; i <= 100000; i = i + 0.01);
        }
    }

    void calculator() {

    }

    void calender() {
        Calender ob = new Calender();
        ob.work();
    }

    void notepad() {

    }

    void lock_screen() {
        Date date = new Date();
        SimpleDateFormat date1 = new SimpleDateFormat("dd.MM.yyyy");
        // SimpleDateFormat day1=new SimpleDateFormat("EEEE"); FOR DAY NAME
        SimpleDateFormat time1 = new SimpleDateFormat("hh:mm a");
        System.out.println("                                    ");
        System.out.println("        ...PEOPLE WORLD...          ");
        System.out.println("                                    ");
        System.out.println("                 *                  ");
        System.out.println("               *   *                ");
        System.out.println("             *       *              ");
        System.out.println("           *___________*            ");
        System.out.println("             |       |              ");
        System.out.println("             |       |              ");
        System.out.println("             |_______|              ");
        System.out.println("                                    ");
        System.out.println("                                    ");
        System.out.println("         COMMAND BASED OS           ");
        System.out.println("                                    ");
        System.out.println(" TIME :  " + time1.format(date));
        System.out.println(" DATE : " + date1.format(date));
        System.out.println("                                    ");
    }

    void password_change() {
        Scanner sc = new Scanner(System.in);
        String sto;
        System.out.println("ENTER OLD PASSWORD");
        sto = sc.next();
        if (sto.equals(pasw)) {
            System.out.println("ENTER NEW PASSWORD");
            pasw = sc.next();
        } else {
            System.out.println("WRONG PASSWORD,AUTHORIZATION FAILED");
        }
    }

    public static void main(String[] args) {
        Operating_System obj = new Operating_System();
        obj.lock_screen();
        Scanner sc = new Scanner(System.in);
        String pass;
        pasw = "Java Codes";
        System.out.print(" ENTER PASSWORD : ");
        pass = sc.nextLine();
        if (pass.equals(pasw)) {
            obj.menu();
        } else {
            System.out.println("WRONG PASSWORD,AUTHORIZATION FAILED...");
        }
    }
}

class ScreenSaver extends Frame {

    public void paint(Graphics g) {
        g.setColor(Color.black);
        for (;;) {
            int x = (int) (Math.random() * 1500);
            int y = (int) (Math.random() * 900);
            g.drawLine(x, y, x, y);
        }
    }

    public void screenenable() {
        ScreenSaver ob = new ScreenSaver();
        ob.setBackground(Color.white);
        ob.setSize(90, 700);
        ob.setTitle("ScreenSaver");
        ob.setVisible(true);
    }
}

class Searching_Puzzle {

    char ar[][];  // character array that wiil form the matrix
    int row, col; //  rows and coulumn of the matrix
    String words[]; // string array that will store the words which user wants to search
    int count;  // integer to count the no of digits of word
    String word;  // string to store word that user want to search
    int srow, scol, i1; // integers to store starting row and coulumn position

    void initia_input() // funtion to initialize the matrix and also for input of data
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE ROWS AND COLUMN OF MATRIX.");
        row = sc.nextInt();
        col = sc.nextInt();
        ar = new char[row][col];
        System.out.println("ENTER THE CHARACTERS ROW WISE.");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ar[i][j] = sc.next().charAt(0);
            }
        }
        print_matrix();
    }        // end of initia_input()

    void print_matrix() // funtion to print the matrix
    {
        System.out.print("\t\t");
        for (int i = 0; i < col; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int i = 0; i < row; i++) {
            System.out.print(i + "\t|\t");
            for (int j = 0; j < col; j++) {
                System.out.print(ar[i][j] + "\t");
            }
            System.out.println("|");
        }
    } // end of print()

    void in_out_words() // funtion to store words that user want to search
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER HOW MANY WORDS YOU WANT TO SEARCH.");
        int no_words = sc.nextInt();
        words = new String[no_words];
        System.out.println("ENTER THE WORDS YOU WANT TO SEARCH.");
        for (int i = 0; i < no_words; i++) {
            words[i] = sc.next();
        }
        send_words();
    }     // end of in_out_words()

    void send_words() // function to send words,one word at a time for searching
    {
        for (int i = 0; i < words.length; i++) {
            i1 = i;
            search_words(words[i]);
        }
    }// end of send_words

    void search_words(String w) // funtion to search first character of the word
    {
        word = w;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                count = 0;
                if (ar[i][j] == word.charAt(count)) {
                    srow = i;
                    scol = j;
                    count++;
                    horiz(i, j);
                    opphoriz(i, j);
                    vert(i, j);
                    oppvert(i, j);
                    rdiag(i, j);
                    ldiag(i, j);
                    opprdiag(i, j);
                    oppldiag(i, j);
                }
            }
        }
    }   // end of search_words()

    void horiz(int r, int c) // funtion to check whether word is present horrizontally or not
    {
        count = 1;
        while (count != word.length() && c != col - 1) {
            c++;
            if (ar[r][c] == word.charAt(count)) {
                count++;
            }

        }
        found_at(count, r, c);
    }   // end of horiz()

    void opphoriz(int r, int c) // funtion to check whether word is present opposite horrizontally or not
    {
        count = 1;
        while (count != word.length() && c != 0) {
            c--;
            if (ar[r][c] == word.charAt(count)) {
                count++;
            }

        }
        found_at(count, r, c);
    }  // end of opphoriz()

    void vert(int r, int c) // funtion to check whether word is present vertically or not
    {
        count = 1;
        while (count != word.length() && r != row - 1) {
            r++;
            if (ar[r][c] == word.charAt(count)) {
                count++;
            }

        }
        found_at(count, r, c);
    }   // end of vert()

    void oppvert(int r, int c) // funtion to check whether word is present opposite vertically or not
    {
        count = 1;
        while (count != word.length() && r != 0) {
            r--;
            if (ar[r][c] == word.charAt(count)) {
                count++;
            }

        }
        found_at(count, r, c);
    } // end of oppvert()

    void rdiag(int r, int c) // funtion to check whether word is present right diagonally or not
    {
        count = 1;
        while (count != word.length() && (r != row - 1 && c != col - 1)) {
            r++;
            c++;
            if (ar[r][c] == word.charAt(count)) {
                count++;
            }

        }
        found_at(count, r, c);
    } // end of rdiag()

    void ldiag(int r, int c) // funtion to check whether word is present left diagonally or not
    {
        count = 1;
        while (count != word.length() && (r != row - 1 && c != 0)) {
            r++;
            c--;
            if (ar[r][c] == word.charAt(count)) {
                count++;
            }

        }
        found_at(count, r, c);
    } // end of ldiag()

    void opprdiag(int r, int c) // funtion to check whether word is present opposite right diagonally or not
    {
        count = 1;
        while (count != word.length() && (r != 0 && c != 0)) {
            r--;
            c--;
            if (ar[r][c] == word.charAt(count)) {
                count++;
            }

        }
        found_at(count, r, c);
    } // end of opprdiag()

    void oppldiag(int r, int c) // funtion to check whether word is present opposite left diagonally or not
    {
        count = 1;
        while (count != word.length() && (r != 0 && c != col - 1)) {
            r--;
            c++;
            if (ar[r][c] == word.charAt(count)) {
                count++;
            }

        }
        found_at(count, r, c);
    } // end of oppldiag()

    void found_at(int check, int r, int c) // funtion to display the starting and end position of corresponding searching word 
    {
        if (count == word.length()) {
            System.out.println(" ' " + words[i1] + " '" + "  FOUND AT POS = [" + srow + "][" + scol + "]--[" + r + "][" + c + "]");
        }
    }  // end of found_at()

    public void searching_words() {
        Scanner sc = new Scanner(System.in);
        Searching_Puzzle ob = new Searching_Puzzle();
        ob.initia_input();
        ob.in_out_words();
    }
}

class MindReader {

    public void mindread() {
        Scanner sc = new Scanner(System.in);
        String ch[] = {"I-Social", "I-Nex", "Be-Social", "Techno-World", "My-World", "I-Robo", "I-Ave", "Computer", "I-Social", "Hacker-World", "I-Krez", "I-Solo", "I-End", "I-Atharva", "I-Alive"};
        int sym, any;
        sym = any = 0;
        for (;;) {
            System.out.println("Think Of Any Number(>10 and <100) And Then Sum The Digits And Then Subtract It From Original");
            System.out.println("Number And Saw The Corresponding Name To The Resultant Number ");
            for (int i = 1; i < 100; i++) {
                if (i % 9 == 0) {
                    System.out.print(i + "-->" + ch[sym] + "   ");
                }
                if (i % 9 != 0) {
                    System.out.print(i + "-->" + ch[any] + "   ");
                    any++;
                }
                if (any == 15) {
                    any = 0;
                }
                if (sym == 15) {
                    sym = 0;
                }
                if (i % 10 == 0) {
                    System.out.println();
                }
            }
            System.out.println("\n Press 1 to continue ");
            int take = sc.nextInt();
            if (take == 1) {
                System.out.println("You Thought Of This Name " + ch[sym]);
            }
            System.out.println("If You Are Not Satisfied You Can Check Again ");
            System.out.println("Enter 1 To Continue And 0 To Exit ");
            int check = sc.nextInt();
            if (check == 0) {
                break;
            } else {
                sym++;
            }
        }
    }
}

class Cross_Zero {

    char ar[][] = new char[3][3];
    int pk = 0, pk1 = 0, p = 0, n, aa = 0, aa2 = 0;

    public void CrossZero() {
        Scanner sc = new Scanner(System.in);
        for (;;) {
            System.out.println("..........Welcome..........");
            System.out.println(" Enter your choice");
            System.out.println(" 1-Start New Game ");
            System.out.println(" 2-getRules ");
            System.out.println(" 3-AI Status ");
            System.out.println(" 4-Cheat Code");
            System.out.println(" 5-Exit ");
            int n = sc.nextInt();
            if (n == 1) {
                for (;;) {
                    System.out.println("  Select Mode");
                    System.out.println("1:Human vs Human");
                    System.out.println("2:Human vs AI");
                    int a = sc.nextInt();
                    if (a == 1) {
                        vsHuman();
                        break;
                    } else if (a == 2) {
                        vsAI();
                        break;
                    } else {
                        System.out.println("Wrong input,please");
                    }
                }
            } else if (n == 2) {
                getRules();
            } else if (n == 3) {
                AIStatus();
            } else if (n == 4) {
                cheatcode();
            } else if (n == 5) {
                System.out.println("..........Bye Bye..........");
                break;
            } else {
                System.out.println("Wrong input,enter your choice carefully");
            }
            getDefault();
        }
    }

    void vsAI() {
        System.out.println("Ok,you decided to play with me");
        Scanner sc = new Scanner(System.in);
        System.out.println("Let's decide who will play first : You or Me ");
        System.out.println("Guess this word");
        System.out.println("__o__s__");
        String s = sc.nextLine();
        if (s.equalsIgnoreCase("horse")) {
            System.out.println("Yes it's correct,Make your first Move");
            initialize();
            print();
            user1();
        } else if (s.equalsIgnoreCase("horse ")) {
            System.out.println("Yes it's Correct,make your move");
            initialize();
            print();
            winuser();
        } else {
            System.out.println("Wrong answer,I will make first Move");
            initialize();
            AI1();
        }
        if (pk == 0 && pk1 == 0) {
            System.out.println("draw");
        }
    }

    void initialize() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ar[i][j] = ' ';
            }
        }
    }

    void vsHuman() {
        initialize();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ok,then you select two player mode");
        print();
        System.out.println("Player 1:X");
        System.out.println("Player 2:O");
        for (p = 3; p <= 11; p++) {
            if (p % 2 != 0) {
                for (;;) {
                    System.out.println("Enter position,player:-'X'");
                    int x = sc.nextInt();
                    if ((x == 1 || x == 2 || x == 3) && (ar[0][x - 1] == ' ')) {
                        ar[0][x - 1] = 'X';
                        print();
                        break;
                    } else if ((x == 4 || x == 5 || x == 6) && (ar[1][x - 4] == ' ')) {
                        ar[1][x - 4] = 'X';
                        print();
                        break;
                    } else if ((x == 7 || x == 8 || x == 9) && (ar[2][x - 7] == ' ')) {
                        ar[2][x - 7] = 'X';
                        print();
                        break;
                    } else {
                        System.out.println("Wrong input,enter again");
                    }
                }
            } else {
                for (;;) {
                    System.out.println("Enter position,player:-'O'");
                    n = sc.nextInt();
                    if ((n == 1 || n == 2 || n == 3) && (ar[0][n - 1] == ' ')) {
                        ar[0][n - 1] = 'O';
                        print();
                        break;
                    } else if ((n == 4 || n == 5 || n == 6) && (ar[1][n - 4] == ' ')) {
                        ar[1][n - 4] = 'O';
                        print();
                        break;
                    } else if ((n == 7 || n == 8 || n == 9) && (ar[2][n - 7] == ' ')) {
                        ar[2][n - 7] = 'O';
                        print();
                        break;
                    } else {
                        System.out.println("Wrong input,enter again");
                    }
                }
            }
        }
    }

    void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("[" + ar[i][j] + "]");
            }
            System.out.println();
        }
        checkWin();
    }

    void user1() {
        Scanner sc = new Scanner(System.in);
        for (p = 3; p <= 11; p++) {
            if (p % 2 != 0) {
                for (;;) {
                    System.out.println("Enter your Move");
                    n = sc.nextInt();
                    if ((n == 1 || n == 2 || n == 3) && (ar[0][n - 1] == ' ')) {
                        ar[0][n - 1] = 'X';
                        print();
                        break;
                    } else if ((n == 4 || n == 5 || n == 6) && (ar[1][n - 4] == ' ')) {
                        ar[1][n - 4] = 'X';
                        print();
                        break;
                    } else if ((n == 7 || n == 8 || n == 9) && (ar[2][n - 7] == ' ')) {
                        ar[2][n - 7] = 'X';
                        print();
                        break;
                    } else {
                        System.out.println("Wrong input,enter again");
                    }
                }
            } else {
                System.out.println("It's my turn");
                if (((ar[0][0] == 'O' && ar[1][0] == 'O') || (ar[0][2] == 'O' && ar[1][1] == 'O') || (ar[2][1] == 'O' && ar[2][2] == 'O')) && (ar[2][0] == ' ')) {
                    ar[2][0] = 'O';
                    print();
                } else if (((ar[1][0] == 'O' && ar[2][0] == 'O') || (ar[1][1] == 'O' && ar[2][2] == 'O') || (ar[0][1] == 'O' && ar[0][2] == 'O')) && (ar[0][0] == ' ')) {
                    ar[0][0] = 'O';
                    print();
                } else if (((ar[1][2] == 'O' && ar[2][2] == 'O') || (ar[0][0] == 'O' && ar[0][1] == 'O') || (ar[1][1] == 'O' && ar[2][0] == 'O')) && (ar[0][2] == ' ')) {
                    ar[0][2] = 'O';
                    print();
                } else if (((ar[0][2] == 'O' && ar[1][2] == 'O') || (ar[0][0] == 'O' && ar[1][1] == 'O') || (ar[2][0] == 'O' && ar[2][1] == 'O')) && (ar[2][2] == ' ')) {
                    ar[2][2] = 'O';
                    print();
                } else if (((ar[0][0] == 'O' && ar[2][0] == 'O') || (ar[1][1] == 'O' && ar[1][2] == 'O')) && (ar[1][0] == ' ')) {
                    ar[1][0] = 'O';
                    print();
                } else if (((ar[0][0] == 'O' && ar[2][2] == 'O') || (ar[0][1] == 'O' && ar[2][1] == 'O') || (ar[1][0] == 'O' && ar[1][2] == 'O') || (ar[0][2] == 'O' && ar[2][0] == 'O')) && (ar[1][1] == ' ')) {
                    ar[1][1] = 'O';
                    print();
                } else if (((ar[1][0] == 'O' && ar[1][1] == 'O') || (ar[0][2] == 'O' && ar[2][2] == 'O')) && (ar[1][2] == ' ')) {
                    ar[1][2] = 'O';
                    print();
                } else if (((ar[0][1] == 'O' && ar[1][1] == 'O') || (ar[2][0] == 'O' && ar[2][2] == 'O')) && (ar[2][1] == ' ')) {
                    ar[2][1] = 'O';
                    print();
                } else if (((ar[1][1] == 'O' && ar[2][1] == 'O') || (ar[0][0] == 'O' && ar[0][2] == 'O')) && (ar[0][1] == ' ')) {
                    ar[0][1] = 'O';
                    print();
                } else if (((ar[0][0] == 'X' && ar[1][0] == 'X') || (ar[0][2] == 'X' && ar[1][1] == 'X') || (ar[2][1] == 'X' && ar[2][2] == 'X')) && (ar[2][0] == ' ')) {
                    ar[2][0] = 'O';
                    print();
                } else if (((ar[1][0] == 'X' && ar[2][0] == 'X') || (ar[1][1] == 'X' && ar[2][2] == 'X') || (ar[0][1] == 'X' && ar[0][2] == 'X')) && (ar[0][0] == ' ')) {
                    ar[0][0] = 'O';
                    print();
                } else if (((ar[1][2] == 'X' && ar[2][2] == 'X') || (ar[0][0] == 'X' && ar[0][1] == 'X') || (ar[1][1] == 'X' && ar[2][0] == 'X')) && (ar[0][2] == ' ')) {
                    ar[0][2] = 'O';
                    print();
                } else if (((ar[0][2] == 'X' && ar[1][2] == 'X') || (ar[0][0] == 'X' && ar[1][1] == 'X') || (ar[2][0] == 'X' && ar[2][1] == 'X')) && (ar[2][2] == ' ')) {
                    ar[2][2] = 'O';
                    print();
                } else if (((ar[0][0] == 'X' && ar[2][0] == 'X') || (ar[1][1] == 'X' && ar[1][2] == 'X')) && (ar[1][0] == ' ')) {
                    ar[1][0] = 'O';
                    print();
                } else if (((ar[0][0] == 'X' && ar[2][2] == 'X') || (ar[0][1] == 'X' && ar[2][1] == 'X') || (ar[1][0] == 'X' && ar[1][2] == 'X') || (ar[0][2] == 'X' && ar[2][0] == 'X')) && (ar[1][1] == ' ')) {
                    ar[1][1] = 'O';
                    print();
                } else if (((ar[1][0] == 'X' && ar[1][1] == 'X') || (ar[0][2] == 'X' && ar[2][2] == 'X')) && (ar[1][2] == ' ')) {
                    ar[1][2] = 'O';
                    print();
                } else if (((ar[0][1] == 'X' && ar[1][1] == 'X') || (ar[2][0] == 'X' && ar[2][2] == 'X')) && (ar[2][1] == ' ')) {
                    ar[2][1] = 'O';
                    print();
                } else if (((ar[1][1] == 'X' && ar[2][1] == 'X') || (ar[0][0] == 'X' && ar[0][2] == 'X')) && (ar[0][1] == ' ')) {
                    ar[0][1] = 'O';
                    print();
                } else if (((ar[1][1] == 'X' && ar[2][2] == 'X') && (ar[0][0] == 'O')) && ar[0][2] == ' ') {
                    ar[0][2] = 'O';
                    print();
                } else if ((ar[2][1] == 'X' && ar[1][2] == 'X') && ar[2][2] == ' ') {
                    ar[2][2] = 'O';
                    print();
                } else if (ar[1][1] == ' ') {
                    ar[1][1] = 'O';
                    print();
                } else if (ar[2][1] == 'X' && ar[0][2] == 'X' && ar[2][2] == ' ') {
                    ar[2][2] = 'O';
                    print();
                } else if ((n == 9 || n == 1 || n == 3 || n == 7) && (ar[0][1] == ' ')) {
                    ar[0][1] = 'O';
                    System.out.println("This is the best move by you");
                    for (double dc = 1.0; dc <= 10000000; dc = dc + 0.03) {
                    }
                    print();
                } else if (ar[0][0] == ' ') {
                    ar[0][0] = 'O';
                    print();
                } else if (ar[0][2] == ' ') {
                    ar[0][2] = 'O';
                    print();
                } else if (ar[2][0] == ' ') {
                    ar[2][0] = 'O';
                    print();
                } else if (ar[2][2] == ' ') {
                    ar[2][2] = 'O';
                    print();
                } else if (ar[0][1] == ' ') {
                    ar[0][1] = 'O';
                    print();
                } else if (ar[1][0] == ' ') {
                    ar[1][0] = 'O';
                    print();
                } else if (ar[1][2] == ' ') {
                    ar[1][2] = 'O';
                    print();
                } else if (ar[2][1] == ' ') {
                    ar[2][1] = 'O';
                    print();
                } else {
                    System.out.println("Sorry some error Occurs");
                }
            }
        }
    }

    void checkWin() {
        if ((ar[0][0] == 'X' && ar[0][1] == 'X' && ar[0][2] == 'X')
                || (ar[0][0] == 'X' && ar[1][0] == 'X' && ar[2][0] == 'X')
                || (ar[1][0] == 'X' && ar[1][1] == 'X' && ar[1][2] == 'X')
                || (ar[0][1] == 'X' && ar[1][1] == 'X' && ar[2][1] == 'X')
                || (ar[2][0] == 'X' && ar[2][1] == 'X' && ar[2][2] == 'X')
                || (ar[0][2] == 'X' && ar[1][2] == 'X' && ar[2][2] == 'X')
                || (ar[0][0] == 'X' && ar[1][1] == 'X' && ar[2][2] == 'X')
                || (ar[0][2] == 'X' && ar[1][1] == 'X' && ar[2][0] == 'X')) {
            pk1++;
            p = 12;
            endGame();
        } else if ((ar[0][0] == 'O' && ar[0][1] == 'O' && ar[0][2] == 'O')
                || (ar[0][0] == 'O' && ar[1][0] == 'O' && ar[2][0] == 'O')
                || (ar[1][0] == 'O' && ar[1][1] == 'O' && ar[1][2] == 'O')
                || (ar[0][1] == 'O' && ar[1][1] == 'O' && ar[2][1] == 'O')
                || (ar[2][0] == 'O' && ar[2][1] == 'O' && ar[2][2] == 'O')
                || (ar[0][2] == 'O' && ar[1][2] == 'O' && ar[2][2] == 'O')
                || (ar[0][0] == 'O' && ar[1][1] == 'O' && ar[2][2] == 'O')
                || (ar[0][2] == 'O' && ar[1][1] == 'O' && ar[2][0] == 'O')) {
            pk++;
            p = 12;
            endGame();
        }
    }

    void endGame() {
        if (pk1 > 0) {
            aa2++;
            System.out.println("Player:-'X' won the Game");
        } else if (pk > 0) {
            aa++;
            System.out.println("Player:-'O' won the Game");
        }
    }

    void AIStatus() {
        System.out.println("AI Defeated " + aa2 + " times and won " + aa + " times");
    }

    void AI1() {
        Scanner sc = new Scanner(System.in);
        ar[0][0] = 'O';
        print();
        for (int i = 4; i <= 5; i++) {
            if (i % 2 == 0) {
                for (;;) {
                    System.out.println("It's your turn");
                    n = sc.nextInt();
                    if ((n == 1 || n == 2 || n == 3) && (ar[0][n - 1] == ' ')) {
                        ar[0][n - 1] = 'X';
                        print();
                        break;
                    } else if ((n == 4 || n == 5 || n == 6) && (ar[1][n - 4] == ' ')) {
                        ar[1][n - 4] = 'X';
                        print();
                        break;
                    } else if ((n == 7 || n == 8 || n == 9) && (ar[2][n - 7] == ' ')) {
                        ar[2][n - 7] = 'X';
                        print();
                        break;
                    } else {
                        System.out.println("Wrong input,enter again");
                    }
                }
            } else {
                System.out.println("It's My Turn");
                if (n == 2) {
                    pos2();
                } else if (n == 3) {
                    pos3();
                } else if (n == 4) {
                    pos4();
                } else if (n == 5) {
                    pos5();
                } else if (n == 6) {
                    pos6();
                } else if (n == 7) {
                    pos7();
                } else if (n == 8) {
                    pos8();
                } else if (n == 9) {
                    pos8();
                }
            }
        }
    }

    void pos2() {
        Scanner sc = new Scanner(System.in);
        ar[2][0] = 'O';
        print();
        for (p = 3; p <= 8; p++) {
            if (p % 2 != 0) {
                for (;;) {
                    System.out.println("Your Turn");
                    n = sc.nextInt();
                    if ((n == 1 || n == 2 || n == 3) && (ar[0][n - 1] == ' ')) {
                        ar[0][n - 1] = 'X';
                        print();
                        break;
                    } else if ((n == 4 || n == 5 || n == 6) && (ar[1][n - 4] == ' ')) {
                        ar[1][n - 4] = 'X';
                        print();
                        break;
                    } else if ((n == 7 || n == 8 || n == 9) && (ar[2][n - 7] == ' ')) {
                        ar[2][n - 7] = 'X';
                        print();
                        break;
                    } else {
                        System.out.println("Wrong input,enter again");
                    }
                }
            } else {
                System.out.println("It's My Turn");
                if (((ar[0][0] == 'O' && ar[1][0] == 'O') || (ar[0][2] == 'O' && ar[1][1] == 'O') || (ar[2][1] == 'O' && ar[2][2] == 'O')) && (ar[2][0] == ' ')) {
                    ar[2][0] = 'O';
                    print();
                } else if (((ar[1][0] == 'O' && ar[2][0] == 'O') || (ar[1][1] == 'O' && ar[2][2] == 'O') || (ar[0][1] == 'O' && ar[0][2] == 'O')) && (ar[0][0] == ' ')) {
                    ar[0][0] = 'O';
                    print();
                } else if (((ar[1][2] == 'O' && ar[2][2] == 'O') || (ar[0][0] == 'O' && ar[0][1] == 'O') || (ar[1][1] == 'O' && ar[2][0] == 'O')) && (ar[0][2] == ' ')) {
                    ar[0][2] = 'O';
                    print();
                } else if (((ar[0][2] == 'O' && ar[1][2] == 'O') || (ar[0][0] == 'O' && ar[1][1] == 'O') || (ar[2][0] == 'O' && ar[2][1] == 'O')) && (ar[2][2] == ' ')) {
                    ar[2][2] = 'O';
                    print();
                } else if (((ar[0][0] == 'O' && ar[2][0] == 'O') || (ar[1][1] == 'O' && ar[1][2] == 'O')) && (ar[1][0] == ' ')) {
                    ar[1][0] = 'O';
                    print();
                } else if (((ar[0][0] == 'O' && ar[2][2] == 'O') || (ar[0][1] == 'O' && ar[2][1] == 'O') || (ar[1][0] == 'O' && ar[1][2] == 'O') || (ar[0][2] == 'O' && ar[2][0] == 'O')) && (ar[1][1] == ' ')) {
                    ar[1][1] = 'O';
                    print();
                } else if (((ar[1][0] == 'O' && ar[1][1] == 'O') || (ar[0][2] == 'O' && ar[2][2] == 'O')) && (ar[1][2] == ' ')) {
                    ar[1][2] = 'O';
                    print();
                } else if (((ar[0][1] == 'O' && ar[1][1] == 'O') || (ar[2][0] == 'O' && ar[2][2] == 'O')) && (ar[2][1] == ' ')) {
                    ar[2][1] = 'O';
                    print();
                } else if (((ar[1][1] == 'O' && ar[2][1] == 'O') || (ar[0][0] == 'O' && ar[0][2] == 'O')) && (ar[0][1] == ' ')) {
                    ar[0][1] = 'O';
                    print();
                } else if (n == 4) {
                    ar[2][2] = 'O';
                    print();
                }
            }
        }
    }

    void pos3() {
        Scanner sc = new Scanner(System.in);
        ar[2][2] = 'O';
        print();
        for (p = 3; p <= 8; p++) {
            if (p % 2 != 0) {
                for (;;) {
                    System.out.println("Your Turn");
                    n = sc.nextInt();
                    if ((n == 1 || n == 2 || n == 3) && (ar[0][n - 1] == ' ')) {
                        ar[0][n - 1] = 'X';
                        print();
                        break;
                    } else if ((n == 4 || n == 5 || n == 6) && (ar[1][n - 4] == ' ')) {
                        ar[1][n - 4] = 'X';
                        print();
                        break;
                    } else if ((n == 7 || n == 8 || n == 9) && (ar[2][n - 7] == ' ')) {
                        ar[2][n - 7] = 'X';
                        print();
                        break;
                    } else {
                        System.out.println("Wrong input,enter again");
                    }
                }
            } else {
                System.out.println("It's My Turn");
                if (((ar[0][0] == 'O' && ar[1][0] == 'O') || (ar[0][2] == 'O' && ar[1][1] == 'O') || (ar[2][1] == 'O' && ar[2][2] == 'O')) && (ar[2][0] == ' ')) {
                    ar[2][0] = 'O';
                    print();
                } else if (((ar[1][0] == 'O' && ar[2][0] == 'O') || (ar[1][1] == 'O' && ar[2][2] == 'O') || (ar[0][1] == 'O' && ar[0][2] == 'O')) && (ar[0][0] == ' ')) {
                    ar[0][0] = 'O';
                    print();
                } else if (((ar[1][2] == 'O' && ar[2][2] == 'O') || (ar[0][0] == 'O' && ar[0][1] == 'O') || (ar[1][1] == 'O' && ar[2][0] == 'O')) && (ar[0][2] == ' ')) {
                    ar[0][2] = 'O';
                    print();
                } else if (((ar[0][2] == 'O' && ar[1][2] == 'O') || (ar[0][0] == 'O' && ar[1][1] == 'O') || (ar[2][0] == 'O' && ar[2][1] == 'O')) && (ar[2][2] == ' ')) {
                    ar[2][2] = 'O';
                    print();
                } else if (((ar[0][0] == 'O' && ar[2][0] == 'O') || (ar[1][1] == 'O' && ar[1][2] == 'O')) && (ar[1][0] == ' ')) {
                    ar[1][0] = 'O';
                    print();
                } else if (((ar[0][0] == 'O' && ar[2][2] == 'O') || (ar[0][1] == 'O' && ar[2][1] == 'O') || (ar[1][0] == 'O' && ar[1][2] == 'O') || (ar[0][2] == 'O' && ar[2][0] == 'O')) && (ar[1][1] == ' ')) {
                    ar[1][1] = 'O';
                    print();
                } else if (((ar[1][0] == 'O' && ar[1][1] == 'O') || (ar[0][2] == 'O' && ar[2][2] == 'O')) && (ar[1][2] == ' ')) {
                    ar[1][2] = 'O';
                    print();
                } else if (((ar[0][1] == 'O' && ar[1][1] == 'O') || (ar[2][0] == 'O' && ar[2][2] == 'O')) && (ar[2][1] == ' ')) {
                    ar[2][1] = 'O';
                    print();
                } else if (((ar[1][1] == 'O' && ar[2][1] == 'O') || (ar[0][0] == 'O' && ar[0][2] == 'O')) && (ar[0][1] == ' ')) {
                    ar[0][1] = 'O';
                    print();
                } else if (n == 5) {
                    ar[2][0] = 'O';
                    print();
                }
            }
        }
    }

    void pos4() {
        Scanner sc = new Scanner(System.in);
        ar[0][2] = 'O';
        print();
        for (p = 3; p <= 8; p++) {
            if (p % 2 != 0) {
                for (;;) {
                    System.out.println("Your Turn");
                    n = sc.nextInt();
                    if ((n == 1 || n == 2 || n == 3) && (ar[0][n - 1] == ' ')) {
                        ar[0][n - 1] = 'X';
                        print();
                        break;
                    } else if ((n == 4 || n == 5 || n == 6) && (ar[1][n - 4] == ' ')) {
                        ar[1][n - 4] = 'X';
                        print();
                        break;
                    } else if ((n == 7 || n == 8 || n == 9) && (ar[2][n - 7] == ' ')) {
                        ar[2][n - 7] = 'X';
                        print();
                        break;
                    } else {
                        System.out.println("Wrong input,enter again");
                    }
                }
            } else {
                System.out.println("It's My Turn");
                if (((ar[0][0] == 'O' && ar[1][0] == 'O') || (ar[0][2] == 'O' && ar[1][1] == 'O') || (ar[2][1] == 'O' && ar[2][2] == 'O')) && (ar[2][0] == ' ')) {
                    ar[2][0] = 'O';
                    print();
                } else if (((ar[1][0] == 'O' && ar[2][0] == 'O') || (ar[1][1] == 'O' && ar[2][2] == 'O') || (ar[0][1] == 'O' && ar[0][2] == 'O')) && (ar[0][0] == ' ')) {
                    ar[0][0] = 'O';
                    print();
                } else if (((ar[1][2] == 'O' && ar[2][2] == 'O') || (ar[0][0] == 'O' && ar[0][1] == 'O') || (ar[1][1] == 'O' && ar[2][0] == 'O')) && (ar[0][2] == ' ')) {
                    ar[0][2] = 'O';
                    print();
                } else if (((ar[0][2] == 'O' && ar[1][2] == 'O') || (ar[0][0] == 'O' && ar[1][1] == 'O') || (ar[2][0] == 'O' && ar[2][1] == 'O')) && (ar[2][2] == ' ')) {
                    ar[2][2] = 'O';
                    print();
                } else if (((ar[0][0] == 'O' && ar[2][0] == 'O') || (ar[1][1] == 'O' && ar[1][2] == 'O')) && (ar[1][0] == ' ')) {
                    ar[1][0] = 'O';
                    print();
                } else if (((ar[0][0] == 'O' && ar[2][2] == 'O') || (ar[0][1] == 'O' && ar[2][1] == 'O') || (ar[1][0] == 'O' && ar[1][2] == 'O') || (ar[0][2] == 'O' && ar[2][0] == 'O')) && (ar[1][1] == ' ')) {
                    ar[1][1] = 'O';
                    print();
                } else if (((ar[1][0] == 'O' && ar[1][1] == 'O') || (ar[0][2] == 'O' && ar[2][2] == 'O')) && (ar[1][2] == ' ')) {
                    ar[1][2] = 'O';
                    print();
                } else if (((ar[0][1] == 'O' && ar[1][1] == 'O') || (ar[2][0] == 'O' && ar[2][2] == 'O')) && (ar[2][1] == ' ')) {
                    ar[2][1] = 'O';
                    print();
                } else if (((ar[1][1] == 'O' && ar[2][1] == 'O') || (ar[0][0] == 'O' && ar[0][2] == 'O')) && (ar[0][1] == ' ')) {
                    ar[0][1] = 'O';
                    print();
                } else if (n == 2) {
                    ar[2][2] = 'O';
                    print();
                }
            }
        }
    }

    void pos6() {
        Scanner sc = new Scanner(System.in);
        ar[0][2] = 'O';
        print();
        for (p = 3; p <= 8; p++) {
            if (p % 2 != 0) {
                for (;;) {
                    System.out.println("Your Turn");
                    n = sc.nextInt();
                    if ((n == 1 || n == 2 || n == 3) && (ar[0][n - 1] == ' ')) {
                        ar[0][n - 1] = 'X';
                        print();
                        break;
                    } else if ((n == 4 || n == 5 || n == 6) && (ar[1][n - 4] == ' ')) {
                        ar[1][n - 4] = 'X';
                        print();
                        break;
                    } else if ((n == 7 || n == 8 || n == 9) && (ar[2][n - 7] == ' ')) {
                        ar[2][n - 7] = 'X';
                        print();
                        break;
                    } else {
                        System.out.println("Wrong input,enter again");
                    }
                }
            } else {
                System.out.println("It's My Turn");
                if (((ar[0][0] == 'O' && ar[1][0] == 'O') || (ar[0][2] == 'O' && ar[1][1] == 'O') || (ar[2][1] == 'O' && ar[2][2] == 'O')) && (ar[2][0] == ' ')) {
                    ar[2][0] = 'O';
                    print();
                } else if (((ar[1][0] == 'O' && ar[2][0] == 'O') || (ar[1][1] == 'O' && ar[2][2] == 'O') || (ar[0][1] == 'O' && ar[0][2] == 'O')) && (ar[0][0] == ' ')) {
                    ar[0][0] = 'O';
                    print();
                } else if (((ar[1][2] == 'O' && ar[2][2] == 'O') || (ar[0][0] == 'O' && ar[0][1] == 'O') || (ar[1][1] == 'O' && ar[2][0] == 'O')) && (ar[0][2] == ' ')) {
                    ar[0][2] = 'O';
                    print();
                } else if (((ar[0][2] == 'O' && ar[1][2] == 'O') || (ar[0][0] == 'O' && ar[1][1] == 'O') || (ar[2][0] == 'O' && ar[2][1] == 'O')) && (ar[2][2] == ' ')) {
                    ar[2][2] = 'O';
                    print();
                } else if (((ar[0][0] == 'O' && ar[2][0] == 'O') || (ar[1][1] == 'O' && ar[1][2] == 'O')) && (ar[1][0] == ' ')) {
                    ar[1][0] = 'O';
                    print();
                } else if (((ar[0][0] == 'O' && ar[2][2] == 'O') || (ar[0][1] == 'O' && ar[2][1] == 'O') || (ar[1][0] == 'O' && ar[1][2] == 'O') || (ar[0][2] == 'O' && ar[2][0] == 'O')) && (ar[1][1] == ' ')) {
                    ar[1][1] = 'O';
                    print();
                } else if (((ar[1][0] == 'O' && ar[1][1] == 'O') || (ar[0][2] == 'O' && ar[2][2] == 'O')) && (ar[1][2] == ' ')) {
                    ar[1][2] = 'O';
                    print();
                } else if (((ar[0][1] == 'O' && ar[1][1] == 'O') || (ar[2][0] == 'O' && ar[2][2] == 'O')) && (ar[2][1] == ' ')) {
                    ar[2][1] = 'O';
                    print();
                } else if (((ar[1][1] == 'O' && ar[2][1] == 'O') || (ar[0][0] == 'O' && ar[0][2] == 'O')) && (ar[0][1] == ' ')) {
                    ar[0][1] = 'O';
                    print();
                } else if (n == 2) {
                    ar[2][0] = 'O';
                    print();
                }
            }
        }
    }

    void pos7() {
        Scanner sc = new Scanner(System.in);
        ar[2][2] = 'O';
        print();
        for (p = 3; p <= 8; p++) {
            if (p % 2 != 0) {
                for (;;) {
                    System.out.println("Your Turn");
                    n = sc.nextInt();
                    if ((n == 1 || n == 2 || n == 3) && (ar[0][n - 1] == ' ')) {
                        ar[0][n - 1] = 'X';
                        print();
                        break;
                    } else if ((n == 4 || n == 5 || n == 6) && (ar[1][n - 4] == ' ')) {
                        ar[1][n - 4] = 'X';
                        print();
                        break;
                    } else if ((n == 7 || n == 8 || n == 9) && (ar[2][n - 7] == ' ')) {
                        ar[2][n - 7] = 'X';
                        print();
                        break;
                    } else {
                        System.out.println("Wrong input,enter again");
                    }
                }
            } else {
                System.out.println("It's My Turn");
                if (((ar[0][0] == 'O' && ar[1][0] == 'O') || (ar[0][2] == 'O' && ar[1][1] == 'O') || (ar[2][1] == 'O' && ar[2][2] == 'O')) && (ar[2][0] == ' ')) {
                    ar[2][0] = 'O';
                    print();
                } else if (((ar[1][0] == 'O' && ar[2][0] == 'O') || (ar[1][1] == 'O' && ar[2][2] == 'O') || (ar[0][1] == 'O' && ar[0][2] == 'O')) && (ar[0][0] == ' ')) {
                    ar[0][0] = 'O';
                    print();
                } else if (((ar[1][2] == 'O' && ar[2][2] == 'O') || (ar[0][0] == 'O' && ar[0][1] == 'O') || (ar[1][1] == 'O' && ar[2][0] == 'O')) && (ar[0][2] == ' ')) {
                    ar[0][2] = 'O';
                    print();
                } else if (((ar[0][2] == 'O' && ar[1][2] == 'O') || (ar[0][0] == 'O' && ar[1][1] == 'O') || (ar[2][0] == 'O' && ar[2][1] == 'O')) && (ar[2][2] == ' ')) {
                    ar[2][2] = 'O';
                    print();
                } else if (((ar[0][0] == 'O' && ar[2][0] == 'O') || (ar[1][1] == 'O' && ar[1][2] == 'O')) && (ar[1][0] == ' ')) {
                    ar[1][0] = 'O';
                    print();
                } else if (((ar[0][0] == 'O' && ar[2][2] == 'O') || (ar[0][1] == 'O' && ar[2][1] == 'O') || (ar[1][0] == 'O' && ar[1][2] == 'O') || (ar[0][2] == 'O' && ar[2][0] == 'O')) && (ar[1][1] == ' ')) {
                    ar[1][1] = 'O';
                    print();
                } else if (((ar[1][0] == 'O' && ar[1][1] == 'O') || (ar[0][2] == 'O' && ar[2][2] == 'O')) && (ar[1][2] == ' ')) {
                    ar[1][2] = 'O';
                    print();
                } else if (((ar[0][1] == 'O' && ar[1][1] == 'O') || (ar[2][0] == 'O' && ar[2][2] == 'O')) && (ar[2][1] == ' ')) {
                    ar[2][1] = 'O';
                    print();
                } else if (((ar[1][1] == 'O' && ar[2][1] == 'O') || (ar[0][0] == 'O' && ar[0][2] == 'O')) && (ar[0][1] == ' ')) {
                    ar[0][1] = 'O';
                    print();
                } else if (n == 5) {
                    ar[0][2] = 'O';
                    print();
                }
            }
        }
    }

    void pos8() {
        Scanner sc = new Scanner(System.in);
        ar[2][0] = 'O';
        print();
        for (p = 3; p <= 8; p++) {
            if (p % 2 != 0) {
                for (;;) {
                    System.out.println("Your Turn");
                    n = sc.nextInt();
                    if ((n == 1 || n == 2 || n == 3) && (ar[0][n - 1] == ' ')) {
                        ar[0][n - 1] = 'X';
                        print();
                        break;
                    } else if ((n == 4 || n == 5 || n == 6) && (ar[1][n - 4] == ' ')) {
                        ar[1][n - 4] = 'X';
                        print();
                        break;
                    } else if ((n == 7 || n == 8 || n == 9) && (ar[2][n - 7] == ' ')) {
                        ar[2][n - 7] = 'X';
                        print();
                        break;
                    } else {
                        System.out.println("Wrong input,enter again");
                    }
                }
            } else {
                System.out.println("It's My Turn");
                if (((ar[0][0] == 'O' && ar[1][0] == 'O') || (ar[0][2] == 'O' && ar[1][1] == 'O') || (ar[2][1] == 'O' && ar[2][2] == 'O')) && (ar[2][0] == ' ')) {
                    ar[2][0] = 'O';
                    print();
                } else if (((ar[1][0] == 'O' && ar[2][0] == 'O') || (ar[1][1] == 'O' && ar[2][2] == 'O') || (ar[0][1] == 'O' && ar[0][2] == 'O')) && (ar[0][0] == ' ')) {
                    ar[0][0] = 'O';
                    print();
                } else if (((ar[1][2] == 'O' && ar[2][2] == 'O') || (ar[0][0] == 'O' && ar[0][1] == 'O') || (ar[1][1] == 'O' && ar[2][0] == 'O')) && (ar[0][2] == ' ')) {
                    ar[0][2] = 'O';
                    print();
                } else if (((ar[0][2] == 'O' && ar[1][2] == 'O') || (ar[0][0] == 'O' && ar[1][1] == 'O') || (ar[2][0] == 'O' && ar[2][1] == 'O')) && (ar[2][2] == ' ')) {
                    ar[2][2] = 'O';
                    print();
                } else if (((ar[0][0] == 'O' && ar[2][0] == 'O') || (ar[1][1] == 'O' && ar[1][2] == 'O')) && (ar[1][0] == ' ')) {
                    ar[1][0] = 'O';
                    print();
                } else if (((ar[0][0] == 'O' && ar[2][2] == 'O') || (ar[0][1] == 'O' && ar[2][1] == 'O') || (ar[1][0] == 'O' && ar[1][2] == 'O') || (ar[0][2] == 'O' && ar[2][0] == 'O')) && (ar[1][1] == ' ')) {
                    ar[1][1] = 'O';
                    print();
                } else if (((ar[1][0] == 'O' && ar[1][1] == 'O') || (ar[0][2] == 'O' && ar[2][2] == 'O')) && (ar[1][2] == ' ')) {
                    ar[1][2] = 'O';
                    print();
                } else if (((ar[0][1] == 'O' && ar[1][1] == 'O') || (ar[2][0] == 'O' && ar[2][2] == 'O')) && (ar[2][1] == ' ')) {
                    ar[2][1] = 'O';
                    print();
                } else if (((ar[1][1] == 'O' && ar[2][1] == 'O') || (ar[0][0] == 'O' && ar[0][2] == 'O')) && (ar[0][1] == ' ')) {
                    ar[0][1] = 'O';
                    print();
                } else if (n == 4) {
                    ar[0][2] = 'O';
                    print();
                }
            }
        }
    }

    void pos5() {
        Scanner sc = new Scanner(System.in);
        ar[2][2] = 'O';
        print();
        for (p = 3; p <= 8; p++) {
            if (p % 2 != 0) {
                for (;;) {
                    System.out.println("Your Turn");
                    n = sc.nextInt();
                    if ((n == 1 || n == 2 || n == 3) && (ar[0][n - 1] == ' ')) {
                        ar[0][n - 1] = 'X';
                        print();
                        break;
                    } else if ((n == 4 || n == 5 || n == 6) && (ar[1][n - 4] == ' ')) {
                        ar[1][n - 4] = 'X';
                        print();
                        break;
                    } else if ((n == 7 || n == 8 || n == 9) && (ar[2][n - 7] == ' ')) {
                        ar[2][n - 7] = 'X';
                        print();
                        break;
                    } else {
                        System.out.println("Wrong input,enter again");
                    }
                }
            } else {
                System.out.println("It's My Turn");
                if (((ar[0][0] == 'O' && ar[1][0] == 'O') || (ar[0][2] == 'O' && ar[1][1] == 'O') || (ar[2][1] == 'O' && ar[2][2] == 'O')) && (ar[2][0] == ' ')) {
                    ar[2][0] = 'O';
                    print();
                } else if (((ar[1][0] == 'O' && ar[2][0] == 'O') || (ar[1][1] == 'O' && ar[2][2] == 'O') || (ar[0][1] == 'O' && ar[0][2] == 'O')) && (ar[0][0] == ' ')) {
                    ar[0][0] = 'O';
                    print();
                } else if (((ar[1][2] == 'O' && ar[2][2] == 'O') || (ar[0][0] == 'O' && ar[0][1] == 'O') || (ar[1][1] == 'O' && ar[2][0] == 'O')) && (ar[0][2] == ' ')) {
                    ar[0][2] = 'O';
                    print();
                } else if (((ar[0][2] == 'O' && ar[1][2] == 'O') || (ar[0][0] == 'O' && ar[1][1] == 'O') || (ar[2][0] == 'O' && ar[2][1] == 'O')) && (ar[2][2] == ' ')) {
                    ar[2][2] = 'O';
                    print();
                } else if (((ar[0][0] == 'O' && ar[2][0] == 'O') || (ar[1][1] == 'O' && ar[1][2] == 'O')) && (ar[1][0] == ' ')) {
                    ar[1][0] = 'O';
                    print();
                } else if (((ar[0][0] == 'O' && ar[2][2] == 'O') || (ar[0][1] == 'O' && ar[2][1] == 'O') || (ar[1][0] == 'O' && ar[1][2] == 'O') || (ar[0][2] == 'O' && ar[2][0] == 'O')) && (ar[1][1] == ' ')) {
                    ar[1][1] = 'O';
                    print();
                } else if (((ar[1][0] == 'O' && ar[1][1] == 'O') || (ar[0][2] == 'O' && ar[2][2] == 'O')) && (ar[1][2] == ' ')) {
                    ar[1][2] = 'O';
                    print();
                } else if (((ar[0][1] == 'O' && ar[1][1] == 'O') || (ar[2][0] == 'O' && ar[2][2] == 'O')) && (ar[2][1] == ' ')) {
                    ar[2][1] = 'O';
                    print();
                } else if (((ar[1][1] == 'O' && ar[2][1] == 'O') || (ar[0][0] == 'O' && ar[0][2] == 'O')) && (ar[0][1] == ' ')) {
                    ar[0][1] = 'O';
                    print();
                } else if ((n == 7)) {
                    ar[0][2] = 'O';
                    print();
                } else if ((n == 4)) {
                    ar[1][2] = 'O';
                    print();
                } else if ((n == 2)) {
                    ar[2][1] = 'O';
                    print();
                } else if ((n == 8)) {
                    ar[0][1] = 'O';
                    print();
                } else if ((n == 3)) {
                    ar[2][0] = 'O';
                    print();
                } else if ((n == 6)) {
                    ar[1][0] = 'O';
                    print();
                }
            }
        }
    }

    void getRules() {
        System.out.println("It's Time to know about Tictactoe");
        System.out.println("The conditions required to win this game are :");
        System.out.println("Either you can win row wise");
        System.out.println("[X][X][X]");
        System.out.println("[ ][ ][ ]");
        System.out.println("[ ][ ][ ]");
        System.out.println("Or you can win column wise");
        System.out.println("[X][ ][ ]");
        System.out.println("[X][ ][ ]");
        System.out.println("[X][ ][ ]");
        System.out.println("Or you can win diagonally");
        System.out.println("[X][ ][ ]");
        System.out.println("[ ][X][ ]");
        System.out.println("[ ][ ][X]");
        System.out.println("If none of these three conditions satisfied then it leads to draw");
        System.out.println("Let's go to the main menu");
    }

    void getDefault() {
        pk1 = 0;
        pk = 0;
        p = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ar[i][j] = ' ';
            }
        }
    }

    void cheatcode() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the registered Code to know the Cheat code");
        String ss = sc.nextLine();
        if (ss.equals("tictactoe")) {
            System.out.println("This Cheat code is valid with AI mode only");
            System.out.println("Enter 'house ' in guess this word");
        } else {
            System.out.println("Sorry,Code didn't match");
        }
    }

    void winuser() {
        Scanner sc = new Scanner(System.in);
        for (p = 3; p <= 11; p++) {
            if (p % 2 != 0) {
                for (;;) {
                    System.out.println("Enter your position,player:-'X'");
                    n = sc.nextInt();
                    if ((n == 1 || n == 2 || n == 3) && (ar[0][n - 1] == ' ')) {
                        ar[0][n - 1] = 'X';
                        print();
                        break;
                    } else if ((n == 4 || n == 5 || n == 6) && (ar[1][n - 4] == ' ')) {
                        ar[1][n - 4] = 'X';
                        print();
                        break;
                    } else if ((n == 7 || n == 8 || n == 9) && (ar[2][n - 7] == ' ')) {
                        ar[2][n - 7] = 'X';
                        print();
                        break;
                    } else {
                        System.out.println("Wrong input,enter again");
                    }
                }
            } else {
                System.out.println("It's my turn");
                if (ar[0][0] == ' ') {
                    ar[0][0] = 'O';
                } else if (ar[0][1] == ' ') {
                    ar[0][1] = 'O';
                } else if (ar[0][2] == ' ') {
                    ar[0][2] = 'O';
                } else if (ar[1][0] == ' ') {
                    ar[1][0] = 'O';
                } else if (ar[1][1] == ' ') {
                    ar[1][1] = 'O';
                } else if (ar[1][2] == ' ') {
                    ar[1][2] = 'O';
                } else if (ar[2][0] == ' ') {
                    ar[2][0] = 'O';
                } else if (ar[2][1] == ' ') {
                    ar[2][1] = 'O';
                } else if (ar[2][2] == ' ') {
                    ar[2][2] = 'O';
                } else {
                    System.out.println("Sorry,some error occurs");
                }
                print();
            }
        }
    }
}

class ChessGame {

    String board[][] = new String[8][8];
    int end = 0;    // 1 = true ,0 = false
    int legal = 0;
    int wcastl = 1;
    int bcastl = 1;
    int check = 0;
    int winwhite = 0;
    int winblack = 0;

    void initialize() {
        board[0][0] = "BROOK  ";
        board[0][1] = "BHORSE ";
        board[0][2] = "BBISHOP";
        board[0][3] = "BQUEEN ";
        board[0][4] = "BKING  ";
        board[0][5] = "BBISHOP";
        board[0][6] = "BHORSE ";
        board[0][7] = "BROOK  ";
        board[1][0] = "BPAWN  ";
        board[1][1] = "BPAWN  ";
        board[1][2] = "BPAWN  ";
        board[1][3] = "BPAWN  ";
        board[1][4] = "BPAWN  ";
        board[1][5] = "BPAWN  ";
        board[1][6] = "BPAWN  ";
        board[1][7] = "BPAWN  ";
        board[6][0] = "WPAWN  ";
        board[6][1] = "WPAWN  ";
        board[6][2] = "WPAWN  ";
        board[6][3] = "WPAWN  ";
        board[6][4] = "WPAWN  ";
        board[6][5] = "WPAWN  ";
        board[6][6] = "WPAWN  ";
        board[6][7] = "WPAWN  ";
        board[7][0] = "WROOK  ";
        board[7][1] = "WHORSE ";
        board[7][2] = "WBISHOP";
        board[7][3] = "WQUEEN ";
        board[7][4] = "WKING  ";
        board[7][5] = "WBISHOP";
        board[7][6] = "WHORSE ";
        board[7][7] = "WROOK  ";
    } // end of intialize();

    void print_board() {
        System.out.println("     0          1          2          3          4          5          6          7");
        char ch = 'A';
        for (int i = 0; i < 8; i++) {
            System.out.println("  ________________________________________________________________________________________");
            System.out.print(ch++ + " ");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    board[i][j] = "       ";
                }
                System.out.print("| " + board[i][j] + "  ");
            }
            System.out.println("|");
        }
        System.out.println("  ________________________________________________________________________________________");
    }  // end of print_board();

    void start_game() {
        end = 0;    // 1 = true ,0 = false
        legal = 0;
        wcastl = 1;
        bcastl = 1;
        check = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = "       ";
            }
        }
        initialize();
        print_board();
        for (;;) {
            System.out.println("\nWhite Turns");
            white_move();
            check_win();
            if (end == 1) {
                System.out.println("White wins");
                winwhite++;
                break;
            }
            System.out.println("\nBlack Turns");
            black_move();
            check_win();
            if (end == 1) {
                System.out.println("Black wins");
                winblack++;
                break;
            }
        }
    } // end of start_game();

    void white_move() {
        legal = 0;
        Scanner sc = new Scanner(System.in);
        String init = "";
        String finl = "";
        int r1, c1, r2, c2;
        for (;;) {
            try {
                init = sc.next();
                finl = sc.next();
                char ch1 = init.charAt(0);
                r1 = ch1 - 65;
                ch1 = init.charAt(1);
                c1 = ch1 - 48;
                ch1 = finl.charAt(0);
                r2 = ch1 - 65;
                ch1 = finl.charAt(1);
                c2 = ch1 - 48;
                if (board[r1][c1] == "WPAWN  ") {
                    wpawn(r1, c1, r2, c2);
                } else if (board[r1][c1] == "WROOK  ") {
                    wrook(r1, c1, r2, c2);
                } else if (board[r1][c1] == "WHORSE ") {
                    whorse(r1, c1, r2, c2);
                } else if (board[r1][c1] == "WBISHOP") {
                    wbishop(r1, c1, r2, c2);
                } else if (board[r1][c1] == "WQUEEN ") {
                    wqueen(r1, c1, r2, c2);
                } else if (board[r1][c1] == "WKING  ") {
                    wking(r1, c1, r2, c2);
                }
                if (legal == 1) {
                    board[r2][c2] = board[r1][c1];
                    board[r1][c1] = "       ";
                    print_board();
                    bking_check(r2, c2);
                    break;
                } else {
                    System.out.println("Wrong Input,Enter your move again");
                }
            } catch (Exception e) {
                System.out.println("Enter your move again,wrong input");
            }
        }

    } // end of white_move();

    void black_move() {
        legal = 0;
        Scanner sc = new Scanner(System.in);
        int r1, c1, r2, c2;
        String init = "";
        String finl = "";
        for (;;) {
            try {
                init = sc.next();
                finl = sc.next();
                char ch1 = init.charAt(0);
                r1 = ch1 - 65;
                ch1 = init.charAt(1);
                c1 = ch1 - 48;
                ch1 = finl.charAt(0);
                r2 = ch1 - 65;
                ch1 = finl.charAt(1);
                c2 = ch1 - 48;
                if (board[r1][c1] == "BPAWN  ") {
                    bpawn(r1, c1, r2, c2);
                } else if (board[r1][c1] == "BROOK  ") {
                    brook(r1, c1, r2, c2);
                } else if (board[r1][c1] == "BHORSE ") {
                    bhorse(r1, c1, r2, c2);
                    if (legal == 2) {
                        legal = 1;
                    }
                } else if (board[r1][c1] == "BBISHOP") {
                    bbishop(r1, c1, r2, c2);
                } else if (board[r1][c1] == "BQUEEN ") {
                    bqueen(r1, c1, r2, c2);
                } else if (board[r1][c1] == "BKING  ") {
                    bking(r1, c1, r2, c2);
                }
                if (legal == 1) {
                    board[r2][c2] = board[r1][c1];
                    board[r1][c1] = "       ";
                    print_board();
                    wking_check(r2, c2);
                    break;
                } else if (end == 1) {
                    break;
                } else {
                    System.out.println("Wrong Input,Enter your move again");
                }
            } catch (Exception e) {
                System.out.println("Enter again,wrong input");
            }
        }
    } // end of black_move();

    void wpawn(int r1, int c1, int r2, int c2) {
        Scanner sc = new Scanner(System.in);
        if (r1 == 1 && r2 == 0 && (c1 == c2 - 1 || c2 == c1 - 1 || c1 == c2)) {
            System.out.println("Enter which piece you want to promote");
            String in = sc.next();
            board[r1][c1] = in;
            legal = 1;
        } else if ((r1 < 6 && r1 - r2 > 1) || (r1 > 7 || c1 > 7 || r2 > 7 || c2 > 7 || r1 - r2 > 2 || r1 - r2 < 0 || c2 - c1 > 1 || c1 - c2 > 1)) {
            legal = 0;
        } else if ((board[r1 - 1][c1] == "       " && c1 == c2 && r2 == r1 - 1)
                || (c1 == 0 && board[r2][c2] == "       " && r2 == r1 - 1 && c1 == c2)
                || (r1 == 6 && r2 == 4 && c1 == c2 && board[r1 - 1][c1] == "       " && board[r2][c2] == "       ")
                || ((c1 == 0 && r2 == r1 - 1) && (board[r2][c2] == "BPAWN  " || board[r2][c2] == "BHORSE " || board[r2][c2] == "BKING  " || board[r2][c2] == "BROOK  " || board[r2][c2] == "BBISHOP" || board[r2][c2] == "BQUEEN ") && (c2 == c1 + 1))
                || (board[r1 - 1][c1 - 1] == "BPAWN  " && r2 == r1 - 1 && c2 == c1 - 1)
                || (board[r1 - 1][c1 - 1] == "BHORSE " && r2 == r1 - 1 && c2 == c1 - 1)
                || (board[r1 - 1][c1 - 1] == "BBISHOP" && r2 == r1 - 1 && c2 == c1 - 1)
                || (board[r1 - 1][c1 - 1] == "BROOK  " && r2 == r1 - 1 && c2 == c1 - 1)
                || (board[r1 - 1][c1 - 1] == "BQUEEN " && r2 == r1 - 1 && c2 == c1 - 1)
                || (board[r1 - 1][c1 - 1] == "BKING  " && r2 == r1 - 1 && c2 == c1 - 1)
                || (c1 == 7 && board[r2][c2] == "       " && r2 == r1 - 1 && c1 == c2)
                || ((c1 == 7 && r2 == r1 - 1) && (board[r2][c2] == "BPAWN  " || board[r2][c2] == "BKING  " || board[r2][c2] == "BHORSE " || board[r2][c2] == "BROOK  " || board[r2][c2] == "BBISHOP" || board[r2][c2] == "BQUEEN ") && (c2 == c1 - 1))
                || (board[r1 - 1][c1 + 1] == "BPAWN  " && r2 == r1 - 1 && c2 == c1 + 1)
                || (board[r1 - 1][c1 + 1] == "BHORSE " && r2 == r1 - 1 && c2 == c1 + 1)
                || (board[r1 - 1][c1 + 1] == "BBISHOP" && r2 == r1 - 1 && c2 == c1 + 1)
                || (board[r1 - 1][c1 + 1] == "BROOK  " && r2 == r1 - 1 && c2 == c1 + 1)
                || (board[r1 - 1][c1 + 1] == "BQUEEN " && r2 == r1 - 1 && c2 == c1 + 1)
                || (board[r1 - 1][c1 + 1] == "BKING  " && r2 == r1 - 1 && c2 == c1 + 1)) {
            legal = 1;
        } else {
            legal = 0;
        }
    }// end of wpawn();

    void wrook(int r1, int c1, int r2, int c2) {
        legal = 0;
        int leg1 = 0;
        if (board[r2][c2] == "BPAWN  " || board[r2][c2] == "BROOK  " || board[r2][c2] == "BBISHOP" || board[r2][c2] == "BQUEEN " || board[r2][c2] == "BHORSE " || board[r2][c2] == "BKING  ") {
            leg1++;
        }
        if (board[r2][c2] != "WPAWN  " && board[r2][c2] != "WROOK  " && board[r2][c2] != "WBISHOP" && board[r2][c2] != "WQUEEN " && board[r2][c2] != "WKING  " && board[r2][c2] != "WHORSE ") {
            if (r1 == r2 && r1 < 8 && r2 < 8 && c1 < 8 && c2 < 8) {
                if (c1 > c2) {
                    c1 = c1 + c2;
                    c2 = c1 - c2;
                    c1 = c1 - c2;
                }
                for (int i = c1; i <= c2; i++) {
                    if (board[r1][i] == "       ") {
                        leg1++;
                    }
                }
                if (leg1 == c2 - c1) {
                    legal = 1;
                    wcastl++;
                }
            } else if (c1 == c2 && r1 < 8 && r2 < 8 && c1 < 8 && c2 < 8) {
                if (r1 > r2) {
                    r1 = r1 + r2;
                    r2 = r1 - r2;
                    r1 = r1 - r2;
                }
                for (int i = r1; i <= r2; i++) {
                    if (board[i][c1] == "       ") {
                        leg1++;
                    }
                }
                if (leg1 == r2 - r1) {
                    legal = 1;
                    wcastl++;
                }
            }
        }
    } // end of wrook();

    void whorse(int r1, int c1, int r2, int c2) {
        int leg1 = 0;
        wrook(r1, c1, r2, c2);
        if (legal != 1) {
            leg1++;
        }
        wbishop(r1, c1, r2, c2);
        if (legal != 1) {
            leg1++;
        }
        if (leg1 == 2) {
            if (r1 - r2 < 3 && r2 - r1 < 3 && c1 - c2 < 3 && c2 - c1 < 3) {
                if (r1 != r2 && c1 != c2 && r1 - r2 != c1 - c2 && r2 - r1 != c2 - c1) {
                    legal = 1;
                }
            }
        } else {
            legal = 0;
        }
    } // end of whorse();

    void wbishop(int r1, int c1, int r2, int c2) {
        legal = 0;
        int leg1 = 0;
        int cp = c1;
        if (r2 < r1 && c2 < c1) {
            if (board[r2][c2] == "BKING  " || board[r2][c2] == "BPAWN  " || board[r2][c2] == "BHORSE " || board[r2][c2] == "BROOK  " || board[r2][c2] == "BQUEEN " || board[r2][c2] == "BBISHOP") {
                leg1++;
            }
            for (int i = r1; i >= r2; i--) {
                if (c1 > -1 && c1 < 8 && board[i][c1] == "       ") {
                    leg1++;
                }
                c1--;
            }
            if (leg1 == r1 - r2 && (leg1 == cp - c2 || leg1 == c2 - cp)) {
                legal = 1;
            }
        }
        if (r2 < r1 && c2 > c1 && legal != 1) {
            leg1 = 0;
            if (board[r2][c2] == "BPAWN  " || board[r2][c2] == "BKING  " || board[r2][c2] == "BHORSE " || board[r2][c2] == "BROOK  " || board[r2][c2] == "BQUEEN " || board[r2][c2] == "BBISHOP") {
                leg1++;
            }
            for (int i = r1; i >= r2; i--) {
                if (c1 > -1 && c1 < 8 && board[i][c1] == "       ") {
                    leg1++;
                }
                c1++;
            }
            if (leg1 == r1 - r2 && (leg1 == cp - c2 || leg1 == c2 - cp)) {
                legal = 1;
            }
        }
        if (r1 < r2 && c1 > c2 && legal != 1) {
            leg1 = 0;
            if (board[r2][c2] == "BPAWN  " || board[r2][c2] == "BHORSE " || board[r2][c2] == "BKING  " || board[r2][c2] == "BROOK  " || board[r2][c2] == "BQUEEN " || board[r2][c2] == "BBISHOP") {
                leg1++;
            }
            for (int i = r1; i <= r2; i++) {
                if (c1 > -1 && c1 < 8 && board[i][c1] == "       ") {
                    leg1++;
                }
                c1--;
            }
            if (leg1 == r2 - r1 && (leg1 == cp - c2 || leg1 == c2 - cp)) {
                legal = 1;
            }
        }
        if (r2 > r1 && c2 > c1 && legal != 1) {
            leg1 = 0;
            if (board[r2][c2] == "BPAWN  " || board[r2][c2] == "BHORSE " || board[r2][c2] == "BROOK  " || board[r2][c2] == "BKING  " || board[r2][c2] == "BQUEEN " || board[r2][c2] == "BBISHOP") {
                leg1++;
            }
            for (int i = r1; i <= r2; i++) {
                if (c1 > -1 && c1 < 8 && board[i][c1] == "       ") {
                    leg1++;
                }
                c1++;
            }
            if (leg1 == r2 - r1 && (leg1 == cp - c2 || leg1 == c2 - cp)) {
                legal = 1;
            }
        }
    } // end of wbishop();

    void wqueen(int r1, int c1, int r2, int c2) {
        wrook(r1, c1, r2, c2);
        if (legal != 1) {
            wbishop(r1, c1, r2, c2);
        }
    } // end of wqueen();

    void wking(int r1, int c1, int r2, int c2) {
        legal = 0;
        if (((r2 == 7 && c2 == 6) || (r2 == 7 && c2 == 2)) && (wcastl == 1)) {
            if (c2 == 6) {
                if (board[r2][c2] == "       " && board[r2][7] == "WROOK  " && board[r2][6] == "       ") {
                    board[r2][c2] = "WKING  ";
                    board[r2][c2 - 1] = "WROOK  ";
                    board[r2][7] = "       ";
                    System.out.println("Short Castling...");
                    legal = 1;
                    wcastl++;
                }
            } else {
                if (board[r2][c2] == "       " && board[r2][0] == "WROOK  " && board[r2][1] == "       " && board[r2][3] == "       ") {
                    board[r2][c2] = "WKING  ";
                    board[r2][c2 + 1] = "WROOK  ";
                    board[r2][0] = "       ";
                    System.out.println("Long Castling...");
                    legal = 1;
                    wcastl++;
                }
            }
        }
        if ((r2 - r1 == 1 && c1 == c2) || (r1 - r2 == 1 && c1 == c2) || (c1 - c2 == 1 && r1 == r2) || (c2 - c1 == 1 && r1 == r2) || (r2 - r1 == 1 && c1 - c2 == 1) || (r2 - r1 == 1 && c2 - c1 == 1) || (r1 - r2 == 1 && c1 - c2 == 1) || (r1 - r2 == 1 && c2 - c1 == 1)) {
            if (board[r2][c2] != "WPAWN  " && board[r2][c2] != "WROOK  " && board[r2][c2] != "WBISHOP" && board[r2][c2] != "WQUEEN ") {
                legal = 1;
                wcastl++;
            }
        }
    } // end of wking();

    void bpawn(int r1, int c1, int r2, int c2) {
        Scanner sc = new Scanner(System.in);
        if (r1 == 6 && r2 == 7 && (c1 == c2 - 1 || c2 == c1 - 1 || c1 == c2)) {
            System.out.println("Enter which piece you want to promote");
            String in = sc.next();
            board[r1][c1] = in;
            legal = 1;
        } else if (r1 > 7 || r2 > 7 || c1 > 7 || c2 > 7 || r2 - r1 > 2 || r2 - r1 < 0 || c1 - c2 > 1 || c2 - c1 > 1) {
            legal = 0;
        } else if (r1 > 1 && r2 - r1 > 1) {
            legal = 0;
        } else if ((board[r1 + 1][c1] == "       " && c1 == c2 && r2 == r1 + 1)
                || (c1 == 0 && board[r2][c2] == "       " && r2 == r1 + 1 && c1 == c2)
                || (r1 == 1 && r2 == 3 && c1 == c2 && board[r1 + 1][c1] == "       " && board[r2][c2] == "       ")
                || ((c1 == 0 && r2 == r1 + 1) && (board[r2][c2] == "WPAWN  " || board[r2][c2] == "WHORSE " || board[r2][c2] == "WKING  " || board[r2][c2] == "WROOK  " || board[r2][c2] == "WBISHOP" || board[r2][c2] == "WQUEEN ") && (c2 == c1 + 1))
                || (board[r1 + 1][c1 - 1] == "WPAWN  " && r2 == r1 + 1 && c2 == c1 - 1)
                || (board[r1 + 1][c1 - 1] == "WHORSE " && r2 == r1 + 1 && c2 == c1 - 1)
                || (board[r1 + 1][c1 - 1] == "WBISHOP" && r2 == r1 + 1 && c2 == c1 - 1)
                || (board[r1 + 1][c1 - 1] == "WROOK  " && r2 == r1 + 1 && c2 == c1 - 1)
                || (board[r1 + 1][c1 - 1] == "WQUEEN " && r2 == r1 + 1 && c2 == c1 - 1)
                || (board[r1 + 1][c1 - 1] == "WKING  " && r2 == r1 + 1 && c2 == c1 - 1)
                || (c1 == 7 && board[r2][c2] == "       " && r2 == r1 + 1 && c1 == c2)
                || ((c1 == 7 && r2 == r1 + 1) && (board[r2][c2] == "WPAWN  " || board[r2][c2] == "WHORSE " || board[r2][c2] == "WROOK  " || board[r2][c2] == "WBISHOP" || board[r2][c2] == "WQUEEN " || board[r2][c2] == "WKING  ") && (c2 == c1 - 1))
                || (board[r1 + 1][c1 + 1] == "WPAWN  " && r2 == r1 + 1 && c2 == c1 + 1)
                || (board[r1 + 1][c1 + 1] == "WHORSE " && r2 == r1 + 1 && c2 == c1 + 1)
                || (board[r1 + 1][c1 + 1] == "WBISHOP" && r2 == r1 + 1 && c2 == c1 + 1)
                || (board[r1 + 1][c1 + 1] == "WKING  " && r2 == r1 + 1 && c2 == c1 + 1)
                || (board[r1 + 1][c1 + 1] == "WROOK  " && r2 == r1 + 1 && c2 == c1 + 1)
                || (board[r1 + 1][c1 + 1] == "WQUEEN " && r2 == r1 + 1 && c2 == c1 + 1)) {
            legal = 1;
        } else {
            legal = 0;
        }
    }  // end of bpawn();

    void brook(int r1, int c1, int r2, int c2) {
        legal = 0;
        int leg1 = 0;
        if (board[r2][c2] == "WPAWN  " || board[r2][c2] == "WKING  " || board[r2][c2] == "WROOK  " || board[r2][c2] == "WBISHOP" || board[r2][c2] == "WQUEEN " || board[r2][c2] == "WHORSE ") {
            leg1++;
        }
        if (board[r2][c2] != "BHORSE " && board[r2][c2] != "BPAWN  " && board[r2][c2] != "BROOK  " && board[r2][c2] != "BBISHOP" && board[r2][c2] != "BQUEEN " && board[r2][c2] != "BKING  ") {
            if (r1 == r2 && r1 < 8 && r2 < 8 && c1 < 8 && c2 < 8) {
                if (c1 > c2) {
                    c1 = c1 + c2;
                    c2 = c1 - c2;
                    c1 = c1 - c2;
                }
                for (int i = c1; i <= c2; i++) {
                    if (board[r1][i] == "       ") {
                        leg1++;
                    }
                }
                if (leg1 == c2 - c1) {
                    legal = 1;
                    bcastl++;
                }
            } else if (c1 == c2 && r1 < 8 && r2 < 8 && c1 < 8 && c2 < 8) {
                if (r1 > r2) {
                    r1 = r1 + r2;
                    r2 = r1 - r2;
                    r1 = r1 - r2;
                }
                for (int i = r1; i <= r2; i++) {
                    if (board[i][c1] == "       ") {
                        leg1++;
                    }
                }
                if (leg1 == r2 - r1) {
                    legal = 1;
                    bcastl++;
                }
            } else {
                legal = 0;
            }
        }
    } // end of brook();

    void bhorse(int r1, int c1, int r2, int c2) {
        int leg1 = 0;
        brook(r1, c1, r2, c2);
        if (legal != 1) {
            leg1++;
        }
        bbishop(r1, c1, r2, c2);
        if (legal != 1) {
            leg1++;
        }
        if (leg1 == 2) {
            if (r1 - r2 < 3 && r2 - r1 < 3 && c1 - c2 < 3 && c2 - c1 < 3) {
                if (r1 != r2 && c1 != c2 && r1 - r2 != c1 - c2 && r2 - r1 != c2 - c1) {
                    legal = 1;
                }
            }
        } else {
            legal = 0;
        }
    } // end of bhorse();

    void bbishop(int r1, int c1, int r2, int c2) {
        legal = 0;
        int leg1 = 0;
        int cp = c1;
        if (r2 < r1 && c2 < c1) {
            if (board[r2][c2] == "WPAWN  " || board[r2][c2] == "WKING  " || board[r2][c2] == "WHORSE " || board[r2][c2] == "WROOK  " || board[r2][c2] == "WQUEEN " || board[r2][c2] == "WBISHOP") {
                leg1++;
            }
            for (int i = r1; i >= r2; i--) {
                if (c1 > -1 && c1 < 8 && board[i][c1] == "       ") {
                    leg1++;
                }
                c1--;
            }
            if (leg1 == r1 - r2 && (leg1 == cp - c2 || leg1 == c2 - cp)) {
                legal = 1;
            }
        }
        if (r2 < r1 && c2 > c1 && legal != 1) {
            leg1 = 0;
            if (board[r2][c2] == "WPAWN  " || board[r2][c2] == "WKING  " || board[r2][c2] == "WHORSE " || board[r2][c2] == "WROOK  " || board[r2][c2] == "WQUEEN " || board[r2][c2] == "WBISHOP") {
                leg1++;
            }
            for (int i = r1; i >= r2; i--) {
                if (c1 > -1 && c1 < 8 && board[i][c1] == "       ") {
                    leg1++;
                }
                c1++;
            }
            if (leg1 == r1 - r2 && (leg1 == cp - c2 || leg1 == c2 - cp)) {
                legal = 1;
            }
        }
        if (r1 < r2 && c1 > c2 && legal != 1) {
            leg1 = 0;
            if (board[r2][c2] == "WPAWN  " || board[r2][c2] == "WHORSE " || board[r2][c2] == "WROOK  " || board[r2][c2] == "WQUEEN " || board[r2][c2] == "WBISHOP" || board[r2][c2] == "WKING  ") {
                leg1++;
            }
            for (int i = r1; i <= r2; i++) {
                if (c1 < 8 && c1 > -1 && board[i][c1] == "       ") {
                    leg1++;
                }
                c1--;
            }
            if (leg1 == r2 - r1 && (leg1 == cp - c2 || leg1 == c2 - cp)) {
                legal = 1;
            }
        }
        if (r2 > r1 && c2 > c1 && legal != 1) {
            leg1 = 0;
            if (board[r2][c2] == "WPAWN  " || board[r2][c2] == "WHORSE " || board[r2][c2] == "WROOK  " || board[r2][c2] == "WQUEEN " || board[r2][c2] == "WBISHOP" || board[r2][c2] == "WKING  ") {
                leg1++;
            }
            for (int i = r1; i <= r2; i++) {
                if (c1 > -1 && c1 < 8 && board[i][c1] == "       ") {
                    leg1++;
                }
                c1++;
            }
            if (leg1 == r2 - r1 && (leg1 == cp - c2 || leg1 == c2 - cp)) {
                legal = 1;
            }
        }
    } // end of bbishop();

    void bqueen(int r1, int c1, int r2, int c2) {
        brook(r1, c1, r2, c2);
        if (legal != 1) {
            bbishop(r1, c1, r2, c2);
        }
    } // end of bqueen();

    void bking(int r1, int c1, int r2, int c2) {
        legal = 0;
        if (((r2 == 0 && c2 == 6) || (r2 == 0 && c2 == 2)) && (bcastl == 1)) {
            if (c2 == 6) {
                if (board[r2][c2] == "       " && board[r2][7] == "BROOK  " && board[r2][6] == "       ") {
                    board[r2][c2] = "BKING  ";
                    board[r2][c2 - 1] = "BROOK  ";
                    board[r2][7] = "       ";
                    System.out.println("Short Castling...");
                    legal = 1;
                    bcastl++;
                }
            } else {
                if (board[r2][c2] == "       " && board[r2][0] == "BROOK  " && board[r2][1] == "       " && board[r2][3] == "       ") {
                    board[r2][c2] = "BKING  ";
                    board[r2][c2 + 1] = "BROOK  ";
                    board[r2][0] = "       ";
                    System.out.println("Long Castling...");
                    legal = 1;
                    bcastl++;
                }
            }
        }
        if ((r2 - r1 == 1 && c1 == c2) || (r1 - r2 == 1 && c1 == c2) || (c1 - c2 == 1 && r1 == r2) || (c2 - c1 == 1 && r1 == r2) || (r2 - r1 == 1 && c1 - c2 == 1) || (r2 - r1 == 1 && c2 - c1 == 1) || (r1 - r2 == 1 && c1 - c2 == 1) || (r1 - r2 == 1 && c2 - c1 == 1)) {
            if (board[r2][c2] != "BPAWN  " && board[r2][c2] != "BROOK  " && board[r2][c2] != "BBISHOP" && board[r2][c2] != "BQUEEN ") {
                legal = 1;
                bcastl++;
            }
        }
    } // end of bking();   

    void check_win() {
        end = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == "WKING  " || board[i][j] == "BKING  ") {
                    end++;
                }
            }
        }
        if (end != 2) {
            System.out.println("Game Over");
            end = 1;
        }
    }  // end of check_win();

    void get_rules() {
        System.out.println();
        System.out.println("Rules...");
        System.out.println("1) White player will make first move ");
        System.out.println("2) Rook (represented) as BROOK (black rook) and WROOK (white rook)");
        System.out.println("   Will make only straight move , means vertically and horizantally");
        System.out.println("3) Horse (represented) as BHORSE (black horse) and WHORSE (white horse) ");
        System.out.println("   Will make two straight move and one turn move , means two vertically");
        System.out.println("   And one horizantally or two horizonatally and one vertically");
        System.out.println("4) Bishop (represented) as BBISHOP (black bishop) and WBISHOP (white bishop)");
        System.out.println("   Will move only diagonally");
        System.out.println("5) Queen (represented) as BQUEEN (black queen) and WQUEEN (white queen)");
        System.out.println("   Can make move of rook and bishop both");
        System.out.println("6) King (represented) as BKING (black king) and WKING (white king) can");
        System.out.println("   Move in any direction but only one move");
        System.out.println("7) Pawn (represented) as BPAWN (black pawn) and WPAWN (white pawn) can");
        System.out.println("   Make only one move(vertically for normal move and diagonally to attack)");
        System.out.println();
    } // end of getRules();

    void get_help() {
        System.out.println();
        System.out.println("Here ,you will know how to make move ");
        System.out.println("1:");
        System.out.println("Enter Initial Position As : Enter Row No. And then Column No.");
        System.out.println("2:");
        System.out.println("Enter Final Position As : Enter Row No. And then Column No.");
        System.out.println("Some Tips :");
        System.out.println("1) Stay Focused");
        System.out.println("2) Protect Your Queen as it has special moves");
        System.out.println("3) Try to block opponent queen");
        System.out.println("4) And always make move with a backup plan");
        System.out.println("...........BEST OF LUCK..........");
    } // end of getHelp();

    void statistics() {
        System.out.println("White Wins = " + winwhite);
        System.out.println("Black Wins = " + winblack);

    } // end of statistics();

    void bking_check(int r1, int c1) {
        check = 0;
        int r2 = 0;
        int c2 = 0;
        int count = 0;
        if (c1 != 7 && board[r1][c1] == "WPAWN  " && board[r1 - 1][c1 + 1] == "BKING  ") {
            System.out.println("Check...");
            check = 1;
        }
        if (c1 != 0 && board[r1][c1] == "WPAWN  " && board[r1 - 1][c1 - 1] == "BKING  ") {
            check = 1;
            System.out.println("\nCheck...");
        }
        if (board[r1][c1] == "WROOK  ") {
            for (int i = r1 + 1; i < 8; i++) {
                if (board[i][c1] != "       ") {
                    count++;
                }
                if (board[i][c1] == "BKING  " && count == 0) {
                    System.out.println("\nCheck...");
                    check = 1;
                    break;
                }
            }
            for (int i = c1 + 1; i < 8; i++) {
                if (board[r1][i] != "       ") {
                    count++;
                }
                if (board[r1][i] == "BKING  " && count == 0) {
                    System.out.println("\nCheck...");
                    check = 1;
                    break;
                }
            }
        }
        if (board[r1][c1] == "WHORSE ") {
            int sto = pospis("BKING  ");
            r2 = sto / 10;
            c2 = sto % 10;
            whorse(r1, c1, r2, c2);
            if (legal == 1) {
                check = 1;
                System.out.println("\nCheck...");
            }
        }
        if (board[r1][c1] == "WBISHOP") {
            int sto = pospis("BKING  ");
            r2 = sto / 10;
            c2 = sto % 10;
            wbishop(r1, c1, r2, c2);
            if (legal == 1) {
                System.out.println("\nCheck...");
                check = 1;
            }
        }
        if (board[r1][c1] == "WQUEEN ") {
            int sto = pospis("BKING  ");
            r2 = sto / 10;
            c2 = sto % 10;
            wqueen(r1, c1, r2, c2);
            if (legal == 1) {
                System.out.println("Check...");
                check = 1;
            }
        }
    } // end of bking_check();

    void wking_check(int r1, int c1) {
        check = 0;
        int r2 = 0;
        int c2 = 0;
        int count = 0;
        if (c1 != 7 && board[r1][c1] == "BPAWN  " && board[r1 + 1][c1 + 1] == "WKING  ") {
            System.out.println("Check...");
            check = 1;
        }
        if (c1 != 0 && board[r1][c1] == "BPAWN  " && board[r1 + 1][c1 - 1] == "WKING  ") {
            System.out.println("\nCheck...");
            check = 1;
        }
        if (board[r1][c1] == "BROOK  ") {
            for (int i = r1 + 1; i < 8; i++) {
                if (board[i][c1] != "       ") {
                    count++;
                }
                if (board[i][c1] == "WKING  " && count == 0) {
                    System.out.println("\nCheck...");
                    check = 1;
                    break;
                }
            }
            for (int i = c1 + 1; i < 8; i++) {
                if (board[r1][i] != "       ") {
                    count++;
                }
                if (board[r1][i] == "WKING  " && count == 0) {
                    System.out.println("\nCheck...");
                    check = 1;
                    break;
                }
            }
        }
        if (board[r1][c1] == "BHORSE ") {
            int sto = pospis("WKING  ");
            r2 = sto / 10;
            c2 = sto % 10;
            bhorse(r1, c1, r2, c2);
            if (legal == 1) {
                System.out.println("\nCheck...");
                check = 1;
            }
        }
        if (board[r1][c1] == "BBISHOP") {
            int sto = pospis("WKING  ");
            r2 = sto / 10;
            c2 = sto % 10;
            wbishop(r1, c1, r2, c2);
            if (legal == 1) {
                System.out.println("\nCheck...");
                check = 1;
            }
        }
        if (board[r1][c1] == "BQUEEN ") {
            int sto = pospis("WKING  ");
            r2 = sto / 10;
            c2 = sto % 10;
            wqueen(r1, c1, r2, c2);
            if (legal == 1) {
                System.out.println("Check...");
                check = 1;
            }
        }
    } // end of wking_check();

    int pospis(String sto) {
        int pos = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == sto) {
                    pos = i * 10 + j;
                }
            }
        }
        return pos;
    }

    public void chessplay() {
        ChessGame ob = new ChessGame();
        Scanner sc = new Scanner(System.in);
        int choice;
        for (;;) {
            System.out.println("......WELCOME......");
            System.out.println("ENTER YOUR CHOICE  ");
            System.out.println("1 : START_GAME     ");  // working on this only
            System.out.println("2 : GET_RULES      ");
            System.out.println("3 : GET_HELP       ");
            System.out.println("4 : STATISTICS     ");
            System.out.println("5 : END_GAME       ");
            choice = sc.nextInt();
            if (choice == 1) {
                ob.start_game();
            } else if (choice == 2) {
                ob.get_rules();
            } else if (choice == 3) {
                ob.get_help();
            } else if (choice == 4) {
                ob.statistics();
            } else if (choice == 5) {
                System.out.println("....BYE....");
                break;
            }
        }
    } // end of main();
}

class Calender {

    public void work() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Month and year");
        int month = sc.nextInt();
        int year = sc.nextInt();
        int tdays = 4;
        int y = year - 1;
        int mon = month - 1;
        int m[] = {0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        while (y > 2015) {
            if (y % 4 == 0) {
                tdays += 366;
            } else {
                tdays += 365;
            }
            y--;
        }
        while (mon > 0) {
            if (year % 4 == 0) {
                m[2] = 29;
            } else {
                m[2] = 28;
            }
            tdays += m[mon];
            mon--;
        }
        while (tdays >= 7) {
            tdays = tdays - 7;
        }
        System.out.println("Mon\tTue\tWed\tThu\tFri\tSat\tSun");
        for (int i = 1; i <= tdays; i++) {
            System.out.print("\t");
        }
        for (int i = 1; i <= m[month]; i++) {
            if (tdays == 7) {
                System.out.println();
                tdays = 0;
            }
            System.out.print(i + "\t");
            tdays++;
        }
        System.out.println();
    }
}