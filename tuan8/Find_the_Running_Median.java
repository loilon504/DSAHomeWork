import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        ArrayList<Double> ans = new ArrayList<>();
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        for (int i = 0; i < a.size(); i++) {
            int maLeft = 0;
            int miRight = 100000;
            if (!left.isEmpty()) {
                maLeft = -left.peek();
            }
            if (!right.isEmpty()) {
                miRight = right.peek();
            }
            if (a.get(i) <= maLeft) {
                left.add(-a.get(i));
            } else {
                right.add(a.get(i));
            }
            while (right.size() > left.size()) {
                int value = right.peek();
                right.poll();
                left.add(-value);
            }
            while (left.size() > right.size()) {
                int value = -left.peek();
                left.poll();
                right.add(value);
            }
            if (left.size() == right.size()) ans.add((double) (-left.peek() + right.peek()) / 2);
            else ans.add((double) right.peek());
        }
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < aCount; i++) {
            int aItem = Integer.parseInt(bufferedReader.readLine().trim());
            a.add(aItem);
        }

        List<Double> result = Result.runningMedian(a);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
