package WordSearch;

import java.util.HashSet;

/**
 * Created by haha on 2015/4/30.
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        int len = word.length();
        if(len == 0) return true;
        int hlen = board.length;
        if(hlen == 0) return false;
        int wlen = board[0].length;
        if(wlen == 0) return false;
        boolean[][] track = new boolean[hlen][wlen];
        for(int h = 0; h < hlen; ++h){
            for(int w = 0; w < wlen; ++w){
                if(board[h][w] == word.charAt(0)){
                    if(len == 1) return true;
                    track[h][w] = true;
                    if(solver(board, wlen, hlen, word, len, 0, h, w, 0, track)) return true;
                    track[h][w] = false;
                }
            }
        }
        return false;
    }

    private boolean solver(char[][] board, int wlen, int hlen, String word, int len, int idx, int h, int w, int dir, boolean[][] track){
        if(dir != 1 && h - 1 >= 0){
            if(!track[h - 1][w] && word.charAt(idx + 1) == board[h - 1][w]){
                if(idx + 1 == len - 1) return true;
                track[h - 1][w] = true;
                if(solver(board, wlen, hlen, word, len, idx + 1, h - 1, w, 3, track)) return true;
                track[h - 1][w] = false;
            }
        }
        if(dir != 2 && w + 1 < wlen){
            if(!track[h][w + 1] && word.charAt(idx + 1) == board[h][w + 1]){
                if(idx + 1 == len - 1) return true;
                track[h][w + 1] = true;
                if(solver(board, wlen, hlen, word, len, idx + 1, h, w + 1, 4, track)) return true;
                track[h][w + 1] = false;
            }
        }
        if(dir != 3 && h + 1 < hlen){
            if(!track[h + 1][w] && word.charAt(idx + 1) == board[h + 1][w]){
                if(idx + 1 == len - 1) return true;
                track[h + 1][w] = true;
                if(solver(board, wlen, hlen, word, len, idx + 1, h + 1, w, 1, track)) return true;
                track[h + 1][w] = false;
            }
        }
        if(dir != 4 && w - 1 >= 0){
            long r = ((long) h) * (w - 1);
            if(!track[h][w - 1] && word.charAt(idx + 1) == board[h][w - 1]){
                if(idx + 1 == len - 1) return true;
                track[h][w - 1] = true;
                if(solver(board, wlen, hlen, word, len, idx + 1, h, w - 1, 2, track)) return true;
                track[h][w - 1] = false;
            }
        }
        return false;
    }
}
