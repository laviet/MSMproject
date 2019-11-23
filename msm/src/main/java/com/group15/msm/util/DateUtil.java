package com.group15.msm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 22-11-2019
 * Time: 21:22
 */
public class DateUtil {
public static String convertDate(Date date){
    SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
    return dateFormat.format(date);
}

}
