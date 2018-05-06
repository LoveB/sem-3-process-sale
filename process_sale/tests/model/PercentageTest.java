package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PercentageTest {
    @Test
    public void toStringTest() throws Exception {
        Percentage tax = new Percentage(10);

        String expString = "10%";
        String result = tax.toString();
        assertEquals(expString, result);
    }

}