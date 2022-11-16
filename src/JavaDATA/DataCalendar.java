package JavaDATA;


import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataCalendar {
    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        System.out.println(date);
        //Thread.sleep(1000);
        Date date1 =new Date();
        System.out.println(date1.getTime()-date.getTime());
        Calendar calendar =  Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(calendar.getTime());
        calendar.add(Calendar.WEEK_OF_MONTH,1);
        System.out.println(calendar.getTime());
        DateFormat dateFormat =DateFormat.getDateInstance(DateFormat.YEAR_FIELD);
        System.out.println(dateFormat.format(calendar.getTime()));

    }
}
