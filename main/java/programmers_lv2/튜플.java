package programmers_lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 튜플 {
    public int[] solution(String s) {
        List<List<String>> set = makeSet(s);
        Collections.sort(set, (s1, s2) -> s2.size() - s1.size());
        int[] answer = makeAnswer(set);

        return answer;
    }

    private List<List<String>> makeSet(String s){

        int start = 0;
        List<List<String>> set = new ArrayList<>();
        List<String> tuple = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < s.length() - 1; i++){
            if(s.charAt(i) == '{') {
                start = 1;
                sb.setLength(0);
                continue;
            }
            if(s.charAt(i) == '}') {
                start = 0;
                tuple = new ArrayList<>(Arrays.asList(sb.toString().split(",")));
                set.add(tuple);
                continue;
            }
            if(start == 1){
                sb.append(s.charAt(i));
            }
        }
        return set;
    }

    private int[] makeAnswer(List<List<String>> set){
        int size = set.size();
        int[] answer = new int[size];

        for(int i = 0; i < size - 1; i++){
            set.get(i).removeAll(set.get(i + 1));
            answer[size - 1 - i] = Integer.parseInt(set.get(i).get(0));
        }
        answer[0] = Integer.parseInt(set.get(size - 1).get(0));

        return answer;
    }
}
