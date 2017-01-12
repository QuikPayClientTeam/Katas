package balance;

import static org.junit.Assert.*;
import org.junit.Test;

public class BalanceTest
{
	@Test
	public void testBalance()
	{
		Balance balance = new Balance();
		assertNotNull(balance);
	}

	@Test
	public void testIsBalanced()
	{
		Balance balance = new Balance();
		assertEquals(false, balance.isBalanced("{{)(}}"));
		assertEquals(false, balance.isBalanced("({)}"));
		assertEquals(true, balance.isBalanced("[({})]"));
		assertEquals(true, balance.isBalanced("{}([])"));
		assertEquals(true, balance.isBalanced("{()}[[{}]]"));
	}
}
