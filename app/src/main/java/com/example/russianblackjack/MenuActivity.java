package com.example.russianblackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onClickStartNewGameBtn(View view) {
        Intent intent = new Intent(MenuActivity.this, ChooseActivity.class);

        startActivity(intent);
    }

    public void onClickStartExitBtn(View view) {
        System.exit(0);
    }
}
