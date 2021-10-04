package com.example.russianblackjack;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

import dialogues.Dialogues;

public class MainActivity extends AppCompatActivity {

    private static final int START_KING_MODE = 3;

    private Button new_game_btn;
    private Button enough_btn;
    private Button give_up_btn;
    private TextView score_txt;
    private TextView dialog_txt;
    private ImageView cards_img;
    private ImageView bot;
    private LinearLayout cards_place;
    private LinearLayout bot_cards_place;
    private ArrayList<Integer> taken_cards;
    private ArrayList<Integer> taken_user_cards;
    private int score_user;
    private int score_bot;
    private int cnt_evil_bot = 0;
    private Random random;
    private final int SIZE_CARDS = 36;
    public static final String CHOOSED_BOT_MODE = "choosed_bot_mode";
    private Dialogues dialogues;
    private int bot_mode;
    private int cnt_bot_win;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random();
        new_game_btn = (Button)findViewById(R.id.new_game_btn);
        enough_btn = (Button)findViewById(R.id.enough_btn);
        give_up_btn = (Button)findViewById(R.id.give_up_btn);
        score_txt = (TextView)findViewById(R.id.score_txt);
        dialog_txt = (TextView)findViewById(R.id.dialog_txt);
        cards_img = (ImageView)findViewById(R.id.cards_img);
        bot = (ImageView)findViewById(R.id.bot);
        cards_place = (LinearLayout)findViewById(R.id.cards_place);
        bot_cards_place = (LinearLayout)findViewById(R.id.bot_cards_place);
        taken_cards = new ArrayList<Integer>();
        taken_user_cards = new ArrayList<Integer>();

        if (savedInstanceState != null){
            score_user = savedInstanceState.getInt("score_user");
            score_bot = savedInstanceState.getInt("score_bot");
            cnt_evil_bot = savedInstanceState.getInt("cnt_evil_bot");
            score_txt.setText(savedInstanceState.getString("score_text"));
            taken_cards.addAll(savedInstanceState.getIntegerArrayList("taken_cards"));
            taken_user_cards.addAll(savedInstanceState.getIntegerArrayList("taken_user_cards"));
            dialogues = ChooseActivity.botMode[savedInstanceState.getInt("bot_mode")];
            cnt_bot_win = savedInstanceState.getInt("cnt_bot_win");

            for (int cur : taken_user_cards){
                ImageView img = new ImageView(this);
                setImgByInd(img, cur);
                cards_place.addView(img);
            }
        }
        else{
            score_user = 0;
            score_bot = 0;
            score_txt.setText(R.string.you_score + score_user);
            bot_mode = getIntent().getExtras().getInt(CHOOSED_BOT_MODE) ;
            dialogues = ChooseActivity.botMode[bot_mode];
            cnt_bot_win = 0;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("score_user", score_user);
        outState.putInt("score_bot", score_bot);
        outState.putInt("cnt_evil_bot", cnt_evil_bot);
        outState.putString("score_text", score_txt.getText().toString());
        outState.putIntegerArrayList("taken_cards", taken_cards);
        outState.putIntegerArrayList("taken_user_cards", taken_user_cards);
        outState.putInt("bot_mode", bot_mode);
        outState.putInt("cnt_bot_win", cnt_bot_win);
    }

