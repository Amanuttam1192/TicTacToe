package com.example.a201b035_tictac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean isWinner = false;
    int imageClicked = -1;
    int player = 1; //player1 is cross
    int [][]winningStates = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int []gameState = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public void load (View view)
    {
        ImageView v = (ImageView) view;
        int tag = Integer.parseInt(v.getTag().toString());
        imageClicked = gameState[tag];
        if(isWinner == false && imageClicked == -1) {
            if (player == 1) {
                v.setImageResource(R.drawable.cross);
                gameState[tag] = player;
                Toast.makeText(this, tag + "" + "Cross", Toast.LENGTH_LONG).show();
                player = 0;
            } else {
                v.setImageResource(R.drawable.zero);
                gameState[tag] = player;
                Toast.makeText(this, tag + "" + "Zero", Toast.LENGTH_LONG).show();
                player = 1;
            }

            for (int i = 0; i < winningStates.length; i++) {
                if (gameState[winningStates[i][0]] == gameState[winningStates[i][1]] && gameState[winningStates[i][1]] == gameState[winningStates[i][2]] && gameState[winningStates[i][0]] > -1) {
                    Toast.makeText(this, "Winner is " + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    isWinner = true;
                }
            }
        }
    }

    public void reset(View view)
    {
        GridLayout gridLayout = findViewById(R.id.gridLayout);
        int total_images = gridLayout.getChildCount();
        for(int i = 0; i < total_images; i++)
        {
            ImageView v = (ImageView) gridLayout.getChildAt(i);
            v.setImageDrawable(null);
        }

        isWinner = false;
        imageClicked = -1;
        player = 1;
        for(int i = 0; i < gameState.length; i++)
        {
            gameState[i] = -1;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}