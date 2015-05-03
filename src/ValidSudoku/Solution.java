package ValidSudoku;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by haha on 2015/4/25.
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> cells = new HashMap<Integer, HashSet<Character>>();
        HashMap<Integer, HashSet<Character>> rows = new HashMap<Integer, HashSet<Character>>();
        HashMap<Integer, HashSet<Character>> cols = new HashMap<Integer, HashSet<Character>>();
        for(int r = 0; r < 9; ++r){
            for(int c = 0; c < 9; ++c){
                char ch = board[r][c];
                if(ch != '.'){
                    if(rows.containsKey(r)){
                        HashSet<Character> set = rows.get(r);
                        if(set.contains(ch)) return false;
                        else set.add(ch);
                    }else{
                        HashSet<Character> set = new HashSet<Character>();
                        set.add(ch);
                        rows.put(r, set);
                    }
                    if(cols.containsKey(c)){
                        HashSet<Character> set = cols.get(c);
                        if(set.contains(ch)) return false;
                        else set.add(ch);
                    }else{
                        HashSet<Character> set = new HashSet<Character>();
                        set.add(ch);
                        cols.put(c, set);
                    }
                    int idc = 3 * (r / 3) + c / 3;
                    if(cells.containsKey(idc)){
                        HashSet<Character> set = cells.get(idc);
                        if(set.contains(ch)) return false;
                        else set.add(ch);
                    }else{
                        HashSet<Character> set = new HashSet<Character>();
                        set.add(ch);
                        cells.put(idc, set);
                    }
                }
            }
        }
        return true;
    }
}
