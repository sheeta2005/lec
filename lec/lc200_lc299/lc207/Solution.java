package lc200_lc299.lc207;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            adj.get(b).add(a);
        }

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            boolean flag = dfs(i, visited, adj);
            if (!flag) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int i, int[] visited, List<List<Integer>> adj) {
        List<Integer> list = adj.get(i);
        visited[i] = 1;
        for (Integer num : list) {
            if (visited[num] == 1) {
                return false;
            } else if (visited[num] == 0) {
                if (!dfs(num, visited, adj)) {
                    return false;
                }
            }
        }
        visited[i] = 2;
        return true;
    }
}