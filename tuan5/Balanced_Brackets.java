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
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static int[] a;

    public static String isBalanced(String s) {
        // Write your code here
        a = new int[1005];
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') a[++n] = 0;
            else if (s.charAt(i) == '[') a[++n] = 1;
            else if (s.charAt(i) == '{') a[++n] = 2;
            else {
                if (n == 0) return "NO";
                if (s.charAt(i) == ')' && a[n] != 0) return "NO";
                if (s.charAt(i) == ']' && a[n] != 1) return "NO";
                if (s.charAt(i) == '}' && a[n] != 2) return "NO";
                n--;
            }
        }
        if (n != 0) return "NO";
        return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
