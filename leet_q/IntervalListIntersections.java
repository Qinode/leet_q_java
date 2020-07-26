class Solution {
    private static final int START = 0;
    private static final int END = 1;

    public int[][] intervalIntersection(int[][] A, int[][] B) {

        int i = 0;
        int j = 0;
        List<int[]> result = new ArrayList<int[]>();

        while( i < A.length && j < B.length ){
            int[] intervalA = A[i];
            int[] intervalB = B[j];

            if( intervalA[START] > intervalB[END] ){
                j++;
                continue;
            } else if (intervalA[END] < intervalB[START] ){
                i++;
                continue;
            } else { // has intersection
                result.add(new int[] {
                        Math.max(intervalA[START], intervalB[START]),
                        Math.min(intervalA[END], intervalB[END])
                });

                if (intervalA[END] < intervalB[END]){
                    i++;
                } else {
                    j++;
                }
            }
        }
        return result.toArray(new int[0][0]);
    }
}