import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.AbstractMap.SimpleEntry;

public class isCycleUDGraphBFS {
    /*
     * Detect Cycle in an undirected graph using BFS
     * 
     */

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>(Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(0, 2, 3),
                Arrays.asList(1, 4),
                Arrays.asList(1, 4),
                Arrays.asList(2, 3))); // true

        // List<List<Integer>> graph = new ArrayList<>(Arrays.asList(
        // Arrays.asList(1),
        // Arrays.asList(2),
        // Arrays.asList(1, 3),
        // Arrays.asList(2))); // false

        boolean[] visited = new boolean[graph.size()];
        boolean isCycle = false;

        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i] && hasCycleBFS(graph, visited, i)) {
                isCycle = true;
                break;
            }
        }

        System.out.println("is Cycle : " + isCycle);
    }

    private static boolean hasCycleBFS(List<List<Integer>> graph, boolean[] visited, int u) {
        Queue<SimpleEntry<Integer, Integer>> queue = new LinkedList<>();

        queue.add(new SimpleEntry<>(u, -1));
        visited[u] = true;

        while (!queue.isEmpty()) {
            SimpleEntry<Integer, Integer> node = queue.poll();
            int source = node.getKey();
            int parent = node.getValue();

            for (int v : graph.get(source)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(new SimpleEntry<>(v, source));
                } else if (v != parent) {
                    return true;
                }
            }
        }

        return false;
    }
}