    private void setImgByInd (ImageView img, int cur_curd){
        switch (cur_curd + 1){
            case 1:  img.setImageResource(R.drawable.jack_hearts); break;
            case 10: img.setImageResource(R.drawable.jack_cross); break;
            case 19: img.setImageResource(R.drawable.jack_diamonds); break;
            case 28: img.setImageResource(R.drawable.jack_spades); break;
            case 2:  img.setImageResource(R.drawable.queen_hearts); break;
            case 11: img.setImageResource(R.drawable.queen_cross); break;
            case 20: img.setImageResource(R.drawable.queen_diamonds); break;
            case 29: img.setImageResource(R.drawable.queen_spades); break;
            case 3:  img.setImageResource(R.drawable.king_hearts); break;
            case 12: img.setImageResource(R.drawable.king_cross); break;
            case 21: img.setImageResource(R.drawable.king_diamonds); break;
            case 30: img.setImageResource(R.drawable.king_spades); break;
            case 4:  img.setImageResource(R.drawable.hearts_6); break;
            case 13: img.setImageResource(R.drawable.cross_6); break;
            case 22: img.setImageResource(R.drawable.diamonds_6); break;
            case 31: img.setImageResource(R.drawable.spades_6); break;
            case 5:  img.setImageResource(R.drawable.hearts_7); break;
            case 14: img.setImageResource(R.drawable.cross_7); break;
            case 23: img.setImageResource(R.drawable.diamonds_7); break;
            case 32: img.setImageResource(R.drawable.spades_7); break;
            case 6:  img.setImageResource(R.drawable.hearts_8); break;
            case 15: img.setImageResource(R.drawable.cross_8); break;
            case 24: img.setImageResource(R.drawable.diamonds_8); break;
            case 33: img.setImageResource(R.drawable.spades_8); break;
            case 7:  img.setImageResource(R.drawable.hearts_9); break;
            case 16: img.setImageResource(R.drawable.cross_9); break;
            case 25: img.setImageResource(R.drawable.diamonds_9); break;
            case 34: img.setImageResource(R.drawable.spades_9); break;
            case 8:  img.setImageResource(R.drawable.hearts_10); break;
            case 17: img.setImageResource(R.drawable.cross_10); break;
            case 26: img.setImageResource(R.drawable.diamonds_10); break;
            case 35: img.setImageResource(R.drawable.spades_10); break;
            case 9:  img.setImageResource(R.drawable.ace_hearts); break;
            case 18: img.setImageResource(R.drawable.ace_cross); break;
            case 27: img.setImageResource(R.drawable.ace_diamonds); break;
            case 36: img.setImageResource(R.drawable.ace_spades); break;
        }
    }

    private void userTakeCard(){
        int cur_curd = random.nextInt(SIZE_CARDS);

        if (taken_cards.size() >= SIZE_CARDS) {
            Toast.makeText(MainActivity.this, "You take all cards!", Toast.LENGTH_SHORT).show();
            return;
        }

        while (taken_cards.contains(cur_curd))
            cur_curd = random.nextInt(SIZE_CARDS);

        taken_cards.add(cur_curd);
        taken_user_cards.add(cur_curd);

        switch (cur_curd % 9 + 1){
            case 1: score_user += 2; break;
            case 2: score_user += 3; break;
            case 3: score_user += 4; break;
            case 4: score_user += 6; break;
            case 5: score_user += 7; break;
            case 6: score_user += 8; break;
            case 7: score_user += 9; break;
            case 8: score_user += 10; break;
            case 9: score_user += 11; break;
        }

        ImageView img = new ImageView(this);

        setImgByInd(img, cur_curd);

        cards_place.addView(img);

        score_txt.setText("You score: " + score_user);
    }

    private String getMessage(ArrayList<String> messages){
        return messages.get(random.nextInt(messages.size()));
    }

    private void botSaing(int score_bot){
        if (score_bot >= 18)
            dialog_txt.setText(getMessage(dialogues.getMoreEighteenPointsMes()));
        else if(score_bot > 11)
            dialog_txt.setText(getMessage(dialogues.getMoreElevenPointsMes()));
        else
            dialog_txt.setText(getMessage(dialogues.getFirstCurdMes()));
    }

    private void botFinalSaing(int mode){
        if (mode == 0)
            dialog_txt.setText(getMessage(dialogues.getUserWinMes()));
        else if(mode == 1)
            dialog_txt.setText(getMessage(dialogues.getScoreEqualMes()));
        else if (mode == 2)
            dialog_txt.setText(getMessage(dialogues.getBotWinMes()));
        else if (mode == 3)
            dialog_txt.setText(getMessage(dialogues.getUserGiveUpMes()));
    }

