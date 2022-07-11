package programmers_lv3;

import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {
    int answer = 0;
    int n = 0;
    int[][] computers;
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                bfs(i);
                answer++;
            }
        }

        return answer;
    }

    private void bfs(int x){
        visited[x] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(x);

        while(!q.isEmpty()){
            int i = q.poll();

            for(int j = 0; j < n; j++){

                if(i == j) continue;
                if(computers[i][j] != 1) continue;

                visited[j] = true;
                computers[i][j]++;
                q.add(j);
            }
        }
    }
}
