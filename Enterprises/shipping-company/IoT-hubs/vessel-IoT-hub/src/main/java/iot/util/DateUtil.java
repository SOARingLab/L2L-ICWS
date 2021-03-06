package iot.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     * return ms
     *
     * @param left
     * @param right
     * @return
     * @throws ParseException
     */
    public static long TimeMinus(String left, String right) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        try {
            Date d1 = sdf.parse(left);
            Date d2 = sdf.parse(right);
            return d1.getTime() - d2.getTime();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return 0;
    }


    /**
     * 时间戳转日期
     *
     * @param ms
     * @return
     */
    public static Date transForDate(Long ms) {
        if (ms == null) {
            ms = 0L;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date temp = null;
        if (ms != null) {
            try {
                String str = sdf.format(ms);
                temp = sdf.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return temp;
    }

    /**
     * String to Date
     *
     * @param dateStr
     * @return
     */
    public static Date str2date(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = sdf.parse(dateStr);
            return date;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static String date2str(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        sdf.setTimeZone(TimeZone.getTimeZone("Shanghai"));
        if (date != null) {
            return sdf.format(date);
        }
        return null;
    }

    public static String ms2dateStr(long ms){
        String dateStr = null;
        dateStr = date2str(transForDate(ms));
        return dateStr;
    }

    public static long translate2simuMs(long startMs , long curMs , long zoomInVal){
        return  (curMs-startMs)*zoomInVal + startMs;
    }
    public static String translate2simuDateStr(String startStr , long curMs , long zoomInVal){
        long startMs = str2date(startStr).getTime();
        return  ms2dateStr((curMs-startMs)*zoomInVal + startMs);
    }
}
