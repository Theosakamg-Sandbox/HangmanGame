package com.tactfactory.demo.hangmangame.words;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public abstract class WordProviderBase implements WordProvider {

    protected static final Random ran = new Random(LocalDateTime.now().getNano());

    protected int miniWordSize = 1;

    protected final List<String> words = new ArrayList<>();

    @Override
    public String getRandom() {
        int idx = WordProviderBase.ran.nextInt(this.words.size()-1);
        final String word = this.words.get(idx);

        return word;
    }

    protected static String normalize(String string) {
        return string.trim().toLowerCase(Locale.getDefault());
    }

    /**
    * @return the miniWordSize.
    */
    @Override
    public int getMiniWordSize() {
        return this.miniWordSize;
    }

    /**
    * @param miniWordSize the miniWordSize to set.
    * @return this.
    */
    @Override
    public WordProvider setMiniWordSize(int miniWordSize) {
        this.miniWordSize = miniWordSize;
        return this;
    }



}
