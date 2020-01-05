package com.example.russianblackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import dialogues.Dialogues;

public class ChooseActivity extends AppCompatActivity {

    public static final int KIND_MODE = 0;
    public static final int NORMAL_MODE = 1;
    public static final int EVIL_MODE = 2;
    public static final int KING_MODE = 3;

    public static final Dialogues[] botMode = {
            new Dialogues("kind"),
            new Dialogues("normal"),
            new Dialogues("evil"),
            new Dialogues("king")};
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        intent = new Intent (ChooseActivity.this, MainActivity.class);
    }

    public void onClickKindModeBtn(View view) {
        intent.putExtra(MainActivity.CHOOSED_BOT_MODE, KIND_MODE);
        startActivity(intent);
    }

    public void onClickNormalModeBtn(View view) {
        intent.putExtra(MainActivity.CHOOSED_BOT_MODE, NORMAL_MODE);
        startActivity(intent);
    }

    public void onClickEvilModeBtn(View view) {
        intent.putExtra(MainActivity.CHOOSED_BOT_MODE, EVIL_MODE);
        startActivity(intent);
    }
}
