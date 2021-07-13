package week3.forth;

public class Shirt {
    private String id;
    private String description;
    private String color;
    private String size;


    public Shirt(String id, String description, String color, String size) {
        this.id = id;
        this.description = description;
        this.color = color;
        this.size = size;
    }

    public Shirt(String str){
        String[] arr = str.split(",");
        this.id = arr[0].trim();
        this.description = arr[1].trim();
        this.color = arr[2].trim();
        this.size = arr[3].trim();
    }

    public static void main(String[] args) {
        String[] shirts = new String[11];
        shirts[0] = "S001,Black Polo Shirt,Black,XL";
        shirts[1] = "S002,Black Polo Shirt,Black,L";
        shirts[2] = "S003,Blue Polo Shirt,Blue,XL";
        shirts[3] = "S004,Blue Polo Shirt,Blue,M";
        shirts[4] = "S005,Tan Polo Shirt,Tan,XL";
        shirts[5] = "S006,Black T-Shirt,Black,XL";
        shirts[6] = "S007,White T-Shirt,White,XL";
        shirts[7] = "S008,White T-Shirt,White,L";
        shirts[8] = "S009,Green T-Shirt,Green,S";
        shirts[9] = "S010,Orange T-Shirt,Orange,S";
        shirts[10] = "S011,Maroon Polo Shirt,Maroon,S";

        Shirt[] shirtsObj = new Shirt[shirts.length];
        for(int i = 0; i < shirtsObj.length; i++)
            shirtsObj[i] = new Shirt(shirts[i]);

        for(int i = 0; i < shirtsObj.length; i++) {
            System.out.println(shirtsObj[i]);
            System.out.println();
        }
    }


    @Override
    public String toString() {
        return "Shirt{" + "\n" +
                "id = " + id + "\n" +
                "description = " + description + "\n" +
                "color = " + color + "\n" +
                "size = " + size + "\n" +
                '}';
    }
}
