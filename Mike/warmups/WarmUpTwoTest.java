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
        assertEquals(WarmUpTwo.stringBits("HiHiHi"),"HHH");
        assertEquals(WarmUpTwo.stringBits(""),"");
        assertEquals(WarmUpTwo.stringBits("Greetings"),"Getns");
        assertEquals(WarmUpTwo.stringBits("Chocoate"),"Coot");
        assertEquals(WarmUpTwo.stringBits("pi"),"p");
        assertEquals(WarmUpTwo.stringBits("Hello Kitten"),"HloKte");
        assertEquals(WarmUpTwo.stringBits("hxaxpxpxy"),"happy");
    }

    @Test
    public void stringSplosionTest() {
        assertEquals(WarmUpTwo.stringSplosion("Code"),"CCoCodCode");
        assertEquals(WarmUpTwo.stringSplosion("abc"),"aababc");
        assertEquals(WarmUpTwo.stringSplosion("ab"),"aab");
        assertEquals(WarmUpTwo.stringSplosion("x"),"x");
        assertEquals(WarmUpTwo.stringSplosion("fade"),"ffafadfade");
        assertEquals(WarmUpTwo.stringSplosion("There"),"TThTheTherThere");
        assertEquals(WarmUpTwo.stringSplosion("Kitten"),"KKiKitKittKitteKitten");
        assertEquals(WarmUpTwo.stringSplosion("Bye"),"BByBye");
        assertEquals(WarmUpTwo.stringSplosion("Good"),"GGoGooGood");
        assertEquals(WarmUpTwo.stringSplosion("Bad"),"BBaBad");
    }

    @Test
    public void last2Test() {
        assertEquals(WarmUpTwo.last2("hixxhi"),1);
        assertEquals(WarmUpTwo.last2("xaxxaxaxx"),1);
        assertEquals(WarmUpTwo.last2("axxxaaxx"),2);
        assertEquals(WarmUpTwo.last2("xxaxxaxxaxx"),3);
        assertEquals(WarmUpTwo.last2("xaxaxaxx"),0);
        assertEquals(WarmUpTwo.last2("xxxx"),2);
        assertEquals(WarmUpTwo.last2("13121312"),1);
        assertEquals(WarmUpTwo.last2("11212"),1);
        assertEquals(WarmUpTwo.last2("13121311"),0);
        assertEquals(WarmUpTwo.last2("1717171"),2);
        assertEquals(WarmUpTwo.last2("hi"),0);
        assertEquals(WarmUpTwo.last2("h"),0);
        assertEquals(WarmUpTwo.last2(""),0);
    }

    @Test
    public void arrayCount9Test() {
        int[] testOne = {1,2,9};
        assertEquals(WarmUpTwo.arrayCount9(testOne),1);
        int[] testTwo = {1,9,9};
        assertEquals(WarmUpTwo.arrayCount9(testTwo),2);
        int[] testThree = {1,9,9,3,9};
        assertEquals(WarmUpTwo.arrayCount9(testThree),3);
        int[] testFour = {1, 2, 3};
        assertEquals(WarmUpTwo.arrayCount9(testFour),0);
        int[] testFive = {};
        assertEquals(WarmUpTwo.arrayCount9(testFive),0);
        int[] testSix = {4, 2, 4, 3, 1};
        assertEquals(WarmUpTwo.arrayCount9(testSix),0);
        int[] testSeven = {9, 2, 4, 3, 1};
        assertEquals(WarmUpTwo.arrayCount9(testSeven),1);
    }

    @Test
    public void arrayFront9Test() {
        int[] testOne = {1, 2, 9, 3, 4};
        assertEquals(WarmUpTwo.arrayFront9(testOne),true);
        int[] testTwo = {1,2,3,4,9};
        assertEquals(WarmUpTwo.arrayFront9(testTwo),false);
        int[] testThree = {1,2,3,4,5};
        assertEquals(WarmUpTwo.arrayFront9(testThree),false);
        int[] testFour = {9, 2, 3};
        assertEquals(WarmUpTwo.arrayFront9(testFour),true);
        int[] testFive = {1, 9, 9};
        assertEquals(WarmUpTwo.arrayFront9(testFive),true);
        int[] testSix = {1,2,3};
        assertEquals(WarmUpTwo.arrayFront9(testSix),false);
        int[] testSeven = {1,9};
        assertEquals(WarmUpTwo.arrayFront9(testSeven),true);
        int[] testEight = {5,5};
        assertEquals(WarmUpTwo.arrayFront9(testEight),false);
        int[] testNine = {2};
        assertEquals(WarmUpTwo.arrayFront9(testNine),false);
        int[] testTen = {9};
        assertEquals(WarmUpTwo.arrayFront9(testTen),true);
        int[] testEleven = {};
        assertEquals(WarmUpTwo.arrayFront9(testEleven),false);
        int[] testTwelve = {3,9,2,3,3};
        assertEquals(WarmUpTwo.arrayFront9(testTwelve),true);
    }

    @Test
    public void array123Test() {
        int[] testOne = {1,1,2,3,1};
        assertEquals(WarmUpTwo.array123(testOne),true);
        int[] testTwo = {1,1,2,4,1};
        assertEquals(WarmUpTwo.array123(testTwo),false);
        int[] testThree = {1,1,2,1,2,3};
        assertEquals(WarmUpTwo.array123(testThree),true);
        int[] testFour = {1,1,2,1,2,1};
        assertEquals(WarmUpTwo.array123(testFour),false);
        int[] testFive = {1, 2, 3, 1, 2, 3};
        assertEquals(WarmUpTwo.array123(testFive),true);
        int[] testSix = {1,2,3};
        assertEquals(WarmUpTwo.array123(testSix),true);
        int[] testSeven = {1,1,1};
        assertEquals(WarmUpTwo.array123(testSeven),false);
        int[] testEight = {1,2};
        assertEquals(WarmUpTwo.array123(testEight),false);
        int[] testNine = {1};
        assertEquals(WarmUpTwo.array123(testNine),false);
        int[] testTen = {1};
        assertEquals(WarmUpTwo.array123(testTen),false);
    }

    @Test
    public void stringMatchTest() {
        assertEquals(WarmUpTwo.stringMatch("xxcaazz","xxbaaz"),3);
        assertEquals(WarmUpTwo.stringMatch("abc","abc"),2);
        assertEquals(WarmUpTwo.stringMatch("abc","axc"),0);
        assertEquals(WarmUpTwo.stringMatch("hello","he"),1);
        assertEquals(WarmUpTwo.stringMatch("he","hello"),1);
        assertEquals(WarmUpTwo.stringMatch("h","hello"),0);
        assertEquals(WarmUpTwo.stringMatch("","hello"),0);
        assertEquals(WarmUpTwo.stringMatch("aabbccdd","abbbxxd"),1);
        assertEquals(WarmUpTwo.stringMatch("aaxxaaxx","iaxxai"),3);
        assertEquals(WarmUpTwo.stringMatch("iaxxai","aaxxaaxx"),3);
    }

    @Test
    public void stringXTest() {
        assertEquals(WarmUpTwo.stringX("xxHxix"),"xHix");
        assertEquals(WarmUpTwo.stringX("abxxxcd"),"abcd");
        assertEquals(WarmUpTwo.stringX("xabxxxcdx"),"xabcdx");
        assertEquals(WarmUpTwo.stringX("xKittenx"),"xKittenx");
        assertEquals(WarmUpTwo.stringX("Hello"),"Hello");
        assertEquals(WarmUpTwo.stringX("xx"),"xx");
        assertEquals(WarmUpTwo.stringX("x"),"x");
        assertEquals(WarmUpTwo.stringX(""),"");
    }

    @Test
    public void altPairsTest() {
        assertEquals(WarmUpTwo.altPairs ("kitten"),"kien");
        assertEquals(WarmUpTwo.altPairs ("Chocolate"),"Chole");
        assertEquals(WarmUpTwo.altPairs ("CodingHorror"),"Congrr");
        assertEquals(WarmUpTwo.altPairs ("yak"),"ya");
        assertEquals(WarmUpTwo.altPairs ("ya"),"ya");
        assertEquals(WarmUpTwo.altPairs ("y"),"y");
        assertEquals(WarmUpTwo.altPairs (""),"");
        assertEquals(WarmUpTwo.altPairs ("ThisThatTheOther"),"ThThThth");
    }

    @Test
    public void stringYakTest() {
        assertEquals(WarmUpTwo.stringYak  ("yakpak"),"pak");
        assertEquals(WarmUpTwo.stringYak  ("pakyak"),"pak");
        assertEquals(WarmUpTwo.stringYak  ("yak123ya"),"123ya");
        assertEquals(WarmUpTwo.stringYak  ("yak"),"");
        assertEquals(WarmUpTwo.stringYak  ("yakxxxyak"),"xxx");
        assertEquals(WarmUpTwo.stringYak  ("HiyakHi"),"HiHi");
        assertEquals(WarmUpTwo.stringYak  ("xxxyakyyyakzzz"),"xxxyyzzz");
    }

    @Test
    public void array667Test() {
        int[] testOne = {6,6,2};
        assertEquals(WarmUpTwo.array667 (testOne),1);
        int[] testTwo = {6,6,2,6};
        assertEquals(WarmUpTwo.array667 (testTwo),1);
        int[] testThree = {6,7,2,6};
        assertEquals(WarmUpTwo.array667 (testThree),1);
        int[] testFour = {6,6,2,6,7};
        assertEquals(WarmUpTwo.array667 (testFour),2);
        int[] testFive = {1,6,3};
        assertEquals(WarmUpTwo.array667 (testFive),0);
        int[] testSix = {6,1};
        assertEquals(WarmUpTwo.array667 (testSix),0);
        int[] testSeven = {};
        assertEquals(WarmUpTwo.array667 (testSeven),0);
        int[] testEight = {3,6,7,6};
        assertEquals(WarmUpTwo.array667 (testEight),1);
        int[] testNine = {3,6,6,7};
        assertEquals(WarmUpTwo.array667 (testNine),2);
        int[] testTen = {6,3,6,6};
        assertEquals(WarmUpTwo.array667 (testTen),1);
        int[] testEleven = {6,7,6,6};
        assertEquals(WarmUpTwo.array667 (testEleven),2);
        int[] testTwelve = {1,2,3,5,6};
        assertEquals(WarmUpTwo.array667 (testTwelve),0);
        int[] testThirteen = {1,2,3,6,6};
        assertEquals(WarmUpTwo.array667 (testThirteen),1);
    }

    @Test
    public void noTriplesTest() {
        int[] testOne = {1,1,2,2,1};
        assertEquals(WarmUpTwo.noTriples (testOne),true);
        int[] testTwo = {1,1,2,2,2,1};
        assertEquals(WarmUpTwo.noTriples (testTwo),false);
        int[] testThree = {1,1,1,2,2,2,1};
        assertEquals(WarmUpTwo.noTriples (testThree),false);
        int[] testFour = {1, 1, 2, 2, 1, 2, 1};
        assertEquals(WarmUpTwo.noTriples (testFour),true);
        int[] testFive = {1,2,1};
        assertEquals(WarmUpTwo.noTriples (testFive),true);
        int[] testSix = {1,1,1};
        assertEquals(WarmUpTwo.noTriples (testSix),false);
        int[] testSeven = {1,1};
        assertEquals(WarmUpTwo.noTriples (testSeven),true);
        int[] testEight = {1};
        assertEquals(WarmUpTwo.noTriples (testEight),true);
        int[] testNine = {};
        assertEquals(WarmUpTwo.noTriples (testNine),true);
    }

    @Test
    public void has271Test() {
        int[] testOne = {1,2,7,1};
        assertEquals(WarmUpTwo.has271  (testOne),true);
        int[] testTwo = {1,2,8,1};
        assertEquals(WarmUpTwo.has271  (testTwo),false);
        int[] testThree = {2,7,1};
        assertEquals(WarmUpTwo.has271  (testThree),true);
        int[] testFour = {3,8,2};
        assertEquals(WarmUpTwo.has271  (testFour),true);
        int[] testFive = {2,7,3};
        assertEquals(WarmUpTwo.has271  (testFive),true);
        int[] testSix = {2,7,4};
        assertEquals(WarmUpTwo.has271  (testSix),false);
        int[] testSeven = {2,7,-1};
        assertEquals(WarmUpTwo.has271  (testSeven),true);
        int[] testEight = {2,7,-2};
        assertEquals(WarmUpTwo.has271  (testEight),false);
        int[] testNine = {4,5,3,8,0};
        assertEquals(WarmUpTwo.has271  (testNine),true);
        int[] testTen = {2,7,5,10,4};
        assertEquals(WarmUpTwo.has271  (testTen),true);
        int[] testEleven = {2,7,-2,4,9,3};
        assertEquals(WarmUpTwo.has271  (testEleven),true);
        int[] testTwelve = {2,7,5,10,1};
        assertEquals(WarmUpTwo.has271  (testTwelve),false);
        int[] testThirteen = {2,7,-2,4,10,2};
        assertEquals(WarmUpTwo.has271  (testThirteen),false);
    }
}
