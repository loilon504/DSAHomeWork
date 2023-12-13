import java.io.*;
import java.util.*;

public class MSTSolution {

    static int[] distances;
    static int[][] matrix;
    static Set<Integer> visited;
    static boolean[] isVisited;
    static int minEdge;
    static int minCost = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodesCount = scanner.nextInt();
        matrix = new int[nodesCount + 1][nodesCount + 1];
        int edgesCount = scanner.nextInt();
        visited = new HashSet<>();
        isVisited = new boolean[nodesCount + 1];

        for (int i = 0; i < edgesCount; i++) {
            int source = scanner.nextInt();
            int target = scanner.nextInt();
            int weight = scanner.nextInt();
            matrix[source][target] = weight == 0 ? -1 : weight;
            matrix[target][source] = weight == 0 ? -1 : weight;
        }

        int start = scanner.nextInt();
        visited.add(start);
        isVisited[start] = true;
        long totalCost = 0;

        while (visited.size() != nodesCount) {
            findMinEdge();

            if (minCost == -1) {
                minCost = 0;
            }
            totalCost += minCost;

            visited.add(minEdge);
            isVisited[minEdge] = true;
        }

        System.out.println(totalCost);
    }

    static void findMinEdge() {
        minEdge = 0;
        minCost = Integer.MAX_VALUE;

        for (Integer node : visited) {
            checkNeighbours(node);
        }
    }

    static void checkNeighbours(int currentNode) {
        for (int neighbour = 0; neighbour < matrix[currentNode].length; neighbour++) {
            if (neighbour != 0 && neighbour != currentNode) {
                if (!isVisited[neighbour] && matrix[currentNode][neighbour] != 0) {
                    if (minCost > matrix[currentNode][neighbour]) {
                        minEdge = neighbour;
                        minCost = matrix[currentNode][neighbour];
                        if (matrix[currentNode][neighbour] == -1) {
                            break;
                        }
                    }
                }
            }
        }
    }
}