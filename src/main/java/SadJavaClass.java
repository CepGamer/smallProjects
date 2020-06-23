public class SadJavaClass {
    public int isPalindrome(int A) {
        long a = A;
        if (a < 0)
            return 0;
        long l = 1;
        while (a / l >= 10) {
            l *= 10L;
        }
        long r = 10L;
        while (l >= r) {
            if ((a / l) % 10L != (a % r) / (r / 10)) {
                return 0;
            }
            l /= 10L;
            r *= 10L;
        }
        return 1;
    }
}
