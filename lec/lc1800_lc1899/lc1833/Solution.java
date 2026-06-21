package lc1800_lc1899.lc1833;

import java.util.Arrays;

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int cur=costs[0];
        int index=0;
        int count = 0;
        while (coins>cur){
            coins-=costs[index++];
            count++;
        }
        return count;
    }
}