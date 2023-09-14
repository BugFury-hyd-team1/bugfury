package com.project.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String formatToDefaultDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

   
}
