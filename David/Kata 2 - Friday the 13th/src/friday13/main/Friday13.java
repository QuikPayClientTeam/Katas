package friday13.main;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

import friday13.utils.Constants;
import friday13.utils.DateUtils;
import friday13.utils.Display;
import friday13.utils.ResourceBundleUtils;

public class Friday13 {

	private static LocalDate startDate;
	private static LocalDate endDate;
	private static int dayOfMonth;
	private static String dayOfWeek;
	private static HashMap <String, Integer> days = new HashMap <String, Integer>();

	public static void main(String[] args) {
		/*
		 * 	Write a program to show that the 13th day of the month
			falls more often on a Friday than any other day of the
			week. The 1st of January 1973 was a Monday.
			You should aim at producing the clearest possible
			program, not the fastest.
		 */

		mostCommonDay();
		getResults(true);
	}

	private static void init(){
		ResourceBundle rbSettings = ResourceBundleUtils.getResourceBundle(Constants.SETTINGS_DIRECTORY, Constants.SETTINGS_PROPERTIES_FILE);
		String startDateAsString = rbSettings.getString("startDate");
		String endDateAsString = rbSettings.getString("endDate");
		String dayAsString = rbSettings.getString("dayOfMonth");
		dayOfWeek = rbSettings.getString("dayOfWeek");

		startDate = DateUtils.stringToDate(startDateAsString);
		endDate = endDateAsString.isEmpty() ? LocalDate.now() : DateUtils.stringToDate(endDateAsString);
		dayOfMonth = Integer.valueOf(dayAsString);

		days = new HashMap<String, Integer>();
	}

	public static String mostCommonDay(){
		init();

		for (int year = startDate.getYear(); year <= endDate.getYear(); year++){
			int startMonth = year == startDate.getYear() ? startDate.getMonthValue() : 1;
			int endMonth = year == endDate.getYear() ? endDate.getMonthValue() : 12;
			for (int month = startMonth; month <= endMonth; month++){
				boolean checkDate = true;
				if (year == startDate.getYear() && month == startDate.getMonthValue() && dayOfMonth < startDate.getDayOfMonth()){
					checkDate = false;
				}else if (year == endDate.getYear() && month == endDate.getMonthValue() && dayOfMonth > endDate.getDayOfMonth()){
					checkDate = false;
				}

				if (checkDate){
					LocalDate date = LocalDate.of(year, month, dayOfMonth);
					days.put(date.getDayOfWeek().toString(), getCurrentNumberOfDays(days, date.getDayOfWeek().toString()) + 1);
				}
			}
		}

		return getResults();
	}

	private static Integer getCurrentNumberOfDays(HashMap <String, Integer> days, String dayOfWeek){
		Integer numberOfDays = days.get(dayOfWeek);
		if (numberOfDays == null){
			numberOfDays = 0;
			days.put(dayOfWeek, numberOfDays);
		}
		return numberOfDays;
	}

	private static String getResults(){
		return getResults(false);
	}

	private static String getResults(boolean displayResults){

		String mostCommonDay = Constants.EMPTY_STRING;
		Map<String, Integer> orderedMap = new LinkedHashMap<>();

		days.entrySet().stream()
		.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
		.forEachOrdered(result -> orderedMap.put(result.getKey(), result.getValue()));;

		Integer max = null;
		boolean firstMessage = true;
		boolean mostCommon = true;

		for (String key : orderedMap.keySet()) {
			boolean sameNumberOfTimes = true;
			if (max != null && !orderedMap.get(key).equals(max)){
				mostCommon = false;
				sameNumberOfTimes = false;
			}
			max = orderedMap.get(key);
			if (mostCommon){
				if (Constants.EMPTY_STRING.equals(mostCommonDay)){
					mostCommonDay = String.valueOf(key);
				}else{
					mostCommonDay = null;
				}
				if (displayResults){
					Display.displayMessage(firstMessage ? "Most common " + dayOfMonth + " happened " + max + " times on: " : ", ", false);
					firstMessage = false;
					Display.displayMessage(String.valueOf(key), false);
				}
			} else{
				if (displayResults){
					Display.displayMessage(!sameNumberOfTimes ? "\nIt happened " + max + " times on: " : ", ", false);
					Display.displayMessage(String.valueOf(key), false);
				}else{
					break;
				}
			}
		}

		if (displayResults){
			Display.displayMessage("\n\n" + dayOfWeek + " is " + (dayOfWeek.equalsIgnoreCase(mostCommonDay) ? "" : "NOT ") + "the most common " + dayOfMonth + " day of the month.");
		}

		return mostCommonDay;
	}

}
