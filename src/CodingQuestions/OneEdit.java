package src.CodingQuestions;

/**
 * Problem Statement
 * One Away: There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 * EXAMPLE
 * pale , pi e - > true
 * pales , pal e - > true
 * pale , bal e - > true
 * pale , bae - > false
 */
public class OneEdit {
    // Main Problem Solution FUnction
    public static boolean isOneEditAway(String s1, String s2){
        if(s1.length() == s2.length()) {
            return isOneReplace(s1, s2);
        } else if(s1.length() + 1 == s2.length()) {
            return isOneInsert(s1, s2);
        } else if(s1.length() == s2.length()+1){
            return isOneInsert(s2, s1);
        }
        return false;
    }
    public static boolean isOneReplace(String s1, String s2){
        boolean foundDifferent = false;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(foundDifferent){
                    return false;
                } else {
                    foundDifferent = true;
                }
            }
        }
        return true;
    }

    // s1 is always made sure to be smaller than s2 in length
    public static boolean isOneInsert(String s1, String s2){
        int index1 = 0;
        int index2 = 0;
        while (index1 < s1.length() && index2 < s2.length()) {
            if(s1.charAt(index1) != s2.charAt(index2)) {
                if(index2>index1) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        /**
         * Test For One Edit
         */
        System.out.println(isOneEditAway("geek", "peek"));
        System.out.println(isOneEditAway("yawn", "yan"));
        System.out.println(isOneEditAway("yaws", "yan"));



        /**
         * Test For Edit Distance
         */
    }
}
