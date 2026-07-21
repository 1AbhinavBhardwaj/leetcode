class Solution {
    private List<List<String>> result = new ArrayList<>();
    private boolean[][] dp;
    private char[] arr;
    private int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        arr = s.toCharArray();
        dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (arr[i] == arr[j] && (j - i < 3 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }

        backtrack(0, new ArrayList<>(n));
        return result;
    }

    private void backtrack(int start, List<String> path) {
        if (start == n) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < n; end++) {
            if (dp[start][end]) {
                path.add(new String(arr, start, end - start + 1));
                backtrack(end + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }
}