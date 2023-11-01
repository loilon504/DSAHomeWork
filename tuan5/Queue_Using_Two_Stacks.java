import java.io.*;
import java.util.*;

public class Solution {

    public static int[] st;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int q = input.nextInt();
        st = new int[q + 5];
        int l = 1, r = 0;
        for (int test = 1; test <= q; test++) {
            int type = input.nextInt();
            int x;
            if (type == 1) {
                x = input.nextInt();
                st[++r] = x;
            }
            if (type == 2) l++;
            if (type == 3) System.out.println(st[l]);
        }
    }
}
