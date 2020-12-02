package leapyear;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeapYearTest {

    @Test
    public void divisibleBy4Test(){
        assertTrue(LeapYear.divisibleBy4(1996));
        assertTrue(LeapYear.divisibleBy4(4));
        assertFalse(LeapYear.divisibleBy4(47));
        assertFalse(LeapYear.divisibleBy4(2021));

    }

    @Test
    public void divisibleBy100Test(){
        assertTrue(LeapYear.divisibleBy100(1900));
        assertTrue(LeapYear.divisibleBy100(100));
        assertFalse(LeapYear.divisibleBy100(101));
        assertFalse(LeapYear.divisibleBy100(2001));
    }

    @Test
    public void divisibleBy400Test(){
        assertTrue(LeapYear.divisibleBy400(1600));
        assertTrue(LeapYear.divisibleBy400(400));
        assertFalse(LeapYear.divisibleBy400(455));
        assertFalse(LeapYear.divisibleBy400(1900));
    }

    @Test
    public void isLeapYearTest(){
        assertTrue(LeapYear.isLeapYear(2020));
        assertTrue(LeapYear.isLeapYear(2000));
        assertTrue(LeapYear.isLeapYear(1996));
        assertFalse(LeapYear.isLeapYear(1900));
        assertFalse(LeapYear.isLeapYear(2021));
        assertFalse(LeapYear.isLeapYear(467));

    }

}
