/**
 * Ryan Hayes
 * 2/13/20
 * TicTacToe.java
 *
 * This class manages the actual game within the application.
 */

package edu.quinnipiac.ser210.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TicTacToe extends AppCompatActivity implements ITicTacToe {

    // The game board and the game status
    private static final int ROWS = 3, COLS = 3; // number of rows and columns
    private int[][] board = new int[ROWS][COLS]; // game board in 2D array
    private int currentPlayer;
    private ImageButton button0, button1, button2, button3, button4, button5, button6,
            button7, button8;
    private TextView message;
    private String name, messageText;

    // The lifecycle method for when the activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        name = getIntent().getStringExtra(MainActivity.key);
        message = findViewById(R.id.message);
        messageText = "Welcome " + name;
        message.setText(messageText);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);

        // Retrieves data upon activity creation if applicable
        if (savedInstanceState != null) {
            messageText = savedInstanceState.getString("message");
            message.setText(messageText);
            board = (int[][]) savedInstanceState.getSerializable("board");
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    int index = (i * 3) + j;
                    if (board[i][j] == CROSS) {
                        setImage(index, CROSS);
                    } else if (board[i][j] == NOUGHT) {
                        setImage(index, NOUGHT);
                    }
                }
            }
        }
    }

    // Saves game data upon activity destruction
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putSerializable("board", board);
        savedInstanceState.putString("message", messageText);
    }

    // Set the image of a button
    public void setImage(int index, int symbol) {
        switch (index) {
            case 0:
                if (symbol == CROSS) {
                    button0.setImageResource(R.drawable.cross);
                } else {
                    button0.setImageResource(R.drawable.nought);
                }
                break;
            case 1:
                if (symbol == CROSS) {
                    button1.setImageResource(R.drawable.cross);
                } else {
                    button1.setImageResource(R.drawable.nought);
                }
                break;
            case 2:
                if (symbol == CROSS) {
                    button2.setImageResource(R.drawable.cross);
                } else {
                    button2.setImageResource(R.drawable.nought);
                }
                break;
            case 3:
                if (symbol == CROSS) {
                    button3.setImageResource(R.drawable.cross);
                } else {
                    button3.setImageResource(R.drawable.nought);
                }
                break;
            case 4:
                if (symbol == CROSS) {
                    button4.setImageResource(R.drawable.cross);
                } else {
                    button4.setImageResource(R.drawable.nought);
                }
                break;
            case 5:
                if (symbol == CROSS) {
                    button5.setImageResource(R.drawable.cross);
                } else {
                    button5.setImageResource(R.drawable.nought);
                }
                break;
            case 6:
                if (symbol == CROSS) {
                    button6.setImageResource(R.drawable.cross);
                } else {
                    button6.setImageResource(R.drawable.nought);
                }
                break;
            case 7:
                if (symbol == CROSS) {
                    button7.setImageResource(R.drawable.cross);
                } else {
                    button7.setImageResource(R.drawable.nought);
                }
                break;
            case 8:
                if (symbol == CROSS) {
                    button8.setImageResource(R.drawable.cross);
                } else {
                    button8.setImageResource(R.drawable.nought);
                }
                break;
        }
    }

    // Method called when buttons are clicked
    public void onClick(View view) {
        if (checkForWinner() != 0) {
            if (view.getId() == R.id.reset) {
                clearBoard();
            }
        } else {
            switch (view.getId()) {
                case R.id.button0:
                    setMove(0, 0);
                    break;
                case R.id.button1:
                    setMove(0, 1);
                    break;
                case R.id.button2:
                    setMove(0, 2);
                    break;
                case R.id.button3:
                    setMove(0, 3);
                    break;
                case R.id.button4:
                    setMove(0, 4);
                    break;
                case R.id.button5:
                    setMove(0, 5);
                    break;
                case R.id.button6:
                    setMove(0, 6);
                    break;
                case R.id.button7:
                    setMove(0, 7);
                    break;
                case R.id.button8:
                    setMove(0, 8);
                    break;
            }
        }
    }

    // Creates a new board upon initialization
    public TicTacToe(){
        board = new int[ROWS][COLS];
    }

    // Sets the button images to blank and sets the current player
    @Override
    public void clearBoard() {
        board = new int[ROWS][COLS];
        button0.setImageResource(0);
        button1.setImageResource(0);
        button2.setImageResource(0);
        button3.setImageResource(0);
        button4.setImageResource(0);
        button5.setImageResource(0);
        button6.setImageResource(0);
        button7.setImageResource(0);
        button8.setImageResource(0);
        messageText = "Welcome " + name;
        message.setText(messageText);
        currentPlayer = 0;
    }

    // Method used for each player's turn
    @Override
    public void setMove(int player, int location) {
        int current;
        if (player == 0) {
            current = CROSS;
        } else {
            current = NOUGHT;
        }

        int row = location / 3;
        int col = location % 3;
        System.out.println(location);
        if (board[row][col] == EMPTY) {
            board[row][col] = current;
            setImage(location, current);
        } else {
            return;
        }

        int status = checkForWinner();
        switch (status) {
            case 1:
                messageText = "Draw!";
                message.setText(messageText);
                break;
            case 2:
                messageText = "Cross Wins!";
                message.setText(messageText);
                break;
            case 3:
                messageText = "Nought Wins!";
                message.setText(messageText);
                return;
        }

        if (currentPlayer == 0 && checkForWinner() == 0) {
            currentPlayer = 1;
            setMove(1, getComputerMove());
        } else {
            currentPlayer = 0;
        }
    }

    // Determines where the AI should move
    @Override
    public int getComputerMove() {

        // Checks horizontal placement of X's
        int count = 0;
        int emptySpace = -1;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == CROSS) {
                    count++;
                } else if (board[i][j] == EMPTY) {
                    emptySpace = (i * 3) + j;
                }

            }
            if (count == 2 && emptySpace != -1) {
                return emptySpace;

            }
            count = 0;
        }

        // Checks vertical placement of X's
        count = 0;
        emptySpace = -1;
        for (int i = 0; i < COLS; i++) {
            for (int j = 0; j < ROWS; j++) {
                if (board[j][i] == CROSS) {
                    count++;
                } else if (board[j][i] == EMPTY) {
                    emptySpace = (j * 3) + i;
                }
            }
            if (count == 2 && emptySpace != -1) {
                return emptySpace;
            }
            count = 0;
        }

        // Checks left-to-right diagonal placement of X's
        count = 0;
        emptySpace = -1;
        for (int i = 0; i < ROWS; i++) {
            if (board[i][i] == CROSS) {
                count++;
            } else if (board[i][i] == EMPTY) {
                emptySpace = (i * 3) + i;
            }

        }
        if (count == 2 && emptySpace != -1) {
            return emptySpace;
        }

        // Checks right-to-left diagonal placement of X's
        count = 0;
        emptySpace = -1;
        for (int i = 0; i < ROWS; i++) {
            if (board[i][(ROWS - 1) - i] == CROSS) {
                count++;
            } else if (board[i][(ROWS - 1) - i] == EMPTY) {
                emptySpace = (i * 3) + ((ROWS - 1) - i);
            }
        }
        if (count == 2 && emptySpace != -1) {
            return emptySpace;
        }

        // If there is no place to block the player, then choose randomly
        boolean chosen = false;
        while (!chosen) {
            int rand = (int) (Math.random() * 9);
            if (rand == 9) {
                rand = 8;
            }
            int row = rand / 3;
            int col = rand % 3;
            if (board[row][col] == EMPTY) {
                return rand;
            }
        }
        return -1;
    }

    // Checks the current status of the game
    @Override
    public int checkForWinner() {
        int current;
        if (currentPlayer == 0) {
            current = CROSS;
        } else {
            current = NOUGHT;
        }

        //Check for horizontal win
        int count = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == current) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == 3) {
                    if (current == CROSS) {
                        return 2;
                    } else {
                        return 3;
                    }
                }
            }
            count = 0;
        }

        //Check for vertical win
        count = 0;
        for (int i = 0; i < COLS; i++) {
            for (int j = 0; j < ROWS; j++) {
                if (board[j][i] == current) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == 3) {
                    if (current == CROSS) {
                        return 2;
                    } else {
                        return 3;
                    }
                }
            }
            count = 0;
        }

        //Check for left-to-right diagonal win
        count = 0;
        for (int i = 0; i < ROWS; i++) {
            if (board[i][i] == current) {
                count++;
            } else {
                count = 0;
            }
            if (count == 3) {
                if (current == CROSS) {
                    return 2;
                } else {
                    return 3;
                }
            }
        }

        //Check for right-to-left diagonal win
        count = 0;
        for (int i = 0; i < ROWS; i++) {
            if (board[i][(ROWS - 1) - i] == current) {
                count++;
            } else {
                count = 0;
            }
            if (count == 3) {
                if (current == CROSS) {
                    return 2;
                } else {
                    return 3;
                }
            }
        }

        //Checks if game is a draw
        int full = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] != EMPTY) {
                    full++;
                } else {
                    full = 0;
                }
            }
        }
        if (full == 9) {
            return 1;
        }
        return 0;
    }
}