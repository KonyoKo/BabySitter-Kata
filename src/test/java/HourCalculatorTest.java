import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class HourCalculatorTest {

    @Test
    public void testTimeTo24HourConverstions() {
        assertTrue("22:30".equals(HourCalculator.convertToMilitaryFormat("10:30 PM")));
        assertTrue("12:00".equals(HourCalculator.convertToMilitaryFormat("12:00 PM")));
        assertTrue("00:10".equals(HourCalculator.convertToMilitaryFormat("12:10 AM")));
        assertTrue("03:00".equals(HourCalculator.convertToMilitaryFormat("03:00 AM")));
        assertTrue("09:00".equals(HourCalculator.convertToMilitaryFormat("09:00 AM")));
        assertTrue("06:00".equals(HourCalculator.convertToMilitaryFormat("06:00 AM")));

    }

    @Test
    public void testCheckTimeFormat() {
        assertTrue("".equals(HourCalculator.convertToMilitaryFormat("ab:cd AM")));
        assertTrue("".equals(HourCalculator.convertToMilitaryFormat("12:34 CM")));
        assertTrue("".equals(HourCalculator.convertToMilitaryFormat("100:200 AD")));
    }

    @Test
    public void testMidTime() {
        //Case 1: Same day test case
        assertTrue(HourCalculator.inBetween("17:00", "23:00", "19:00"));
        assertTrue(HourCalculator.inBetween("17:00", "23:00", "17:00"));
        assertTrue(HourCalculator.inBetween("17:00", "23:00", "23:00"));
        assertFalse(HourCalculator.inBetween("17:00", "23:00", "00:00"));

        //Case 2: Different day test case
        assertTrue(HourCalculator.inBetween("15:00", "06:00", "22:00"));
        assertTrue(HourCalculator.inBetween("15:00", "06:00", "04:00"));
        assertTrue(HourCalculator.inBetween("15:00", "06:00", "00:00"));
        assertTrue(HourCalculator.inBetween("15:00", "06:00", "23:59"));
        assertTrue(HourCalculator.inBetween("15:00", "06:00", "15:00"));
        assertTrue(HourCalculator.inBetween("15:00", "06:00", "06:00"));
        assertFalse(HourCalculator.inBetween("15:00", "06:00", "14:59"));
        assertFalse(HourCalculator.inBetween("15:00", "06:00", "06:01"));
    }

    @Test
    public void testTimeDifference() {
       //Same day test cases
        assertEquals(10, HourCalculator.timeDifference("12:00", "22:00"));
        assertEquals(8, HourCalculator.timeDifference("12:00", "19:05"));
        assertEquals(6, HourCalculator.timeDifference("17:00", "22:30"));

        //Different day test cases
        assertEquals(10, HourCalculator.timeDifference("18:00", "04:00"));
        assertEquals(2, HourCalculator.timeDifference("23:00", "01:00"));
        assertEquals(4, HourCalculator.timeDifference("22:00", "01:25"));

    }

}
