package stu.xuronghao.ledger.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DatetimeHandler {
    public static String getCurrentDatetime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        TimeZone zone = TimeZone.getTimeZone("GMT+8:00");
        dateFormat.setTimeZone(zone);

        return dateFormat.format(new Date());
    }
}
