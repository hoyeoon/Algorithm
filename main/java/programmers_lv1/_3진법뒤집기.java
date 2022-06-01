package programmers_lv1;

public class _3진법뒤집기 {
    public int solution(int n) {
        String reversedTernary = getReversedTernary(n);
        return Integer.parseInt(reversedTernary, 3);
    }

    // 3진법 구하기
    String getReversedTernary(int n){
        StringBuilder sb = new StringBuilder();

        while(n > 0){
            sb.append(n % 3);
            n /= 3;
        }

        return sb.toString();
    }
}
