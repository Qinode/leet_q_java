class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> aPlusB = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < B.length; j++){
                aPlusB.computeIfPresent(A[i] + B[j], (k, v) -> v+1);
                aPlusB.computeIfAbsent(A[i] + B[j], (k) -> 1);
            }
        }

        int result = 0;
        for (int i = 0; i < C.length; i++){
            for (int j = 0; j < D.length; j++){
                result += aPlusB.getOrDefault(-(C[i] + D[j]), 0);
            }
        }
        return result;
    }
}