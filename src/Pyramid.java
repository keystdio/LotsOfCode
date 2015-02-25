import java.util.*;
import java.io.*;
/**
 * Created by kuangyou on 2/22/15.
 */
public class Pyramid {
    public static final int size = 100;

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("pyramid.txt"));
        int[][] a = new int[size][size];
        int[][] opt = new int[size][size];

        read(a, input);

        DPsolve(a,opt);

        traceBack(a, opt);

    }

    public static void traceBack(int[][] a, int[][] opt) {
        int m = 0;
        int n = 0;

        int sum = opt[0][0];
        System.out.print("The path is: " + a[m][n]);
        while(m < size-1) {
            sum -= a[m][n];
            if(sum == opt[m+1][n]) {
                System.out.print(" -> " + a[m+1][n]);
                m = m+1;
            } else if(sum == opt[m+1][n+1]) {
                System.out.print(" -> " + a[m+1][n+1]);
                m = m+1;
                n = n+1;
            }
        }
    }

    public static void DPsolve(int[][] a, int[][] opt) {
        for(int i=0;i<size;i++) {
            opt[size-1][i] = a[size-1][i];
        }

        for(int row=size-2; row>=0; row--) {
            for(int col=0; col<=row; col++) {
                opt[row][col] = a[row][col] + Math.max(opt[row+1][col], opt[row+1][col+1]);
            }
        }

        System.out.println("Max path sum is: " + opt[0][0]);
    }

    public static void read(int[][] a, Scanner input) {
        int row = 0;
        while(input.hasNextLine()) {
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);
            int col = 0;
            while(lineScan.hasNextInt()) {
                int curr = lineScan.nextInt();
                a[row][col] = curr;
                col++;
            }
            row++;
        }
    }

}
