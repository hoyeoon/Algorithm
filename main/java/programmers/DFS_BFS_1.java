package programmers;

import java.util.*;

// 타겟 넘버
public class DFS_BFS_1 {
	 public int solution(int[] numbers, int target) {
	        int answer = 0;
	        Queue<int[]> q = new LinkedList<>();
	        q.offer(new int[]{-numbers[0], 0});
	        q.offer(new int[]{numbers[0], 0});
	        
	        int n = numbers.length;
	        while(!q.isEmpty()){
	            int[] v = q.poll();
	            int value = v[0];
	            int idx = v[1];
	            idx++;
	            
	            if(idx < n){
	                q.offer(new int[]{value - numbers[idx], idx});
	                q.offer(new int[]{value + numbers[idx], idx});
	            }else{
	                if(target == value){
	                    answer++;
	                }
	            }
	        }
	        return answer;
	   }
}
