package lc1559;


class Solution {
    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        if (n == 0) return false;
        int m = grid[0].length;


        int[] parent = new int[n * m];
        for (int i = 0; i < n * m; i++) {
            parent[i] = i;
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = grid[i][j];
                // 向右看
                if (j + 1 < m && grid[i][j + 1] == c) {
                    int u = i * m + j;
                    int v = i * m + (j + 1);
                    if (union(parent, u, v)) {
                        return true;
                    }
                }

                if (i + 1 < n && grid[i + 1][j] == c) {
                    int u = i * m + j;
                    int v = (i + 1) * m + j;
                    if (union(parent, u, v)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }


    private int find(int[] parent, int x) {

        int root = x;
        while (parent[root] != root) {
            root = parent[root];
        }

        while (parent[x] != root) {
            int next = parent[x];
            parent[x] = root;
            x = next;
        }
        return root;
    }

    // 合并两个集合，返回是否出现了环
    private boolean union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX == rootY) {
            // 两个节点已经连通，合并会形成环
            return true;
        }
        // 合并两个集合
        parent[rootY] = rootX;
        return false;
    }
}