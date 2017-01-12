package lcd;

import static org.junit.Assert.*;
import org.junit.Test;

public class LCDTest
{
	@Test
	public void testLCD()
	{
		LCD lcd = new LCD();
		assertNotNull(lcd);
	}

	@Test
	public void testGetDigitalForm()
	{
		LCD lcd = new LCD();
		System.out.println(lcd.getDigitalForm(912));
		System.out.println(lcd.getDigitalForm(180));
		System.out.println(lcd.getDigitalForm(214));
		System.out.println(lcd.getDigitalForm(11111));
		System.out.println(lcd.getDigitalForm(555));
		System.out.println(lcd.getDigitalForm(4673));
	}
}
