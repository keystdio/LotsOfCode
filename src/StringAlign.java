import java.util.*;
public class StringAlign {
    public static void main(String[] args) {
        String s = "tataag";
        String t = "tcatag";
        int[][] grid = new int[s.length() + 1][t.length() + 1];

        for(int i=0;i<s.length()+1;i++){
            grid[i][0] = 1 * i;
        }

        for(int i=0;i<t.length()+1;i++){
            grid[0][i] = 1 * i;
        }

        for(int i=1;i<s.length()+1;i++){
            for(int j=1;j<t.length()+1;j++){
                int[] options = new int[3];
                options[0] = grid[i][j-1] + 1;
                options[1] = grid[i-1][j] + 1;
                options[2] = grid[i-1][j-1] + ((s.charAt(i-1)==t.charAt(j-1))? (-2) : (1));

                grid[i][j] = options[findMin(options)];
            }
        }

        for(int i=0;i<s.length()+1;i++) {
            System.out.println(Arrays.toString(grid[i]));
        }

//        traceBack(grid,s,t);

    }

    private static int findMin(int[] options) {
        int minIdx=0;
        int minVal=options[0];
        for(int i=0;i<options.length;i++){
            if(minVal > options[i]) {
                minIdx = i;
                minVal = options[i];
            }
        }
        return minIdx;
    }
}
