import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        HashSet hs = new HashSet();
        for (int i = 1; i <= n; i++) {
            String s = input.nextLine();
            hs.add(s);
            System.out.println(hs.size());
        }
    }
}