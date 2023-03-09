package fr.istic.vv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    Date dateIsValid;
    Date dateIsValid2;
    Date dateIsValid3;
    Date dateIsValid4;
    Date dateIsValid5;
    Date dateForCompare11;
    Date dateForCompare12;
    Date dateForCompare21;
    Date dateForCompare22;
    Date dateForCompare31;
    Date dateForCompare32;

    @BeforeEach
    void SetUp(){
        dateIsValid = new Date(1,1,2020);
        dateIsValid2 = new Date(12,03,2019);
        dateIsValid3 = new Date(01,04,2018);
        dateIsValid4 = new Date(01,02,2024);
        dateIsValid5 = new Date(31,12,2021);
        dateForCompare11 = new Date(1,1,2010);
        dateForCompare12 = new Date(3,4,2019);
        dateForCompare21 = new Date(4,4,2000);
        dateForCompare22 = new Date(5,4,2000);
        dateForCompare31 = new Date(22,10,2000);
        dateForCompare32 = new Date(3,11,2000);
    }

    @Test
    void testCreationException(){
        assertThrows(IllegalArgumentException.class, ()-> new Date(300,3000,303));
    }

    @Test
    void testIsValide(){
        assertTrue(Date.isValidDate(1,1,2020));
        assertTrue(Date.isValidDate(10,03,2019));
        assertTrue(Date.isValidDate(31,03,2018));
        assertTrue(Date.isValidDate(29,02,2024));
    }

    @Test
    void testIsNotValid(){
        assertFalse(Date.isValidDate(0,0,0));
        assertFalse(Date.isValidDate(31,04,2022));
        assertFalse(Date.isValidDate(29,02,2023));
        assertFalse(Date.isValidDate(20,14,2009));
        assertFalse(Date.isValidDate(40,05,2010));




    }

    @ParameterizedTest
    @ValueSource(ints = {2004,2008,2016,4, 400})
    void testIsLeapYear(int year){
        assertTrue(Date.isLeapYear(year));
    }


    @ParameterizedTest
    @ValueSource(ints = { 2003, 2005, 2010, 2011, 2015, 3,100 })
    void testIsNotLeapYear(int year){
        assertFalse(Date.isLeapYear(year));
    }

    @Test
    void testNextDate(){
        assertTrue(dateIsValid.nextDate().compareTo(new Date(2,1,2020)) == 0);
        assertTrue(dateIsValid2.nextDate().compareTo(new Date(13,03,2019)) == 0);
        assertTrue(dateIsValid3.nextDate().compareTo(new Date(2,04,2018)) == 0);
        assertTrue(dateIsValid4.nextDate().compareTo(new Date(2,02,2024)) == 0);
        assertTrue(dateIsValid5.nextDate().compareTo(new Date(1,1,2022)) == 0);
    }

    @Test
    void testPreviousDate(){
        assertTrue(dateIsValid.previousDate().compareTo(new Date(31,12,2019)) == 0);
        assertTrue(dateIsValid2.previousDate().compareTo(new Date(11,03,2019)) == 0);
        assertTrue(dateIsValid3.previousDate().compareTo(new Date(31,03,2018)) == 0);
        assertTrue(dateIsValid4.previousDate().compareTo(new Date(31,01,2024)) == 0);
        assertTrue(dateIsValid5.previousDate().compareTo(new Date(30,12,2021)) == 0);
    }

    @Test
    void testCompareTo0(){
        assertTrue(dateIsValid.compareTo(dateIsValid) == 0);
    }

    @Test
    void testCompareToPos(){
        assertTrue(dateForCompare12.compareTo(dateForCompare11) > 0);
        assertTrue(dateForCompare22.compareTo(dateForCompare21) > 0);
        assertTrue(dateForCompare32.compareTo(dateForCompare31) > 0);
    }

    @Test
    void testCompareToNeg(){
        assertTrue(dateForCompare11.compareTo(dateForCompare12) < 0);
        assertTrue(dateForCompare21.compareTo(dateForCompare22) < 0);
        assertTrue(dateForCompare31.compareTo(dateForCompare32) < 0);
    }

    @Test
    void testCompareToException(){
        assertThrows( NullPointerException.class, ()-> dateForCompare22.compareTo(null));
    }
    

}