import java.util.ArrayList;
import java.util.List;

public class SadJavaClass {
    public String largestNumber(final List<Integer> A) {
        final StringBuilder res = new StringBuilder();
        final List<String> strings = new ArrayList<>(A.size());

        boolean all0s = true;
        for (int i : A) {
            strings.add(Integer.toString(i));
            all0s &= i == 0;
        }
        if (all0s)
            return "0";

        strings.sort((o1, o2) -> {
            String a = o1 + o2;
            String b = o2 + o1;

            return a.compareTo(b);
        });
        for (int i = strings.size() - 1; i >= 0; i--) {
            res.append(strings.get(i));
        }

        return res.toString();
    }
}
