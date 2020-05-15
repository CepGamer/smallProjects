import java.util.ArrayList;
import java.util.List;

public class SadJavaClass {
    public ArrayList<ArrayList<Integer>> solve(int A) {
        final ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A > 0)
        {
            final ArrayList<Integer> row = new ArrayList<>();
            row.add(1);
            result.add(row);
        }
        for (int i = 1; i < A; i++)
        {
            final ArrayList<Integer> row = new ArrayList<>();
            final ArrayList<Integer> prev = result.get(result.size() - 1);
            row.add(1);
            for (int j = 0; j < i - 1; j++)
            {
                row.add(prev.get(j) + prev.get(j + 1));
            }
            row.add(1);
            result.add(row);
        }

        return result;
    }
}
