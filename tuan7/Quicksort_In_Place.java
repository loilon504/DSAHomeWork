import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int n;
    public static int[] a = new int[5005];

    public static void process(int l, int r) {
        if (l >= r) return;
        int pivot = a[r];
        int id = l;
        for (int i = l; i < r; i++) {
            while (id <= i && a[id] < pivot) id++;
            if (a[i] < pivot && id <= i) {
                int tmp = a[i];
                a[i] = a[id];
                a[id] = tmp;
                id++;
            }
        }
        while (id <= r && a[id] < pivot) id++;
        a[r] = a[id];
        a[id] = pivot;
        for (int i = 1; i <= n; i++) System.out.print(a[i] + " ");
        System.out.println();
        process(l, id - 1);
        process(id + 1, r);
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = input.nextInt();
        }
        process(1, n);
    }
}