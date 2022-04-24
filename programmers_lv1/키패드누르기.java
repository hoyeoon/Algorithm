package programmers_lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class 키패드누르기 {
    int calDist(int[] pos1, int[] pos2) {
        return Math.abs(pos1[0] - pos2[0]) +  Math.abs(pos1[1] - pos2[1]);
    }
    
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int l_thumb = 10;
        int r_thumb = 11;
        int[][] pos = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, 
                      {1, 0}, {1, 1}, {1, 2},
                      {2, 0}, {2, 1}, {2, 2},
                      {3, 0}, {3, 2}};
        
        List<Integer> left = new ArrayList<>(Arrays.asList(1, 4, 7));
        List<Integer> right = new ArrayList<>(Arrays.asList(3, 6, 9));
        
        System.out.print(l_thumb + ", " + r_thumb + ", ");
        
        for(int i = 0; i < numbers.length; i++){
            System.out.print(l_thumb + ", " + r_thumb + ", ");
            if(left.contains(numbers[i])){
                sb.append("L");
                l_thumb = numbers[i];
            } else if(right.contains(numbers[i])){
                sb.append("R");
                r_thumb = numbers[i];
            } else{
                int l_dist = calDist(pos[l_thumb], pos[numbers[i]]);
                int r_dist = calDist(pos[r_thumb], pos[numbers[i]]);
                
                if(l_dist < r_dist){
                    sb.append("L");
                    l_thumb = numbers[i];
                } else if(l_dist > r_dist){
                    sb.append("R");
                    r_thumb = numbers[i];
                } else{
                    if(hand.equals("right")){
                        sb.append("R");
                        r_thumb = numbers[i];
                    } 
                    else{
                        sb.append("L");
                        l_thumb = numbers[i];
                    }
                }
            }
            System.out.println(numbers[i] + ", " + sb.charAt(sb.length() - 1));
        }
        
        return sb.toString();
    }
}