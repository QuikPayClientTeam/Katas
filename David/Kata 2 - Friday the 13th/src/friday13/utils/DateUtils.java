package friday13.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateUtils {

	private DateUtils(){}

	public static LocalDate stringToDate(String dateAsString){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
		return LocalDate.parse(dateAsString, formatter);
	}

}
