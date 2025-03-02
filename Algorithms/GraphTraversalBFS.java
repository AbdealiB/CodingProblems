import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphTraversalBFS {
    /*
     * Breadth First Search (BFS) is an algorithm for traversing or searching tree
     * or
     * graph data structures. The algorithm starts at the root node and explores all
     * of the neighbor nodes at the present depth prior to moving on to the nodes at
     * the next depth level.
     * 
     * Time Complexity: O(V + E), where V is the number of vertices and E is the
     * number of edges in the graph.
     * 
     * Space Complexity: O(V), where V is the number of vertices in the graph.
     * 
     */

    public static void main(String[] args) {
        // Following is an example of an undirected graph with 5 vertices and 5 edges.
        // 0 -> 1, 2
        // 1 -> 0, 3, 4
        // 2 -> 0
        // 3 -> 1
        // 4 -> 1

        // Adjacency matrix of the undirected graph
        int[][] graphMatrix = { { 0, 1, 1, 0, 0 }, { 1, 0, 0, 1, 1 }, { 1, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 0 } };

        // Adjacency list of the undirected graph
        // List<List<Integer>> graph = new ArrayList<>(Arrays.asList(
        // Arrays.asList(1, 2),
        // Arrays.asList(0, 3, 4),
        // Arrays.asList(0),
        // Arrays.asList(1),
        // Arrays.asList(1)));

        // Adjacency matrix to adjacency list
        List<List<Integer>> graphList = new ArrayList<>();
        for (int i = 0; i < graphMatrix.length; i++) {
            List<Integer> neighbors = new ArrayList<>();
            for (int j = 0; j < graphMatrix[i].length; j++) {
                if (graphMatrix[i][j] == 1) {
                    neighbors.add(j);
                }
            }
            graphList.add(neighbors);
        }

        boolean[] visited = new boolean[graphList.size()];
        ArrayList<Integer> result = new ArrayList<>();

        System.out.println("BFS traversal of the graph:");
        bfs(graphList, 0, visited, result);
        result.stream().forEach(x -> System.out.print(x + " "));
    }

    private static List<Integer> bfs(List<List<Integer>> graph, int u, boolean[] visited, ArrayList<Integer> result) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(u);
        result.add(u);
        visited[u] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int v : graph.get(current)) {
                if (!visited[v]) {
                    queue.add(v);
                    result.add(v);
                    visited[v] = true;
                }
            }
        }

        return result;
    }
}
