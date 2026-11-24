import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

// [Console]::InputEncoding = [System.Text.UTF8Encoding]::new()
// [Console]::OutputEncoding = [System.Text.UTF8Encoding]::new()
// $env:JAVA_TOOL_OPTIONS = "-Dfile.encoding=UTF-8"''

public class Schach {
    
public static char[][] Spielfeld = {
            {'R','K','B','D','M','B','K','R'},
            {'P','P','P','P','P','P','P','P'},
            {'q','q','q','q','q','q','q','q'},
            {'q','q','q','q','q','q','q','q'},
            {'q','q','q','q','q','q','q','q'},
            {'q','q','q','q','q','q','q','q'},
            {'p','p','p','p','p','p','p','p'},
            {'r','k','b','d','m','b','k','r'},
        };
    public static char[][] Reset = {
            {'R','K','B','D','M','B','K','R'},
            {'P','P','P','P','P','P','P','P'},
            {'q','q','q','q','q','q','q','q'},
            {'q','q','q','q','q','q','q','q'},
            {'q','q','q','q','q','q','q','q'},
            {'q','q','q','q','q','q','q','q'},
            {'p','p','p','p','p','p','p','p'},
            {'r','k','b','d','m','b','k','r'},
        };
    public static int [] spieler = {1, 2};
    public int [] runden = new int [2];
    public static int [] Punktzahl = {0, 0};
    static final String PURPLE = "\u001B[35m";
    static final String RESET = "\u001B[0m";
    static final String BG_GREEN = "\u001B[42m";


    public static void Schach(String[] args){
        System.setOut(new PrintStream(
            System.out,
            true,
            StandardCharsets.UTF_8
        ));
        Ausgabe();
        play();
        Ausgabe();
        //int [][][] zahlen = new int [3][4][7]; 
        //System.out.println(zahlen[0][0].length);
        
    }

    public static void play(){
        while (Punktzahl[0] <=5 || Punktzahl[1] <=5 ){
            boolean x = false;
            int i=0;
            while(x==false){
                Figurenauswahl(spieler[i]);
                Figurenbewegung(spieler[i]);
                if(i == 0){
                    i=1;
                }else if(i == 1){
                    i=0;
                }
            }
            System.out.println("Spieler 1:" + Punktzahl[0] + "Spieler2:" + Punktzahl[1]);
            reset();
        }
    }
    public static void reset(){
        Spielfeld=Reset;
    }

    public static void Figurenauswahl(int Spieler){
        boolean x = false;
        char spieleryb = 'p';
        int spielerx = 10;
        int spielery = 0;
        while(x == false){
            while (spieleryb > 104 || spieleryb < 97 || spielerx > 8){
                Scanner input = new Scanner(System.in);
                System.out.println("Welche Stelle willst du Spieler "+Spieler+"?(Buchstaben)");
                spieleryb = input.next().charAt(0);
                System.out.println("Welche Stelle willst du Spieler "+Spieler+"?(Zahlen)");
                spielerx = input.nextInt();
                spielerx--;
            }
            spielery = BuchstabenzuZahlen(spieleryb);
            if(Spieler == 1 && istSchwarz(spielery, spielerx)){
                x = true;
            }else if (Spieler == 0 && istWeiß(spielery, spielerx)){
                x = true;
            }
        }
        char y = Spielfeld[spielery][spielerx];
        switch(y){
            case 'R':
                Rook(spielery, spielerx);
                break;
            case 'K':
                Knight(spielery, spielerx);
                break;
            case 'B':
                Bishop(spielery, spielerx);
                break;
            case 'D':
                Dame(spielery, spielerx);
                break;
            case 'M':
                King(spielery, spielerx);
                break;
            case 'P':
                Pawn(spielery, spielerx);
                break;
            case 'r':
                Rook(spielery, spielerx);
                break;
            case 'k':
                Knight(spielery, spielerx);
                break;
            case 'b':
                Bishop(spielery, spielerx);
                break;
            case 'd':
                Dame(spielery, spielerx);
                break;
            case 'm':
                King(spielery, spielerx);
                break;
            case 'p':
                Pawn(spielery, spielerx);
                break;
        }
    }
    public static void Rook(int a, int b){
        System.out.println("┌────┬────┬────┬────┬────┬────┬────┬────┐");
        for (int i = 0; i<8; i++){
            System.out.print("│");
            for(int j = 0; j<8; j++){
                if(i==a&&j==b){
                    System.out.print(PURPLE);
                }
                char x = Spielfeld[i][j];
                switch (x) {
                    case 'R' -> System.out.print(" ♜  ");
                    case 'K' -> System.out.print(" ♞  ");
                    case 'B' -> System.out.print(" ♝  ");
                    case 'D' -> System.out.print(" ♛  ");
                    case 'M' -> System.out.print(" ♚  ");
                    case 'P' -> System.out.print(" ♟  ");
                    case 'r' -> System.out.print(" ♖  ");
                    case 'k' -> System.out.print(" ♘  ");
                    case 'b' -> System.out.print(" ♗  ");
                    case 'd' -> System.out.print(" ♕  ");
                    case 'm' -> System.out.print(" ♔  ");
                    case 'p' -> System.out.print(" ♙  ");
                    default -> System.out.print("    ");
                }
                System.out.print(RESET);
                if(j!=7){
                    System.out.print("│");
                }
            }
            System.out.print("│");
            System.out.println("");
            if(i!=7){
                    System.out.println("├────┼────┼────┼────┼────┼────┼────┼────┤");
                }
        }
        System.out.println("└────┴────┴────┴────┴────┴────┴────┴────┘");
    }
    public static void Knight(int a, int b){
        System.out.println("┌────┬────┬────┬────┬────┬────┬────┬────┐");
        for (int i = 0; i<8; i++){
            System.out.print("│");
            for(int j = 0; j<8; j++){
                if(i==a&&j==b){
                    System.out.print(PURPLE);
                }
                if((i==a+2||i==a-2) && (j==b-1||j==b+1)){
                    System.out.print(BG_GREEN);
                }
                char x = Spielfeld[i][j];
                switch (x) {
                    case 'R' -> System.out.print(" ♜  ");
                    case 'K' -> System.out.print(" ♞  ");
                    case 'B' -> System.out.print(" ♝  ");
                    case 'D' -> System.out.print(" ♛  ");
                    case 'M' -> System.out.print(" ♚  ");
                    case 'P' -> System.out.print(" ♟  ");
                    case 'r' -> System.out.print(" ♖  ");
                    case 'k' -> System.out.print(" ♘  ");
                    case 'b' -> System.out.print(" ♗  ");
                    case 'd' -> System.out.print(" ♕  ");
                    case 'm' -> System.out.print(" ♔  ");
                    case 'p' -> System.out.print(" ♙  ");
                    default -> System.out.print("    ");
                }
                System.out.print(RESET);
                if(j!=7){
                    System.out.print("│");
                }
            }
            System.out.print("│");
            System.out.println("");
            if(i!=7){
                    System.out.println("├────┼────┼────┼────┼────┼────┼────┼────┤");
                }
        }
        System.out.println("└────┴────┴────┴────┴────┴────┴────┴────┘");
    }
    public static void Bishop(int i, int j){
        
    }
    public static void Dame(int i, int j){
        
    }
    public static void King(int i, int j){
        
    }
    public static void Pawn(int i, int j){
        
    }

