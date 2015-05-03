package MaxPointsOnALine;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haha on 2015/5/2.
 */
public class Solution {
    public int maxPoints(Point[] points) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        if (points.length < 2 )
            return points.length;
        int max = 2;
        for(int i = 0; i < points.length; ++i){
            map.clear();
            int offset = 0;
            int m = 1;
            for(int j = 0; j < points.length; ++j){
                if(i != j){
                    int dx = points[i].x - points[j].x;
                    int dy = points[i].y - points[j].y;
                    String key;
                    if(dx == 0 && dy ==0){
                        ++offset;
                    }else{
                        if(dx == 0){
                            key = "0";
                        }else if(dy == 0){
                            key = "1";
                        }else{
                            boolean sign = dx > 0 && dy > 0 || dx < 0 && dy < 0;
                            if(dx < 0) dx = -dx;
                            if(dy < 0) dy = -dy;
                            int gcd = gcd(dx, dy);
                            dx /= gcd;
                            dy /= gcd;
                            key = dx + "/" + dy + sign;
                        }
                        if(map.containsKey(key)){
                            int r = map.get(key) + 1;
                            map.replace(key, r);
                            if(r > m) m = r;
                        }else{
                            map.put(key, 2);
                            if(2 > m) m = 2;
                        }
                    }
                }
            }
            if(m + offset > max) max = m + offset;
        }
        return max;
    }

    private int gcd(int a, int b){
        while(a!=0 && b!=0){
            int c = b;
            b = a%b;
            a = c;
        }
        return a+b;
    }
}

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}