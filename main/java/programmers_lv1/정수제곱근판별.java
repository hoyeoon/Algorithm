package programmers_lv1;

public class 정수제곱근판별 {
    public long solution(long n) {
        long answer = -1;

        if(Math.round(Math.sqrt(n)) == Math.sqrt(n)){
            answer = (long)Math.pow(Math.sqrt(n) + 1, 2);
        }

        return answer;
    }
}
