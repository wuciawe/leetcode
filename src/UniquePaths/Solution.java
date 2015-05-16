package UniquePaths;

/**
 * Created by haha on 2015/5/16.
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int A = m + n - 2, B = Math.min(m - 1, n - 1);
        long result = 1;
        for (int i = 1; i <= B; ++i)
        {
            result = result * A-- / i;
        }
        return (int)result;
    }
}
