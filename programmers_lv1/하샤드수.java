package programmers_lv1;

public class 하샤드수 {
    public boolean solution(int x) {
        int arr = x;
        int sum = 0;

        while(x > 0){
            sum += x % 10;
            x /= 10;
        }

        return arr % sum == 0 ? true : false;
    }
}
