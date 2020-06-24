import java.util.ArrayList;

public class SadJavaClass {
    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= A * 2 - 1; i++) {
            ArrayList<Integer> line = new ArrayList<>();
            for (int j = 1; j <= A * 2 - 1; j++) {
                line.add(Math.max(Math.abs(i - A), Math.abs(j - A)) + 1);
            }
            res.add(line);
        }
        return res;
    }
}
