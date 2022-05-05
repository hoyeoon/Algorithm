package programmers_lv1;

import java.util.stream.IntStream;

public class _2016년 {
    int i = 1;

    public String solution(int a, int b) {
        String[] yoil = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int[] month_group1 = {1, 3, 5, 7, 8, 10, 12};   // 31일
        int[] month_group2 = {4, 6, 9, 11}; // 30일
        int total_day = b;

        while(i <= a - 1){
            if(IntStream.of(month_group1).anyMatch(month -> month == i)){
                total_day += 31;
            } else if(IntStream.of(month_group2).anyMatch(month -> month == i)){
                total_day += 30;
            } else{
                total_day += 29;
            }
            i++;
        }
        System.out.println(total_day);

        return yoil[total_day % 7];
    }
}
