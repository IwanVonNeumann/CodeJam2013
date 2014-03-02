import java.io.*;

/**
 * Created by Iwan on 14.2.3.
 */
public class FileManager {

    private BufferedReader br;
    private PrintWriter pw;

    private int cases;

    public FileManager(String input, String output) {

        try {
            File in = new File(input);
            File out = new File(output);

            br = new BufferedReader(new FileReader(in));
            pw = new PrintWriter(out);

            cases = Integer.parseInt(br.readLine());

        } catch (FileNotFoundException e) {
            System.out.println("File not found ex in constructor...");
        } catch (IOException e) {
            System.out.println("IO ex in constructor...");
        }

    }

    public int getCases() {
        return cases;
    }

    public String getLine() {
        String line = "";
        try {
            line = br.readLine();
        } catch (IOException e) {
            System.out.println("IO ex while reading form file...");
        }
        return line;
    }

    public void passLine() {
        try {
            br.readLine();
        } catch (IOException e) {
            System.out.println("IO ex while reading form file...");
        }
    }

    public char[][] getCharMatrix(int x, int y) {
        char[][] M = new char[x][];
        try {
            for (int i = 0; i < x; i++) {
                M[i] = br.readLine().toCharArray();
            }
        } catch (IOException e) {
            System.out.println("IO ex while reading char matrix...");
        }
        return M;
    }

    public int[] getIntVector()
    {
        String[] s = getLine().split(" ");
        int k = s.length;
        int[] v = new int[k];
        for (int i = 0; i < k; i++) {
            v[i] = Integer.parseInt(s[i].trim());
        }
        return v;
    }

    public double[] getDoubleVector()
    {
        String[] s = getLine().split(" ");
        int k = s.length;
        double[] v = new double[k];
        for (int i = 0; i < k; i++) {
            v[i] = Double.parseDouble(s[i].trim());
        }
        return v;
    }

    public int[][] getIntMatrix(int x, int y) {
        int[][] M = new int[x][];
        for (int i = 0; i < x; i++) {
            M[i] = getIntVector();
        }
        return M;
    }

    public void sendLine(String line) {
        pw.print(line);
        pw.print("\n");
    }

    public void finish() {
        try {
            br.close();
            pw.close();
        } catch (IOException e) {
            System.out.println("IO ex during finalization...");
        }
    }

    public void printVector(char[] v) {
        for (int i : v) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void printVector(int[] v) {
        for (int i : v) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void printMatrix(char[][] M) {
        int n = M.length;
        for (char[] v : M) {
            printVector(v);
        }
        System.out.println();
    }

    public void printMatrix(int[][] M) {
        int n = M.length;
        for (int[] v : M) {
            printVector(v);
        }
        System.out.println();
    }

}
