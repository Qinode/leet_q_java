class Solution {
    public int reverse(int x) {
        boolean positive = x >= 0;
        x = (positive) ? x : -x;
        long reversed = 0;

        while (x != 0){
            reversed = reversed * 10 + (x % 10);
            x /= 10;
        }

        reversed = (positive) ? reversed : -reversed;
        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE){
            return 0;
        } else {
            return (int) reversed;
        }
    }
}