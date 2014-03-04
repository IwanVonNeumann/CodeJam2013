import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Iwan on 14.2.3.
 */
public class FairSquare {

    static int k = 0;
    static char[] digits = "0123456789".toCharArray();

    static List<Double> fairSquares;

    public static void main(String[] args) {

        String[] n = new String[9];

        for (int i = 0; i < 9; i++) {
            n[i] = "" + digits[i + 1];
        }

        fairSquares = new LinkedList<Double>();

        for (String s : n) {
            //System.out.println(s);
            k++;
            check(s);
            append(s, 1);
        }

        System.out.println("k = " + k);

        Collections.sort(fairSquares);

        System.out.println("List:");

        for (Double d : fairSquares) {
            System.out.println(d);
        }

        //generateNumbers(1, 1050);
        //printAllFairSquares(1, 100000);

        generateFairSquares(1, 20);
        /*
        1
        4
        9
        121
        484
        10201
        12321
        14641
        40804
        44944
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

    public static void generateNumbers(double min, double max) {
        double i = min;

        while ((Math.abs(max + 1 - i)) > 1E-10) {
            String s = doubleToString(i);
            System.out.println(s);
            i++;
        }
    }

    public static void generateFairSquares(double min, double max) {
        double i = min;
        String x;
        String r;
        while ((Math.abs(max + 1 - i)) > 1E-10) {
            String s = doubleToString(i);
            r = reverse(s);
            x = s + r;
            System.out.println(x);
            for (char c : digits) {
                x = s + c + r;
                System.out.println(x);
            }
            i++;
        }
    }


    public static void printAllFairSquares(double min, double max) {
        double i = min;
        double j = i;

        while ((Math.abs(max + 1 - j)) > 1E-10) {
            i = j;
            j++;
            if (!isPalindrome(i)) {
                continue;
            }
            if (!isSquare(i)) {
                continue;
            }
            String s = doubleToString(Math.sqrt(i));
            if (!isPalindrome(s)) {
                continue;
            }
            System.out.println(doubleToString(i));

        }
    }

    public static void append(String s, int lvl) {
        String[] S = new String[10];
        String x;
        String r;
        for (int i = 0; i < 10; i++) {
            S[i] = s + digits[i];
            //System.out.println(S[i]);
            k++;
            r = reverse(S[i]);
            x = S[i] + r;
            check(x);
            for (int j = 0; j < 10; j++) {
                x = S[i] + digits[j] + r;
                check(x);
            }
        }
        lvl++;
        if (lvl < 4) {
            for (String y : S) {
                append(y, lvl);
            }
        }
    }

    public static void check(String s) {
        if (squareIsPalindrome(s)) {
            double x = Double.parseDouble(s);
            double x2 = x * x;
            fairSquares.add(x2);
            //System.out.print(s + "\t" + doubleToString(x2) + "\n");
        }
    }

    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static boolean squareIsPalindrome(String s) {
        double x = Double.parseDouble(s);
        //System.out.println(x);
        double x2 = x * x;
        //System.out.println(x2);
        String i = doubleToString(x2);
        //System.out.println(i);
        boolean p = isPalindrome(i);
        //System.out.println(p);
        return p;
    }

    public static boolean isPalindrome(double d) {
        String s = doubleToString(d);
        return isPalindrome(s);
    }

    public static boolean isPalindrome(String s) {
        int n = s.length();
        int k = n / 2;
        boolean p = true;
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

    public static boolean isSquare(double d) {
        double r = Math.floor(Math.sqrt(d));
        return Math.abs(d - r * r) < 1E-10;
    }

    public static String doubleToString(double d) {
        String s = Double.toString(d);
        String p = s.substring(0, s.length() - 2);
        return p;
    }
}
