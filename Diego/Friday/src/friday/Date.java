package friday;

public class Date
{
	public static Month[] months = {Month.JANUARY, Month.FEBRUARY, Month.MARCH, Month.APRIL, Month.MAY, Month.JUNE, Month.JULY, Month.AUGUST, Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER};
	public static Day[] days = {Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.THURSDAY, Day.FRIDAY, Day.SATURDAY, Day.SUNDAY};

	private int day;
	private Month month;
	private int year;
	private Day dayOfWeek;
	private boolean isLeapYear;

	public Date(int day, Month month, int year, Day dayOfWeek)
	{
		this.day = day;
		this.month = month;
		this.year = year;
		this.dayOfWeek = dayOfWeek;
		if (year % 4 == 0)
		{
			isLeapYear = true;
		}
	}

	public int getDay()
	{
		return this.day;
	}

	public Month getMonth()
	{
		return month;
	}

	public int getYear()
	{
		return this.year;
	}

	public Day getDayOfWeek()
	{
		return dayOfWeek;
	}

	public Date getNextDate()
	{
		int newDay = day + 1;
		int newMonth = month.getNumber();
		int newYear = year;
		int newDayOfWeek = dayOfWeek.getNumber() + 1;

		//Check new year
		if (month == Month.DECEMBER && day == Month.DECEMBER.getMaxDays())
		{
			newDay = 1;
			newMonth = 1;
			newYear++;
		}
		//Check new month
		else if (day >= month.getMaxDays())
		{
			if (!(isLeapYear && month == Month.FEBRUARY && day < 29))
			{
				newMonth++;
				newDay = 1;
			}
		}

		if (dayOfWeek.getNumber() >= 7)
		{
			newDayOfWeek = 1;
		}

		Date nextDate = new Date(newDay, months[newMonth - 1], newYear, days[newDayOfWeek - 1]);
		return nextDate;
	}

	@Override
	public String toString()
	{
		String temp = String.format("%s %s %d, %d", dayOfWeek.getName(), month.getName(), day, year);
		//System.out.println(temp);
		return temp;
	}
}
