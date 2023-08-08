import java.util.Scanner;

public class PlayervsComputer {
    static Scanner sc=new Scanner(System.in);
    static TicTacToe obj=new TicTacToe();
    public static void playervsComputer() {
        char[][] board=new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j]=' ';
            }
        }
        boolean gameover=false;
        System.out.print("Enter player's name :");
        String player1=sc.nextLine();
        char player='X';
        while(!gameover){
            if(obj.checkwin(board,player)){
                        if(player=='O'){
                                System.out.println("Player "+ player1+" wins");
                            }
                            else{
                                System.out.println("Computer wins");
                            }
                        gameover=true;
                    }
            if(obj.boardfull(board)){
                System.out.println("Game Ties");
                break;
            }
            if(player=='X'){
                System.out.println("Computer's Turn");
                bestmove(board);
                obj.showboard(board);
                if(obj.checkwin(board,player)){
                        if(player=='O'){
                                System.out.println("Player "+ player1+" wins");
                            }
                            else{
                                System.out.println("Computer wins");
                            }
                        gameover=true;
                    }
                    
                player='O';
            }
            else{
                System.out.println("player "+ player1+"'s Turn");
                System.out.print("Enter box no : ");
                int pos=sc.nextInt()-1;
                if(board[pos/3][pos%3]==' '){
                    board[pos/3][pos%3]=player;
                }
                else{
                    System.out.println("Invalid move. Try again!");
                }
            obj.showboard(board);
                if(obj.checkwin(board,player)){
                        if(player=='O'){
                                System.out.println("Player "+ player1+" wins");
                            }
                            else{
                                System.out.println("Computer wins");
                            }
                        gameover=true;
                    }    
                player='X';
            }
        }   
    }
    public static void bestmove(char[][] board) {
        int bestScore=Integer.MIN_VALUE;
        int score;
        int pos=0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==' '){
                    board[i][j]='X';
                    score=minmax(board,0,false);
                    board[i][j]=' ';
                    if(score>bestScore){
                        bestScore=score;
                        pos=3*i+j+1;
                    }
                }
            }
        }
        pos--;
        board[pos/3][pos%3]='X';
    }
    public static int minmax(char[][] board,int depth,boolean ismaximizing) {
        if(obj.checkwin(board,'X')){
            return 1;
        }
        else if(obj.checkwin(board, 'O')){
            return -1;
        }
       if(obj.boardfull(board)){
        return 0;
       }
       if(ismaximizing){
            int bestScore=Integer.MIN_VALUE;
            int score;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if(board[i][j]==' '){
                        board[i][j]='X';
                        score=minmax(board,depth+1,false);
                        board[i][j]=' ';
                        bestScore=Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
       }
       else{
            int bestScore=Integer.MAX_VALUE;
                int score;
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[0].length; j++) {
                        if(board[i][j]==' '){
                            board[i][j]='O';
                            score=minmax(board,depth+1,true);
                            board[i][j]=' ';
                            bestScore=Math.min(score, bestScore);
                        }
                    }
                }
                return bestScore;
       }
    }
    public static void main(String[] args) {
        
    }
}
