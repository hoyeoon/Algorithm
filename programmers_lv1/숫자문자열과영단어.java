package programmers_lv1;

public class 숫자문자열과영단어 {
	public int solution(String s) {
        String[] eng = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        
        for(int i = 0; i < 10; i++){
            s = s.replaceAll(eng[i], num[i]);
        }
        System.out.println(s);
        
        return Integer.parseInt(s);
    }
}
