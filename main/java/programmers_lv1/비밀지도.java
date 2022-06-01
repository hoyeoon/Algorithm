package programmers_lv1;

public class 비밀지도 {
    int N;

    public String[] solution(int n, int[] arr1, int[] arr2) {
        N = arr1.length;
        String[] answer = new String[N];

        for(int i = 0; i < N; i++){
            answer[i] = makeBinary(arr1[i] | arr2[i]);
        }

        return answer;
    }

    String makeBinary(int n){
        StringBuilder sb = new StringBuilder();

        while(n > 0){
            if(n % 2 == 1){
                sb.append("#");
            }else{
                sb.append(" ");
            }
            n /= 2;
        }

        int len = sb.length();
        if(len != N){
            for(int i = 0; i < N - len; i++){
                sb.append(" ");
            }
        }

        return sb.reverse().toString();
    }
}
