/**
 * Ryan Hayes
 * 2/13/20
 * MainActivity.java
 *
 * This class is the main and first class created on startup.
 */

package edu.quinnipiac.ser210.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String key = "mykey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Method called when the start button is clicked
    public void onClick(View view) {
        EditText editText = findViewById(R.id.nameInput);
        String name = editText.getText().toString();
        if (!name.equals("")) {
            Intent intent = new Intent(this, TicTacToe.class);
            intent.putExtra(key, name);
            ITicTacToe game = new TicTacToe();
            startActivity(intent);
        }
    }
}
