class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {
        int[][] f = new int[n + 1][k + 1];
        int[][] g = new int[n + 1][k + 1];

        // No segment is being drawn initially
        f[1][0] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {

                // We are not currently extending a segment
                f[i][j] = (f[i - 1][j] + g[i - 1][j]) % MOD;

                // Continue the current state
                g[i][j] = g[i - 1][j];

                if (j > 0) {
                    // Start a new segment
                    g[i][j] = (g[i][j] + f[i - 1][j - 1]) % MOD;

                    // Continue an existing segment
                    g[i][j] = (g[i][j] + g[i - 1][j - 1]) % MOD;
                }
            }
        }

        return (f[n][k] + g[n][k]) % MOD;
    }
}