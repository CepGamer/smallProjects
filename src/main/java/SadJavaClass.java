import java.util.ArrayList;
import java.util.BitSet;

public class SadJavaClass {
    public int pow(int x, int n, int d) {
        if (n == 0) {
            return 1 % d;
        }
        ArrayList<Long> arr = new ArrayList<>(32);
        arr.add(0, (long) (x % d));
        for (int i = 1; i < 32; i++) {
            long mul = arr.get(i - 1) * (arr.get(i - 1));
            arr.add(i, (mul % d));
        }
        long res = 1;
        BitSet bits = BitSet.valueOf(new long[]{n});
        for (int i = 0; i < 32; i++) {
            if (bits.get(i)) {
                res = (res * arr.get(i)) % d;
            }
        }
        if (res < 0) {
            res += d;
        }
        return (int)res;
    }
}
