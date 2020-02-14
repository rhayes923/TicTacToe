/**
 * TicTacToe class implements the interface
 * @author relkharboutly
 * @date 1/5/2017
 */
public class TicTacToe implements ITicTacToe {
		 
	   // The game board and the game status
	   private static final int ROWS = 3, COLS = 3; // number of rows and columns
	   private int[][] board = new int[ROWS][COLS]; // game board in 2D array
	   private boolean chosen;
	  
	/**
	 * clear board and set current player   
	 */
	public TicTacToe(){
		
	}
	@Override
	public void clearBoard() {
		board = new int[ROWS][COLS];
	}
	
	@Override
	public void setMove(int player, int location) {
		int current;
		if (player == 0) {
			current = NOUGHT;
		} else {
			current = CROSS;
		}
		switch (location) {
		case 0:
			if (board[0][0] == EMPTY) {
				board[0][0] = current;
			} else {
				return;
			}
			break;
		case 1:
			if (board[0][1] == EMPTY) {
				board[0][1] = current;
			} else {
				return;
			}
			break;
		case 2:
			if (board[0][2] == EMPTY) {
				board[0][2] = current;
			} else {
				return;
			}
			break;
		case 3:
			if (board[1][0] == EMPTY) {
				board[1][0] = current;
			} else {
				return;
			}
			break;
		case 4:
			if (board[1][1] == EMPTY) {
				board[1][1] = current;
			} else {
				return;
			}
			break;
		case 5:
			if (board[1][2] == EMPTY) {
				board[1][2] = current;
			} else {
				return;
			}
			break;
		case 6:
			if (board[2][0] == EMPTY) {
				board[2][0] = current;
			} else {
				return;
			}
			break;
		case 7:
			if (board[2][1] == EMPTY) {
				board[2][1] = current;
			} else {
				return;
			}
			break;
		case 8:
			if (board[2][2] == EMPTY) {
				board[2][2] = current;
			} else {
				return;
			}
			break;
		}
		TTTConsole.currentPlayer = 0;
	}

	@Override
	public int getComputerMove() {
		
		if (board[0][0] == CROSS && board[0][1] == CROSS && board[0][2] == EMPTY) {
			return 2;
		} else if ((board[0][0] == CROSS && board[0][1] == EMPTY && board[0][2] == CROSS)) {
			return 1;
		} else if ((board[0][0] == EMPTY && board[0][1] == CROSS && board[0][2] == CROSS)) {
			return 0;
			
		} else if ((board[1][0] == CROSS && board[1][1] == CROSS && board[1][2] == EMPTY)) {
			return 5;
		} else if ((board[1][0] == CROSS && board[1][1] == EMPTY && board[1][2] == CROSS)) {
			return 4;
		} else if ((board[1][0] == EMPTY && board[1][1] == CROSS && board[1][2] == CROSS)) {
			return 3;
			
		} else if ((board[2][0] == CROSS && board[2][1] == CROSS && board[2][2] == EMPTY)) {
			return 8;
		} else if ((board[2][0] == CROSS && board[2][1] == EMPTY && board[2][2] == CROSS)) {
			return 7;
		} else if ((board[2][0] == EMPTY && board[2][1] == CROSS && board[2][2] == CROSS)) {
			return 6;
		
		} else if ((board[0][0] == CROSS && board[1][0] == CROSS && board[2][0] == EMPTY)) {
			return 6;
		} else if ((board[0][0] == CROSS && board[1][0] == EMPTY && board[2][0] == CROSS)) {
			return 3;
		} else if ((board[0][0] == EMPTY && board[1][0] == CROSS && board[2][0] == CROSS)) {
			return 0;
		
		} else if ((board[0][1] == CROSS && board[1][1] == CROSS && board[2][1] == EMPTY)) {
			return 7;
		} else if ((board[0][1] == CROSS && board[1][1] == EMPTY && board[2][1] == CROSS)) {
			return 4;
		} else if ((board[0][1] == EMPTY && board[1][1] == CROSS && board[2][1] == CROSS)) {
			return 1;
			
		} else if ((board[0][2] == CROSS && board[1][2] == CROSS && board[2][2] == EMPTY)) {
			return 8;
		} else if ((board[0][2] == CROSS && board[1][2] == EMPTY && board[2][2] == CROSS)) {
			return 5;
		} else if ((board[0][2] == EMPTY && board[1][2] == CROSS && board[2][2] == CROSS)) {
			return 2;
			
		} else if ((board[0][0] == CROSS && board[1][1] == CROSS && board[2][2] == EMPTY)) {
			return 8;
		} else if ((board[0][0] == CROSS && board[1][1] == EMPTY && board[2][2] == CROSS)) {
			return 4;
		} else if ((board[0][0] == EMPTY && board[1][1] == CROSS && board[2][2] == CROSS)) {
			return 0;
			
		} else if ((board[0][2] == CROSS && board[1][1] == CROSS && board[2][0] == EMPTY)) {
			return 6;
		} else if ((board[0][2] == CROSS && board[1][1] == EMPTY && board[2][0] == CROSS)) {
			return 4;
		} else if ((board[0][2] == EMPTY && board[1][1] == CROSS && board[2][0] == CROSS)) {
			return 2;
			
		} else {
			boolean chosen = false;
			while (!chosen) {
				int rand = (int) (Math.random() * 9);
				if (rand == 9) {
					rand = 8;
				}
				switch (rand) {
				case 0:
					if (board[0][0] == EMPTY) {
						return rand;
					}
					break;
				case 1:
					if (board[0][1] == EMPTY) {
						return rand;
					}
					break;
				case 2:
					if (board[0][2] == EMPTY) {
						return rand;
					}
					break;
				case 3:
					if (board[1][0] == EMPTY) {
						return rand;
					}
					break;
				case 4:
					if (board[1][1] == EMPTY) {
						return rand;
					}
					break;
				case 5:
					if (board[1][2] == EMPTY) {
						return rand;
					}
					break;
				case 6:
					if (board[2][0] == EMPTY) {
						return rand;
					}
					break;
				case 7:
					if (board[2][1] == EMPTY) {
						return rand;
					}
					break;
				case 8:
					if (board[2][2] == EMPTY) {
						return rand;
					}
					break;
				}
			}
		}
		return -1;
	}

