import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class isCycleUDGraphDFS {
    /*
     * Detect Cycle in an undirected graph using DFS
     */

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>(Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(0, 2, 3),
                Arrays.asList(1, 4),
                Arrays.asList(1, 4),
                Arrays.asList(2, 3)));

        boolean[] visited = new boolean[graph.size()];
        boolean isCycle = false;

        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i] && hasCycleDFS(graph, visited, i, -1)) {
                isCycle = true;
                break;
            }
        }

        System.out.println("is Cycle : " + isCycle);
    }

    private static boolean hasCycleDFS(List<List<Integer>> graph, boolean[] visited, int u, int parent) {
        visited[u] = true;
        for (int x : graph.get(u)) {
            if (x == parent) {
                continue;
            }

            if (visited[x]) {
                return true;
            }

            if (hasCycleDFS(graph, visited, x, u)) {
                return true;
            }
        }

        return false;
    }
}
