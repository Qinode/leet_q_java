class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }else{
            Arrays.sort(nums1);
            Arrays.sort(nums2);

            List<Integer> result = new ArrayList<Integer>();

            int ptr1 = 0;
            int ptr2 = 0;

            while (ptr1 < nums1.length && ptr2 < nums2.length){
                if(nums1[ptr1] < nums2[ptr2]){
                    ptr1++;
                }else if(nums1[ptr1] == nums2[ptr2]){
                    result.add(nums1[ptr1]);
                    ptr1++;
                    ptr2++;
                }else{
                    ptr2++;
                }
            }
            return result.stream().mapToInt(i -> i).toArray();
        }

    }
}