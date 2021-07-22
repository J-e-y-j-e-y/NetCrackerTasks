package week4.first;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Person {
    private Calendar BDAY = null;

    Person(Calendar BDAY){
        this.BDAY = BDAY;
    }

    public static void main(String[] args) {
        Calendar day = new GregorianCalendar();
        day.set(2017, Calendar.FEBRUARY, 12);
        Person p = new Person(day);
        System.out.println(p);
        System.out.println(p.formatDate(DatePattern.MID));
        System.out.println(p.formatDate(DatePattern.SHORT));
    }

    @Override
    public String toString() {
        return "Person{" +
                "BDAY=" + formatDate(DatePattern.FULL) +
                '}';
    }

    String formatDate(DatePattern pattern){
        SimpleDateFormat formatter = new SimpleDateFormat(pattern.format);
        return formatter.format(BDAY.getTime());
    }

    enum DatePattern{
        FULL("d MMMM y (EEEE)"),
        MID("dd.MM.y (E)"),
        SHORT("dd.MM.yy");

        private String format;

        DatePattern(String format){
            this.format = format;
        }
    }
}
