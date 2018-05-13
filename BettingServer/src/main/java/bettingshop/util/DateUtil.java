package bettingshop.util;

import java.sql.Date;
import java.util.Calendar;

public final class DateUtil {

	public static Date getCurrDate() {
		Date sqlDate = new Date(Calendar.getInstance().getTime().getTime());
		return sqlDate;
	}

}
