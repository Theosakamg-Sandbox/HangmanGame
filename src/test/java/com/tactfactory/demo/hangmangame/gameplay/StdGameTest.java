/*
 * StdGameTest.java, HangMan Game
 *
 * Copyright © 2019 Mickael Gaillard / TACTfactory
 * License    : all rights reserved
 */

package com.tactfactory.demo.hangmangame.gameplay;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StdGameTest {

    private StdGame item;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        this.item = new StdGame("wordtofind");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testStdGame() {
        Assert.assertNotNull(this.item);
    }

    @Test
    public void testSubmitChar() {
        this.item.submitChar('o');

        Assert.assertEquals(1, this.item.getCountTry());
        Assert.assertEquals(0, this.item.getCountError());
    }

    @Test
    public void testMaskToDisplay() {
        List<Character> result = this.item.maskToDisplay();

        Assert.assertEquals(10, result.size());
    }

    @Test
    public void testGetCountTry() {
        Assert.assertEquals(0, this.item.getCountTry());

        this.item.submitChar('o');

        Assert.assertEquals(1, this.item.getCountTry());
    }

    @Test
    public void testGetCountError() {
        Assert.assertEquals(0, this.item.getCountError());

        this.item.submitChar('x');

        Assert.assertEquals(1, this.item.getCountError());
    }

    @Test
    public void testIsFinishTrue() {
        Assert.assertFalse(this.item.isFinish());

        this.item.submitChar('w');
        this.item.submitChar('o');
        this.item.submitChar('r');
        this.item.submitChar('d');
        this.item.submitChar('t');
        this.item.submitChar('o');
        this.item.submitChar('f');
        this.item.submitChar('i');
        this.item.submitChar('n');
        this.item.submitChar('d');

        Assert.assertTrue(this.item.isFinish());
    }

    @Test
    public void testIsFinishFalse() {
        this.item = new StdGame("azerty");

        Assert.assertFalse(this.item.isFinish());

        this.item.submitChar('w');
        this.item.submitChar('o');
        this.item.submitChar('r');
        this.item.submitChar('d');
        this.item.submitChar('t');
        this.item.submitChar('o');
        this.item.submitChar('f');
        this.item.submitChar('i');
        this.item.submitChar('n');
        this.item.submitChar('d');
        this.item.submitChar('v');
        this.item.submitChar('c');

        Assert.assertTrue(this.item.isFinish());
    }

    @Test
    public void testIsWin() {
        Assert.assertFalse(this.item.isWin());

        this.item.submitChar('w');
        this.item.submitChar('o');
        this.item.submitChar('r');
        this.item.submitChar('d');
        this.item.submitChar('t');
        this.item.submitChar('o');
        this.item.submitChar('f');
        this.item.submitChar('i');
        this.item.submitChar('n');
        this.item.submitChar('d');

        Assert.assertTrue(this.item.isWin());
    }

}
