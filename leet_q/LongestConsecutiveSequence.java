class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        Arrays.sort(nums);
        int maxLength = 1;
        int length = 1;

        for (int i = 1; i < nums.length; i ++){
            if (nums[i] == nums[i-1] + 1){
                length ++;
            }else if(nums[i] == nums[i - 1]){
                continue;
            }
            else{
                maxLength = Math.max(maxLength, length);
                length = 1;
            }
        }

        return Math.max(maxLength, length);
    }
}