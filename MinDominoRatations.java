import java.util.List;

class MinDominoRatations {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int dices = tops.length;
        List<Integer> first_pair = List.of(tops[0], bottoms[0]);

        for(int i = 1; i < dices; i++){
            if(!first_pair.contains(tops[i])&&!first_pair.contains(bottoms[i])){
                return -1;
            }
        }

        int min_swap = dices;
        for(int i = 0; i < first_pair.size(); i++){
            int target = first_pair.get(i);
            int top_swap = 0, bottom_swap = 0;
            for(int j = 0; j < dices; j++){
                if(tops[j] != target){
                    top_swap++;

                    if(bottoms[j] != target){
                        top_swap += dices;
                    }
                }

                if(bottoms[j] != target){
                    bottom_swap++;

                    if(tops[j] != target){
                        bottom_swap += dices;
                    }
                }
            }
            min_swap = Math.min(min_swap, Math.min(top_swap, bottom_swap));
        }

        return min_swap == dices ? -1 : min_swap;
    }
}