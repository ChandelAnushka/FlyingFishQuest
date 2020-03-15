package com.example.flyingfishquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    private Button playAgain;
    private TextView displayScore;
    private String Score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        Score = getIntent().getExtras().get("Score").toString();

        playAgain = findViewById(R.id.button);
        displayScore = findViewById(R.id.textView3);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameOver.this,MainActivity.class);
                startActivity(intent);

            }
        });

        displayScore.setText("Total Score:" + Score);

    }
}
