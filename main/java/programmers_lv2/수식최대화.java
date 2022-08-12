package programmers_lv2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 수식최대화 {
    List<String> expressionList;
    Set<String> operatorSet = new HashSet<>();
    List<String> operatorList;
    boolean[] visited;
    String[] operatorArr;
    int n;
    long result = Long.MIN_VALUE;

    public long solution(String expression) {
        expressionList = makeExpressionList(expression);
        operatorList = new ArrayList<>(operatorSet);
        n = operatorList.size();
        visited = new boolean[n];
        operatorArr = new String[n];
        perm(0, n, n);

        return result;
    }

    private void perm(int depth, int n, int r){
        if(depth == r){
            List<String> list = deepCopy(expressionList);

            for(String operator : operatorArr){
                int i = 1;

                while(list.size() != i){
                    //System.out.println("list.size() = " + list.size() + ", " + "i = " + i);
                    // 우선순위 연산자인 경우
                    if(list.get(i).equals(operator)){
                        long result = 0;

                        if(operator.equals("*")){
                            result = Long.parseLong(list.get(i - 1)) * Long.parseLong(list.get(i + 1));
                        } else if(operator.equals("+")){
                            result = Long.parseLong(list.get(i - 1)) + Long.parseLong(list.get(i + 1));
                        } else if(operator.equals("-")){
                            result = Long.parseLong(list.get(i - 1)) - Long.parseLong(list.get(i + 1));
                        }

                        for(int j = 0; j < 2; j++){
                            list.remove(i - 1);
                        }
                        list.set(i - 1, String.valueOf(result));
                    }
                    // 우선순위가 연산자가 아닐때
                    else{
                        i += 2;
                    }
                }
            }
            result = Math.max(result, Math.abs(Long.parseLong(list.get(0))));
            return;
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                operatorArr[depth] = operatorList.get(i);
                perm(depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    private List<String> deepCopy(List<String> originList){
        List<String> newList = new ArrayList<>();

        for(int i = 0; i < originList.size(); i++){
            newList.add(originList.get(i));
        }

        return newList;
    }

    private void addOperator(String operator){
        operatorSet.add(operator);
    }

    private List<String> makeExpressionList(String expression){
        List<String> list = new ArrayList<>();
        String op = "";

        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '*' || expression.charAt(i) == '+' || expression.charAt(i) == '-'){
                addOperator(String.valueOf(expression.charAt(i)));
                list.add(op);
                op = "";
                list.add(String.valueOf(expression.charAt(i)));
                continue;
            }
            op += expression.charAt(i);
        }
        list.add(op);

        return list;
    }
}
