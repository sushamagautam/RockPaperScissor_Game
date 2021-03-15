package rockPaperScissor;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissor {
   public static void main(String[]args){
       Random rand = new Random();					//for computer to choose random number
       Scanner userInput = new Scanner(System.in);	//user selects the number & give the input
       int level = 0, pcScore = 0, youScore = 0;	//initialize the level & scores
       while(level < 3) {							// it's a best of 3 game, hence level = 3
           System.out.println("(1) Rock\t  (2) Paper\t  (3) Scissor");
           System.out.print("Enter your Choice : ");
           int user_choice = userInput.nextByte();
           int computer_choice = rand.nextInt(3)+1;
           System.out.println("You chose "+ user_choice);
           System.out.println("Computer chose "+ computer_choice);
           
           if (gameResponse(user_choice, computer_choice) == 2){
               pcScore++;
               System.out.println("\n Computer won this round \n");
           }else if (gameResponse(user_choice, computer_choice) == 1){
               youScore++;
               System.out.println("\n You won this round \n");
           }else if(gameResponse(user_choice, computer_choice) == 3){
               System.out.println("\n This round is a TIE! \n");
           }
           else{
               System.out.println("Something went wrong. Enter a valid option and try again");
               return;
           }
           level++;
       }
       System.out.println("******Final Verdict******");
       if (pcScore > youScore){
           System.out.println(">>>> Computer Wins! <<<<");
       }else if(pcScore == youScore){
           System.out.println(">>>> Ops, This game is a TIE! Play again? <<<<");
       }
       else {
           System.out.println(">>>> You Win! <<<<");
       }


   }
   
   	/*The outcome of the game is determined by 3 simple rules:
   		-Rock wins against scissors. >>>>(Rock crushes scissors/blunt scissors)
   		-Scissors win against paper. >>>>(Scissors cut papers)
   		-Paper wins against rock. >>>>>>>(paper covers rock) 
   	*/

   public static int gameResponse(int user_choice, int computer_choice){
       if (user_choice == 1 && computer_choice == 2){				//1-Rock, 2-Paper, 3-Scissors
           return 2;
       }else if (user_choice == 2 && computer_choice == 1){
           return 1;
       }else if (user_choice == 3 && computer_choice == 1){
           return 2;
       }else if (user_choice == 1 && computer_choice == 3){
           return 1;
       }else if (user_choice == 2 && computer_choice == 3){
           return 2;
       }else if (user_choice == 3 && computer_choice == 2){
           return 1;
       }else if(user_choice == computer_choice){
           return 3;
       }
       else{
           return -1;
       }

   }
}