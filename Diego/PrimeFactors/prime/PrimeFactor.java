package prime;

import java.util.LinkedList;
import java.util.List;

public class PrimeFactor {
	public static List<Integer> generate(int number) {
		List<Integer> factors = new LinkedList<Integer>();

		for (int candidate = 2; number > 1; candidate++)
		{
			for (; number % candidate == 0; number /= candidate)
			{
				factors.add(candidate);
			}
		}

		return factors;
	}
}
