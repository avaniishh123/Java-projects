public class Solution {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));    // Output: false
        System.out.println(isMatch("aa", "a*"));   // Output: true
        System.out.println(isMatch("ab", ".*"));   // Output: true
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // dp[i][j] represents whether the first i characters in s match the first j characters in p
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty pattern matches empty string
        dp[0][0] = true;

        // Handle patterns with '*' at the beginning
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Build the DP matrix
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == '.' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                }
            }
        }
        
        return dp[m][n];
    }
}