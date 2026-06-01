package lc3100_lc3199.lc3161;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    class SegmentTree {
        int[] tree;
        int[] lazy;
        int n;

        //初始化
        public SegmentTree(int[] arr) {
            this.n = arr.length;
            tree = new int[4 * n];
            lazy = new int[4 * n];
            build(0, 1, n, arr);
        }

        //递归二分构造
        private void build(int node, int l, int r, int[] arr) {
            if (l == r) {
                tree[node] = arr[l - 1];
            }
            int mid = (l + r) / 2;
            build(2 * node + 1, l, mid, arr);
            build(2 * node + 2, mid + 1, r, arr);
            tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
        }

        //单点更新
        public  void update(int value){

        }


        //查询
        public int query(int l, int r) {
            return query(0, 1, n, l, r);
        }

        private int query(int node, int nodeL, int nodeR, int l, int r) {
            if (l <= nodeL && nodeR <= r) {
                return tree[node];
            }
            int mid = (nodeL + nodeR) / 2;
            int leftMax = query(2 * node + 1, nodeL, mid, l, r);
            int rightMax = query(2 * node + 2, mid + 1, nodeR, l, r);
            return Math.max(leftMax, rightMax);
        }
    }

    public List<Boolean> getResults(int[][] queries) {
        int n = queries.length;
        List<Boolean> booleans = new ArrayList<>();
        int[] obstacle = new int[50001];
        for (int i = 0; i < n; i++) {
            if (queries[i][0] == 1) {
                method1(queries[i][1], obstacle);
            } else {
                booleans.add(method2(queries[i][1], queries[i][2]));
            }
        }
        return booleans;
    }

    private Boolean method2(int index, int len) {
        Boolean res = false;
        return res;
    }

    private void method1(int index, int[] obstacle) {
        obstacle[index] = 1;
    }
}
