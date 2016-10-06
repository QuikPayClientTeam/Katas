import java.util.Random;

public class kata1_diceroll {

	public static void main(String[] args) {

		Random random = new Random();
		//dumb 0 check: http://stackoverflow.com/questions/20389890/generating-a-random-number-between-1-and-10-java
		//((max - min) + 1) + min
		int max = 6;
		int min = 1;
		
		int dice1 = random.nextInt((max - min) + 1) + min;
		int dice2 = random.nextInt((max - min) + 1) + min;

		printDice(dice1);
		printDice(dice2);

	}

	public static void printDice(int i) {
		switch (i) {
		case 1:
			System.out.println("=====");
			System.out.println("= 1 =");
			System.out.println("=====");
			break;
		case 2:
			System.out.println("=====");
			System.out.println("= 2 =");
			System.out.println("=====");
			break;
		case 3:
			System.out.println("=====");
			System.out.println("= 3 =");
			System.out.println("=====");
			break;
		case 4:
			System.out.println("=====");
			System.out.println("= 4 =");
			System.out.println("=====");
			break;
		case 5:
			System.out.println("=====");
			System.out.println("= 5 =");
			System.out.println("=====");
			break;
		case 6:
			System.out.println("=====");
			System.out.println("= 6 =");
			System.out.println("=====");
			break;

		}

	}


}
