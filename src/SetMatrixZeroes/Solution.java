package SetMatrixZeroes;

import com.sun.org.apache.xml.internal.security.utils.HelperNodeList;

/**
 * Created by haha on 2015/5/1.
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null) return;
        int hlen = matrix.length;
        if(hlen == 0) return;
        int wlen = matrix[0].length;
        if(wlen == 0) return;

        boolean firstCol = false;
        boolean firstRow = false;

        for(int h = 0; h < hlen; ++h){
            if(h == 0){
                if(matrix[0][0] == 0){
                    firstCol = true;
                    firstRow = true;
                }else{
                    for(int w = 1; w < wlen; ++w){
                        if(matrix[0][w] == 0){
                            firstRow = true;
                            break;
                        }
                    }
                }
            }else{
                if(!firstCol && matrix[h][0] == 0) firstCol = true;
                for(int w = 1; w < wlen; ++w){
                    if(matrix[h][w] == 0){
                        matrix[h][0] = 0;
                        matrix[0][w] = 0;
                    }
                }
            }
        }
        for(int h = 1; h < hlen; ++h){
            for(int w = 1; w < wlen; ++w){
                if(matrix[0][w] == 0 || matrix[h][0] == 0){
                    matrix[h][w] = 0;
                }
            }
        }

        if(firstCol){
            for(int h = 0; h < hlen; ++h){
                matrix[h][0] = 0;
            }
        }
        if(firstRow){
            for(int w = 0; w < wlen; ++w){
                matrix[0][w] = 0;
            }
        }
    }
}
