import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        int n = A.length();
        for (int i = 1; i <= n / 2; i++) if (A.charAt(i - 1) != A.charAt(n - i)) {
            System.out.print("No");
            return;
        }
        System.out.print("Yes");
    }
}



