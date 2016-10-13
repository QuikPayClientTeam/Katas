import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class kata2_friday13th {

	public static void main(String[] args) {
		
		int[][] log = createLogger();
		gatherInfo(log);
		output(log);
		System.out.println(isFridayMost(log));

	}
	
	//create logging array
	public static int[][] createLogger(){

		return new int[][] { { 1, 2, 3, 4, 5, 6, 7 }, { 0, 0, 0, 0, 0, 0, 0 } };

	}
	
	//find all the 13ths days
	public static int[][] gatherInfo(int[][] log){
		// set current time
		Calendar cal = Calendar.getInstance();
		Date now = cal.getTime();
		cal.setTime(now);

		// set starting date
		Calendar starting_date = new GregorianCalendar(1973, 0, 13);

		
		// check all 13ths days
		while (starting_date.compareTo(cal) < 0) {
			int x = log[1][starting_date.get(Calendar.DAY_OF_WEEK) - 1];
			x++;
			log[1][starting_date.get(Calendar.DAY_OF_WEEK) - 1] = x;
			starting_date.add(Calendar.MONTH, 1);

		}
		
		return log;
	}

	public static void output(int[][] in) {

		// System.out.println(Arrays.deepToString(log));

		// report
		System.out.println("Sunday:\t\t" + in[1][0]);
		System.out.println("Monday:\t\t" + in[1][1]);
		System.out.println("Tuesday:\t" + in[1][2]);
		System.out.println("Wendesday:\t" + in[1][3]);
		System.out.println("Thursday:\t" + in[1][4]);
		System.out.println("Friday:\t\t" + in[1][5]);
		System.out.println("Saturday:\t" + in[1][6]);

	}

	public static boolean isFridayMost(int[][] in) {

		int max = 0;
		int maxDay = 0;
		int second = 0;
		int secondDay = 0;

		for (int i = 0; i < 6; i++) {

			if (in[1][i] >= max) {
				second = max;
				secondDay = in[0][i];
				max = in[1][i];
				maxDay = in[0][i];
			}

		}

		if (max == in[1][5] && maxDay == in[0][5]) {
			if (max != second && maxDay != secondDay) {
				return true;
			}

		}
		return false;

	}

}
