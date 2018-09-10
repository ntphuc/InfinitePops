package com.totalawesome.infinitepops.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {

    public static String convertLongToDate(long mil) {
        Date date = new Date(mil);
        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy, HH:mm:ss");
        String dateText = df2.format(date);
        return dateText;
    }
}
