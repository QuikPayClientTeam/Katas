import java.util.Arrays;

public class Thirteenth {

  public static void main(String[] args) {

    int days[] = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int leapDays[] = new int[] {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int count[] = new int[7];
    Arrays.fill(count, 0);
    int calendarDay = 0;
    int begin = 1973;
    int end = 2016; 

    for (int year = begin; year < end + 1; year++) {
        for (int month = 0; month < 12; month++) {
            int day = (calendarDay + 12) % 7;
            count[day]++;
            calendarDay += isLeap(year) ? leapDays[month] : days[month];
        }
    }

    System.out.println("Number of Mondays that are the 13th: " + count[0]);
    System.out.println("Number of Tuesdays that are the 13th: " + count[1]);
    System.out.println("Number of Wednesdays that are the 13th: " + count[2]);
    System.out.println("Number of Thursdays that are the 13th: " + count[3]);
    System.out.println("Number of Fridays that are the 13th: " + count[4]);
    System.out.println("Number of Saturdays that are the 13th: " + count[5]);
    System.out.println("Number of Sundays that are the 13th: " + count[6]);
    
    int sum = 0;
	for (int i : count) {
    	sum  += i;
	}
    System.out.println("Total number of days that are the 13th: " + sum);
    
    if (isBig(count)) {
    System.out.println("Friday is the highest count");	
    } else {
    	System.out.println("Friday is not the highest count");
    }
    
  }

    public static boolean isLeap(int year) {
        if (year % 100 == 0) {
            return year % 400 == 0;
        } else {
            return year % 4 == 0;
        }
    }

    public static boolean isBig(int[] count) {
    	int i;
    	int largest = Integer.MIN_VALUE;
    	for (i = 0;i<count.length;i++){
    		
			if(count[i] > largest ) {
    			largest = count[i];
    		}
    	}
		return largest == count[4];
    }

}
