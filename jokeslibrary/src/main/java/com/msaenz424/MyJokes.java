package com.msaenz424;

import java.util.Random;

public class MyJokes {

    private String[] mJokes = new String[]{
            "You can tune a piano but you can't tune a fish",
            "I'm on a seafood diet, I see food and I eat it",
            "Light travels faster than sound. This is why some people appear bright until they speak",
            "If practice makes perfect, and nobody's perfect, why practice?",
            "I am a nobody, nobody is perfect, therefore I am perfect",
            "Why did the blonde get excited after finishing her puzzle in 6 months? The box said 2-4 years!",
            "Do not underestimate your abilities. That is your boss's job"
    };

    public String[] getJokes(){
        return mJokes;
    }

    public String getRandomJoke(){
        int rnd = new Random().nextInt(mJokes.length);
        return mJokes[rnd];
    }
}
