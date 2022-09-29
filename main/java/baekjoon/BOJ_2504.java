package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2504 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int value = 1;

        for(int i = 0; i < arr.length; i++) {
            if('(' == arr[i]) {
                stack.push(arr[i]);
                value *= 2;
            } else if('[' == arr[i]) {
                stack.push(arr[i]);
                value *= 3;
            } else if(')' == arr[i]) {
                if(stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                } else if(arr[i - 1] == '(') {
                    result += value;
                }
                stack.pop();
                value /= 2;
            } else if(']' == arr[i]) {
                if(stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                } else if(arr[i - 1] == '[') {
                    result += value;
                }
                stack.pop();
                value /= 3;
            }
        }

        if(!stack.isEmpty()) {
            result = 0;
        }

        System.out.println(result);
    }
}
