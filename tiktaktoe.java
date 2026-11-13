import java.util.Scanner;

class tiktaktoe{

    //public static char[][] Spielfeld = new char [3][3];
    public static char[][] Spielfeld = {
            {'q','q','q'},
            {'q','q','q'},
            {'q','q','q'}
        };
    public int [] spieler = {1, 2};
    public int [] runden = new int [2];
    public static int [] Punktzahl = {0, 0};




    public static void tiktaktoe(String[] args){
        Ausgabe();
        play();
        Ausgabe();
        //int [][][] zahlen = new int [3][4][7]; 
        //System.out.println(zahlen[0][0].length);
        
    }

    public static void play(){
        boolean x = false;
        while(x==false){
            Scanner input = new Scanner(System.in);
            System.out.println("Welche Stelle willst du Spieler 1?(horizontal)");
            int spieler1x = input.nextInt();
            System.out.println("Welche Stelle willst du Spieler 1?(vertikal)");
            int spieler1y = input.nextInt();
            Eingabe(1, spieler1x, spieler1y);
            Ausgabe();
            x = Gewinn();
            System.out.println("Welche Stelle willst du Spieler 2?(horizontal)");
            int spieler2x = input.nextInt();
            System.out.println("Welche Stelle willst du Spieler 2?(vertikal)");
            int spieler2y = input.nextInt();
            Eingabe(2, spieler2x, spieler2y);
            Ausgabe();
            x = Gewinn();
        }
        System.out.println(Punktzahl[0] + Punktzahl[1]);
        
    }
    public static void Eingabe(int Spieler, int Stellex, int Stelley){
        char Zeichen = 'q';
        if (Spieler == 1){
            Zeichen = 'X';
        }else{
            Zeichen = 'O';
        }
        if(Stellex >= 4 || Stelley >= 4 || Stellex <=0 || Stelley <=0){

        }else{
            Spielfeld[Stellex - 1][Stelley - 1] = Zeichen;
        }
    }
    public static void Ausgabe(){
        System.out.println("┌───┬───┬───┐");
        for (int i = 0; i<3; i++){
            System.out.print("│");
            for(int j = 0; j<3; j++){
                if (Spielfeld[i][j] == 'X'){
                    System.out.print(" X ");
                }else if(Spielfeld[i][j] == 'O'){
                    System.out.print(" O ");
                }else{
                    System.out.print("   ");
                }
                if(j!=2){
                    System.out.print("│");
                }
            }
            System.out.print("│");
            System.out.println("");
            if(i!=2){
                    System.out.println("├───┼───┼───┤");
                }
            
        }
        System.out.println("└───┴───┴───┘");
          
    }

    public int Gewonnen(){
        int x = 0;
        return x;
    }

    public static boolean Gewinn(){
        boolean x = false;
        int[] vertikalx = new int [3];
        int[] vertikaly = new int [3];
        int horizontalx = 0;
        int horizontaly = 0;
        int diagonölxl = 0;
        int diagonölxr = 0;
        int diagonölyl = 0;
        int diagonölyr = 0;
        boolean diagonöll = false;
        boolean diagonölr = false;
        
        for (int i = 0; i<3; i++){

            for(int j = 0; j<3; j++){
                if(i==0&&j==0 || i==1&&j==1 || i==2&&j==2){
                    diagonöll = true;
                }else{
                    diagonöll =false;
                }
                if(i==0&&j==2 || i==1&&j==1 || i==2&&j==0){
                    diagonölr = true;
                }else{
                    diagonölr =false;
                }
                if (Spielfeld[i][j] == 'X'){
                    if(diagonöll==true){
                        diagonölxl ++;
                    }
                    if(diagonölr==true){
                        diagonölxr ++;
                    }
                    horizontalx ++;
                    vertikalx[i]++;
                }else if (Spielfeld[i][j] == 'O'){
                    if(diagonöll==true){
                        diagonölxr ++;
                    }
                    if(diagonölr==true){
                        diagonölyr ++;
                    }
                    horizontaly ++;
                    vertikaly[i]++;
                }
            }

            x = Gewinncheck(horizontalx, horizontaly);
            horizontalx = 0;
            horizontaly = 0;
        }
        for (int i = 0; i < 3; i++) {
            x = Gewinncheck(vertikalx[i], vertikaly[i]);
        }
        x = Gewinncheck(diagonölxl, diagonölyl);
        x = Gewinncheck(diagonölxr, diagonölyr);
        return x;
    }

    public static boolean Gewinncheck(int x, int y){
        boolean z=false;
        if (x==3 && y==3){
            System.out.println("wie?");
        }else{
            if (x == 3){
                Punktzahl[0] +=1;
                z=true;
            }
            if (y == 3){
                Punktzahl[1] +=1;
                z=true;
            }
        }
        return z;
    }







}