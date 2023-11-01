package tuan3;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */
    public static int[] pre = new int[100005];
    public static int[] pos = new int[100005];
    public static int[] val = new int[100005];
    public static boolean[] cl = new boolean[100005];

    public static void remove(int cur_pos) {
        cl[cur_pos] = false;
        pre[cur_pos + 1] = pre[cur_pos];
    }

    public static int get(int cur_pos) {
        if (cur_pos == 0) return 0;
        if (cl[cur_pos] == true) return cur_pos;
        return (pre[cur_pos] = get(pre[cur_pos]));
    }

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        boolean ok = true;
        int n = q.size(), sum = 0;
        for (int i = 1; i <= n; i++) {
            pre[i] = i - 1;
            pos[q.get(i - 1)] = i;
            val[i] = 0;
            cl[i] = true;
        }
        for (int i = 1; i <= n; i++) {
            int cur_pos = pos[i];
            // System.out.println("HEHE " + cur_pos);
            while (cur_pos != 0) {
                // System.out.print("HA " + cur_pos + " ");
                cur_pos = get(pre[cur_pos]);
                if (cur_pos != 0) {
                    val[cur_pos]++;
                    sum++;
                    if (val[cur_pos] == 3) {
                        ok = false;
                        break;
                    }
                }
            }
            // System.out.println();
            if (ok == false) break;
            // for (int j = 1; j <= n; j++) System.out.print(val[j] + " ");
            // System.out.println();
            remove(pos[i]);
        }
        if (ok) System.out.println(sum);
        else System.out.println("Too chaotic");
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                tuan3.Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
