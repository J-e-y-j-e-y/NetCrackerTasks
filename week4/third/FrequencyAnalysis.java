package week4.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FrequencyAnalysis {
    private HashSet<Character> first = new HashSet<>();
    private HashSet<Character> second = new HashSet<>();

    public static void main(String[] args) throws IOException {
        FrequencyAnalysis freq = new FrequencyAnalysis();
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите первую строку:");
        String s1 = buf.readLine();
        System.out.println("Введите вторую строку:");
        String s2 = buf.readLine();

        freq.processStrings(s1, s2);
        Set<Character> ss1 = freq.firstAndSecond(Option.ASC);
        Set<Character> ss2 = freq.firstMinusSecond(Option.DESC);
        Set<Character> ss3 = freq.firstOrSecond(Option.HASH);

        Iterator<Character> it1 = ss1.iterator();
        while (it1.hasNext())
            System.out.print(it1.next() + " ");
        System.out.println();

        Iterator<Character> it2 = ss2.iterator();
        while (it2.hasNext())
            System.out.print(it2.next() + " ");
        System.out.println();

        Iterator<Character> it3 = ss3.iterator();
        while (it3.hasNext())
            System.out.print(it3.next() + " ");
        System.out.println();
    }

    public void processStrings(String s1, String s2){
        for(int i = 0; i < s1.length(); i++)
            first.add(s1.charAt(i));
        for(int i = 0; i < s2.length(); i++)
            second.add(s2.charAt(i));
    }



    Set<Character> firstAndSecond(Option option) throws IOException {
        HashSet<Character> res = new HashSet<>(first);
        res.retainAll(second);
        return formatSet(res, option);
    }

    Set<Character> firstMinusSecond(Option option) throws IOException {
        HashSet<Character> res = new HashSet<>(first);
        res.removeAll(second);
        return formatSet(res, option);
    }

    Set<Character> firstOrSecond(Option option) throws IOException {
        HashSet<Character> res = new HashSet<>(first);
        res.addAll(second);
        return formatSet(res, option);
    }

    enum Option{
        ASC,
        DESC,
        HASH
    }

    Set<Character> formatSet(HashSet<Character> set, Option option) throws IOException {
        switch (option) {
            case ASC:
                return new TreeSet<>(set);
            case DESC:
                return new TreeSet<>(set).descendingSet();
            case HASH:
                System.out.print("Введите величину циклического сдвига: n = ");
                BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
                int n = Integer.parseInt(buf.readLine());
                TreeSet<Character> sortedSet = new TreeSet<>(new Comparator<Character>() {
                    @Override
                    public int compare(Character o1, Character o2) {
                        System.out.println(o1 +  " hash<" + o1.hashCode() + ">  " + "  shift-> " + shiftLeft(o1.hashCode(), n));
                        System.out.println(o2 +  " hash<" + o2.hashCode() + ">  " + "  shift-> " + shiftLeft(o2.hashCode(), n));
                        return shiftLeft(o1.hashCode(), n) - shiftLeft(o2.hashCode(), n);
                    }
                });
                sortedSet.addAll(set);
                return sortedSet;
        }
        return null;
    }

    public static int shiftLeft(int num, int shift) {
        int count = 0;
        int num2 = num;
        while(num2 > 0){
            count++;
            num2 >>= 1;
        }
        int[] a = new int[count];
        for(int i = 0; i < count; i++){
            a[i] = num % 2;
            num >>= 1;
        }

        int[] b = new int[count];
        // шаг 1
        System.arraycopy(a, shift, b, 0, count - shift);
        // шаг 2
        System.arraycopy(a, 0, b, count - shift, shift);

        int res = 0;
        for(int i = 0; i < count; i++) {
            res += b[i] * Math.pow(2, i);
        }
        return res;
    }
}
