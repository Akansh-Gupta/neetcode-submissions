class Solution {
    public int maxArea(int[] heights) {
        int max = 0, l = 0, r = heights.length - 1, cur = 0;
        while (l < r) {
            if (heights[l] < heights[r]) {
                cur = heights[l] * (r - l);
                l++;
            } else {
                cur = heights[r] * (r - l);
                r--;
            }
            if (cur > max)
                max = cur;
        }
        return max;
    }
}
