/**
 * Created by Iwan on 14.2.3.
 */
public class LawnMower {

    public static void main(String[] args) {

        FileManager fm;

        fm = new FileManager(
                "D:\\Google2013\\B-small-practice.in",
                "D:\\Google2013\\B-small-practice.out");

        fm = new FileManager(
                "D:\\Google2013\\B-large-practice.in",
                "D:\\Google2013\\B-large-practice.out");

        int k = fm.getCases();

        System.out.println("Cases: " + k);

        for (int c = 1; c <= k; c++) {

            int[] d = fm.getIntVector();
            int[][] F = fm.getIntMatrix(d[0], d[1]);

            String result = validField(F, d[0], d[1]) ? "YES" : "NO";
            String answer = "Case #" + c + ": " + result;

            System.out.println(answer);
            fm.printVector(d);
            fm.printMatrix(F);

            fm.sendLine(answer);
        }
        fm.finish();
    }

    public static boolean clearVertical(int[][] F, int x, int y) {
        int p = F[x][y];
        int n = F.length;
        boolean s; // = true;
        for (int i = 0; i < n; i++) {
            s = F[i][y] <= p; // s &= F[i][y] <= p;
            if (s == false) return false;
        }
        return true;
    }

    public static boolean clearHorizontal(int[][] F, int x, int y) {
        int p = F[x][y];
        int n = F[0].length;
        boolean s; // = true;
        for (int i = 0; i < n; i++) {
            s = F[x][i] <= p;// s &= F[x][i] <= p;
            if (s == false) return false;
        }
        return true;
    }

    public static boolean clearSquare(int[][] F, int x, int y) {
        return clearVertical(F, x, y) | clearHorizontal(F, x, y);
    }

    public static boolean validField(int[][] F, int n, int m) {
        boolean c = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c &= clearSquare(F, i, j);
                if (!c) {
                    System.out.format("Fail at [%d, %d]\n", i, j);
                    return false;
                }
            }
        }
        return true;
    }
}
