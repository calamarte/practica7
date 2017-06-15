import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by calamarte on 13/06/2017.
 */
public class Util {
    //devuelve objeto tipo calendario a partir de string de fecha
    public static Calendar getCalendarDate(String s) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyy-MM-dd");
        Date date = df.parse(s);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    //devuelve formato de fecha
    public static String calendarToString(Calendar c){
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        return sdf.format(c.getTime());
    }
}
