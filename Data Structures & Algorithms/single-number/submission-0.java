class Solution {
    public int singleNumber(int[] nums) {
        int a = 1;
        for(int i=0;i<nums.length;i++){
            a ^= nums[i];
        }
        return a ^ 1;
    }
}
