class LengthAfterTransformation {
    public int lengthAfterTransformations(String s, int t) {
        int[] letterCount = new int[27];

        for(int i = 0; i < s.length(); i++){
            letterCount[s.charAt(i) - 97]++;
        }

        for(int i = 0; i < t; i++){
            System.arraycopy(letterCount, 0, letterCount, 1, 26);
            letterCount[0] = 0;

            if(letterCount[26] !=0){
                letterCount[0]+= letterCount[26];
                letterCount[1]+= letterCount[26];
                letterCount[26] = 0;
            }

            for(int j = 0; j < 26; j++){
                letterCount[j] %= (1_000_000_000 + 7);
            }
        }

        int total = 0;
        for(int i = 0; i < 26; i++){
            total += letterCount[i];
            if(total >  (1_000_000_000 + 7)){
                total %= (1_000_000_000 + 7);
            }
        }

        return total;
    }
}