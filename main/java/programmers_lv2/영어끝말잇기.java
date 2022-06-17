package programmers_lv2;

public class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        for(int i = 1; i < words.length; i++){
            if(isNotSameLastWord(words[i - 1], words[i]) || isReduplicateWord(words, i, words[i])){
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
        }
        return answer;
    }

    private boolean isNotSameLastWord(String before_word, String word){
        return before_word.charAt(before_word.length() - 1) != word.charAt(0) ? true : false;
    }

    private boolean isReduplicateWord(String[] words, int idx, String word){
        for(int i = 0; i < idx; i++){
            if(word.equals(words[i])) return true;
        }
        return false;
    }
}
