package src.CodingQuestions;

import java.util.Arrays;

/*
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character


Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 */
public class EditDistnce {

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return editDistanceRecursive(word1, word2, m, n, memo);
    }

    private static int editDistanceRecursive(String word1, String word2, int m, int n, int[][] memo) {
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
            return editDistanceRecursive(word1, word2, m - 1, n - 1, memo);
        }

        int insert = 1 + editDistanceRecursive(word1, word2, m, n - 1, memo);
        int delete = 1 + editDistanceRecursive(word1, word2, m - 1, n, memo);
        int replace = 1 + editDistanceRecursive(word1, word2, m - 1, n - 1, memo);

        memo[m][n] = Math.min(Math.min(insert, delete), replace);
        return memo[m][n];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("rubbe", "rubal"));
        System.out.println(minDistance("paagal", "arnab"));
    }
}
