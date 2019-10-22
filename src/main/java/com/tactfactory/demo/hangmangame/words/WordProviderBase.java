package com.tactfactory.demo.hangmangame.words;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class WordProviderBase implements WordProvider {

    protected List<String> words = new ArrayList<>();

    protected static final Random ran = new Random(LocalDateTime.now().getNano());

    @Override
    public String getRandom() {
        int idx = WordProviderBase.ran.nextInt(this.words.size()-1);
        final String word = this.words.get(idx);

        return word;
    }

    protected static String normalize(String string) {
        return string.trim().toLowerCase();
    }

}
