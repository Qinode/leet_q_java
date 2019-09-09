// Time Execeed Limit, but this is the 'right' way of solving the problem by using MiniMax algorithm.

//class Solution {
//
//    Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
//
//    public int jump(int[] nums) {
//        if (nums.length == 0 || nums.length == 1){
//            return 0;
//        }else {
//            return jump(nums, 0);
//        }
//    }
//
//    public int jump(int[] nums, int start) {
//        if (cache.containsKey(start)){
//            return cache.get(start);
//        }
//
//        if (start + nums[start] + 1 >= nums.length){
//            cache.put(start, 1);
//            return 1;
//        } else {
//            List<Integer> jumps = new ArrayList<Integer>();
//            int minJumps = Integer.MAX_VALUE;
//            for (int i = 1; i <= nums[start]; i++){
//                int nextRecursive = jump(nums, start + i);
//                if (nextRecursive == Integer.MAX_VALUE){
//                } else {
//                    minJumps = Math.min(minJumps, 1 + nextRecursive);
//                }
//            }
//            cache.put(start, minJumps);
//            return minJumps;
//        }
//    }
//
//    public int min(List<Integer> jumps){
//        int minStep = Integer.MAX_VALUE;
//        for (Integer i : jumps){
//            minStep = Math.min(minStep, i);
//        }
//        return minStep;
//    }
//}