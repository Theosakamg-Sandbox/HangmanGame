/*
 * DisplayCliTest.java, HangMan Game
 *
 * Copyright © 2019 Mickael Gaillard / TACTfactory
 * License    : all rights reserved
 */

package com.tactfactory.demo.hangmangame;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tactfactory.demo.hangmangame.gameplay.GameMock;

public class DisplayCliTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private DisplayCli item;

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(this.outContent));
        System.setErr(new PrintStream(this.errContent));

        this.item = new DisplayCli();
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(this.originalOut);
        System.setErr(this.originalErr);
    }

    @Test
    public void testDisplayMask() {
        this.item.displayMask(Arrays.asList('s', null,'z'));

        Assert.assertFalse(this.outContent.toString().equals(""));
        Assert.assertTrue(this.outContent.toString().contains("s _ z"));
    }

    @Test
    public void testDisplayHangman() {
        this.item.displayHangman(0);
        Assert.assertTrue("ERR0", this.outContent.toString().contains(DisplayCli.ERR0));

        this.outContent.reset();
        this.item.displayHangman(1);
        Assert.assertTrue("ERR1", this.outContent.toString().contains(DisplayCli.ERR1));

        this.outContent.reset();
        this.item.displayHangman(2);
        Assert.assertTrue("ERR2", this.outContent.toString().contains(DisplayCli.ERR2));

        this.outContent.reset();
        this.item.displayHangman(3);
        Assert.assertTrue("ERR3", this.outContent.toString().contains(DisplayCli.ERR3));

        this.outContent.reset();
        this.item.displayHangman(4);
        Assert.assertTrue("ERR4", this.outContent.toString().contains(DisplayCli.ERR4));

        this.outContent.reset();
        this.item.displayHangman(5);
        Assert.assertTrue("ERR5", this.outContent.toString().contains(DisplayCli.ERR5));

        this.outContent.reset();
        this.item.displayHangman(6);
        Assert.assertTrue("ERR6", this.outContent.toString().contains(DisplayCli.ERR6));

        this.outContent.reset();
        this.item.displayHangman(7);
        Assert.assertTrue("ERR7", this.outContent.toString().contains(DisplayCli.ERR7));

        this.outContent.reset();
        this.item.displayHangman(8);
        Assert.assertTrue("ERR8", this.outContent.toString().contains(DisplayCli.ERR8));

        this.outContent.reset();
        this.item.displayHangman(9);
        Assert.assertTrue("ERR9", this.outContent.toString().contains(DisplayCli.ERR9));

        this.outContent.reset();
        this.item.displayHangman(10);
        Assert.assertTrue("ERR10", this.outContent.toString().contains(DisplayCli.ERR10));

        this.outContent.reset();
        this.item.displayHangman(11);
        Assert.assertTrue("Empty", this.outContent.toString().contains(""));
    }

    @Test
    public void testStep() {
        final GameMock game = new GameMock();
        this.item.step(game);

        Assert.assertFalse(this.outContent.toString().equals(""));

        game.setCountTry(1);
        this.outContent.reset();
        this.item.step(game);
        Assert.assertFalse(this.outContent.toString().equals(""));
    }

    @Test
    public void testRequestValue() {
        this.item.requestValue();

        Assert.assertTrue(this.outContent.toString().contains("Enter a charactere"));
    }

    @Test
    public void testResultMessageWin() {
        final GameMock game = new GameMock();
        game.setWinner(true);
        this.item.resultMessage(game);

        Assert.assertFalse(this.outContent.toString().equals(""));
        Assert.assertTrue(this.outContent.toString().contains("GOOD GAME"));
    }

    @Test
    public void testResultMessageLose() {
        final GameMock game = new GameMock();
        game.setWinner(false);
        this.item.resultMessage(game);

        Assert.assertFalse(this.outContent.toString().equals(""));
        Assert.assertTrue(this.outContent.toString().contains("You lose !"));
    }

}
