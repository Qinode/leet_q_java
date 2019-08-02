class Solution {
    public int removeDuplicates(int[] nums) {
            if (nums.length == 0 || nums.length == 1){
	                return nums.length;
	            }else {
		                int length = 1;
		                for (int i = 1; i < nums.length; i++){
				                if (nums[i] != nums[i-1]){
						                    length++;
						                    nums[length-1] = nums[i];
						                }
				            }
		                return length;
		            }
        }
}
