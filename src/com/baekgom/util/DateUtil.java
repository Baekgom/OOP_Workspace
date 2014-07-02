package com.baekgom.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateUtil {

	public static String getCurrentTime() {

		Calendar calendar = Calendar.getInstance(Locale.KOREAN);
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd hh:mm");

		return sdf.format(calendar.getTime());
	}

}
