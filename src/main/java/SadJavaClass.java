import java.util.*;

/**
 * Definition for an interval.
 */
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}


public class SadJavaClass {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        final PriorityQueue<Interval> queue = new PriorityQueue<>((o1, o2) ->
                o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start);
        final ArrayList<Interval> result = new ArrayList<>();
        queue.addAll(intervals);

        if (queue.peek() == null)
            return result;

        Interval current = new Interval(queue.peek().start, queue.peek().end);
        for (Interval interval = queue.poll();interval != null;interval = queue.poll())
        {
            if (current.end >= interval.start)
            {
                current = new Interval(current.start, Math.max(current.end, interval.end));
            }
            else
            {
                result.add(current);
                current = new Interval(interval.start, interval.end);
            }
        }
        result.add(current);

        return result;
    }
}
