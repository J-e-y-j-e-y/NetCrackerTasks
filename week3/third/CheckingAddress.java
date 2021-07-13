package week3.third;

public class CheckingAddress {
    public static void main(String[] args) {
        Address address = new Address();

        String str1 = "РФ , Самарская обл., г. Самара, ул. 40 лет Победы, 24, 2к1, 123";
        String str11 = "Италия, Ломбардия, Милан, Соборная площадь, 13, , 1";
        String str111 = "Великобритания, Кембриджшир ,  Кембридж ,  Трампингтон  ,  1, 1, 155";

        String str2 = "РФ, Самарская область; Самара. 40 лет Победы, 24; 2к1 - 123";
        String str22 = "Италия - Ломбардия; Милан, Соборная площадь. 13. - 1";
        String str222 = "Великобритания- Кембриджшир. Кембридж , Трампингтон; 1; 1. 155";


        address.fromStrSplit(str1);
        System.out.println(address);
        System.out.println();
        address.fromStrSplit(str11);
        System.out.println(address);
        System.out.println();
        address.fromStrSplit(str111);
        System.out.println(address);
        System.out.println();

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");

        address.fromStrToken(str2);
        System.out.println(address);
        System.out.println();
        address.fromStrToken(str22);
        System.out.println(address);
        System.out.println();
        address.fromStrToken(str222);
        System.out.println(address);
    }
}
