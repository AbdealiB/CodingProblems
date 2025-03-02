import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphTraversalDFS {
    /*
     * Depth First Search (DFS) is an algorithm for traversing or searching tree or
     * graph data structures. The algorithm starts at the root node and explores as
     * far as possible along each branch before backtracking.
     * 
     * Time Complexity: O(V + E), where V is the number of vertices and E is the
     * number of edges in the graph.
     * Space Complexity: O(V), where V is the number of vertices in the graph.
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

        // Adjacency list of the undirected graph
        // List<List<Integer>> graph = new ArrayList<>(Arrays.asList(
        // Arrays.asList(1, 2),
        // Arrays.asList(0, 3, 4),
        // Arrays.asList(0),
        // Arrays.asList(1),
        // Arrays.asList(1)));

        boolean[] visited = new boolean[graphList.size()];
        List<Integer> result = new ArrayList<>();

        dfs(graphList, 0, visited, result);

        System.out.println("DFS traversal of the graph:");
        result.stream().forEach(x -> System.out.print(x + " "));
    }

    private static List<Integer> dfs(List<List<Integer>> graph, int node, boolean[] visited, List<Integer> result) {
        visited[node] = true;
        result.add(node);
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited, result);
            }
        }

        return result;
    }
}
