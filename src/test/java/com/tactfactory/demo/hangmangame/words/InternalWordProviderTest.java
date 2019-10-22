package com.tactfactory.demo.hangmangame.words;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InternalWordProviderTest {

    private InternalWordProvider item;

    @Before
    public void setUp() throws Exception {
        this.item = new InternalWordProvider();
    }

    @Test
    public void testInternalWordProvider() {
        Assert.assertNotNull(this.item);
    }

    @Test
    public void testAddWord() throws WordException {
        this.item.addWord("MyTest");
    }

    @Test(expected = WordException.class)
    public void testAddWordException() throws WordException {
        this.item.addWord("a");
    }

    @Test
    public void testGetRandom() throws WordException {
        this.item.addWord("mytest1");
        this.item.addWord("mytest2");
        this.item.addWord("mytest3");

        Assert.assertTrue(this.item.getRandom().contains("mytest"));
    }

    @Test
    public void testNormalize() {
        Assert.assertEquals("monsupertest", WordProviderBase.normalize(" MonSuperTest "));
    }

    @Test
    public void testGetMiniWordSize() {
        Assert.assertEquals(1, this.item.getMiniWordSize());
    }

    @Test
    public void testSetMiniWordSize() {
        this.item.setMiniWordSize(10);
        Assert.assertEquals(10, this.item.getMiniWordSize());
    }

}
