class Solution {
    private boolean[] color;
    private boolean[] visited;
    private boolean ok;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        color = new boolean[n+1];
        visited = new boolean[n+1];
        ok = true;
        
        List<Integer>[] graph = new LinkedList[n+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        
        for (int i = 0; i < dislikes.length; i++) {
            for (int j = 0; j < dislikes[i].length; j++) {
                graph[dislikes[i][0]].add(dislikes[i][1]);
                graph[dislikes[i][1]].add(dislikes[i][0]);
            }
        }
        
        for (int i = 1; i < graph.length; i++) {
            if (!visited[i])
                bfs(graph, i);
        }
        
        return ok;
    }
    
    
    private void dfs(List<Integer>[] graph, int start) {
        if (!ok)return;
        if (visited[start])return;
        visited[start] = true;
        for(int neigh: graph[start]) {
            if (!visited[neigh]) {
                color[neigh] = !color[start];
                dfs(graph, neigh);
            } else {
                if (color[neigh] == color[start]) {
                    ok = false;
                }
            }
        }
    }
    
    private void bfs(List<Integer>[] graph, int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);
        
        while (!q.isEmpty() && ok) {
            int cur = q.poll();
            for (int i: graph[cur]) {
                if (!visited[i]) {
                    visited[i] = true;
                    color[i] = !color[cur];
                    q.offer(i);
                } else {
                    if (color[cur] == color[i]) {
                        ok = false;
                    }
                }
            }
        }
    }
}