package lc1722;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UnionFind uf = new UnionFind(n);

        // 构建并查集，合并可交换的下标
        for (int[] swap : allowedSwaps) {
            uf.union(swap[0], swap[1]);
        }

        // 统计每个连通分量里 source 的元素出现次数
        Map<Integer, Map<Integer, Integer>> groupCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            groupCount.computeIfAbsent(root, k -> new HashMap<>())
                    .put(source[i], groupCount.get(root).getOrDefault(source[i], 0) + 1);
        }

        int res = 0;
        // 遍历 target，在对应连通分量里找匹配的元素
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            Map<Integer, Integer> count = groupCount.get(root);
            if (count.containsKey(target[i]) && count.get(target[i]) > 0) {
                count.put(target[i], count.get(target[i]) - 1);
            } else {
                res++;
            }
        }
        return res;
    }

    // 并查集实现
    static class UnionFind {
        int[] parent;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if (fx != fy) {
                parent[fy] = fx;
            }
        }
    }
}