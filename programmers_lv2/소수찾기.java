package programmers_lv2;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
    boolean[] visited;
    String[] arr;
    Set<Integer> primeSet = new HashSet<>();

    public int solution(String numbers) {
        arr = numbers.split("");
        int n = numbers.length();

        for(int r = 1; r <= n; r++){
            visited = new boolean[n];
            perm(0, n, r, "");
        }
        System.out.println(primeSet);
        return primeSet.size();
    }

    boolean isPrime(int num){
        if(num == 0 || num == 1) return false;

        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    void perm(int depth, int n, int r, String result){

        if(depth == r){
            // System.out.println(Arrays.toString(visited));
            // System.out.println(result);
            if(isPrime(Integer.parseInt(result))) primeSet.add(Integer.parseInt(result));
            return;
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                result += arr[i];
                perm(depth + 1, n, r, result);
                visited[i] = false;
                result = result.substring(0, result.length() - 1);
            }
        }
    }
}
