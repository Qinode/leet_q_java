public class MinSum {
    public long minSum(int[] nums1, int[] nums2) {
        long min1 = 0; int zero1 = 0;
        long min2 = 0; int zero2 = 0;

        for(int i = 0; i < nums1.length; i++){
            min1 += nums1[i];
            if(nums1[i] == 0){
                min1++;
                zero1++;
            }
        }
        for(int i = 0; i < nums2.length; i++){
            min2 += nums2[i];
            if(nums2[i] == 0){
                min2++;
                zero2++;
            }
        }

        if(zero1 == 0 && min1 < min2){
            return -1;
        }

        if(zero2 == 0 && min2 < min1){
            return -1;
        }

        return Math.max(min1, min2);
    }
}
