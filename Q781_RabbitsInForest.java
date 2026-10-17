import java.util.HashMap;
import java.util.Map;

class Q781_RabbitsInForest {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < answers.length; i++){
            freqMap.merge(answers[i], 1, Integer::sum);
        }

        int result = 0;

        for(Map.Entry<Integer, Integer> pair : freqMap.entrySet()){
            if(pair.getValue() <= (pair.getKey()+1)){
                result += pair.getKey() + 1;
            }else{
                result += (pair.getKey() + 1) * Math.ceil((double)pair.getValue() / (pair.getKey() + 1));
            }
        }

        return result;
    }
}