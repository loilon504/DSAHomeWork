import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        int save = arr.get(n - 1);
        for (int i = n - 2; i >= -1; i--) {
            if (i != n - 2) {
                for (int j = 0; j < n; j++) System.out.print(arr.get(j) + " ");
                System.out.println();
            }
            if (i == -1) arr.set(0, save); else {
                if (arr.get(i) >= save) arr.set(i + 1, arr.get(i)); else {
                    arr.set(i + 1, save);
                    break;
                }
            }
        }
        for (int j = 0; j < n; j++) System.out.print(arr.get(j) + " ");
        System.out.println();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
