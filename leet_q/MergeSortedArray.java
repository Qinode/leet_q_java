// Solution 1 solve the array from left to right
// In this case, there might be chance we can't merge
// the two in one go. E.g. [4, 0, 0, 0, 0, 0], [1, 2, 3, 5, 6]
// This is the minumum element is in the second array.

class Solution1 {
    public int subMerge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;

        while(i < m && j < n){
            if(nums1[i] > nums2[j]) {
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                if(j + 1 < n && nums2[j] > nums2[j+1]) j++;
            }
            i++;
        }

        while( j < n ){
            nums1[i++] = nums2[j++];
        }

        return i--;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while(nums1.length != m){
            m = subMerge(nums1, m, nums2, nums1.length - m);
        }
    }
}

// This solution is more efficient, it solves the array from right
// to left. It is critical to observe that the some spaces in the right
// of the first array are empty, therefore, fill the elemtn from
// right to left is more nature.
class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int k = nums1.length - 1;
        int i = m - 1;
        int j = n - 1;

        while( i >= 0 && j >= 0 ){
            if( nums1[i] > nums2[j] ){
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // This has to be j, because if j reach -1 before i
        // Then the rest of the array is already sorted.
        while( j >= 0 ){
            nums1[k--] = nums2[j--];
        }

    }
}
