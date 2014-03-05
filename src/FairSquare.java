import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Iwan on 14.2.3.
 */
public class FairSquare {

    static char[] digits = "0123456789".toCharArray();

    static List<Long> fairSquares;

    public static void main(String[] args) {

        fairSquares = new LinkedList<Long>();

        generateFairSquares(10000);

        Collections.sort(fairSquares);

        System.out.println("List:");

        for (Long i : fairSquares) {
            System.out.format("%d\t\t\t%.0f%n", i, Math.sqrt(i));
        }




        //generateFairSquares(20);

        /*
        printAllFairSquares(1, 100000);
        :
        1       1
        4       2
        9       3
        121     11
        484     22
        10201   101
        12321   111
        14641   121
        40804   202
        44944   212
        */

        /*
        FileManager fm;

        fm = new FileManager(
                "D:\\Google2013\\C-small-practice.in",
                "D:\\Google2013\\C-small-practice.out");

        fm = new FileManager(
                "D:\\Google2013\\C-large-practice-1.in",
                "D:\\Google2013\\C-large-practice-1.out");

        int k = fm.getCases();

        System.out.println("Cases: " + k);

        for (int j = 1; j <= k; j++) {

            double[] bounds = fm.getDoubleVector();
            double min = bounds[0];
            double max = bounds[1];

            double i = min;

            int p = 0;

            System.out.println(min + " " + max + ": " + p);
            String answer = "Case #" + j + ": " + p;
            fm.sendLine(answer);

        }
        fm.finish();
        */
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
        long i  = Long.parseLong(s);
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
