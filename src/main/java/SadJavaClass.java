import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class SadJavaClass {
    public int repeatedNumber(final List<Integer> A) {
        BitSet set = new BitSet(A.size() + 1);
        for (int a : A)
        {
            if (set.get(a))
            {
                return a;
            }
            set.set(a);
        }
        return -1;
    }
}
