package week4.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateGenerator {
    private Calendar dateCalender;
    private Date date;

    public static void main(String[] args) throws IOException {
        DateGenerator generator = new DateGenerator();
        generator.readData();
        System.out.println(generator);
    }

    public void readData() throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите дату в формате: год месяц число(разделяются пробелами) *месяц[1 - Январь ... 12 - Декабрь]");
        String[] s = buf.readLine().split(" ");
        if(s.length != 3)
            throw new IllegalArgumentException();
        int year = Integer.parseInt(s[0]);
        int month = Integer.parseInt(s[1]);
        int day = Integer.parseInt(s[2]);

        System.out.println("Введите время в формате: часы:минуты (часы в формате 24)");
        s = buf.readLine().split(":");
        if(s.length != 2)
            throw new IllegalArgumentException();
        int hours = Integer.parseInt(s[0]);
        int mins = Integer.parseInt(s[1]);

        dateCalender = new GregorianCalendar();
        dateCalender.set(year, month-1, day, hours, mins);

        date = new Date(year-1900, month-1, day, hours, mins);
    }


    @Override
    public String toString() {
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return "Calender = " + formatter.format(dateCalender.getTime()) + "\n" +
         "Date = " + formatter.format(date);
    }
}