    private void botTakeCard(){
        int cur_curd = random.nextInt(SIZE_CARDS);

        if (taken_cards.size() >= SIZE_CARDS)
            return;

        while (taken_cards.contains(cur_curd))
            cur_curd = random.nextInt(SIZE_CARDS);

        taken_cards.add(cur_curd);

        switch (cur_curd % 9 + 1){
            case 1: score_bot += 2; break;
            case 2: score_bot += 3; break;
            case 3: score_bot += 4; break;
            case 4: score_bot += 6; break;
            case 5: score_bot += 7; break;
            case 6: score_bot += 8; break;
            case 7: score_bot += 9; break;
            case 8: score_bot += 10; break;
            case 9: score_bot += 11; break;
        }

        ImageView img = new ImageView(this);
        img.setImageResource(R.drawable.shirt);
        bot_cards_place.addView(img);
    }

    public void onClickCards(View view) {
        userTakeCard();

        if (score_bot < 18)
            botTakeCard();

        cards_img.setClickable(false);
        botSaing(score_bot);
        cards_img.setClickable(true);
    }

    public void onClickEnough(View view) {
        stopGame();
        while (score_bot < 18)
            botTakeCard();

        if (isUserWin()) {
            showWinMessage();
            cnt_bot_win = 0;
        }
	else if (isDraw()){
            showDrawMessage();
        }
        else {
            showLoseMessage();
            cnt_bot_win++;
        }
    }

    private void stopGame()
    {
        cards_img.setClickable(false);
        give_up_btn.setClickable(false);
        enough_btn.setClickable(false);
    }

    private boolean isUserWin()
    {
        return (score_user <= 21 && score_bot < score_user) ||
                (score_user <= 21 && score_bot > 21) ||
                ((score_user > 21 && score_bot > 21) && (score_user < score_bot));
    }

    private void showWinMessage()
    {
        score_txt.setText("You score: " + score_user + "\nBot score: " + score_bot + " \n You win!");
        botFinalSaing(0);
    }

    private boolean isDraw()
    {
        return score_user == score_bot;
    }

    private void showDrawMessage()
    {
        score_txt.setText("You score equal bot's score. \n\n Draw!");
        botFinalSaing(1);
    }

    private void showLoseMessage()
    {
        score_txt.setText("You score: " + score_user + "\nBot score: " + score_bot + "\n You lose!");
        botFinalSaing(2);
    }

    public void onClickNewGame(View view) {
        score_user = 0;
        score_bot = 0;
        score_txt.setText("You score: " + score_user);
        dialog_txt.setText("Я тебя не звал. Убирайся.");
        taken_cards.clear();
        taken_user_cards.clear();

        cards_img.setClickable(true);
        give_up_btn.setClickable(true);
        enough_btn.setClickable(true);
        cards_place.removeAllViews();
        bot_cards_place.removeAllViews();

        if (cnt_bot_win >= START_KING_MODE) {
            dialogues = ChooseActivity.botMode[ChooseActivity.KING_MODE];
            bot.setImageResource(R.drawable.bot_win_streek);
        }
        else {
            dialogues = ChooseActivity.botMode[bot_mode];
            bot.setImageResource(R.drawable.bot);
        }
    }

    public void onClickGiveUpBtn(View view) {
        score_txt.setText("You'r gave up. \n\n You lose!");
        cnt_bot_win++;
        botFinalSaing(3);
    }

    public void onClickBot(View view) {
        dialog_txt.setText(getMessage(dialogues.getUserClickOnBot()));

        cnt_evil_bot++;

        if (cnt_evil_bot == 6) {
            score_user--;
            score_txt.setText("You score: " + score_user);
            dialog_txt.setText("Ты меня задолбал, придурок. Я начинаю вводить санкции. Погляди на свои очки!");
        }
        else if (cnt_evil_bot == 7){
            dialog_txt.setText("Всё! Это край, я обиделся, катись отсюда! Я ухожу и не дам тебе больше играть.");

            bot.setImageResource(R.drawable.empty);

            cards_img.setClickable(false);
            give_up_btn.setClickable(false);
            new_game_btn.setClickable(false);
            enough_btn.setClickable(false);
            bot.setClickable(false);


            Toast.makeText(this, "Bot kicks out you from the game!", Toast.LENGTH_SHORT);

            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            startActivity(intent);
        }
    }
}