package MinimumWindowSubstring;

/**
 * Created by haha on 2015/5/1.
 */
public class Solution {
    public String minWindow(String s, String t) {
        int[] record = new int[256];
        int[] cur = new int[256];
        int tlen = t.length();
        if(tlen == 0) return "";

        for(int i = 0; i < tlen; ++i){
            ++record[t.charAt(i)];
        }

        int faster = 0, slower = 0, cnt = 0, min = s.length();
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(record[ch] > 0){
                if(cnt == 0){
                    slower = i;
                    ++cnt;
                    if(cnt == tlen) return s.substring(slower, slower + 1);
                    start  = slower;
                    ++cur[ch];
                }else{
                    ++cur[ch];
                    if(ch == s.charAt(slower) && cnt == tlen){
                        --cur[ch];
                        faster = i + 1;
                        for(int j = slower + 1; j < faster; ++j){
                            char ch2 = s.charAt(j);
                            if(record[ch2] > 0){
                                if(cur[ch2] == record[ch2]){
                                    slower = j;
                                    int r = faster - slower;
                                    if(r < min) {
                                        min = r;
                                        start = slower;
                                        end = faster;
                                    }
                                    break;
                                }else{
                                    --cur[ch2];
                                }
                            }
                        }
                    }else if(cur[ch] <= record[ch] && cnt < tlen){
                        ++cnt;
                        if(cnt == tlen){
                            faster = i + 1;
                            end = faster;
                            if(faster - slower < min) {
                                min = faster - slower;
                                start = slower;
                                end = faster;
                            }
                            ch = s.charAt(slower);
                            if(cur[ch] > record[ch]){
                                --cur[ch];
                                for(int j = slower + 1; j < faster; ++j){
                                    char ch2 = s.charAt(j);
                                    if(record[ch2] > 0){
                                        if(cur[ch2] == record[ch2]){
                                            slower = j;
                                            int r = faster - slower;
                                            if(r < min) {
                                                min = r;
                                                start = slower;
                                                end = faster;
                                            }
                                            break;
                                        }else{
                                            --cur[ch2];
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
        if(cnt == tlen) return s.substring(start, end);
        else return "";
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minWindow("cabwefgewcwaefgcf", "cae");
    }
}