    public static int BuchstabenzuZahlen(char x){
        switch(x){
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 6;
            case 'h':
                return 7;
            default:
                return 0;
        }
    }
    
    public static void Figurenbewegung(int Spieler){
        char spielery = 'p';
        int spielerx = 10;
        while (spielery > 104 || spielery < 97 || spielerx > 8){
            Scanner input = new Scanner(System.in);
            System.out.println("Welche Stelle willst du Spieler "+Spieler+"?(Buchstaben)");
            spielery = input.next().charAt(0);
            System.out.println("Welche Stelle willst du Spieler "+Spieler+"?(Zahlen)");
            spielerx = input.nextInt();
        }
    }

    

    public static boolean istSchwarz(int i, int j){
        char x = Spielfeld[i][j];
        switch(x){
            case 'R':
                return true;
            case 'K':
                return true;
            case 'B':
                return true;
            case 'D':
                return true;
            case 'M':
                return true;
            case 'P':
                return true;
            default:
                return false;
        }
    }

    public static boolean istWeiß(int i, int j){
        char x = Spielfeld[i][j];
        switch(x){
            case 'r':
                return true;
            case 'k':
                return true;
            case 'b':
                return true;
            case 'd':
                return true;
            case 'm':
                return true;
            case 'p':
                return true;
            default:
                return false;
        }
    }
    
    public static void Ausgabe(){
        System.out.println("┌────┬────┬────┬────┬────┬────┬────┬────┐");
        for (int i = 0; i<8; i++){
            System.out.print("│");
            for(int j = 0; j<8; j++){
                char x = Spielfeld[i][j];
                switch (x) {
                    case 'R' -> System.out.print(" ♜  ");
                    case 'K' -> System.out.print(" ♞  ");
                    case 'B' -> System.out.print(" ♝  ");
                    case 'D' -> System.out.print(" ♛  ");
                    case 'M' -> System.out.print(" ♚  ");
                    case 'P' -> System.out.print(" ♟  ");
                    case 'r' -> System.out.print(" ♖  ");
                    case 'k' -> System.out.print(" ♘  ");
                    case 'b' -> System.out.print(" ♗  ");
                    case 'd' -> System.out.print(" ♕  ");
                    case 'm' -> System.out.print(" ♔  ");
                    case 'p' -> System.out.print(" ♙  ");
                    default -> System.out.print("    ");
                }
                if(j!=7){
                    System.out.print("│");
                }
            }
            System.out.print("│");
            System.out.println("");
            if(i!=7){
                    System.out.println("├────┼────┼────┼────┼────┼────┼────┼────┤");
                }
        }
        System.out.println("└────┴────┴────┴────┴────┴────┴────┴────┘");   
    }


}
