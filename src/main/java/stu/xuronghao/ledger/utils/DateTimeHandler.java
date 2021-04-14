package stu.xuronghao.ledger.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeHandler {
    public static String getCurrentDatetime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(ConstantVariable.DATE_FORMAT);

        TimeZone zone = TimeZone.getTimeZone(ConstantVariable.TIME_ZONE);
        dateFormat.setTimeZone(zone);

        return dateFormat.format(new Date());
    }

    public static String getDate(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat(ConstantVariable.DATE_FORMAT);
        return dateFormat.format(date);
    }


    private DateTimeHandler() {
    }
}
