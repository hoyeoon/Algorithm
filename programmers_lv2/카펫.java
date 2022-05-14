package programmers_lv2;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int longValue = brown / 2 - 1;
        int shortValue = 1;

        while(true){
            if((longValue - 2) * shortValue == yellow){
                answer[0] = longValue;
                answer[1] = shortValue + 2;
                break;
            }
            longValue--;
            shortValue++;
        }

        return answer;
    }
}
