package programmers_lv1;

public class 소수찾기 {
    public int solution(int n) {
        int answer = -1;

        for(int i = 1; i <= n; i++){
            if(isPrime(i)){
                answer++;
            }
        }

        return answer;
    }

    boolean isPrime(int num){
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
