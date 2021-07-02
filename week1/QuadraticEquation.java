package week1;

public class QuadraticEquation {
    private double a, b, c;
    private class Discriminant{
        double getDiscriminant(){
            return Math.pow(b, 2) - 4*a*c;
        }
    }

    QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static void main(String[] args) {
        QuadraticEquation qua1 = new QuadraticEquation(4, 4, 1);
        qua1.solveEquation();

        System.out.println();
        QuadraticEquation qua2 = new QuadraticEquation(1, 4, 1);
        qua2.solveEquation();

        System.out.println();
        QuadraticEquation qua3 = new QuadraticEquation(4, 4, 5);
        qua3.solveEquation();
    }

    void solveEquation(){
        Discriminant d = new Discriminant();
        double D = d.getDiscriminant();
        if(D > 0){
            System.out.println("Уравнение имеет два корня:");
            double x1 = (Math.pow(b, 2) - Math.sqrt(D)) / (2*a);
            double x2 = (Math.pow(b, 2) + Math.sqrt(D)) / (2*a);
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }else if(D == 0){
            System.out.println("Уравнение имеет один корень:");
            double x = -b / (2*a);
            System.out.println("x = " + x);
        }else{
            System.out.println("Нет корней");
        }
    }
}
