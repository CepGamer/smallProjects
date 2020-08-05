import java.math.BigInteger;

public class SadJavaClass {
    public int compareVersion(String A, String B) {
        int al = 0;
        int bl = 0;
        while (true) {
            int dif = compareString(A.substring(al, getDotIndex(A, al)),
                    B.substring(bl, getDotIndex(B, bl)));

            if (dif > 0) {
                return 1;
            } else if (dif < 0) {
                return -1;
            }

            al = getDotIndex(A, al) + 1;
            bl = getDotIndex(B, bl) + 1;
            if (B.length() - bl != A.length() - al) {
                if (al > A.length()) {
                    return -anyNonZeroes(B, bl);
                } else if (bl > B.length()) {
                    return anyNonZeroes(A, al);
                }
            } else {
                if (al > A.length()) {
                    return 0;
                }
            }
        }
    }

    private int getDotIndex(String A, int al) {
        return A.indexOf('.', al) == -1 ? A.length() : A.indexOf('.', al);
    }

    private int compareString(String l, String r) {
        int ad = 0;
        int bd = 0;

        while (ad < l.length() && l.charAt(ad) == '0') {
            ad++;
        }
        while (bd < r.length() && r.charAt(bd) == '0') {
            bd++;
        }

        if (l.length() - ad != r.length() - bd) {
            return l.length() - ad - r.length() + bd;
        } else {
            for (int i = 0; i < l.length() - ad; i++) {
                if (l.charAt(i + ad) != r.charAt(i + bd)) {
                    return l.charAt(i) - r.charAt(i);
                }
            }
        }
        return 0;
    }

    private int anyNonZeroes(String a, int l) {
        for (int i = l; i < a.length(); i++) {
            if (a.charAt(i) != '.' && a.charAt(i) != '0') {
                return 1;
            }
        }
        return 0;
    }
}
