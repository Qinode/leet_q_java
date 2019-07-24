public class Solution {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            return count(countAndSay(n - 1));
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countAndSay(4));
    }

    public String count(String input) {
        if (input.length() == 1){
            return "1" + input;
        } else {
            String anwser = "";
            int count = 1;
            for(int i = 1; i < input.length(); i++){
                if (input.charAt(i) == input.charAt(i - 1)){
                    count ++;
                } else {
                    anwser += String.valueOf(count) + input.charAt(i-1);
                    count = 1;
                }
            }
            anwser += String.valueOf(count) + input.charAt(input.length() - 1);
            return anwser;
        }
    }
}