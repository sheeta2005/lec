package lc0_lc99.lc11;

class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int leftPos = 0;
        int rightPos = height.length - 1;
        while (leftPos < rightPos) {
            max = Math.max(Math.min(height[leftPos], height[rightPos])*(rightPos-leftPos), max);
            if (height[leftPos]>height[rightPos]){
                rightPos--;
            }
            else {
                leftPos++;
            }
        }
        return max;
    }
}