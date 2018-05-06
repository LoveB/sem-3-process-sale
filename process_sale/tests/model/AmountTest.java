package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class AmountTest {
    @Test
    public void minus() throws Exception {
        Amount high = new Amount(30);
        Amount low = new Amount(20);
        Amount differenceHighLow = new Amount(10);
        Amount differenceLowHigh = new Amount(-10);
        Amount equal = new Amount(0);

        Amount expResult = differenceHighLow;
        Amount result = high.minus(low);
        assertEquals(expResult, result);

        Amount expResultNeg = differenceLowHigh;
        Amount resultNeg = low.minus(high);
        assertEquals(expResultNeg, resultNeg);

        Amount expResultZero = equal;
        Amount resultZero = low.minus(low);
        assertEquals(expResultZero, resultZero);
    }

    @Test
    public void plus() throws Exception {
        Amount high = new Amount(30);
        Amount low = new Amount(20);
        Amount neg = new Amount(-10);
        Amount sumHighLow = new Amount(50);
        Amount sumHighNeg = new Amount(20);

        Amount expResult = sumHighLow;
        Amount result = high.plus(low);
        assertEquals(expResult, result);

        Amount expResultNeg = sumHighNeg;
        Amount resultNeg = high.plus(neg);
        assertEquals(expResultNeg, resultNeg);
    }

    @Test
    public void multPercentage() throws Exception {
        Amount amount = new Amount(400);
        Percentage percent = new Percentage(25);
        Amount prodHighLow = new Amount(100);

        Amount expResult = prodHighLow;
        Amount result = amount.multPercentage(percent);
        assertEquals(expResult, result);
    }

    @Test
    public void lessThan() throws Exception {
        Amount high = new Amount(30);
        Amount low = new Amount(20);

        Boolean expResultLowHight = true;
        Boolean resultLowHigh = low.lessThan(high);
        assertEquals(expResultLowHight, resultLowHigh);

        Boolean expResultHighLow = false;
        Boolean resultHighLOw = high.lessThan(low);
        assertEquals(expResultHighLow, resultHighLOw);

    }

    @Test
    public void equals() throws Exception {
        Amount high = new Amount(30);
        Amount low = new Amount(20);

        Boolean expResultLowHigh = false;
        Boolean resultLowHigh = low.equals(high);
        assertEquals(expResultLowHigh, resultLowHigh);

        Boolean expResultHighHigh = true;
        Boolean resultHighHigh = high.equals(high);
        assertEquals(expResultHighHigh, resultHighHigh);
    }

}