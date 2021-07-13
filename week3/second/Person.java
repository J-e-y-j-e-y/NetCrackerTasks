package week3.second;

public class Person {
    private String surname;
    private String name;
    private String fathername;

    public Person(String surname, String name, String fathername) {
        this.surname = surname;
        this.name = name;
        this.fathername = fathername;
    }

    public static void main(String[] args) {
        Person p1 = new Person("Иванов", "Иван", "Иванович");
        Person p2 = new Person("Иванов", null, null);
        Person p3 = new Person("Иванов", "Иван", null);
        Person p4 = new Person("Иванов", "Иван", "");
        Person p5 = new Person("Иванов", null, "Иванович");
        Person p6 = new Person("Иванов", "", "Иванович");
        Person p7 = new Person("Иванов", "", "");
        Person p8 = new Person("", "Иван", "");
        Person p9 = new Person(null, null, "Иванович");

        System.out.println(p1.getShortName());
        System.out.println(p2.getShortName());
        System.out.println(p3.getShortName());
        System.out.println(p4.getShortName());
        System.out.println(p5.getShortName());
        System.out.println(p6.getShortName());
        System.out.println(p7.getShortName());
        System.out.println(p8.getShortName());
        System.out.println(p9.getShortName());
    }

    public String getShortName(){
        if(surname == null || surname.equals(""))
            return "no name";

        String res = surname;
        if(name == null || name.equals(""))
            return res;
        res += " " + name.substring(0, 1).toUpperCase() + ".";

        if(fathername == null || fathername.equals(""))
            return res;
        res += fathername.substring(0, 1).toUpperCase() + ".";
        return res;
    }
}
