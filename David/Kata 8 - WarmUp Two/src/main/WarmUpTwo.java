package main;

public class WarmUpTwo {

	public static String stringTimes(String string, int n) {
		String finalString = "";
		for (int index = 0; index < n; index++){
			finalString += string;
		}
		return finalString;
	}

	public static String frontTimes(String string, int n) {
		String finalString = "";
		int frontLength = string.length() >= 3 ? 3 : string.length();
		for (int index = 0; index < n; index++){
			finalString += string.substring(0, frontLength);
		}
		return finalString;
	}

	public static int countXX(String string) {
		int count = 0;
		if (string.length() > 1){
			for (int index = 0; index < string.length() - 1; index++){
				String nextTwoCharacters = string.substring(index, index+2);
				if (nextTwoCharacters.equalsIgnoreCase("xx")){
					count++;
				}
		    }
		}
		return count;
	}

	public static boolean doubleX(String string) {
		boolean doubleX = false;

		int firstX = string.toLowerCase().indexOf("x");

		if (firstX != -1 && firstX < string.length() - 1){
			String nextCharacter = string.substring(firstX + 1, firstX + 2).toLowerCase();
			if (nextCharacter.equalsIgnoreCase("x")) {
				doubleX = true;
			}
		}

		return doubleX;
	}

	public static String stringBits(String string) {
		String finalString = "";
		for (int index = 0; index < string.length(); index+=2) {
			finalString += string.substring(index, index + 1);
		}
		return finalString;
	}

	public static String stringSplosion(String string) {
		String finalString = "";
		for (int index = 1; index <= string.length(); index++){
			finalString += string.substring(0, index);
		}
		return finalString;
	}

	public static int last2(String string) {
		int numberOfTimes = 0;
		if (string.length() > 2){
			String substring = string.substring(string.length() - 2);
			for (int index = 0; index < string.length() - 2; index++){
				String compareString = string.substring(index, index + 2);
				if (compareString.equals(substring)){
					numberOfTimes++;
				}
			}
		}
		return numberOfTimes;
	}

	public static int arrayCount9(int[] numbers) {
		int numberOfNines = 0;
		for (int index = 0; index < numbers.length; index++){
			if (numbers[index] == 9){
				numberOfNines++;
			}
		}
		return numberOfNines;
	}

	public static boolean arrayFront9(int[] numbers) {
		boolean isNine = false;
		for (int index = 0; index < numbers.length && index < 4; index++){
			if (numbers[index] == 9){
				isNine = true;
				break;
			}
		}
		return isNine;
	}

	public static boolean array123(int[] numbers) {
		int previousNumber = -1;
		int numbersInSequence = 0;
		boolean isOne = false;
		for (int index = 0; index < numbers.length; index++){
			if (numbers[index] == 1){
				isOne = true;
				numbersInSequence = 1;
			}else{
				if (previousNumber != -1){
					if (isOne && numbers[index] == (previousNumber + 1)){
						numbersInSequence++;
					}else{
						numbersInSequence = 0;
						isOne = false;
					}
				}
			}
			if (numbersInSequence == 3){
				break;
			}
			previousNumber = numbers[index];
		}
		return (numbersInSequence == 3);
	}

	public static int stringMatch(String fisrtString, String secondString) {
		int numberOfSameSubstrings = 0;
		int maxLength = fisrtString.length() < secondString.length() ? fisrtString.length() : secondString.length();
		for (int index = 0; index < maxLength - 1; index++){
			String firstStringSubstring = fisrtString.substring(index, index + 2);
			String secondStringSubstring = secondString.substring(index, index + 2);
			if (firstStringSubstring.equals(secondStringSubstring)){
				numberOfSameSubstrings++;
			}
		}
		return numberOfSameSubstrings;
	}

	public static String stringX(String string) {
		String finalString = "";
		for (int index = 0; index < string.length(); index++){
			if (index == 0 || index == string.length() - 1 || !string.substring(index, index + 1).equals("x")){
				finalString += string.substring(index, index + 1);
			}
		}
		return finalString;
	}

	public static String altPairs(String string) {
		String finalString = "";
		boolean keepCharacters = false;

		for (int index = 0; index < string.length(); index++){
			if (index % 2 == 0){
				keepCharacters = !keepCharacters;
			}
			if (keepCharacters){
				finalString += string.substring(index, index + 1);
			}
		}

		return finalString;
	}

	public static String stringYak(String string) {
		String finalString = "";
		for (int index = 0; index < string.length(); index++){
			String yak = string.substring(index, index + (string.length() - index >= 3 ? 3 : 1));
			String firstCharacter = yak.substring(0, 1);
			String thirdCharacter = yak.length() > 1 ? yak.substring(2, 3) : "";
			if (firstCharacter.equalsIgnoreCase("y") && thirdCharacter.equalsIgnoreCase("k")){
				index += 2;
			}else{
				finalString += firstCharacter;
			}
		}
		return finalString;
	}

	public static int array667(int[] numbers) {
		int numberOfTimes = 0;
		boolean isPreviousSix = false;
		boolean isCurrentSix = false;
		boolean isCurrentSeven = false;
		for (int index = 0; index < numbers.length; index++){

			if (numbers[index] == 6){
				isCurrentSix = true;
			}else if (numbers[index] == 7){
				isCurrentSeven = true;
			}

			if (isPreviousSix && (isCurrentSix || isCurrentSeven)){
				numberOfTimes++;
			}

			isPreviousSix = isCurrentSix;
			isCurrentSix = false;
			isCurrentSeven = false;
		}
		return numberOfTimes;
	}

	public static boolean noTriples(int[] numbers) {
		boolean noTriples = true;
		int sameNumber = 1;
		int previousNumber = -1;
		for (int index = 0; index < numbers.length; index++){
			int currentNumber = numbers[index];
			if (currentNumber == previousNumber){
				sameNumber++;
				if (sameNumber == 3){
					noTriples = false;
					break;
				}
			}else{
				sameNumber = 1;
			}
			previousNumber = currentNumber;
		}
		return noTriples;
	}

	public static boolean has271(int[] numbers){
		boolean has271 = false;

		boolean numberPlusFive = false;
		boolean firstTime = false;
		int number = -1;

		for (int index = 0; index < numbers.length; index++){
			if (!numberPlusFive){
				if (!firstTime && numbers[index] == number + 5){
					numberPlusFive = true;
				}else{
					if (firstTime){
						firstTime = false;
					}
					number = numbers[index];
				}
			}else{
				if (Math.abs(numbers[index] - (number - 1)) <= 2){
					has271 = true;
					break;
				}else{
					numberPlusFive = false;
					number = numbers[index];
				}
			}
		}

		return has271;
	}

}
