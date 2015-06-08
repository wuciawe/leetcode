package MaximalSquare;

/**
 * Created by haha on 2015/6/8.
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int result = 0;
        int lastc = 0;
        int[] record = new int[matrix[0].length];
        for(int i = 0; i < record.length; ++i){
            if(matrix[0][i] == '1'){
                record[i] = 1;
                result = 1;
            }
        }
        for(int j = 1; j < matrix.length; ++j){
            lastc = record[0];
            record[0] = matrix[j][0] == '1' ? 1 : 0;
            for(int i = 1; i < record.length; ++i){
                if(matrix[j][i] == '0'){
                    lastc = record[i];
                    record[i] = 0;
                }else{
                    int t = Math.min(lastc, record[i]);
                    lastc = record[i];
                    record[i] = Math.min(t, record[i - 1]) + 1;
                    if(record[i] > result) result = record[i];
                }
            }
        }
        return result * result;
    }
}
