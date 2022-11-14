class Solution {

    class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            graph[v1].add(new Edge(edge[0], edge[1]));
            graph[v2].add(new Edge(edge[1], edge[0]));
        }

        boolean[] visited = new boolean[n];
        return validPathHelper(graph, source, destination, visited);
    }

    public boolean validPathHelper(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {
        if (src == dest) {
            return true;
        }

        visited[src] = true;

        for (Edge edge : graph[src]) {
            if (visited[edge.nbr] == false) {
                boolean hasNbrPath = validPathHelper(graph, edge.nbr, dest, visited);
                if (hasNbrPath == true) {
                    return true;
                }
            }
        }

        return false;
    }
}
