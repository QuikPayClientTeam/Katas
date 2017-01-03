package warmups;

import static org.junit.Assert.*;

import org.junit.Test;

public class WarmUpTwoTest {

    @Test
    public void stringTimesTest() {
        assertEquals(WarmUpTwo.stringTimes("Hi",2),"HiHi");
        assertEquals(WarmUpTwo.stringTimes("Hi",3),"HiHiHi");
        assertEquals(WarmUpTwo.stringTimes("Hi",1),"Hi");
        assertEquals(WarmUpTwo.stringTimes("Hi",0),"");
        assertEquals(WarmUpTwo.stringTimes("Hi",5),"HiHiHiHiHi");
        assertEquals(WarmUpTwo.stringTimes("Oh Boy!",2),"Oh Boy!Oh Boy!");
        assertEquals(WarmUpTwo.stringTimes("x",4),"xxxx");
        assertEquals(WarmUpTwo.stringTimes("",4),"");
        assertEquals(WarmUpTwo.stringTimes("code",2),"codecode");
        assertEquals(WarmUpTwo.stringTimes("code",3),"codecodecode");
    }

    @Test
    public void frontTimesTest() {
        assertEquals(WarmUpTwo.frontTimes("Chocolate",2),"ChoCho");
        assertEquals(WarmUpTwo.frontTimes("Chocolate",3),"ChoChoCho");
        assertEquals(WarmUpTwo.frontTimes("Abc",3),"AbcAbcAbc");
        assertEquals(WarmUpTwo.frontTimes("Ab",4),"AbAbAbAb");
        assertEquals(WarmUpTwo.frontTimes("A",4),"AAAA");
        assertEquals(WarmUpTwo.frontTimes("",4),"");
        assertEquals(WarmUpTwo.frontTimes("Abc",0),"");
    }

    @Test
    public void countXXTest() {
        assertEquals(WarmUpTwo.countXX("abcxx"),1);
        assertEquals(WarmUpTwo.countXX("xxx"),2);
        assertEquals(WarmUpTwo.countXX("xxxx"),3);
        assertEquals(WarmUpTwo.countXX("abc"),0);
        assertEquals(WarmUpTwo.countXX("Hello there"),0);
        assertEquals(WarmUpTwo.countXX("Hexxo thxxe"),2);
        assertEquals(WarmUpTwo.countXX(""),0);
        assertEquals(WarmUpTwo.countXX("Kittens"),0);
        assertEquals(WarmUpTwo.countXX("Kittensxxx"),2);
    }

    @Test
    public void doubleXTest() {
        assertEquals(WarmUpTwo.doubleX("axxbb"),true);
        assertEquals(WarmUpTwo.doubleX("axaxax"),false);
        assertEquals(WarmUpTwo.doubleX("xxxxx"),true);
        assertEquals(WarmUpTwo.doubleX("xaxxx"),false);
        assertEquals(WarmUpTwo.doubleX("aaaax"),false);
        assertEquals(WarmUpTwo.doubleX(""),false);
        assertEquals(WarmUpTwo.doubleX("abc"),false);
        assertEquals(WarmUpTwo.doubleX("x"),false);
        assertEquals(WarmUpTwo.doubleX("xx"),true);
        assertEquals(WarmUpTwo.doubleX("xax"),false);
        assertEquals(WarmUpTwo.doubleX("xaxx"),false);
    }

    @Test
    public void stringBitsTest() {
        assertEquals(WarmUpTwo.stringBits("Hello"),"Hlo");
        assertEquals(WarmUpTwo.stringBits("Hi"),"H");
        assertEquals(WarmUpTwo.stringBits("Heeololeo"),"Hello");
    }

    @Test
    public void stringSplosionTest() {
        assertEquals(WarmUpTwo.stringSplosion("Code"),"CCoCodCode");
        assertEquals(WarmUpTwo.stringSplosion("abc"),"aababc");
        assertEquals(WarmUpTwo.stringSplosion("ab"),"aab");
    }

