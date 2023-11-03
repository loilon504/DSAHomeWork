import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. 2D_INTEGER_ARRAY edges
     *  4. INTEGER s
     */

    public static int[] dist = new int[1005];
    public static int[] cl = new int[1005];
    public static int[] q = new int[1000005];
    public static int[][] a = new int[1005][1005];

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // Write your code here
        for (int i = 1; i <= n; i++) {
            dist[i] = 1000000000;
            cl[i] = 0;
            for (int j = 1; j <= n; j++) a[i][j] = 0;
        }
        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            a[u][v] = 1;
            a[v][u] = 1;
        }
        dist[s] = 0;
        int l = 1, r = 0;
        q[++r] = s;
        while (l <= r) {
            int u = q[l++];
            for (int v = 1; v <= n; v++) if (a[u][v] == 1 && dist[v] > dist[u] + 6) {
                dist[v] = dist[u] + 6;
                if (cl[v] == 0) {
                    cl[v] = 1;
                    q[++r] = v;
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) if (i != s) {
            if (dist[i] == 1000000000) ans.add(-1);
            else ans.add(dist[i]);
        }
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int m = Integer.parseInt(firstMultipleInput[1]);

            List<List<Integer>> edges = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                String[] edgesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                List<Integer> edgesRowItems = new ArrayList<>();

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowTempItems[j]);
                    edgesRowItems.add(edgesItem);
                }

                edges.add(edgesRowItems);
            }

            int s = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> result = Result.bfs(n, m, edges, s);

            for (int i = 0; i < result.size(); i++) {
                bufferedWriter.write(String.valueOf(result.get(i)));

                if (i != result.size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
