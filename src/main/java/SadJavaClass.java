public class SadJavaClass {
    public int trailingZeroes(int A) {
        int res = 0;
        for (int i = 5; i <= A; i += 5) {
            int j = i;
            while (j % 5 == 0) {
                res++;
                j /= 5;
            }
        }

        return res;
    }
}
