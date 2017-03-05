package com.msaenz424;

import java.util.Random;

public class MyJokes {

    private String[] mJokes = new String[]{
            "You can tune a piano but you can't tune a fish",
            "Joke 2",
            "Joke 3",
            "Joke 4"
    };

    public String getRandomJoke(){
        int rnd = new Random().nextInt(mJokes.length);
        return mJokes[rnd];
    }
}
