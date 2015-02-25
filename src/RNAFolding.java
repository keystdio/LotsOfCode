/**
 * Created by kuangyou on 2/23/15.
 */
import java.util.*;
public class RNAFolding {
    public static final String RNA = "GGGAAAACCCAAAGGGGUUU";

    public static void main(String[] args) {
        int n = RNA.length();
        int[][] opt = new int[n][n];

        for(int k=5;k<n;k++) {
            for(int i=0; i<n-k;i++) {
                int j = i + k;
                if (i >= j - 4) {
                    opt[i][j] = 0;
                } else {
                    opt[i][j] = Math.max(opt[i][j - 1], findMax(i, j, opt));
                }
            }
        }
        for (int i = 0; i < opt.length; i++) {
            System.out.println(Arrays.toString(opt[i]));
        }
    }

    public static int findMax(int i, int j, int[][] opt) {
        int t = i;
        int max = -99;
        int curr = 0;
        while (t < j-4) {
            if(t-1<0) {
                curr = 0;
            } else {
                if(isMatch(RNA.charAt(t), RNA.charAt(j)) && t<j-4) {
                    curr = 1 + opt[i][t - 1] + opt[t + 1][j - 1];
                } else {
                    curr = 0;
                }
            }
            max = Math.max(curr, max);
            t++;
        }
        return max;
    }

    private static boolean isMatch(char a, char b) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('A', 'U');
        map.put('U', 'A');
        map.put('G', 'C');
        map.put('C', 'G');
        return map.get(a) == b;

    }
}