public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        char[] result = new char[word1.length() + word2.length()];
        int pt1 = 0, pt2 = 0;

        int current = 1;

        while(pt1 < word1.length() || pt2 < word2.length()) {
            if (current == 1) {
                if (pt1 != word1.length()) {
                    result[pt1 + pt2] = word1.charAt(pt1++);
                }
                current = 2;
            } else if (current == 2) {
                if (pt2 != word2.length()) {
                    result[pt1 + pt2] = word2.charAt(pt2++);
                }
                current = 1;
            } else {
                throw new RuntimeException("Impossible");
            }
        }

        return new String(result);
    }
    }        public static void main(String[] args) {
        new MergeStringsAlternately().mergeAlternately("abc", "cdf");
    }
}
