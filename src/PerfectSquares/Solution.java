package PerfectSquares;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by haha on 2015/9/10.
 */
public class Solution {
    public int numSquares(int n) {
        Set<Integer> s = new HashSet<>();
        s.add(n);
        return solver(s, 0);
    }

    private int solver(Set<Integer> remainder, int cur){
        Set<Integer> n = new HashSet<>();
        for(int e : remainder){
            for(int i = (int) Math.sqrt(e); i >= 1; --i){
                int r = e - i * i;
                if(r == 0) return cur + 1;
                n.add(r);
            }
        }
        return solver(n, cur + 1);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numSquares(12));
    }
}
