package com.example.guess_a_name;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText nameInput;
    final String strName = "Diego";
    private String[] guesses;
    private int guessIndex = 0;
    private TextView txtViewGuesses, txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.txtName);
        txtResult = findViewById(R.id.txtResult);
        Button btnGuess = findViewById(R.id.btnGuess);
        txtViewGuesses = findViewById(R.id.txtViewGuesses);

        guesses = new String[10];

        btnGuess.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String txtName = nameInput.getText().toString().trim();
                if(txtName.equalsIgnoreCase(strName)){
                    guesses[guessIndex] = txtName;
                    txtResult.setText("Hooray! You guessed it " + (++guessIndex) + " times!");


                    displayGuesses();

                } else {
                    Toast.makeText(MainActivity.this, "Wrong! Try again!", Toast.LENGTH_SHORT).show();

                    // Add the guess to the array
                    guesses[guessIndex] = txtName;
                    guessIndex++;

                    // Display all guesses
                    displayGuesses();
                }
            }
        });
    }

    private void displayGuesses(){
        StringBuilder allGuesses = new StringBuilder("Your guesses:\n");
        for (int i = 0; i < guessIndex; i++) {
            allGuesses.append(guesses[i]).append("\n");
        }
        txtViewGuesses.setText(allGuesses.toString());
    }
}