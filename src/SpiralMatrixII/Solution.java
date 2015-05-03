package SpiralMatrixII;

/**
 * Created by haha on 2015/5/1.
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        if(n == 0) return new int[0][0];

        int[][] res = new int[n][n];

        int len = n;

        int i = 0;
        while(i < len){
            res[0][i] = ++i;
        }
        final int n2 = n * n;
        int dir = 0;
        int h = 0;
        int w = n - 1;
        int cnt = 0;
        while(i < n2){
            if(cnt == 0) --len;
            switch (dir){
                case 0:
                    for(int step = 0; step < len; ++step){
                        res[++h][w] = ++i;
                    }
                    break;
                case 1:
                    for(int step = 0; step < len; ++step){
                        res[h][--w] = ++i;
                    }
                    break;
                case 2:
                    for(int step = 0; step < len; ++step){
                        res[--h][w] = ++i;
                    }
                    break;
                case 3:
                    for(int step = 0; step < len; ++step){
                        res[h][++w] = ++i;
                    }
                    break;
            }
            cnt = (cnt + 1) % 2;
            dir = (dir + 1) % 4;
        }
        return res;
    }
}
