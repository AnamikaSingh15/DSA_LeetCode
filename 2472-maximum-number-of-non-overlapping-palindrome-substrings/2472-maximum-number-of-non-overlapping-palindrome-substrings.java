class Solution {
    private boolean[][] isPal;
    private int[] dp;
    private int n;
    private int k;

    public int maxPalindromes(String s, int k) {
        this.n = s.length();
        this.k = k;

        isPal = new boolean[n][n];
        dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                    (j - i <= 1 || isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];

            for (int start = 0; start <= i - k; start++) {
                int end = i - 1;

                if (isPal[start][end]) {
                    dp[i] = Math.max(dp[i], dp[start] + 1);
                }
            }
        }

        return dp[n];
    }
}