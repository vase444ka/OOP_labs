package com.example.seafight;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
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

        gameInstance = new SeaFightGame();

        setContentView(R.layout.field_editing_layout);
        EditingView editingView = findViewById(R.id.editingView);
        editingView.setPlayer(gameInstance.human);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev){
        if (gameInstance.human.isReady()){
            setContentView(R.layout.active_game_layout);
            PlayingView playingView = findViewById(R.id.activeGameView);
            playingView.setGameInstance(gameInstance);
        }
        return true;
    }
}