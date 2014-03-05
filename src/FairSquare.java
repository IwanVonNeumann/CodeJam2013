import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Iwan on 14.2.3.
 */
public class FairSquare {

    static char[] digits = "0123456789".toCharArray();

    static List<Long> fairSquares;

    public static void main(String[] args) {

        generateList(10000000);

        FileManager fm;

        /*fm = new FileManager(
                "D:\\Google2013\\C-small-practice.in",
                "D:\\Google2013\\C-small-practice.out");*/


        /*
        fm = new FileManager(
                "D:\\Google2013\\C-large-practice-1.in",
                "D:\\Google2013\\C-large-practice-1.out");


        int k = fm.getCases();

        System.out.println("Cases: " + k);

        for (int j = 1; j <= k; j++) {

            long[] bounds = fm.getLongVector();
            long min = bounds[0];
            long max = bounds[1];

            Iterator x = fairSquares.listIterator(0);

            int p = 0;

            Long i = Long.valueOf(0);

            while (x.hasNext()) {
                i = (Long) x.next();
                //System.out.println(i);
                if (i >= min) {
                    p++;
                    break;
                }
            }

            if (i > max) {
                p--;
            } else

            while (x.hasNext()) {
                i = (Long) x.next();
                p++;
                //System.out.println(i);
                if (i > max) {
                    p--;
                    break;
                }
            }


            System.out.println(min + " " + max + ": " + p);
            String answer = "Case #" + j + ": " + p;
            System.out.println(answer);
            fm.sendLine(answer);

        }
        fm.finish();
        */
    }

    public static void generateList(long max) {
        fairSquares = new LinkedList<Long>();

        generateFairSquares(max);

        Collections.sort(fairSquares);

        System.out.println("List:");

        for (Long i : fairSquares) {
            System.out.format("%d\t\t\t%.0f%n", i, Math.sqrt(i));
        }
    }

    public static void generateFairSquares(long max) {
        for (int j = 1; j <= 9; j++) {
            //System.out.println(j);
            check(j);
        }
        String x;
        String r;
        for (long i = 1; i <= max; i++) {
            String s = Long.toString(i);
            //System.out.println(s);
            r = reverse(s);
            x = s + r;
            check(x);
            for (char c : digits) {
                x = s + c + r;
                check(x);
            }
        }
    }

    public static void check(String s) {
        long i = Long.parseLong(s);
        check(i);
    }

    public static void check(long d) {
        long x = d * d;
        //System.out.format("%.0f\t\t\t%.0f%n", d, x);
        if (isPalindrome(x)) {
            fairSquares.add(x);
        }
    }

    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static boolean isPalindrome(long i) {
        String s = Long.toString(i);
        return isPalindrome(s);
    }

    public static boolean isPalindrome(String s) {
        int n = s.length();
        int k = n / 2;
        boolean p;// = true;
        for (int i = 0; i < k; i++) {
            /*System.out.println("Step " + i);
            System.out.println("Comparing " + s.charAt(i) + " and " +
                s.charAt(n - i - 1));*/
            p = s.charAt(i) == s.charAt(n - i - 1);
            /*System.out.println("Result: " + p);*/
            if (!p) return false;
        }
        return true;
    }

}
