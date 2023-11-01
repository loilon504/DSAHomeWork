import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static void reverse(List<Integer> x) {
        int n = x.size();
        int[] y = new int[n + 5];
        for (int i = 0; i < n; i++) y[n - i - 1] = x.get(i);
        for (int i = 0; i < n; i++) x.set(i, y[i]);
    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        int h1Size = h1.size();
        int h2Size = h2.size();
        int h3Size = h3.size();
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        reverse(h1);
        reverse(h2);
        reverse(h3);
        for (int i = 0; i < h1Size; i++) sum1 += h1.get(i);
        for (int i = 0; i < h2Size; i++) sum2 += h2.get(i);
        for (int i = 0; i < h3Size; i++) sum3 += h3.get(i);
        while (h1Size != 0 && h2Size != 0 && h3Size != 0) {
            int mi = sum1;
            mi = Math.min(mi, sum2);
            mi = Math.min(mi, sum3);
            while (h1Size != 0 && sum1 > mi) {
                sum1 -= h1.get(h1Size - 1);
                h1Size--;
            }
            while (h2Size != 0 && sum2 > mi) {
                sum2 -= h2.get(h2Size - 1);
                h2Size--;
            }
            while (h3Size != 0 && sum3 > mi) {
                sum3 -= h3.get(h3Size - 1);
                h3Size--;
            }
            if (sum1 == sum2 && sum2 == sum3) return sum1;
        }
        return 0;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
