package MergeIntervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by haha on 2015/5/1.
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() < 2) return new ArrayList<Interval>(intervals);
        if(intervals.getClass() != ArrayList.class){
            intervals = new ArrayList<Interval>(intervals);
        }
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        List<Interval> res = new ArrayList<Interval>();
        Interval ele = intervals.get(0);
        int start = ele.start;
        int end = ele.end;
        for(int i = 1; i < intervals.size(); ++i){
            ele = intervals.get(i);
            if(end < ele.start){
                res.add(new Interval(start, end));
                start = ele.start;
            }
            if(ele.end > end) end = ele.end;
        }
        res.add(new Interval(start, end));
        return res;
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}