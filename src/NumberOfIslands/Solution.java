package NumberOfIslands;

import java.util.Stack;

/**
 * Created by haha on 2015/4/29.
 */
public class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int hlen = grid.length;
        if(hlen == 0) return 0;
        int wlen = grid[0].length;
        for(int h = 0; h < hlen; ++h){
            for(int w = 0; w < wlen; ++w){
                if(grid[h][w] == '1'){
                    stack.push(h);
                    stack.push(w);
                    while(!stack.isEmpty()){
                        int nw = stack.pop();
                        int nh = stack.pop();
                        grid[nh][nw] = '2';
                        if(nw - 1 >= 0 && grid[nh][nw - 1] == '1'){
                            stack.push(nh);
                            stack.push(nw - 1);
                        }
                        if(nw + 1 < wlen && grid[nh][nw + 1] == '1'){
                            stack.push(nh);
                            stack.push(nw + 1);
                        }
                        if(nh - 1 >= 0 && grid[nh - 1][nw] == '1'){
                            stack.push(nh - 1);
                            stack.push(nw);
                        }
                        if(nh + 1 < hlen && grid[nh + 1][nw] == '1'){
                            stack.push(nh + 1);
                            stack.push(nw);
                        }
                    }
                   ++res;
                }
            }
        }
        return res;
    }
}
