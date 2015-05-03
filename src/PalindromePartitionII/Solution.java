package PalindromePartitionII;

/**
 * Created by haha on 2015/5/2.
 */
public class Solution {
    public int minCut(String s) {
        int len = s.length();
        if(len < 2) return 0;
        char[] cs = s.toCharArray();
        boolean[][] cache = new boolean[len + 1][len];

        for(int i = 0; i < len; ++i){
            cache[1][i] = true;
            cache[0][i] = true;
        }
        for(int l = 2; l <= len; ++l){
            for(int i = 0; i + l <= len; ++i){
                cache[l][i] = cache[l - 2][i + 1] && cs[i] == cs[i + l - 1];
            }
        }

        int[] res = new int[len];
        res[0] = 0;

        for(int i = 1; i < len; ++i){
            if(cache[i + 1][0]){
                res[i] = 0;
            }else{
                res[i] = res[i - 1];
                for(int j = i - 2; j >= 0; --j){
                    if(cache[i - j][j + 1]){
                        if(res[j] < res[i]) res[i] = res[j];
                    }
                }
                ++res[i];
            }
        }

        return res[len - 1];

//        int res = solver(0, len, cache, record);
//        return res;

    }

//    private int solver(int idx, int len, boolean[][] cache, int[][] record){
//        if(record[idx][len] != -1){
//            return record[idx][len];
//        }else{
//            if(cache[len][idx]){
//                record[idx][len] = 0;
//                return 0;
//            }else{
//                int res = len;
//                for(int x = 1; x < len; ++x){
//                    int r = solver(idx, x, cache, record) + solver(idx + x, len - x, cache, record) + 1;
//                    if(r < res) res = r;
//                    if(r == 1) break;
//                }
//                record[idx][len] = res;
//                return res;
//            }
//        }
//    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }
}