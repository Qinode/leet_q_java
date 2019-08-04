import java.util.ArrayList;
import java.util.List;

class Solution {
    int gameScore = 0;
    Map<String, Integer> cache = new HashMap<String, Integer>();
    // gameScore = alexScore - leeScore;
    // sum(piles) = alexScore + leeScore;
    // alexScore = (gameScore + sum(piles)) / 2

    public int stoneGameII(int[] piles) {
        int allScores = sum(piles);
        int score = minimax(piles, 0, true, 1);
        return (allScores + score)/2;
    }

    public int minimax(int[] piles, int start, boolean isAlex, int M){
        String key = String.format("%s.%s.%s", start, isAlex, M);
        if (cache.containsKey(key)){
            return cache.get(key);
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int x = 1; x <= 2 * M; x++){
            if (start + x - 1 >= piles.length){
                continue;
            }
            int pile = 0;
            for (int j = 0; j < x; j++){
                pile += piles[start + j];
            }
            result.add((isAlex ? pile : -pile) + minimax(piles, start + x, !isAlex, Math.max(M, x)));
        }

        if (isAlex) {
            int resultScore = max(result);
            cache.put(key, resultScore);
            return resultScore;
        } else {
            int resultScore = min(result);
            cache.put(key, resultScore);
            return resultScore;
        }
    }

    public int sum(int[] scores){
        int sum = 0;
        for(Integer i : scores){
            sum += i;
        }
        return sum;
    }

    public int max(List<Integer> score) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < score.size(); i++){
            max = Math.max(max, score.get(i));
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    public int min(List<Integer> score) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < score.size(); i++){
            min = Math.min(min, score.get(i));
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

}