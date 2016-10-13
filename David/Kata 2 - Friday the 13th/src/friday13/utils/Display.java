package friday13.utils;

import java.io.Console;
import java.util.Scanner;

public class Display {

	private Display(){}

	public static void displayMessage(String message, boolean newLine){
		if (newLine){
			System.out.println(message);
		}else{
			System.out.print(message);
		}
	}

	public static void displayMessage(String message){
		displayMessage(message, true);
	}

	public static String askForInput() {
		return askForInput(null);
	}

	public static String askForInput(String message) {
		Console console = System.console();
		Scanner reader = null;
		if (console == null){
			reader = new Scanner(System.in);
		}

		if (message != null){
			displayMessage(message, false);
		}

		String input = Constants.EMPTY_STRING;
		if (console != null){
			input = console.readLine();
		}else{
			input = reader.nextLine();
		}

		return input;
	}

}
