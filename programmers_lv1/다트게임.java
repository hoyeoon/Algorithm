package programmers_lv1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 다트게임 {
    public int solution(String dartResult) {
        Stack<Integer> stack = new Stack<>();
        List<Object> list = new ArrayList<>();
        String[] str = dartResult.split("");
        String tempScore = "";

        // 점수, 보너스, 옵션 구분하여 list에 담기
        for(int i = 0; i < str.length - 1; i++){
            if(Character.isDigit(str[i].charAt(0))){
                tempScore += str[i];
            }else{
                if(!tempScore.equals("")){
                    list.add(tempScore);
                    tempScore = "";
                }
                list.add(str[i]);
            }
        }
        if(!tempScore.equals("")){
            list.add(tempScore);
        }
        list.add(str[str.length - 1]);

        System.out.println(list);

        // 계산
        for(Object o : list){
            if(o.equals("S")){
            } else if(o.equals("D")){
                stack.push((int)Math.pow(stack.pop(), 2));
            } else if(o.equals("T")){
                stack.push((int)Math.pow(stack.pop(), 3));
            } else if(o.equals("*")){
                if(stack.size() >= 2){
                    int recentValue1 = stack.pop();
                    int recentValue2 = stack.pop();
                    stack.push(recentValue2 * 2);
                    stack.push(recentValue1 * 2);
                }else{
                    stack.push(stack.pop() * 2);
                }
            } else if(o.equals("#")){
                stack.push(stack.pop() * -1);
            } else{
                int score = Integer.valueOf((String) o);
                stack.push(score);
            }
        }
        int sum = stack.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        return sum;
    }
}
