package DungeonGame;

/**
 * Created by haha on 2015/4/29.
 */
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int hlen = dungeon.length;
        if(hlen == 0) return 0;
        int wlen = dungeon[0].length;
        if(wlen == 0) return 0;

        int[][] res = new int[hlen][wlen];
        res[hlen - 1][wlen - 1] = Math.max(0, -dungeon[hlen - 1][wlen - 1]);
        for(int w = wlen - 2; w >= 0; --w){
            res[hlen - 1][w] = Math.max(0, res[hlen - 1][w + 1] - dungeon[hlen - 1][w]);
        }
        for(int h = hlen - 2; h >= 0; --h){
            res[h][wlen - 1] = Math.max(0, res[h + 1][wlen - 1] - dungeon[h][wlen - 1]);
            for(int w = wlen - 2; w >= 0; --w){
                res[h][w] = Math.max(0, Math.min(res[h + 1][w], res[h][w + 1]) - dungeon[h][w]);
            }
        }
        return res[0][0] + 1;
    }
}
