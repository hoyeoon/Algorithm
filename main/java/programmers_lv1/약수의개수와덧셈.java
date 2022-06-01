package programmers_lv1;

public class 약수의개수와덧셈 {
    public int solution(int left, int right) {
        int answer = 0;

        for(int i = left; i <= right; i++){
            if(divisor(i) % 2 == 0){
                answer += i;
            } else{
                answer -= i;
            }
        }
        return answer;
    }

    int divisor(int num) {
        int count = 0;

        for(int i = 1; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                count++;

                if(num != i * i) count++;
            }
        }

        return count;
    }
}
