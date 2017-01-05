package kata7;

public class Warmup2 {

	public static void main(String[] args) {

	}

	public static String stringTimes(String str, int n) {
		String result = "";
		for (int i = 0; i < n; i++) {
			result += str;
		}
		return result;
	}

	public static String frontTimes(String str, int n) {
		String result = "";
		String concat = "";

		if (str.length() >= 3) {
			concat = str.substring(0, 3);
		} else {
			concat = str;
		}

		for (int i = 0; i < n; i++) {
			result += concat;
		}
		return result;
	}

	public static int countXX(String str) {
		int count = 0;
		if (str.length() >= 2) {
			for (int i = 0; i < str.length() - 1; i++) {
				if (str.substring(i, i + 2).equals("xx")) {

					count++;
				}
			}

		}
		return count;
	}

	public static boolean doubleX(String str) {
		boolean isFound = false;

		if (str.length() >= 2) {
			int firstX = str.indexOf('x');
			if ((firstX <= str.length() - 2) && firstX > -1) {
				if (str.substring(firstX, firstX + 2).equals("xx")) {
					isFound = true;
				}
			}
		}

		return isFound;

	}

	public static int last2(String str) {
		int count = 0;

		if (str.length() >= 2) {
			for (int i = 0; i < str.length() - 2; i++) {
				if (str.substring(i, i + 2).equals(str.substring(str.length() - 2, str.length()))) {
					count++;
				}
			}
		}

		return count;
	}

}
