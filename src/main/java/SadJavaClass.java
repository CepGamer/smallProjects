import java.util.ArrayList;

public class SadJavaClass {
    public void arrange(ArrayList<Integer> a) {
        final int n = a.size();
        for (int i = 0; i < n; i++) {
            int ai = a.get(i);
            a.set(i, (a.get(ai) % n) * n + a.get(i));
        }
        for (int i = 0; i < n; i++) {
            a.set(i, a.get(i) / n);
        }
    }
}
