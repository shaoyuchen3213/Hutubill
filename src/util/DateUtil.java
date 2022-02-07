package util;

import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class DateUtil {
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	static long millisecondsOfOneDay= 1000*60*60*24;
	public static java.sql.Date util2sql(java.util.Date d){
		return new java.sql.Date(d.getTime());
	}

	
	public static java.util.Date strToUtilDate(String str){
		try{
			return simpleDateFormat.parse(str);
			
		}catch (ParseException  e) {
			e.printStackTrace();
		}
		return null;
	}
	

/*
 * get local time, and set all time to zero. Use data interface to get the local time
 */
	
	public static Date today() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	
	public static Date monthBegin() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DATE, 1);
		
		c.set(Calendar.HOUR_OF_DAY,0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		
		return c.getTime();
	}
	
/*
 * Get the end of the Month
 * @return
 */
	public static Date monthEnd() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		
		c.set(Calendar.DATE, 1);
		c.add(Calendar.MONTH, 1);
		c.add(Calendar.DATE, -1);
		return c.getTime();
	}
	/*
	 * get the month of the day
	 * @return
	 */
	
	public static int thisMonthTotalDay() {
		
		long lastDayMilliSeconds = monthEnd().getTime();
		long firstDatMilliSeconds = monthBegin().getTime();


		return (int) ((lastDayMilliSeconds - firstDatMilliSeconds) / millisecondsOfOneDay) + 1;
	}
	
	/*
	 * Get remaining day for this month
	 * @return
	 */
	
	public static int thisMonthLeftDay() {
		long lastDayMilliSeconds = monthEnd().getTime();
		long toDayMilliSeconds = today().getTime();
		
		return (int) ((lastDayMilliSeconds - toDayMilliSeconds) / millisecondsOfOneDay)+1;
		
	}
	
	public static void main(String[] args) {
		System.out.println(DateUtil.monthEnd());

	}
}
