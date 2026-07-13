class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int current = 0;
        int min = Integer.MAX_VALUE;
        for(int right = 0;right<nums.length;right++){
            current = current + nums[right];
            while(current>=target){
                min = Math.min(min,right-left+1);
                current = current - nums[left];
                left++;
            }
        }
        if(min == Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }
}