package lc3600_lc3699.lc3629;

import java.util.*;


class Solution {
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static Set<Integer> getPrimeFactors(int num) {
        Set<Integer> factors = new HashSet<>();
        if (num <= 1) return factors;
        if (num % 2 == 0) {
            factors.add(2);
            while (num % 2 == 0) num /= 2;
        }
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                factors.add(i);
                while (num % i == 0) num /= i;
            }
        }
        if (num > 1) factors.add(num);
        return factors;
    }

    public int bfs(int[] nums, HashMap<Integer, List<Integer>> map, Set<Integer> primeSet) {
        int n = nums.length;
        Queue<Integer> queue = new ArrayDeque<>(); // 优化3
        boolean[] visited = new boolean[n];
        queue.add(0);
        visited[0] = true;
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curIdx = queue.poll();
                if (curIdx == n - 1) return step;

                if (curIdx - 1 >= 0 && !visited[curIdx - 1]) {
                    visited[curIdx - 1] = true;
                    queue.add(curIdx - 1);
                }
                if (curIdx + 1 < n && !visited[curIdx + 1]) {
                    visited[curIdx + 1] = true;
                    queue.add(curIdx + 1);
                }


                int curNum = nums[curIdx];
                if (primeSet.contains(curNum)) {
                    List<Integer> targetList = map.get(curNum);
                    if (targetList != null) {
                        for (int targetIdx : targetList) {
                            if (!visited[targetIdx] && targetIdx != curIdx) {
                                visited[targetIdx] = true;
                                queue.add(targetIdx);
                            }
                        }
                        map.remove(curNum);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        Set<Integer> primeSet = new HashSet<>();
        for (int num : nums) {
            if (isPrime(num)) {
                primeSet.add(num);
            }
        }


        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> factors = getPrimeFactors(nums[i]);
            for (int p : factors) {
                if (primeSet.contains(p)) {
                    map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
                }
            }
        }


        return bfs(nums, map, primeSet);
    }
}