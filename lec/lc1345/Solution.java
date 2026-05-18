package lc1345;

import java.util.*;


class Solution {

    int bfs(HashMap<Integer, List<Integer>> map, int[] arr) {
        int res = 0;
        int last = arr.length - 1;
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> queue = new LinkedList();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int m = queue.size();
            for (int i = 0; i < m; i++) {
                int n = queue.poll();
                visited[n] = true;
                if (n == last) {
                    return res;
                }
                if (n < last && !visited[n + 1]) {
                    visited[n + 1] = true;
                    queue.offer(n + 1);
                }
                if (n > 0 && !visited[n - 1]) {
                    visited[n - 1] = true;
                    queue.offer(n - 1);
                }
                if (map.containsKey(arr[n])) {
                    List<Integer> list = map.get(arr[n]);
                    for (int num : list) {
                        if (num != n && !visited[num]) {
                            visited[num] = true;
                            queue.offer(num);
                        }
                    }
                    //不超时的关键
                    map.remove(arr[n]);
                }
            }
            res += 1;
        }
        return -1;
    }

    public int minJumps(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        return bfs(map, arr);
    }
}