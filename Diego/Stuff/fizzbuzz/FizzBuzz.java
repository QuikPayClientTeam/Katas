package fizzbuzz;

public class FizzBuzz {
	public FizzBuzz() {
		
	}

	public String determine(int n) {
		String result = new String();
		
		if (n % 3 == 0) {
			result += "Fizz";
		}
		if (n % 5 == 0) {
			result += "Buzz";
		}
		if (result.isEmpty()) {
			result += n;
		}
		
		return result;
	}
	
	public String determine(int[] nums) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			sb.append(determine(nums[i]) + "\n");
		}
		
		return sb.toString();
	}
}
