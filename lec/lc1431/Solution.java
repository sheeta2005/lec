package lc1431;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = -1;
        List<Boolean> list = new ArrayList<>();
        for (int i : candies) {
            if (i > max) {
                max = i;
            }
        }
        for (int i : candies) {
            if (i + extraCandies >= max) {
                list.add(true);
            } else {
                list.add(false);
            }
        }


        return list;
    }
}