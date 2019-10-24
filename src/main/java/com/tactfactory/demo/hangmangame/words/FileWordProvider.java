/*
 * FileWordProvider.java, HangMan Game
 *
 * Copyright © 2019 Mickael Gaillard / TACTfactory
 * License    : all rights reserved
 */

package com.tactfactory.demo.hangmangame.words;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.List;

import com.google.common.io.Files;

/**
 * File implementation of Word provider.
 */
public class FileWordProvider extends WordProviderBase {

    /**
     * Load content of file.
     * @param filePath path to file.
     * @throws Exception for any error.
     */
    public void load(final String filePath) throws Exception {
        final File file = Paths.get(filePath).toFile();
        final List<String> lines = Files.readLines(file, StandardCharsets.UTF_8);

        for (final String string : lines) {
            this.addWord(string);
        }
    }

    @Override
    public void addWord(final String word) throws WordException {
        // TODO make code.
    }

}
