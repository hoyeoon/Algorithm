package programmers_lv2;

public class 피로도 {
    int n;
    boolean[] visited;
    int[][] dungeons;
    int[] input, output;
    int answer = -1;
    int k;

    public int solution(int k, int[][] dungeons) {
        this.n = dungeons.length;
        this.visited = new boolean[n];
        this.input = new int[n];
        this.output = new int[n];
        this.dungeons = dungeons;
        this.k = k;

        for(int i = 0; i < n; i++){
            input[i] = i;
        }

        perm(0, n, n);

        return answer;
    }

    int tiredSystem(int[] idx){
        int currTired = k;
        int cnt = 0;

        for(int i : idx){
            if(dungeons[i][0] > currTired) continue;
            currTired -= dungeons[i][1];
            cnt++;
        }

        return cnt;
    }

    void perm(int depth, int n, int r) {
        if(depth == r) {
            //System.out.println(Arrays.toString(output));
            answer = Math.max(answer, tiredSystem(output));
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = input[i];
                perm(depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
}
