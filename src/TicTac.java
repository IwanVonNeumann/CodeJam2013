
/**
 * Created by Iwan on 14.2.3.
 */
public class TicTac {

    public static void main(String[] args) {

        FileManager fm = new FileManager(
                "D:\\Google2013\\A-small-practice.in",
                "D:\\Google2013\\A-small-practice.out");

        FileManager fm2 = new FileManager(
                "D:\\Google2013\\A-large-practice.in",
                "D:\\Google2013\\A-large-practice.out");

        int k = fm.getCases();

        System.out.println("k = " + k);

        for (int i = 1; i <= k; i++) {
            char[][] G = fm.getCharMatrix(4, 4);
            fm.passLine();
            System.out.println("Case #" + i);
            fm.printMatrix(G);
            String result;
            if (win(G, 'X')) result = "X won";
            else if (win(G, 'O')) result = "O won";
            else if (notFinished(G)) result = "Game has not completed";
            else result = "Draw";
            System.out.println(result);
            String answerLine = "Case #" + i + ": " + result;
            System.out.println(answerLine);
            fm.sendLine(answerLine);
            System.out.println();
        }
        fm.finish();

    }

    public static boolean horizontalWin(char[][] G, char x) {
        for (int i = 0; i < 4; i++) {
            boolean w = true;
            for (int j = 0; j < 4; j++) {
                w &= (G[i][j] == x) | (G[i][j] == 'T');
            }
            if (w) return true;
        }
        return false;
    }

    public static boolean verticalWin(char[][] G, char x) {
        for (int i = 0; i < 4; i++) {
            boolean w = true;
            for (int j = 0; j < 4; j++) {
                w &= (G[j][i] == x) | (G[j][i] == 'T');
            }
            if (w) return true;
        }
        return false;
    }

    public static boolean diagonalWin(char[][] G, char x) {
        boolean L = true;
        boolean R = true;
        for (int i = 0; i < 4; i++) {
            L &= (G[i][i] == x) | (G[i][i] == 'T');
            R &= (G[3 - i][i] == x) | (G[3 - i][i] == 'T');
        }
        return L | R;
    }

    public static boolean win(char[][] G, char x) {
        return horizontalWin(G, x) | verticalWin(G, x) | diagonalWin(G, x);
    }

    public static boolean notFinished(char[][] G) {
        boolean t = true; // taken
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                t &= (G[i][j] != '.');
                if (!t) return true;
            }
        }
        return false;
    }



}
