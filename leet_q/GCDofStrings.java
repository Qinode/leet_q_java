import java.util.Collections;

class GCDofStrings{
    public String gcdOfStrings(String str1, String str2) {
        String shorter = str1.length() < str2.length() ? str1 : str2;

        String t = "", finalT = "";

        while(t.length() < shorter.length()){
            t = shorter.substring(0, t.length() + 1);

            String try1 = String.join("", Collections.nCopies((int)Math.ceil((double)str1.length()/t.length()), t));
            String try2 = String.join("", Collections.nCopies((int)Math.ceil((double)str2.length()/t.length()), t));

            if(try1.equals(str1) && try2.equals(str2)) {
                finalT = t;
            }
        }

        return finalT;
    }
}