    @Test
    public void last2Test() {
        assertEquals(WarmUpTwo.last2("hixxhi"),1);
        assertEquals(WarmUpTwo.last2("xaxxaxaxx"),1);
        assertEquals(WarmUpTwo.last2("axxxaaxx"),2);
    }

    @Test
    public void arrayCount9Test() {
        int[] testOne = {1,2,9};
        assertEquals(WarmUpTwo.arrayCount9(testOne),1);
        int[] testTwo = {1,9,9};
        assertEquals(WarmUpTwo.arrayCount9(testTwo),2);
        int[] testThree = {1,2,9,3,9};
        assertEquals(WarmUpTwo.arrayCount9(testThree),3);
    }

    @Test
    public void arrayFront9Test() {
        int[] testOne = {1,2,9,3,4};
        assertEquals(WarmUpTwo.arrayFront9(testOne),true);
        int[] testTwo = {1,2,3,4,9};
        assertEquals(WarmUpTwo.arrayFront9(testTwo),false);
        int[] testThree = {1,2,3,4,5};
        assertEquals(WarmUpTwo.arrayFront9(testThree),false);
    }

    @Test
    public void array123Test() {
        int[] testOne = {1,1,2,3,1};
        assertEquals(WarmUpTwo.array123(testOne),true);
        int[] testTwo = {1,1,2,4,1};
        assertEquals(WarmUpTwo.array123(testTwo),false);
        int[] testThree = {1,1,2,1,2,3};
        assertEquals(WarmUpTwo.array123(testThree),true);
    }

    @Test
    public void stringMatchTest() {
        assertEquals(WarmUpTwo.stringMatch("xxcaazz","xxbaaz"),3);
        assertEquals(WarmUpTwo.stringMatch("abc","abc"),2);
        assertEquals(WarmUpTwo.stringMatch("abc","axc"),0);
    }

    @Test
    public void stringXTest() {
        assertEquals(WarmUpTwo.stringX("xxHxix"),"xHix");
        assertEquals(WarmUpTwo.stringX("abxxxcd"),"abcd");
        assertEquals(WarmUpTwo.stringX("xabxxxcdx"),"xabcdx");
    }

    @Test
    public void altPairsTest() {
        assertEquals(WarmUpTwo.altPairs ("kitten"),"kien");
        assertEquals(WarmUpTwo.altPairs ("Chocolate"),"Chole");
        assertEquals(WarmUpTwo.altPairs ("CodingHorror"),"Congrr");
    }

    @Test
    public void stringYakTest() {
        assertEquals(WarmUpTwo.stringYak  ("yakpak"),"pak");
        assertEquals(WarmUpTwo.stringYak  ("pakyak"),"pak");
        assertEquals(WarmUpTwo.stringYak  ("yak123ya"),"123ya");
    }

    @Test
    public void array667Test() {
        int[] testOne = {6,6,2};
        assertEquals(WarmUpTwo.array667 (testOne),1);
        int[] testTwo = {6,6,2,6};
        assertEquals(WarmUpTwo.array667 (testTwo),1);
        int[] testThree = {6,7,2,6};
        assertEquals(WarmUpTwo.array667 (testThree),31);
    }

    @Test
    public void noTriplesTest() {
        int[] testOne = {1,1,2,2,1};
        assertEquals(WarmUpTwo.noTriples (testOne),true);
        int[] testTwo = {1,1,2,2,2,1};
        assertEquals(WarmUpTwo.noTriples (testTwo),false);
        int[] testThree = {1,1,1,2,2,2,1};
        assertEquals(WarmUpTwo.noTriples (testThree),false);
    }

    @Test
    public void has271Test() {
        int[] testOne = {1,2,7,1};
        assertEquals(WarmUpTwo.has271  (testOne),true);
        int[] testTwo = {1,2,8,1};
        assertEquals(WarmUpTwo.has271  (testTwo),false);
        int[] testThree = {2,7,1};
        assertEquals(WarmUpTwo.has271  (testThree),true);
    }

}
