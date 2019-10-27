class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];

        if (T.length < 2){
            return new int[] {0};
        } else {
            Deque<Integer> index = new LinkedList<Integer>();
            index.add(0);

            for(int i = 1; i < T.length; i++){
                while (index.size() > 0 && T[i] > T[index.getLast()]) {
                    result[index.getLast()] = i - index.getLast();
                    index.removeLast();
                }

                index.add(i);
            }
        }

        return result;
    }
}