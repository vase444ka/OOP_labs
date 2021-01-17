package com.example.seafight;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.seafight.game.SeaFightGame;

public class MainActivity extends Activity {
    private SeaFightGame gameInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.active_game_layout);
        GameView gameView = findViewById(R.id.activeGameView);


        System.out.println("---activity::onCreate()---");
        gameInstance = new SeaFightGame();
        gameView.setGameInstance(gameInstance);
    }
}