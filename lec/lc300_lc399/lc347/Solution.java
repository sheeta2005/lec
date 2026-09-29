package lc300_lc399.lc347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> (
                a.getValue() - b.getValue()
        ));
        for (int num : nums) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                hashMap.put(num, hashMap.get(num) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> map : hashMap.entrySet()) {
            heap.add(map);
            if (heap.size() > k) {
                heap.poll();
            }
        }


        for (int i = k - 1; i >= 0; i--) {
            Map.Entry<Integer, Integer> poll = heap.poll();
            res[i] = poll.getKey();
        }

        return res;
    }
}