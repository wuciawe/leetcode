package EditDistance;

/**
 * Created by haha on 2015/5/1.
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int[] record = new int[word2.length() + 1];
        for(int i = 0; i <record.length; ++i){
            record[i] = i;
        }

        int[] cur = new int[word2.length() + 1];
        for(int i = 1; i <= word1.length(); ++i){
            cur[0] = i;
            for(int j = 1; j < record.length; ++j){
                int r = 1 + Math.min(cur[j - 1], record[j]);
                int r2 = record[j - 1];
                if(word1.charAt(i - 1) != word2.charAt(j - 1)) ++r2;
                cur[j] = Math.min(r, r2);
            }
            int[] tmp = record;
            record = cur;
            cur = tmp;
        }

        return record[word2.length()];
    }
}
