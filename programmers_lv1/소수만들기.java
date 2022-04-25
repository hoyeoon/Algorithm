package programmers_lv1;

public class 소수만들기 {
	int answer = 0;
    int[] arr;
    boolean[] visited;
    
    boolean isPrime(int n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    
    
    void combination(int start, int n, int r){
        if(r == 0){
            int sum = 0;
            for(int i = 0; i < arr.length; i++){
                if(visited[i]) sum += arr[i];
            }
            
            if(isPrime(sum)) answer++;
            
            return;
        }
        
        for(int i = start; i < n; i++){
            visited[i] = true;
            combination(i + 1, n, r - 1);
            visited[i] = false;
        }
    }
    
    public int solution(int[] nums) {
        arr = nums;
        int n = arr.length;
        visited = new boolean[n];
        
        combination(0, n, 3);

        return answer;
    }
}
