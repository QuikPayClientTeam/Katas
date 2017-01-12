package lcd;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		LCD lcd = new LCD();
		String response;

		while (true)
		{
			System.out.println("Enter Number (q to quit): ");
			response = input.nextLine();

			if (response.equals("q"))
			{
				break;
			}
			else
			{
				try
				{
					System.out.println(lcd.getDigitalForm(Integer.parseInt(response)));
				}
				catch (NumberFormatException e)
				{
					System.out.println("Entry was not a number");
				}
			}
		}

		input.close();
	}
}
