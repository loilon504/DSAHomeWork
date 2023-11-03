import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int[][] visited = new int[15][15];
    public static int sum = 0;
    public static int n;
    public static int m;

    public static int[] ci = {-1, -1, -1, 0, 0, 1, 1, 1};
    public static int[] di = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void DFS(List<List<Integer>> matrix, int u, int v) {
        sum++;
        visited[u][v] = 1;
        for (int i = 0; i < 8; i++) {
            int x = u + ci[i];
            int y = v + di[i];
            if (x >= 0 && x < n && y >= 0 && y < m && visited[x][y] == 0 && matrix.get(x).get(y) == 1) DFS(matrix, x, y);
        }
    }

    public static int connectedCell(List<List<Integer>> matrix) {
        // Write your code here
        int ans = 0;
        n = matrix.size();
        m = matrix.get(0).size();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) visited[i][j] = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) if (matrix.get(i).get(j) == 1 && visited[i][j] == 0) {
                sum = 0;
                DFS(matrix, i, j);
                ans = Math.max(ans, sum);
            }
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        int result = Result.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
