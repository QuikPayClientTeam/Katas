package kata4;

public class AllThemWarmUps {

	public static void main(String[] args) {

	}

	/*
	 * Column One
	 */

	public static boolean SleepIn(boolean weekday, boolean vacation) {
		if (weekday == true) {
			if (vacation == true) {
				return true;
			} else {
				return false;
			}

		}

		return true;
	}

	public static int diff21(int in) {
		if (in > 21) {
			return 2 * (Math.abs(21 - in));
		} else {
			return Math.abs(21 - in);
		}

	}

	public static boolean nearHundred(int n) {
		if ((Math.abs(200 - n)) <= 10) {
			return true;
		}

		if ((Math.abs(100 - n)) <= 10) {
			return true;
		} else {
			return false;
		}

	}

	public static String missingChar(String str, int n) {
		String beggining = str.substring(0, n);
		String ending = str.substring(n + 1, str.length());

		return beggining + ending;
	}

	public static String backAround(String in) {
		if (in != null) {
			char padding = in.charAt(in.length() - 1);
			return padding + in + padding;
		}
		return null;

	}

	public static boolean startHi(String str) {

		if (str.length() >= 2 && str != null) {

			String hi = str.substring(0, 2);

			if (hi.equalsIgnoreCase("hi")) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public static boolean hasTeen(int[] in) {

		for (int i = 0; i < in.length; i++) {
			if (in[i] >= 13 && in[i] <= 19) {
				return true;
			}
		}

		return false;
	}

	public static boolean mixStart(String str) {
		if (str.length() >= 3 && str != null) {
			String ix = str.substring(1, 3);

			// figuring these out
			return ix.equalsIgnoreCase("ix") ? true : false;

		} else {
			return false;
		}

	}

	public static int close10(int x, int y) {
		int compareX = Math.abs(10 - x);
		int compareY = Math.abs(10 - y);
		if (compareX == compareY) {
			return 0;
		}

		return (compareX < compareY) ? x : y;
	}

	public static boolean stringE(String str) {

		int counter = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'e') {
				counter++;
			}
		}

		return (counter > 0 && counter < 4) ? true : false;
	}

	public static String everyNth(String str, int n) {

		if (n > 0) {

			String temp = "";

			for (int i = 0; i < str.length();) {

				temp += str.charAt(i);
				i += n;

			}

			return temp;

		}

		return "WRONG! *sniff*";

	}

	/*
	 * Column Two
	 */

	public static boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
		if (aSmile && bSmile) {
			return true;
		}
		if (!aSmile && !bSmile) {
			return true;
		}
		return false;
	}

	public static boolean parrotTrouble(boolean talking, int hour) {
		if (hour > 23 || hour < 0) {
			System.out.println("Hour is out of bounds :/ ");
			return false;
		} else {
			if ((talking && hour < 7) || (talking && hour > 20)) {
				return true;
			} else {
				return false;
			}

		}
	}

	public static boolean posNeg(int a, int b, boolean negative) {
		if (negative) {
			return (a < 0 && b < 0) ? true : false;
		} else {
			return ((a < 0 && b > 0) || (a > 0 && b < 0)) ? true : false;
		}

	}

	public static String frontBack(String str) {
		if (str != null && str.length() >= 2) {
			char first = str.charAt(0);
			char last = str.charAt(str.length() - 1);
			String temp = str.substring(1, str.length() - 1);
			return last + temp + first;
		}

		return str;

	}

	public static boolean or35(int n) {
		return ((n % 3 == 0) || (n % 5 == 0)) ? true : false;
	}

	public static boolean icyHot(int temp1, int temp2) {
		if (temp1 > 100 && temp2 < 0) {
			return true;
		} else if (temp1 < 0 && temp2 > 100) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean loneTeen(int a, int b) {
		boolean aTeen = (a < 20 && a >= 13);
		boolean bTeen = (b < 20 && b >= 13);

		return (aTeen != bTeen) ? true : false;

	}

	public static String startOz(String str) {
		if (str.length() > 1) {
			if ("oz".equalsIgnoreCase(str.substring(0, 2))) {
				return "oz";
			} else if ("z".equalsIgnoreCase(str.substring(1, 2))) {
				return "z";
			}
		} else if (str.length() >= 1 && "o".equalsIgnoreCase(str.substring(0, 1))) {
			return "o";
		}

		return "";
	}

	public static boolean in3050(int a, int b) {
		boolean aForties = (a >= 30 && a <= 40) ? true : false;
		boolean bForties = (b >= 30 && b <= 40) ? true : false;
		boolean aFifties = (a >= 40 && a <= 50) ? true : false;
		boolean bFifties = (b >= 40 && b <= 50) ? true : false;

		return ((aForties && bForties) || (aFifties && bFifties)) ? true : false;

	}
	
	public static boolean lastDigit(int a, int b){
		if (a >= 0 && b >= 0){
			return ((a % 10) == ( b % 10)) ? true : false;
		} else {
			return false;
		}
		
	}
	
	/*
	 * Column Three
	 */
	
	public static int sumDouble(int a, int b){
		if(a == b){
			return 2 * (a + b);
		} else {
			return a + b;
		}
	}

	public static boolean makes10(int a, int b){
		if(a == 10 || b == 10){
			return true;
		} else if ((a + b) == 10){
			return true; 
		} else {
			return false; 
		}
	}
	
	public static String notString(String str){
		if((str.length() >= 3) && ("not".equalsIgnoreCase(str.substring(0, 3)))){
			return str;
		} else {
			return "not " + str;
		}
	}
	
	public static String front3(String str){
		if(str.length() >= 3){
			String temp = str.substring(0, 3);
			return temp + temp + temp;
		} else {
			return str + str + str;
		}
	}
}
