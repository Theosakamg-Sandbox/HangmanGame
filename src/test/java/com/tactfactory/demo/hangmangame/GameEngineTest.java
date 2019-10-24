/*
 * GameEngineTest.java, HangMan Game
 *
 * Copyright © 2019 Mickael Gaillard / TACTfactory
 * License    : all rights reserved
 */

package com.tactfactory.demo.hangmangame;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameEngineTest {

    private final InputStream originalOut = System.in;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        System.setIn(this.originalOut);
    }

    private void enter(String value) {
        try {
            Thread.sleep(1000);

            final ByteArrayInputStream inContent = new ByteArrayInputStream(value.getBytes());
            System.setIn(inContent);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRun() {
        // bonjurpedfat
        GameEngineTest.this.enter("b\no\nn\nj\nu\nr\np\ne\nd\nf\na\nt\n");

        GameEngine engin = new GameEngine();
        engin.run();
    }

    @Test
    public void testRun2() {
        // bonjurpedfat
        GameEngineTest.this.enter("b\no\nn\nj\nu\nr\np\ne\nd\nf\na\nt\n");

        GameEngine engin = new GameEngine();
        engin.run();
    }

}
