import java.util.Scanner;
public class TicTacToe{
    
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("hi I am Sai Krishna.Enjoy playing the game:)");
        System.out.println("Choose your option");
        boolean optselect=false;
        while(optselect==false){ 
            System.out.println("Game Menu");
            System.out.println("1.Play");
            System.out.println("2.exit");
            System.out.print("Enter your option: ");
            int option=sc.nextInt();
            if(option==1){
                optselect=true;
                boolean gameselect=false;
                    while(gameselect==false){ 
                        System.out.println("Choose the game mode");
                        System.out.println("1.Player vs Player");
                        System.out.println("2.Player vs Computer");
                        System.out.println("3.Go back to Menu");
                        System.out.print("Enter your option: ");
                        int mode=sc.nextInt();
                        if(mode==1){
                            gameselect=true;
                            playervsplayer();
                        }
                        else if(mode==2){
                            gameselect=true;
                            PlayervsComputer obj=new PlayervsComputer();
                            obj.playervsComputer();
                        }
                        else if(mode==3){
                            gameselect=true;
                            optselect=false;
                        }
                        else{
                            System.out.println("Invalid Option.Choose again.");
                        }
                    }
                }
            else if(option==2){
                System.out.println("Exiting game...");
                optselect=true;
            }
            else{
                System.out.println("Invalid Option.Choose again.");
            }
        }
    }

    public static void playervsplayer() {
        char[][] board=new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j]=' ';
            }
        }
        boolean gameover=false;
        System.out.print("Enter player1's name :");
        String dummy=sc.nextLine();//for consuming <space> from before input
        String player1=sc.nextLine();
        System.out.print("Enter player2's name :");
        String player2=sc.nextLine();
        char player='X';
        while(!gameover){
            if(boardfull(board)){
                System.out.println("Game Ties");
                break;
            }
            showboard(board);
            if(player=='X'){
                System.out.println("player "+ player1+"'s Turn");
            }
            else{
                System.out.println("player "+ player2+"'s Turn");
            }
            System.out.print("Enter box no : ");
            int pos=sc.nextInt()-1;
            if(board[pos/3][pos%3]==' '){
                board[pos/3][pos%3]=player;
                if(checkwin(board,player)){
                    if(player=='X'){
                            System.out.println("Player "+ player1+" wins");
                        }
                        else{
                            System.out.println("Player "+ player2+" wins");
                        }
                    gameover=true;
                }
                else{
                    if(player=='X'){
                        player='O';
                    }
                    else{
                        player='X';
                    }
                }
            }
            else{
                System.out.println("Invalid move. Try again!");
            }
        }


    }

    public static boolean boardfull(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==' '){
                    return false;
                }
            }
        }
        return true;
    }

    public static void showboard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]+"|");
            }
            System.out.println();
        }
    }

    public static boolean checkwin(char[][] board, char player) {
        //row-wise checking
        for (int i = 0; i < board.length; i++) {
            if(board[i][0]==player && board[i][1]==player && board[i][2]==player){
                return true;
            }
        }
        //column-wise checking
        for (int j = 0; j < board.length; j++) {
            if(board[0][j]==player && board[1][j]==player && board[2][j]==player){
                return true;
            }
        }
        //diagonal-wise checking
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
                return true;
            }
        if(board[2][0]==player && board[1][1]==player && board[0][2]==player){
                return true;
            }
        return false;
    }

    
}