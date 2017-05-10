package kata11;

import java.util.ArrayList;
import java.util.List;

public class CombinedNumbers {

	public static void main(String[] args) {
		int[] test = new int[] { 50, 2, 1, 9 }; // 95021

		List<Integer> combinations = new ArrayList<Integer>();
		getAllPermutations(test, 0, combinations);
		System.out.println("Max: " + getMax(combinations));

	}

	public static int getMax(List<Integer> list) {
		int max = 0;

		for (int i = 0; i < list.size(); i++) {
			if (max < list.get(i)) {
				max = list.get(i);
			}
		}

		return max;

	}

	public static int arrayToSum(int[] input) {

		// turn array into a string
		String output = "";

		for (int i = 0; i < input.length; i++) {
			output += Integer.toString(input[i]);
		}
		// System.out.println("Array to Sum: " + output);

		// send string back to int
		int sum = Integer.parseInt(output);

		return sum;
	}

	// https://www.youtube.com/watch?v=uPYhYVeXYxM
	public static List<Integer> getAllPermutations(int test[], int currentFocus, List<Integer> list) {

		// last case
		if (currentFocus == test.length) {

			arrayToSum(test);
			System.out.println("getAllPermutations: " + arrayToSum(test));
			list.add(arrayToSum(test));

			return list;
		} else {
			// current order
			getAllPermutations(test, currentFocus + 1, list);

			// swap
			for (int i = currentFocus; i < test.length; i++) {
				int temp = test[currentFocus];
				test[currentFocus] = test[i];
				test[i] = temp;

				// recurse down the hole
				getAllPermutations(test, currentFocus + 1, list);
			}
		}

		return list;

	}

}
