package programmers_lv2;

public class 숫자의표현 {
    public int solution(int n) {
        int answer = 0;

        for(int i = 1; i <= n; i++){
            int sum = 0;

            for(int j = i; j <= n; j++){
                sum += j;
                if(sum > n) break;
                else if(sum == n) {
                    System.out.println(j);
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
