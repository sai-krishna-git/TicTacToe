import java.util.Scanner;

public class TicTacToe{
    public static void main(String[] args) {
        System.out.println("hi I am Sai Krishna.Enjoy playing the game:)");
        System.out.println("Choose your option");
        boolean optselect=false;
        Scanner sc=new Scanner(System.in);
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
                        int mode=sc.nextInt();
                        if(mode==1){
                            gameselect=true;
                        }
                        else if(mode==2){
                            gameselect=true;
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
        sc.close();
    }
}