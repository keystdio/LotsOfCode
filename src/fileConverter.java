/**
 * Created by kuangyou on 2/24/15.
 */

import java.util.*;
import java.io.*;
public class fileConverter {
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(new File("training.txt"));
        while(input.hasNextLine()) {
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);

            while(lineScan.hasNext()) {
                String p1 = lineScan.next();
                String after1 = process(p1);
                String p2 = lineScan.next();

                String last = after1 + p2;
                System.out.println(last);
            }
        }
    }

    public static String process(String s) {
        String result = "";
        for(int i=0; i<s.length(); i++){
            result = (result + s.charAt(i) + ", ");
        }
        return result;
    }
}
