import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'roadsAndLibraries' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c_lib
     *  3. INTEGER c_road
     *  4. 2D_INTEGER_ARRAY cities
     */

    public static ArrayList<ArrayList<Integer>> a = new ArrayList<>();
    public static int[] visited = new int[100005];
    public static int sum;

    public static void DFS(int u) {
        sum++;
        visited[u] = 1;
        for (int v : a.get(u)) if (visited[v] == 0) DFS(v);
    }

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        // Write your code here
        a.clear();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> x = new ArrayList<>();
            a.add(x);
            visited[i] = 0;
        }
        for (int i = 0; i < cities.size(); i++) {
            int u = cities.get(i).get(0);
            int v = cities.get(i).get(1);
            a.get(u - 1).add(v - 1);
            a.get(v - 1).add(u - 1);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) if (visited[i] == 0) {
            sum = 0;
            DFS(i);
            if (c_lib > c_road) {
                ans += (long)(sum - 1) * c_road;
                ans += c_lib;
            } else {
                ans += (long)c_lib * sum;
            }
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

            int c_lib = Integer.parseInt(firstMultipleInput[2]);

            int c_road = Integer.parseInt(firstMultipleInput[3]);

            List<List<Integer>> cities = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                String[] citiesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                List<Integer> citiesRowItems = new ArrayList<>();

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowTempItems[j]);
                    citiesRowItems.add(citiesItem);
                }

                cities.add(citiesRowItems);
            }

            long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
