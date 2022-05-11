package programmers_lv2;

public class N개의최소공배수 {
    public int solution(int[] arr) {
        int lcm = arr[0];

        for(int i = 1; i < arr.length; i++){
            int gcd = gcd(arr[i], lcm);
            lcm = lcm * arr[i] / gcd;
        }

        return lcm;
    }

    int gcd(int num1, int num2){
        int x = Math.max(num1, num2);
        int y = Math.min(num1, num2);

        while(x % y != 0){
            int r = x % y;
            x = y;
            y = r;
        }
        return y;
    }
}
