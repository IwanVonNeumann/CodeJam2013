/**
 * Created by Iwan on 14.2.3.
 */
public class FairSquare {

    public static void main(String[] args) {

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

            while (Math.abs(max + 1 - i) > 1E-10) {
                boolean c;
                c = isPalindrome(i);
                if (!c) {
                    i++;
                    continue;
                }
                c = isSquare(i);
                if (!c) {
                    i++;
                    continue;
                }
                c = isPalindrome(Math.sqrt(i));
                if (!c) {
                    i++;
                    continue;
                }
                i++;
                p++;
            }
            System.out.println(min + " " + max + ": " + p);
            String answer = "Case #" + j + ": " + p;
            fm.sendLine(answer);
            
        }
        fm.finish();

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
