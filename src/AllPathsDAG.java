import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllPathsDAG {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        traverse(graph, 0, new Stack<>(),paths);
        return paths;
    }

    public static void traverse (int[][] graph, int current, Stack<Integer> currentPath, List<List<Integer>> paths) {

            if (current == graph.length -1) {
                //if we are at the destination
                paths.add(currentPath);
            }

        currentPath.add(current);
        for (int nextNode : graph[current]) {
                traverse(graph, nextNode, currentPath, paths);
                currentPath.pop();
            }
        }
    }
