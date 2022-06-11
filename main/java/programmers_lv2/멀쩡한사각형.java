package programmers_lv2;

public class 멀쩡한사각형 {
    public long solution(long w, long h) {
        long gcd = gcd(w, h);
        long unit_w = w / gcd;
        long unit_h = h / gcd;

        return w * h - unit_w * unit_h * gcd + countPossible(unit_w, unit_h) * gcd;
    }

    private long countPossible(long w, long h){
        return (w - 1) * (h - 1);
    }

    private long gcd(long w, long h){
        while(h != 0){
            long temp = w % h;
            w = h;
            h = temp;
        }

        return Math.abs(w);
    }
}
