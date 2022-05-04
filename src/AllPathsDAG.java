import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AllPathsDAG {
    public static void main(String[] args) {
        // [[1,2],[3],[3],[]]

        int[][] test = new int[][] {{1,2},{3},{3},{}};
        allPathsSourceTarget(test);

    }
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        traverse(graph, 0, new Stack<>(), paths);
        return paths;
    }

    public static void traverse (int[][] graph, int current, Stack<Integer> currentPath, List<List<Integer>> paths) {
        currentPath.add(current);
        if (current == graph.length -1) {
            //if we are at the destination
            Stack<Integer> temp = (Stack<Integer>) currentPath.clone();
            paths.add(temp);
        }

        for (int nextNode : graph[current]) {
            traverse(graph, nextNode, currentPath, paths);
            currentPath.pop();
        }
    }
}
