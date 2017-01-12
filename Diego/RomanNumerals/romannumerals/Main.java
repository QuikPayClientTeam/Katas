package romannumerals;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Numerals numeralinator = new Numerals();
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
					System.out.println(numeralinator.getNumeralForm(Integer.parseInt(response)));
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
