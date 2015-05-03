package NQueens;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by haha on 2015/4/11.
 */
public class Solution {
    public List<String[]> solveNQueens(int n){
        List<String[]> result = new LinkedList<String[]>();
        solve(result, n - 1, new int[0], n);
        return result;
    }

    private void solve(List<String[]> res, int q, int[] history, int N){
        for(int col = 0; col < N; ++col){
            boolean valid = valid(history, q, col);
            if(valid){
                if (q == 0){
                    res.add(mkString(history, col, N));
                } else {
                    int len = history.length;
                    int[] nhis = new int[len + 2];
                    nhis[0] = q;
                    nhis[1] = col;
                    for(int i = 0; i < len; ++i){
                        nhis[i + 2] = history[i];
                    }
                    solve(res, q - 1, nhis, N);
                }
            }
        }
    }

    private boolean valid(int[] history, int row, int col){
        int len = history.length;
        for(int i = 0; i < len; i += 2){
            int hr = history[i];
            if(hr == row) return false;
            int hc = history[i + 1];
            if(hc == col) return false;
            int dr = hr - row;
            int dc = hc - col;
            if(dr == dc || dr + dc == 0) return false;
        }
        return true;
    }

    private String[] mkString(int[] history, int col, int N){
        String[] res = new String[N];
        res[0] = pString(col, N);
        for(int i = 1; i < N; ++i)
            res[i] = pString(history[2 * i - 1], N);
        return res;
    }

    private String pString(int col, int N){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(; i < col; ++i)
            sb.append('.');
        sb.append('Q');
        ++i;
        for(; i < N; ++i)
            sb.append('.');
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solveNQueens(4);
    }
}
