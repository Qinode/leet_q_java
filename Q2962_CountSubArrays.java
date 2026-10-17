class CountSubArrays {
    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }

        int left = 0, right = 0, count = 0;
        long result = 0;

        while(left < nums.length - k + 1){
            while(right < nums.length && count < k){
                if(nums[right++] == max) count++;
            }

            if(count == k) result += nums.length - right + 1;
            if(nums[left++] == max) count--;
        }

        return result;
    }
}