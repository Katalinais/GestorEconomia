package Utilities;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Utilities {
    public static LocalDate dateToLocalDate(Date date){
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }
}
