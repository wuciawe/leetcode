package SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haha on 2015/5/1.
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int hlen = matrix.length;
        if(hlen == 0) return new ArrayList<Integer>();
        int wlen = matrix[0].length;
        if(wlen == 0) return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<Integer>(hlen * wlen);

        int i = 0;
        while(i < wlen){
            res.add(matrix[0][i++]);
        }
        i = hlen * wlen - i;
        int dir = 0;
        int h = 0;
        int w = wlen - 1;
        while(i > 0){
            switch (dir){
                case 0:
                    --hlen;
                    for(int step = 0; step < hlen; ++step){
                        res.add(matrix[++h][w]);
                    }
                    i -= hlen;
                    break;
                case 1:
                    --wlen;
                    for(int step = 0; step < wlen; ++step){
                        res.add(matrix[h][--w]);
                    }
                    i -= wlen;
                    break;
                case 2:
                    --hlen;
                    for(int step = 0; step < hlen; ++step){
                        res.add(matrix[--h][w]);
                    }
                    i -= hlen;
                    break;
                case 3:
                    --wlen;
                    for(int step = 0; step < wlen; ++step){
                        res.add(matrix[h][++w]);
                    }
                    i -= wlen;
                    break;
            }
            dir = (dir + 1) % 4;
        }

        return res;
    }
}
