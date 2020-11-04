package ru.surovtseva;


import org.junit.jupiter.api.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
//    @Test
//    public void shouldAnswerWithTrue()
//    {
//        assertTrue( true );
//    }

    @Test
    public void checkSumCorrect() {
        Assertions.assertEquals(5, 4 + 1);
    }

    @Test
    public void checkTrue() {
        Assertions.assertTrue(true);
    }

    @Test
    public void checkFalse() {
        Assertions.assertFalse(false);
    }

    @Test
    public void checkNull() {
        String str = null;
        Assertions.assertNull(str);
    }

    @Test
    public void checkNotNull() {
        String str = "null";
        Assertions.assertNotNull(str);
    }
}


