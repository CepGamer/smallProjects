import java.util.List;

public class SadJavaClass {
    public static int maxSubArray(final List<Integer> A) {
        int maxsum = -1000000;
        int cursum = -1000000;
        for (int val : A)
        {
            cursum = Math.max(cursum + val, val);
            maxsum = Math.max(maxsum, cursum);
        }

        return maxsum;
    }
}
