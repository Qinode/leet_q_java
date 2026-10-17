import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q2799_CountCompleteSubArr {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> completeSet = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) completeSet.add(nums[i]);

        int result = 0;
        Map<Integer, Integer> completeSubArr = new HashMap<Integer, Integer>();
        int left = 0, right = 0;

        while(left < nums.length){
            while(right < nums.length && (completeSet.size() != completeSubArr.keySet().size())){
                completeSubArr.merge(nums[right++], 1, Integer::sum);
            }

            if(completeSet.size() == completeSubArr.keySet().size()) {
                result += nums.length - right + 1;
            }
            int remainingCount = completeSubArr.compute(nums[left++], (k, v) -> v-1);
            if(remainingCount == 0) {
                completeSubArr.remove(nums[left - 1]);
            }
        }

        return result;
    }
}
    
}
