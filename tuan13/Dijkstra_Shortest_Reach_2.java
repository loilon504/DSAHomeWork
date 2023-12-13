import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Pii implements Comparable<Pii>{
    int w, u;
    Pii (int w, int u) {
        this.w = w;
        this.u = u;
    }
    public int compareTo(Pii x) {
        return Integer.compare(this.w, x.w);
    }
}

class Result {

    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        int dist[] = new int[n + 5];
        for(int i = 1; i <= n; ++i) {
            dist[i] = Integer.MAX_VALUE;
        }
        List<List<Pii>> a = new ArrayList<List<Pii>>();
        for(int i = 0; i <= n; ++i) {
            a.add(new ArrayList<Pii>());
        }
        for(List<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            int w = e.get(2);
            a.get(u).add(new Pii(w, v));
            a.get(v).add(new Pii(w, u));
        }

        PriorityQueue<Pii> q = new PriorityQueue<Pii>();
        q.add(new Pii(0, s));
        dist[s] = 0;

        while(!q.isEmpty()) {
            Pii tmp = q.poll();
            int u = tmp.u;
            if(dist[u] != tmp.w) {
                continue;
            }

            for(Pii e : a.get(u)) {
                int v = e.u;
                int w = e.w;
                if(dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    q.add(new Pii(dist[v], v));
                }
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        for(int i = 1; i <= n; ++i) {
            if(i == s) {
                continue;
            }
            if(dist[i] == Integer.MAX_VALUE) {
                ans.add(-1);
            } else {
                ans.add(dist[i]);
            }
        }
        return ans;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                Set<List<Integer>> edges = new HashSet<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(
                                Stream.of(bufferedReader.readLine().split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> edgeList = new ArrayList<>();
                edgeList.addAll(edges);
                List<Integer> result = Result.shortestReach(n, edgeList, s);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}