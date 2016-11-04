package main;

public class WarmUpOne {

	public static boolean sleepIn(boolean weekday, boolean vacation) {
		return !weekday || vacation;
	}

	public static boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
		return aSmile == bSmile;
	}

	public static int sumDouble(int a, int b) {
		return a != b ? a + b : (a + b) * 2;
	}

	public static int diff21(int n) {
		return n < 21 ? 21 - n : (n - 21) * 2;
	}

	public static boolean parrotTrouble(boolean talking, int hour) {
		return talking && (hour < 7 || hour > 20);
	}

	public static boolean makes10(int a, int b) {
		return ((a + b) == 10) || (a == 10) || (b == 10);
	}

	public static boolean nearHundred(int n) {
		return Math.abs((100 - n)) <= 10 || Math.abs((200 - n)) <= 10;
	}

	public static boolean posNeg(int a, int b, boolean negative) {
		return negative ? (a < 0 && b < 0) : (a < 0 && b >= 0) || (a >= 0 && b < 0);
	}

	public static String notString(String str) {
		return str != null && str.startsWith("not") ? str : "not " + str;
	}

	public static String missingChar(String str, int n) {
		return str == null ? str : (n >= 0 && n < str.length()) ? str.substring(0, n) + str.substring(n + 1) : str;
	}

	public static String frontBack(String str) {
		return str == null ? str : str.length() <= 1 ? str : str.substring(str.length() - 1) + str.substring(1, str.length() - 1) + str.substring(0, 1);
	}

	public static String front3(String str) {
		String front = str.length() < 3 ? str : str.substring(0 ,3);
		return str == null ? str : front + front + front;
	}

	public static String backAround(String str) {
		return str == null ? str : str.substring(str.length() - 1) + str + str.substring(str.length() - 1);
	}

	public static boolean or35(int n) {
		return n % 3 == 0 || n % 5 == 0;
	}

	public static String front22(String str) {
		int length = str == null ? 0 : str.length() >= 2 ? 2 : str.length();
		return str.substring(0, length) + str + str.substring(0, length);
	}

	public static boolean startHi(String str) {
		return str == null ? false : str.startsWith("hi");
	}

	public static boolean icyHot(int temp1, int temp2) {
		return (temp1 < 0 && temp2 > 100) || (temp2 < 0 && temp1 > 100);
	}

	public static boolean in1020(int a, int b) {
		return isNumberInRange(a, 10, 20, true) || isNumberInRange(b, 10, 20, true);
	}

	public static boolean hasTeen(int a, int b, int c) {
		return isTeen(a) || isTeen(b) || isTeen(c);
	}

	public static boolean loneTeen(int a, int b) {
		return isTeen(a) != isTeen(b);
	}

	public static String delDel(String str) {
		return str == null ? str : str.indexOf("del") != 1 ? str : str.substring(0, 1) + str.substring(4);
	}

	public static boolean mixStart(String str) {
		return str == null ? false : str.indexOf("ix") == 1;
	}

	private static String characterInPositionIfEqual(String string, String character, int index){
		return string == null || index > string.length() - 1 ? "" : string.substring(index, index + 1).equals(character) ? string.substring(index, index + 1) : "";
	}

	public static String startOz(String str) {
		return characterInPositionIfEqual(str, "o", 0) + characterInPositionIfEqual(str, "z", 1);
	}

	public static int intMax(int a, int b, int c) {
		int max = a;
		if (b > max){
			max = b;
		}
		if (c > max){
			max = c;
		}
		return max;
	}

	public static int close10(int a, int b) {
		int nearest = 0;
		if (Math.abs(10 - a) < Math.abs(10 - b)){
			nearest = a;
		}else if (Math.abs(10 - a) > Math.abs(10 - b)){
			nearest = b;
		}
		return nearest;
	}

	public static boolean in3050(int a, int b) {
		return (isNumberInRange(a, 30, 40, true) && isNumberInRange(b, 30, 40, true)) ||
				(isNumberInRange(a, 40, 50, true) && isNumberInRange(b, 40, 50, true));
	}

	public static int max1020(int a, int b) {
		int max = 0;
		if (isNumberInRange(a, 10, 20, true) && a > max){
			max = a;
		}
		if (isNumberInRange(b, 10, 20, true) && b > max){
			max = b;
		}
		return max;
	}

	public static boolean stringE(String str) {
		int numberOfEs = 0;
		int stringLength = str == null ? 0 : str.length();
		for (int i = 0; i < stringLength; i++){
			if (String.valueOf(str.charAt(i)).equalsIgnoreCase("e")){
				numberOfEs++;
			}
		}
		return isNumberInRange(numberOfEs, 1, 3, true);
	}

	public static boolean lastDigit(int a, int b) {
		return restOfDivingByTen(a) == restOfDivingByTen(b);
	}

	public static String endUp(String str) {
		if (str == null){
			return null;
		}else{
			int startUppercase = str.length() >= 3 ? str.length() - 3 : 0;
			return str.substring(0, startUppercase) + str.substring(startUppercase).toUpperCase();
		}
	}

	public static String everyNth(String str, int n) {
		String result = "";
		if (str != null){
			for (int i = 0; i < str.length(); i += n){
				result += String.valueOf(str.charAt(i));
			}
		}
		return result;
	}

	private static boolean isTeen(int number){
		return (number >= 13 && number <= 19);
	}

	private static boolean isNumberInRange(int number, int low, int high, boolean inclusive){
		return inclusive ? (number >= low && number <= high) : (number > low && number < high);
	}

	private static int restOfDivingByTen(int number){
		return number % 10;
	}
}
