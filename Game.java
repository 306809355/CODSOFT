import java.util.Scanner;

class Random{
    public int generaterandom()
    {
        return 1 + (int)((Math.random()*(100-1))+1);
    }
}

public class Game {
    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random obj = new Random();
        boolean PlayAgain = true;
          System.out.println("Welcome to the Number Guessing Game");
          System.out.println();
          int attempt = 10;
          int score = 0;
          int correct = 0;
          while(PlayAgain)
          {
             //prompt the user to enter number
             System.out.print("Guess the secret number (between 1 and 100): ");
             int unum = scanner.nextInt();
             System.out.println();
             int gnum = obj.generaterandom();
             if(unum==gnum)
             {
                System.out.println("Congratulations! You guessed the correct number!");
                score+=10;
                correct++;
             }
             else if(unum<gnum)
             {
                System.out.println("Too low. Try a higher number.");
             }
             else
             {
                System.out.println("Too high. Try a lower number.");
             }
             attempt--;
             System.out.println();
             System.out.println("Correct Number: "+gnum);
             System.out.println();
             System.out.println("Attempt left: "+attempt);
             System.out.println();
             System.out.println("************************************************");
             System.out.println();
             if(attempt==0)
             {
                System.out.println("Your Score: "+score);
                System.out.println("Your Succes rate: "+(correct*10)+"%");
                System.out.println("-------------------------------------------------");

                System.out.print("Would you like to play again? (Yes/No):");
                String choose = scanner.next().toLowerCase();
                System.out.println("-------------------------------------------------");
                if(choose.equals("yes"))
                {
                    PlayAgain = true;
                    attempt=10;
                }
                else
                {
                    PlayAgain = false;
                    break;
                }
             }

          }

        scanner.close();
    }
}
