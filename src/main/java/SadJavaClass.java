import java.util.*;

public class SadJavaClass {
    boolean isPrime(long a)
    {
        if (a % 2 == 0)
        {
            return false;
        }
        for (long i = 3; i * i <= a; i += 2)
        {
            if (a % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    ArrayList<Integer> res(int a, int b)
    {
        return new ArrayList<>(Arrays.asList(a, b));
    }

    public ArrayList<Integer> primesum(int A) {
        for (long i = 3; i < A / 2; i += 2)
        {
            if (isPrime(i) && isPrime(A - i))
            {
                return res((int)i, (int)(A - i));
            }
        }
        return res(A / 2, A / 2);
    }
}
