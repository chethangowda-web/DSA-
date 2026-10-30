import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {

        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build directed graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph[u].add(new int[]{v, w});
        }

        // dist[node][count] = minimum cost to reach node
        // with count consecutive identical labels
        int[][] dist = new int[n][k + 1];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // {cost, node, consecutiveCount}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        // Starting node contributes to the consecutive count
        dist[0][1] = 0;
        pq.offer(new int[]{0, 0, 1});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int cost = curr[0];
            int node = curr[1];
            int count = curr[2];

            // Ignore outdated states
            if (cost != dist[node][count]) {
                continue;
            }

            // Destination reached with minimum cost
            if (node == n - 1) {
                return cost;
            }

            for (int[] edge : graph[node]) {

                int next = edge[0];
                int weight = edge[1];

                int newCount;

                if (labels.charAt(node) == labels.charAt(next)) {
                    newCount = count + 1;
                } else {
                    newCount = 1;
                }

                // Invalid path
                if (newCount > k) {
                    continue;
                }

                int newCost = cost + weight;

                if (newCost < dist[next][newCount]) {

                    dist[next][newCount] = newCost;

                    pq.offer(new int[]{
                        newCost,
                        next,
                        newCount
                    });
                }
            }
        }

        return -1;
    }
}