	@Override
	public int checkForWinner() {
		if (board[0][0] == CROSS && board[0][1] == CROSS && board[0][2] == CROSS) {
			return 2;
		} else if (board[0][0] == NOUGHT && board[0][1] == NOUGHT && board[0][2] == NOUGHT) {
			return 3;
		
		} else if (board[1][0] == CROSS && board[1][1] == CROSS && board[1][2] == CROSS) {
			return 2;
		} else if (board[1][0] == NOUGHT && board[1][1] == NOUGHT && board[1][2] == NOUGHT) {
			return 3;
		
		} else if (board[2][0] == CROSS && board[2][1] == CROSS && board[2][2] == CROSS) {
			return 2;
		} else if (board[2][0] == NOUGHT && board[2][1] == NOUGHT && board[2][2] == NOUGHT) {
			return 3;
			
		} else if (board[0][0] == CROSS && board[1][0] == CROSS && board[2][0] == CROSS) {
			return 2;
		} else if (board[0][0] == NOUGHT && board[1][0] == NOUGHT && board[2][0] == NOUGHT) {
			return 3;
			
		} else if (board[0][1] == CROSS && board[1][1] == CROSS && board[2][1] == CROSS) {
			return 2;
		} else if (board[0][1] == NOUGHT && board[1][1] == NOUGHT && board[2][1] == NOUGHT) {
			return 3;
			
		} else if (board[0][2] == CROSS && board[1][2] == CROSS && board[2][2] == CROSS) {
			return 2;
		} else if (board[0][2] == NOUGHT && board[1][2] == NOUGHT && board[2][2] == NOUGHT) {
			return 3;
			
		} else if (board[0][0] == CROSS && board[1][1] == CROSS && board[2][2] == CROSS) {
			return 2;
		} else if (board[0][0] == NOUGHT && board[1][1] == NOUGHT && board[2][2] == NOUGHT) {
			return 3;
			
		} else if (board[0][2] == CROSS && board[1][1] == CROSS && board[2][0] == CROSS) {
			return 2;
		} else if (board[0][2] == NOUGHT && board[1][1] == NOUGHT && board[2][0] == NOUGHT) {
			return 3;
			
			
		} else if (board[0][0] != EMPTY && board[0][1] != EMPTY && board[0][2] != EMPTY &&
				board[1][0] != EMPTY && board[1][1] != EMPTY && board[1][2] != EMPTY && 
				board[2][0] != EMPTY && board[2][1] != EMPTY && board[2][2] != EMPTY) {
			return 1;
		}
		return 0;
	}
	
	  /**
	   *  Print the game board 
	   */
	   public  void printBoard() {
	      for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLS; ++col) {
	            printCell(board[row][col]); // print each of the cells
	            if (col != COLS - 1) {
	               System.out.print("|");   // print vertical partition
	            }
	         }
	         System.out.println();
	         if (row != ROWS - 1) {
	            System.out.println("-----------"); // print horizontal partition
	         }
	      }
	      System.out.println();
	   }
	 
	   /**
	    * Print a cell with the specified "content" 
	    * @param content either CROSS, NOUGHT or EMPTY
	    */
	   public void printCell(int content) {
	      switch (content) {
	         case EMPTY:  System.out.print("   "); break;
	         case NOUGHT: System.out.print(" O "); break;
	         case CROSS:  System.out.print(" X "); break;
	      }
	   }
}
