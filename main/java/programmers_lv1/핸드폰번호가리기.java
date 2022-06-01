package programmers_lv1;

public class 핸드폰번호가리기 {
    public String solution(String phone_number) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int idx = phone_number.length() - 4;

        for(int i = 0; i < idx; i++){
            sb.append("*");
        }

        answer = sb.toString() + phone_number.substring(idx);

        return answer;
    }
}
