class Solution {
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0, temp = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        while(temp != slow){
            slow = nums[slow];
            temp = nums[temp];
        }
        return temp;
    }
}