class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        int ans = Integer.MAX_VALUE;

        for (int src = 0; src < n; src++) {
            int[] dist = new int[n];
            int[] parent = new int[n];

            Arrays.fill(dist, -1);
            Arrays.fill(parent, -1);

            Queue<Integer> q = new ArrayDeque<>();
            q.offer(src);
            dist[src] = 0;

            while (!q.isEmpty()) {
                int u = q.poll();

                for (int v : adj[u]) {
                    if (dist[v] == -1) {
                        dist[v] = dist[u] + 1;
                        parent[v] = u;
                        q.offer(v);
                    } else if (parent[u] != v) {
                        ans = Math.min(
                            ans,
                            dist[u] + dist[v] + 1
                        );
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
