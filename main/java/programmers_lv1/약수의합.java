package programmers_lv1;

public class 약수의합 {
    int answer = 0;

    public int solution(int n) {
        function(n);

        return answer;
    }

    void function(int n){
        for(int i = 1; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                answer += i;

                if(n != i * i){
                    answer += n / i;
                }
            }
        }
    }
}
