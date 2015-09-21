package PeekingIterator;

import java.util.Iterator;

/**
 * Created by haha on 2015/9/21.
 */
public class PeekingIterator implements Iterator<Integer> {
    private boolean isPeek;
    private int peekValue;
    private Iterator<Integer> iter;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        isPeek = false;
        peekValue = 0;
        iter = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(!isPeek){
            isPeek = true;
            peekValue = iter.next();
        }
        return peekValue;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(isPeek){
            isPeek = false;
            return peekValue;
        }else return iter.next();
    }

    @Override
    public boolean hasNext() {
        return isPeek || iter.hasNext();
    }
}
