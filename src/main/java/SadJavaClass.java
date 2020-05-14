import java.util.ArrayList;
import java.util.List;

public class SadJavaClass {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        final ArrayList<Integer> B = new ArrayList<>(A);
        B.sort(Integer::compareTo);
        for (int i = 0; i < B.size() - (B.size() % 2); i += 2) {
            int a = B.get(i);
            B.set(i, B.get(i + 1));
            B.set(i + 1, a);
        }

        return B;
    }
}
