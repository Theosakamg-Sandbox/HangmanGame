package com.tactfactory.demo.hangmangame.words;

public class InternalWordProvider extends WordProviderBase {

    public InternalWordProvider() {
        try {
            this.addWord("Bonjour");
            this.addWord("Pendu");
            this.addWord("Enfant");

        } catch (WordException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addWord(String word) throws WordException {
        if (word.length() > 1) {
            this.words.add(normalize(word));
        } else {
            throw new WordException("To short word");
        }
    }

}
