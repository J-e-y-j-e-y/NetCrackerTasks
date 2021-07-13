package week3.fifth;

public class PhoneParser {
    private String countryCode;
    private String number;

    PhoneParser(){}

    public static void main(String[] args) {
        PhoneParser phoneParser = new PhoneParser();

        phoneParser.phoneFromStr("+79175655655");
        System.out.println(phoneParser);

        phoneParser.phoneFromStr("+104289652211");
        System.out.println(phoneParser);

        phoneParser.phoneFromStr("89175655655");
        System.out.println(phoneParser);

        phoneParser.phoneFromStr("+3790175655655"); // номер: 12 цифр, (379) - код Ватикана
        System.out.println(phoneParser);

        phoneParser.phoneFromStr("+1289652211"); // ошибочный номер: 10 цифр
        System.out.println(phoneParser);

        phoneParser.phoneFromStr("69175655655"); // ошибочный номер: должен начинаться с 8 или иметь '+'
        System.out.println(phoneParser);

    }

    public void phoneFromStr(String phone){
        countryCode = null;
        number = null;
        if(phone.startsWith("+") && phone.length() >= 12 && phone.length() <= 15){
            countryCode = phone.substring(1, phone.length()-10);
            number = phone.substring(phone.length()-10);
        }else if(phone.startsWith("8") && phone.length() == 11){
            countryCode = "7";
            number = phone.substring(1);
        }
    }


    @Override
    public String toString() {
        if(countryCode == null || number == null)
            return "wrong number";
        String phone = "+" + countryCode;
        phone += "(" + number.substring(0, 3) + ")";
        phone +=  "-" + number.substring(3, 6);
        phone +=  "-" + number.substring(6, 10);
        return phone;
    }
}
