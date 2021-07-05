package week2.third;

public class ExtendedClass {
    private byte b;
    private int i;
    private double d;
    private String s;


    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) return true;
        if (anObject == null || getClass() != anObject.getClass()) return false;

        ExtendedClass that = (ExtendedClass) anObject;

        if (b != that.b) return false;
        if (i != that.i) return false;
        if (Double.compare(that.d, d) != 0) return false;
        return s != null ? s.equals(that.s) : that.s == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) b;
        result = 31 * result + i;
        temp = Double.doubleToLongBits(d);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (s != null ? s.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ExtendedClass{" +
                "b=" + b +
                ", i=" + i +
                ", d=" + d +
                ", s='" + s + '\'' +
                '}';
    }
}
