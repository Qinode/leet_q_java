class Solution {
    public boolean judgeCircle(String moves) {
        Map<Character, Integer> dict = new HashMap<Character, Integer>();
        dict.put('U', 0);
        dict.put('D', 0);
        dict.put('L', 0);
        dict.put('R', 0);
        for(char c: moves.toCharArray()){
            if(dict.containsKey(c) && dict.get(c) > 0){
                dict.put(c, dict.get(c) - 1);
            }else{
                if(c == 'U'){
                    dict.put('D', dict.get('D') + 1);
                }

                if(c == 'D'){
                    dict.put('U', dict.get('U') + 1);
                }

                if(c == 'L'){
                    dict.put('R', dict.get('R') + 1);
                }

                if(c == 'R'){
                    dict.put('L', dict.get('L') + 1);
                }
            }
        }
        int sum = 0;
        for(int i: dict.values()){
            sum += i;
        }

        return sum == 0;
    }
}