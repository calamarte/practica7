import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by calamarte on 13/06/2017.
 */
public class Util {
    public static Calendar getCalendarDate(String s) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyy-MM-dd");
        Date date = (Date) df.parse(s);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public static String calendarToString(Calendar c){
        Calendar cal = c;
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        return sdf.format(c.getTime());
    }
}
