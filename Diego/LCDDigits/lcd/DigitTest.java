package lcd;

import static org.junit.Assert.*;
import org.junit.Test;

public class DigitTest
{
	@Test
	public void testDigit()
	{
		String[] digit1 = Digit.ONE.toString().split(",");
		System.out.println(digit1[0] + "\n" + digit1[1] + "\n" + digit1[2]);
		assertEquals("   ,  |,  |", Digit.ONE.toString());

		String[] digit2 = Digit.TWO.toString().split(",");
		System.out.println(digit2[0] + "\n" + digit2[1] + "\n" + digit2[2]);
		assertEquals(" _ , _|,|_ ", Digit.TWO.toString());

		String[] digit3 = Digit.THREE.toString().split(",");
		System.out.println(digit3[0] + "\n" + digit3[1] + "\n" + digit3[2]);
		assertEquals(" _ , _|, _|", Digit.THREE.toString());

		String[] digit4 = Digit.FOUR.toString().split(",");
		System.out.println(digit4[0] + "\n" + digit4[1] + "\n" + digit4[2]);
		assertEquals("   ,|_|,  |", Digit.FOUR.toString());

		String[] digit5 = Digit.FIVE.toString().split(",");
		System.out.println(digit5[0] + "\n" + digit5[1] + "\n" + digit5[2]);
		assertEquals(" _ ,|_ , _|", Digit.FIVE.toString());

		String[] digit6 = Digit.SIX.toString().split(",");
		System.out.println(digit6[0] + "\n" + digit6[1] + "\n" + digit6[2]);
		assertEquals(" _ ,|_ ,|_|", Digit.SIX.toString());

		String[] digit7 = Digit.SEVEN.toString().split(",");
		System.out.println(digit7[0] + "\n" + digit7[1] + "\n" + digit7[2]);
		assertEquals(" _ ,  |,  |", Digit.SEVEN.toString());

		String[] digit8 = Digit.EIGHT.toString().split(",");
		System.out.println(digit8[0] + "\n" + digit8[1] + "\n" + digit8[2]);
		assertEquals(" _ ,|_|,|_|", Digit.EIGHT.toString());

		String[] digit9 = Digit.NINE.toString().split(",");
		System.out.println(digit9[0] + "\n" + digit9[1] + "\n" + digit9[2]);
		assertEquals(" _ ,|_|,  |", Digit.NINE.toString());

		String[] digit0 = Digit.ZERO.toString().split(",");
		System.out.println(digit0[0] + "\n" + digit0[1] + "\n" + digit0[2]);
		assertEquals(" _ ,| |,|_|", Digit.ZERO.toString());
	}
}
