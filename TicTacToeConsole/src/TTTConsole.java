import java.util.Scanner;
/**
 * Tic-Tac-Toe: Two-player console, non-graphics
 * @author relkharboutly
 * @date 1/5/2017
 */
public class TTTConsole  {
                                                     
   public static Scanner in = new Scanner(System.in); // the input Scanner
 
   public static TicTacToe TTTboard = new TicTacToe();
   
   protected static int currentPlayer = 1;
   
   private static boolean valid;
   
   /** The entry main method (the program starts here) */
   public static void main(String[] args) {
      
	   int currentState = TicTacToe.PLAYING;
	   String userInput = null;
	   //game loop
	   do {
         TTTboard.printBoard();
         // Print message if game-over
         currentState = TTTboard.checkForWinner();
         /**
          * get player input here and call setMove(). user should input a number between 0-8
          */

         if (currentState == ITicTacToe.CROSS_WON) {
            System.out.println("'X' won! Bye!");
         } else if (currentState == ITicTacToe.NOUGHT_WON) {
            System.out.println("'O' won! Bye!");
         } else if (currentState == ITicTacToe.TIE) {
            System.out.println("It's a TIE! Bye!");
         }
         
         if (currentPlayer == 0) {
         	TTTboard.setMove(0, TTTboard.getComputerMove());
         	currentPlayer = 1;
          } else {
 	         valid = false;
 	         while (!valid) {
 	        	 userInput = in.next();
 	        	 try {
 	        		 int move = Integer.valueOf(userInput);
 	        		 if (move >= 0 && move <= 8) {
 	        			 TTTboard.setMove(1, move);
 	            		 valid = true;
 	            	 }
 	        	 } catch (NumberFormatException e) {
 	        		 if (userInput.equals("q")) {
 	        			 return;
 	        		 }
 	        	 }
 	         }
          }
         
      } while ((currentState == ITicTacToe.PLAYING) && (!userInput.equals("q"))); // repeat if not game-over
   }
}