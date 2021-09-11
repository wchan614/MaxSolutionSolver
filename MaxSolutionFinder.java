import java.util.*;
import java.io.*;

public class MaxSolutionFinder {
    public static void main(String args[]) throws Exception
    {
        // Get the number of tests we're doing
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(br.readLine());

        // Loop through each line and get the 3 numbers
        for (int i = 0; i < lines; i++) {
            int[] xyz = {0,0,0};

            // Getting the 3 intergers
            String[] strs = br.readLine().trim().split("\\s+");
            for (int j = 0; j < strs.length; j++) {
                xyz[j] = Integer.parseInt(strs[j]);
            }

            // Must have at least a pair or we print NO
            if (!preliminaryCheck(xyz[0],xyz[1],xyz[2])) {
                System.out.println("NO");
            }
            else {
                int[] abc = solve(xyz[0],xyz[1],xyz[2]);
                //print out
                System.out.println("YES \n a = " + abc[0] + " /" + " b = " + abc[1] + " /" + " c = " + abc[2]); 
            }
        }
    }

    // There must be at least 1 pair for a solution to exist
    public static Boolean preliminaryCheck(int x, int y, int z) {
        return (x == y || x == z || y == z);
    }

    
    public static int[] solve(int x, int y, int z) {
        // Set the values to whatever and solve any conflicts if it arrises.
        int a = x, b = y, c = z;

        if (Math.max(a,b) == x) {
            // Good
        }
        else {
            if (Math.max(a,c) == x) {
                // Swap b with c
                b = z;
                c = y;
            }
            else {
                // set b to a
                b = x;
            }
        }
        if (Math.max(b,c) == y) {
            // Good
        }
        else {
            if (Math.max(b,a) == y) {
                // Swap c with a
                c = x;
                a = z;
            }
            else {
                // set c to y;
                c = y;
            }
        }
        if (Math.max(a,c) == z) {
            // Good
        }
        else {
            if (Math.max(a,c) == z) {
                // Swap c with b
                c = y;
                b = z;
            }
            else {
                // set b to y;
                b = y;
            }
        }

        // return the a,b,c
        return new int[]{a,b,c};
    }

}