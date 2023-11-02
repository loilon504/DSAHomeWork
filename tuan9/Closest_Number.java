import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void MergeSort(List<Integer> arr, int l, int r) {
        int m = (l + r) / 2;
        if (l >= r) return;
        MergeSort(arr, l, m);
        MergeSort(arr, m + 1, r);
        ArrayList<Integer> temp = new ArrayList<>();
        int i = l, j = m + 1;
        while (i <= m || j <= r) {
            if (i > m) {
                temp.add(arr.get(j));
                j++;
                continue;
            }
            if (j > r) {
                temp.add(arr.get(i));
                i++;
                continue;
            }
            if (arr.get(i) < arr.get(j)) {
                temp.add(arr.get(i));
                i++;
            } else {
                temp.add(arr.get(j));
                j++;
            }
        }
        for (int k = 0; k < temp.size(); k++) {
            arr.set(l + k, temp.get(k));
        }
    }

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        MergeSort(arr, 0, arr.size() - 1);
        List<Integer> ans = new ArrayList<>();
        int mi = (int) 1e9;
        for (int i = 0; i < arr.size() - 1; i++)
            mi = Math.min(mi, arr.get(i + 1) - arr.get(i));
        for (int i = 0; i < arr.size() - 1; i++)
            if (arr.get(i + 1) - arr.get(i) == mi) {
                ans.add(arr.get(i));
                ans.add(arr.get(i + 1));
            }
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        List<Integer> result = Result.closestNumbers(arr);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
