import java.util.ArrayList;
import java.util.BitSet;

public class SadJavaClass {
    public int firstMissingPositive(ArrayList<Integer> A) {
        BitSet set = new BitSet();
        for (int a : A) {
            if (a > 0)
                set.set(a);
        }
        for (int i = 1; i <= A.size() + 2; i++) {
            if (!set.get(i))
                return i;
        }
        return A.size() + 3;
    }
}
