package programmers_lv1;

public class 콜라드추측 {
    public int solution(int num) {
        long n = num;   // int 타입 num으로 하면 overflow 발생
        int count = 0;

            while(n != 1){
            System.out.print(n + ",");
            if(count > 500) break;

            if(n % 2 == 0) {
                n /= 2;
            } else{
                n = n * 3 + 1;
            }
            count++;
        }

            return n == 1 ? count : -1;
    }
}
