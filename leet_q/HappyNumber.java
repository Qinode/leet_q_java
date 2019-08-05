class Solution {

    private Set<Integer> storage = new HashSet<Integer>();

    public boolean isHappy(int n) {
        while (n != 1 && !storage.contains(n)){
            storage.add(n);
            n = nextNumebr(n);
        }

        return n == 1;
    }

    public int nextNumebr(int n){
        String stringN = String.valueOf(n);
        int next = 0;
        for (int i = 0; i < stringN.length(); i++){
            next += (stringN.charAt(i)  - '0') * (stringN.charAt(i)  - '0');
        }
        return next;
    }
}