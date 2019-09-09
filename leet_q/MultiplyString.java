class Solution {
    public String multiply(String s1, String s2) {
        if ("0".equals(s1) || "0".equals(s2)) {
            return "0";
        } else {
            String shortString = s1.length() > s2.length() ? s2 : s1;
            String longString = s1.length() > s2.length() ? s1 : s2;
            String finalAnswer = "0";
            for (int i = shortString.length() - 1; i>=0; i--) {
                StringBuilder answer = stringMultiply(longString, shortString.charAt(i));
                for (int j = 0; i < shortString.length() - 1 - j; j++) {
                    answer.append(0);
                }
                finalAnswer = add(finalAnswer, answer.toString());

            }
            return finalAnswer;
        }
    }

    public StringBuilder stringMultiply(String s1, char c) {
        if (c == '0') {
            return new StringBuilder(0);
        }
        int number1 = c - '0';
        StringBuilder answer = new StringBuilder();
        int increment = 0;
        for (int i = s1.length() - 1; i >= 0; i--) {
            int number2 = s1.charAt(i) - '0';
            int ans = number1 * number2 + increment;
            increment = ans / 10;
            answer.append(ans % 10);
        }
        if (increment != 0) {
            answer.append(increment);
        }
        return answer.reverse();
    }

    public String add(String s1, String s2) {
        if ("0".equals(s1)){
            return s2;
        } else if ("0".equals(s2)) {
            return s1;
        } else {
            String shortString = s1.length() > s2.length() ? s2 : s1;
            String longString = s1.length() > s2.length() ? s1 : s2;
            StringBuilder answer = new StringBuilder(longString);
            int increment = 0;
            int rightPointer = 0;
            for (int i = shortString.length() - 1; i >= 0; i--, rightPointer++) {
                int number = (shortString.charAt(i) - '0') + (longString.charAt(longString.length() - 1 - rightPointer) - '0') + increment;
                increment = number / 10;
                answer.setCharAt(longString.length() - 1 - rightPointer, (char)((number % 10) + '0'));
            }
            while (increment != 0 && rightPointer < longString.length()) {
                int number = (longString.charAt(longString.length() - 1 - rightPointer) - '0') + increment;
                increment = number / 10;
                answer.setCharAt(longString.length() - 1 - rightPointer, (char)((number % 10) + '0'));
                rightPointer++;
            }
            if (increment != 0) {
                answer.insert(0, (char)((increment + '0')));
            }
            return answer.toString();
        }
    }
}