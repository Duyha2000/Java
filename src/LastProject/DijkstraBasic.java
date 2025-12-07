package LastProject;

import java.util.*;

public class DijkstraBasic {

    // Mỗi cạnh: (điểm đến, trọng số)
    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void dijkstra(List<List<Edge>> graph, int start) {
        int n = graph.size();
        int INF = Integer.MAX_VALUE;

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        // PQ lưu (khoảng cách, đỉnh)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[0])
        );
        pq.add(new int[]{0, start});

        boolean[] visited = new boolean[n];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0];
            int u = cur[1];

            if (visited[u]) continue;
            visited[u] = true;

            // Duyệt các cạnh từ u
            for (Edge e : graph.get(u)) {
                int v = e.to;
                int w = e.weight;

                if (dist[v] > d + w) {   // relax
                    dist[v] = d + w;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }

        // In kết quả
        for (int i = 0; i < n; i++) {
            System.out.println("dist to " + i + " = " +
                    (dist[i] == INF ? "INF" : dist[i]));
        }
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // Thêm cạnh vô hướng
        add(graph, 0, 1, 4);
        add(graph, 0, 2, 1);
        add(graph, 2, 1, 2);
        add(graph, 1, 3, 1);
        add(graph, 2, 3, 5);
        add(graph, 3, 4, 3);

        dijkstra(graph, 0);
    }

    static void add(List<List<Edge>> g, int u, int v, int w) {
        g.get(u).add(new Edge(v, w));
        g.get(v).add(new Edge(u, w)); // nếu đồ thị có hướng thì bỏ dòng này
    }
}
