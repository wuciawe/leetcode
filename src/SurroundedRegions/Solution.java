package SurroundedRegions;

import java.util.Stack;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        if(rows < 3) return;
        int cols = board[0].length;
        if(cols < 3) return;

        for(int r = 0; r < rows; ++r){
            for(int c = 0; c < cols; ++c){
                if((r == 0 || r == rows - 1 || c == 0 || c == cols - 1) && board[r][c] == 'O'){
                    Stack<Integer> sr = new Stack<Integer>();
                    Stack<Integer> sc = new Stack<Integer>();
                    sr.add(r);
                    sc.add(c);
                    while(!sr.isEmpty()){
                        int cr = sr.pop();
                        int cc = sc.pop();
                        board[cr][cc] = 'a';
                        if(cr - 1 >= 0 && board[cr - 1][cc] == 'O'){
                            sr.push(cr - 1);
                            sc.push(cc);
                        }
                        if(cr + 1 < rows && board[cr + 1][cc] == 'O'){
                            sr.push(cr + 1);
                            sc.push(cc);
                        }
                        if(cc - 1 >= 0 && board[cr][cc - 1] == 'O'){
                            sr.push(cr);
                            sc.push(cc - 1);
                        }
                        if(cc + 1 < cols && board[cr][cc + 1] == 'O'){
                            sr.push(cr);
                            sc.push(cc + 1);
                        }
                    }
                }
            }
        }
        for(int r = 0; r < rows; ++r){
            for(int c = 0; c < cols; ++c){
                switch (board[r][c]){
                    case 'O':
                        board[r][c] = 'X';
                        break;
                    case 'a':
                        board[r][c] = 'O';
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
