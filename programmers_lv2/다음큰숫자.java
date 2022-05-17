package programmers_lv2;

public class 다음큰숫자 {
    public int solution(int n) {
        int answer = 0;
        int targetOneCount = getOneCount(n);

        for(int i = n + 1; i <= 1000000; i++){
            if(targetOneCount == getOneCount(i)){
                answer = i;
                break;
            }
        }

        return answer;
    }

    int getOneCount(int n){
        int count = 0;

        while(n > 0){
            count += n % 2;
            n /= 2;
        }

        return count;
    }
}
