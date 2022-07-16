package programmers_lv3;
import java.util.*;

public class 단어변환 {
    int n, answer;
    String begin, target;
    String[] words;

    public int solution(String begin, String target, String[] words) {
        this.answer = Integer.MAX_VALUE;
        this.n = words.length;
        this.begin = begin;
        this.target = target;
        this.words = words;

        bfs();

        return answer != Integer.MAX_VALUE ? answer : 0;
    }

    private void bfs(){
        Queue<Info> q = new LinkedList<>();
        q.offer(new Info(begin, 0, new boolean[n]));

        while(!q.isEmpty()){
            Info info = q.poll();
            String word = info.getWord();
            int cnt = info.getCnt();
            boolean[] visited = info.getVisited();

            for(int i = 0; i < n; i++){
                if(visited[i]) continue;
                if(!isDiffOneWord(word, words[i])) continue;
                if(words[i].equals(target)) {
                    answer = Math.min(answer, cnt + 1);
                    break;
                }

                visited[i] = true;
                q.offer(new Info(words[i], cnt + 1, visited));
            }
        }
    }

    private boolean isDiffOneWord(String s1, String s2){
        int cnt = 0;

        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(cnt == 1) return false;
                cnt++;
            }
        }
        return cnt == 1 ? true : false;
    }
}

class Info{
    private String word;
    private int cnt;
    private boolean[] visited;

    public Info(String word, int cnt, boolean[] visited){
        this.word = word;
        this.cnt = cnt;
        this.visited= visited;
    }

    public String getWord(){
        return this.word;
    }

    public int getCnt(){
        return this.cnt;
    }

    public boolean[] getVisited(){
        return this.visited;
    }
}
