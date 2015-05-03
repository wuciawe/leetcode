package SudokuSolver;

import java.util.*;
import java.util.stream.Collector;

/**
 * Created by haha on 2015/4/26.
 */
public class Solution {
    class Candy{
        int r;
        int c;
        int idx;
        HashSet<Character> can;

        public Candy(int r, int c){
            this.r = r;
            this.c = c;
            this.idx = 3 * (r / 3) + c / 3;
            this.can = new HashSet<Character>();
        }

        public Candy(int r, int c, int idx, HashSet<Character> can){
            this.r = r;
            this.c = c;
            this.idx = idx;
            this.can = can;
        }
    }

    class CandyComp implements Comparator<Candy>{

        @Override
        public int compare(Candy o1, Candy o2) {
            if(o1.can.size() < o2.can.size()){
                return -1;
            }
            if(o1.can.size() > o2.can.size()){
                return 1;
            }
            return 0;
        }
    }

    public void solveSudoku(char[][] board) {

        char[][] result = solver(board, init(board));
        if(result != null){
            for(int i = 0; i < 9; ++i){
                board[i] = Arrays.copyOf(result[i], 9);
            }
        }

    }

    private PriorityQueue<Candy> init(char[][] board){
        PriorityQueue<Candy> candidates = new PriorityQueue<Candy>(new CandyComp());
        HashMap<Integer, HashSet<Character>> rows = new HashMap<Integer, HashSet<Character>>();
        HashMap<Integer, HashSet<Character>> cols = new HashMap<Integer, HashSet<Character>>();
        HashMap<Integer, HashSet<Character>> idxs = new HashMap<Integer, HashSet<Character>>();
        for(int i = 0; i < 9; ++i){
            rows.put(i, new HashSet<Character>());
            cols.put(i, new HashSet<Character>());
            idxs.put(i, new HashSet<Character>());
        }
        for(int r = 0; r < 9; ++r){
            int b = 3 * (r / 3);
            for(int c = 0; c < 9; ++c){
                char ch = board[r][c];
                if(ch != '.'){
                    int idx = b + c / 3;
                    rows.get(r).add(ch);
                    cols.get(c).add(ch);
                    idxs.get(idx).add(ch);
                }
            }
        }
        for(int r = 0; r < 9; ++r){
            HashSet<Character> row = rows.get(r);
            for(int c = 0; c < 9; ++c){
                if(board[r][c] == '.'){
                    HashSet<Character> col = cols.get(c);
                    HashSet<Character> id = idxs.get(3 * (r / 3) + c / 3);
                    Candy candy = new Candy(r, c);
                    HashSet<Character> cs = new HashSet<Character>();
                    for(char ch = '1'; ch <= '9'; ++ch){
                        if(!row.contains(ch) && !col.contains(ch) && !id.contains(ch)){
                            cs.add(ch);
                        }
                    }
                    candy.can = cs;
                    candidates.add(candy);
                }
            }
        }
        return candidates;
    }

    private char[][] solver(char[][] board, PriorityQueue<Candy> candidates){
        if(candidates.isEmpty()){
            return board;
        }else{
            Candy ph = candidates.remove();
            if(ph.can.isEmpty()){
                return null;
            }else{
                for(char ch : ph.can){
                    HashSet<Character> nphcan = new HashSet<Character>(ph.can);
                    nphcan.remove(ch);
                    char[][] nboard = new char[9][9];
                    for(int i = 0; i < 9; ++i){
                        nboard[i] = Arrays.copyOf(board[i], 9);
                    }
                    nboard[ph.r][ph.c] = ch;
                    PriorityQueue<Candy> nc = new PriorityQueue<Candy>(new CandyComp());
                    for(Candy c : candidates){
                        if(c.r == ph.r || c.c == ph.c || c.idx == ph.idx){
                            HashSet<Character> ns = new HashSet<Character>(c.can);
                            ns.remove(ch);
                            if(ns.isEmpty()) return null;
                            Candy candy = new Candy(c.r, c.c, c.idx, ns);
                            nc.add(candy);
                        }else{
                            Candy candy = new Candy(c.r, c.c, c.idx, c.can);
                            nc.add(candy);
                        }
                    }
                    char[][] res = solver(nboard, nc);
                    if(res != null){
                        return res;
                    }
                }
                return null;
            }
        }
    }
}
