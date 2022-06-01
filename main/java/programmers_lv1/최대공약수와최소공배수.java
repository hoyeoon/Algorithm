package programmers_lv1;

import java.math.BigInteger;

public class 최대공약수와최소공배수 {
    public int[] solution(int n, int m) {
        int gcd = BigInteger.valueOf(n).gcd(BigInteger.valueOf(m)).intValue();
        int lcm = n * m / gcd;
        return new int[]{gcd, lcm};
    }
}
