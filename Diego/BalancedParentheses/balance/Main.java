package balance;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Balance balancer = new Balance();
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
				System.out.println(balancer.isBalanced(response));
			}
		}

		input.close();
	}
}
