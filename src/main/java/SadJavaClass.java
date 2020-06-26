import java.util.ArrayList;

public class SadJavaClass {
    public int uniquePaths(int A, int B) {
        int min = Math.min(A, B);
        int max = Math.max(A, B);

        if (A == 0 || B == 0) {
            return 1;
        }

        ArrayList<Integer> line = new ArrayList<>(min);
        for (int i = 0; i < min; i++) {
            line.add(1);
        }
        for (int i = 1; i < max; i++) {
            for (int j = 1; j < min; j++) {
                line.set(j, line.get(j) + line.get(j - 1));
            }
        }

        return line.get(line.size() - 1);
    }
}
