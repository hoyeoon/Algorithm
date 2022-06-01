package programmers_lv2;

import java.util.Arrays;

public class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int n = people.length - 1;
        int r = n;
        Arrays.sort(people);
        // System.out.println(Arrays.toString(people));

        for(int l = 0; l <= n; l++){
            int weight = people[l];

            while(l < r){
                if(weight + people[r] <= limit){
                    answer++;
                    r--;
                    break;
                }
                r--;
            }
        }

        return people.length - answer;
    }
}
