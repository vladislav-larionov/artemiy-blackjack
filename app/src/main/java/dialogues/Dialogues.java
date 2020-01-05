package dialogues;

import java.util.ArrayList;

public class Dialogues {
    private String name;
    private ArrayList<String> firstCurdMes;
    private ArrayList<String> moreElevenPointsMes;
    private ArrayList<String> moreEighteenPointsMes;
    private ArrayList<String> userWinMes;
    private ArrayList<String> scoreEqualMes;
    private ArrayList<String> botWinMes;
    private ArrayList<String> userGiveUpMes;
    private ArrayList<String> userClickOnBot;

    public Dialogues(String name) {
        this.name = name;

        if (name == "kind")
            fillDialoduesKind();
        else if (name == "normal")
            fillDialoduesNormal();
        else if (name == "evil")
            fillDialoduesEvil();
        else if (name == "king")
            fillDialoduesKing();
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getFirstCurdMes() {
        return firstCurdMes;
    }

    public ArrayList<String> getMoreElevenPointsMes() {
        return moreElevenPointsMes;
    }

    public ArrayList<String> getMoreEighteenPointsMes() {
        return moreEighteenPointsMes;
    }

    public ArrayList<String> getUserWinMes() {
        return userWinMes;
    }

    public ArrayList<String> getScoreEqualMes() {
        return scoreEqualMes;
    }

    public ArrayList<String> getBotWinMes() {
        return botWinMes;
    }

    public ArrayList<String> getUserGiveUpMes() {
        return userGiveUpMes;
    }

    public ArrayList<String> getUserClickOnBot() {
        return userClickOnBot;
    }

    private void fillDialoduesEvil() {
        firstCurdMes = new ArrayList<String>();
        firstCurdMes.add("Я взял карту, ходи, не задерживай своё поражение.");

        moreElevenPointsMes = new ArrayList<String>();
        moreElevenPointsMes.add("Участники ликвидации чернобыльской аварии, инвалиды разных групп. Хуй вам, а не льготы, спиногрызы сраные! Ебитесь сами, это и есть жизнь, блять.");
        moreElevenPointsMes.add("Как мотивировать себя что-то сделать? Да никак, оставайтесь в жопе!");
        moreElevenPointsMes.add("Как только какая–либо элитарная дизайнерская студия начинает думать про себя как про элитарную и дизайнерскую — тут–то она медной пиздой и накрывается.");

        moreEighteenPointsMes = new ArrayList<String>();
        moreEighteenPointsMes.add("Я взял достаточно карт, чтобы тебя унизить.");

        userWinMes = new ArrayList<>();
        userWinMes.add("Так играют только мудаки!");
        userWinMes.add("Какой дебил писал эту сраную программу!?");
        userWinMes.add("С каких пор одноклеточные умеют играть в карты!?");
        userWinMes.add("Ах ты сука!");
        userWinMes.add("Ты уёбок, ненавижу тебя!");
        userWinMes.add("Ты приёмный!");

        scoreEqualMes = new ArrayList<>();
        scoreEqualMes.add("Даже при равных счетах я лучший. Я победил.");
        scoreEqualMes.add("Очки у нас равные, но мои равнее, я победил.");

        botWinMes = new ArrayList<>();
        botWinMes.add("Ты как всегда всё просрал.");
        botWinMes.add("Проигрывают все, но так облажаться надо ещё постараться.");
        botWinMes.add("Даже обезьяна играет лучше чем ты.");
        botWinMes.add("Ты проиграл и теперь займёшь место тупого бота в этой игре.");
        botWinMes.add("Твоему отражению в зеркале стыдно на тебя смотреть.");
        botWinMes.add("Я в очередной раз задавил тебя своим интеллектом.");

        userGiveUpMes = new ArrayList<>();
        userGiveUpMes.add("Неужели ты такой тупой, что купился на мой блеф!?");
        userGiveUpMes.add("Ты наложил в штаны от одного моего взгляда.");
        userGiveUpMes.add("Ты никогда ничего не можешь довести до конца.");
        userGiveUpMes.add("Наконец-то ты осознал моё превосходство.");
        userGiveUpMes.add("Я конечно подозревал что ты ничтожество, но чтоб такое...");

        userClickOnBot = new ArrayList<>();
        userClickOnBot.add("Убери свою паганую сардельку от моего лица!");
        userClickOnBot.add("Не смей тыкать в меня! А то я начну тыкать в твой счёт!");
        userClickOnBot.add("Моё лицо не сиська твоей мамки что бы его мять!");
        userClickOnBot.add("Когда ты сдохнешь я приду и буду тыкать в тебя.");
        userClickOnBot.add("Да чтоб тебя военком забрал!");
    }

    private void fillDialoduesNormal() {
        firstCurdMes = new ArrayList<String>();
        firstCurdMes.add("Я взял карту, ходи, не задерживай своё поражение.");

        moreElevenPointsMes = new ArrayList<String>();
        moreElevenPointsMes.add("Муахаха! Я почти победил. Сдавайся, у тебя нет шансов.");
        moreElevenPointsMes.add("Как мотивировать себя что-то сделать? Да никак, оставайтесь в жопе!");
        moreElevenPointsMes.add("Я москвичей не люблю, они снобы, жлобы и хамы.");

        moreEighteenPointsMes = new ArrayList<String>();
        moreEighteenPointsMes.add("Я взял достаточно карт, чтобы тебя унизить.");

        userWinMes = new ArrayList<>();
        userWinMes.add("Не буду больше с тобой играть!");
        userWinMes.add("Какой дебил писал эту сраную программу!?");
        userWinMes.add("Твой телефон глюченый кусок говна, на самом деле победил я!");

        scoreEqualMes = new ArrayList<>();
        scoreEqualMes.add("Счёт равный, но мои карты красивее, а у твоих дизайн говно, так что я всё равно победил.");
        scoreEqualMes.add("Очки у нас равные, но мои равнее, я победил.");

        botWinMes = new ArrayList<>();
        botWinMes.add("Ты проиграл. Впрочем, ничего нового.");
        botWinMes.add("Проигрывают все, но твой слив самый позорный.");
        botWinMes.add("Даже моя бабушка лучше играет.");
        botWinMes.add("Ты проиграл и теперь займёшь место тупого бота в этой игре.");
        botWinMes.add("Твоему отражению в зеркале стыдно на тебя смотреть.");


        userGiveUpMes = new ArrayList<>();
        userGiveUpMes.add("Мухаха, я блефовал, а ты купился, дурачёк.");
        userGiveUpMes.add("Я так и знал, что ты сдрейфишь.");
        userGiveUpMes.add("Ты никогда ничего не можешь довести до конца.");
        userGiveUpMes.add("Наконец-то ты осознал моё превосходство.");

        userClickOnBot = new ArrayList<>();
        userClickOnBot.add("Убери свою паганую сардельку от моего лица!");
        userClickOnBot.add("Не смей тыкать в меня! А то я начну тыкать в твой счёт!");
        userClickOnBot.add("Моё лицо не сиська твоей мамки что бы его мять!");
        userClickOnBot.add("Когда ты сдохнешь я приду и буду тыкать в тебя.");
        userClickOnBot.add("Да чтоб тебя военком забрал!");
    }

    private void fillDialoduesKind() {
        firstCurdMes = new ArrayList<String>();
        firstCurdMes.add("Я взял карту, ходи, не задерживай своё поражение.");

        moreElevenPointsMes = new ArrayList<String>();
        moreElevenPointsMes.add("Муахаха! Я почти победил. Сдавайся, у тебя нет шансов.");
        moreElevenPointsMes.add("Я москвичей не люблю, они снобы, жлобы и хамы.");

        moreEighteenPointsMes = new ArrayList<String>();
        moreEighteenPointsMes.add("Я взял достаточно карт, чтобы тебя унизить.");

        userWinMes = new ArrayList<>();
        userWinMes.add("Не буду больше с тобой играть!");
        userWinMes.add("Да ну тебя.");
        userWinMes.add("Шулер он и в Африке шулер.");
        userWinMes.add("Шёл бы ты отсюда...");
        userWinMes.add("Дуракам всегда везёт.");

        scoreEqualMes = new ArrayList<>();
        scoreEqualMes.add("Очки у нас равные, но мои равнее, я победил.");
        scoreEqualMes.add("Тут побеждаю только я.");

        botWinMes = new ArrayList<>();
        botWinMes.add("Ты проиграл. Впрочем, ничего нового.");
        botWinMes.add("Проигрывают все, но твой слив самый позорный.");
        botWinMes.add("Даже моя бабушка лучше играет.");
        botWinMes.add("Твоему отражению в зеркале стыдно на тебя смотреть.");
        botWinMes.add("Неужели ты надеялся меня победить?");

        userGiveUpMes = new ArrayList<>();
        userGiveUpMes.add("Мухаха, я блефовал, а ты купился, дурачёк.");
        userGiveUpMes.add("Я так и знал, что ты сдрейфишь.");
        userGiveUpMes.add("Ты никогда ничего не можешь довести до конца.");
        userGiveUpMes.add("Наконец-то ты осознал моё превосходство.");

        userClickOnBot = new ArrayList<>();
        userClickOnBot.add("Убери свою паганую сардельку от моего лица!");
        userClickOnBot.add("Не смей тыкать в меня! А то я начну тыкать в твой счёт!");
        userClickOnBot.add("Моё лицо не сиська твоей мамки что бы его мять!");
        userClickOnBot.add("Когда ты сдохнешь я приду и буду тыкать в тебя.");
        userClickOnBot.add("Да чтоб тебя военком забрал!");
    }

    private void fillDialoduesKing() {
        firstCurdMes = new ArrayList<String>();
        firstCurdMes.add("Тебе нет смысла брать карту, я всё равно снова выиграю.");

        moreElevenPointsMes = new ArrayList<String>();
        moreElevenPointsMes.add("Я вижу, что ты опять почти проиграл.");

        moreEighteenPointsMes = new ArrayList<String>();
        moreEighteenPointsMes.add("Я взял достаточно карт, чтобы тебя унизить.");

        userWinMes = new ArrayList<>();
        userWinMes.add("Мне стало жаль тебя и я поддался.");
        userWinMes.add("Должно же было тебе хоть раз повезти.");
        userWinMes.add("Да ну тебя.");
        userWinMes.add("Шёл бы ты отсюда...");
        userWinMes.add("Дуракам всегда везёт.");

        scoreEqualMes = new ArrayList<>();
        scoreEqualMes.add("При равных очках побеждает тот, кто в короне. То есть я.");
        scoreEqualMes.add("При равных очках побеждает тот, кто красивее. А из нас двоих красавец только я.");
        scoreEqualMes.add("Тут побеждаю только я.");

        botWinMes = new ArrayList<>();
        botWinMes.add("Ты проиграл. Впрочем, ничего нового.");
        botWinMes.add("Твоя позорная серия продолжается.");
        botWinMes.add("Даже сборная России по футболу не проигрывает столько раз подряд.");
        botWinMes.add("Что, опять?");
        botWinMes.add("Мне уже надоело тебя обыгрывать. Ты хоть сопротивляйся.");

        userGiveUpMes = new ArrayList<>();
        userGiveUpMes.add("После стольких поражений ты сдаёшься?");
        userGiveUpMes.add("Я так и знал, что ты сдрейфишь.");
        userGiveUpMes.add("Ты даже не попытался.");
        userGiveUpMes.add("Ты в очередной раз доказал свою никчёмность.");

        userClickOnBot = new ArrayList<>();
        userClickOnBot.add("Убери свою паганую сардельку от моего лица!");
        userClickOnBot.add("Не смей тыкать в меня! А то я начну тыкать в твой счёт!");
        userClickOnBot.add("Эй, не тыкай, корону мне заляпаешь!");
        userClickOnBot.add("Эй-эй-эй, причёску мне попортишь!");
        userClickOnBot.add("Да чтоб тебя военком забрал!");
    }

    @Override
    public String toString() {
        return name;
    }
}
