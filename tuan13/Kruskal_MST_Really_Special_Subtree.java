import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
    int w, u, v;
    Edge (int u, int v, int w) {
        this.w = w;
        this.u = u;
        this.v = v;
    }
    public int compareTo(Edge x) {
        return Integer.compare(this.w, x.w);
    }
};

class Result {
    public static int[] root = new int[3005];

    public static int get(int u) {
        if (root[u] < 0) return u;
        return (root[u] = get(root[u]));
    }

    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        int gEdges = gFrom.size();
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

        for (int i = 1; i <= gNodes; i++) root[i] = -1;
        for (int i = 0; i < gEdges; i++) {
            pq.add(new Edge(gFrom.get(i), gTo.get(i), gWeight.get(i)));
        }

        int ans = 0;
        while(!pq.isEmpty()) {
            Edge tmp = pq.poll();
            int u = tmp.u;
            int v = tmp.v;
            int w = tmp.w;
            int p = get(u);
            int q = get(v);
            if (p == q) continue;
            ans += w;

            if (root[p] > root[q]) {
                int x = p;
                p = q;
                q = x;
            }
            root[p] += root[q];
            root[q] = p;
        }
        return ans;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        for (int i = 0; i < gEdges; i++) {
            String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            gFrom.add(Integer.parseInt(gFromToWeight[0]));
            gTo.add(Integer.parseInt(gFromToWeight[1]));
            gWeight.add(Integer.parseInt(gFromToWeight[2]));
        }

        int res = Result.kruskals(gNodes, gFrom, gTo, gWeight);

        // Write your code here.
        bufferedWriter.write(String.valueOf(res));

        bufferedReader.close();
        bufferedWriter.close();
    }
}