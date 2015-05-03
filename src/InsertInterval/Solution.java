package InsertInterval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haha on 2015/5/1.
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int size = intervals.size();
        if(size == 0){
            intervals.add(newInterval);
        }else{
            int left = findLeft(intervals, newInterval.start, 0, size - 1);
            int right = findRight(intervals, newInterval.end, 0, size - 1);

            if(left == right){
                intervals.add(left, new Interval(newInterval.start, newInterval.end));
            }else{
                Interval ele = intervals.get(left);
                if(newInterval.start < ele.start) ele.start = newInterval.start;
                Interval ele2 = intervals.get(right - 1);
                if(newInterval.end > ele2.end) ele.end = newInterval.end;
                else ele.end = ele2.end;
                int n = right - left - 1;
                while(n-- > 0){
                    intervals.remove(left + 1);
                }
            }
        }

        return intervals;
    }

    private int findLeft(List<Interval> intervals, int start, int l, int r){
        if(l == r){
            if(start <= intervals.get(l).end) return l;
            else return l + 1;
        }else{
            int mid = l + (r - l) / 2;
            Interval ele = intervals.get(mid);
            if(start < ele.start){
                if(mid == l){
                    return l;
                }
                return findLeft(intervals, start, l, mid - 1);
            }else if(start > ele.end){
                if(mid == r){
                    return mid + 1;
                }
                return findLeft(intervals, start, mid + 1, r);
            }else return mid;
        }
    }

    private int findRight(List<Interval> intervals, int end, int l, int r){
        if(l == r){
            if(end < intervals.get(l).start) return l;
            else return l + 1;
        }else{
            int mid = l + (r - l) / 2;
            Interval ele = intervals.get(mid);
            if(end < ele.start){
                if(mid == l){
                    return l;
                }
                return findRight(intervals, end, l, mid - 1);
            }else if(end > ele.end){
                if(r == mid){
                    return r + 1;
                }
                return findRight(intervals, end, mid + 1, r);
            }else return mid + 1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<Interval> l = new ArrayList<Interval>();
        l.add(new Interval(0, 5));
        l.add(new Interval(8, 9));
//        l.add(new Interval(8, 10));
//        l.add(new Interval(11, 13));
        l = sol.insert(l, new Interval(3, 4));
        return;
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}