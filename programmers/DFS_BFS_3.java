package programmers;

// 단어 변환
import java.util.*;

class Solution {
    static class Info{
        String word;
        int depth;
        
        public Info(String word, int depth){
            this.word = word;
            this.depth = depth;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean isExist = Arrays.stream(words).anyMatch(target::equals);
        int N = words.length;
        
        Queue<Info> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        
        if(isExist){
            q.offer(new Info(begin, 0));
            
            while(!q.isEmpty()){
                Info info = q.poll();
                String currWord = info.word;
                int depth = info.depth;
                
                if(currWord.equals(target)) {
                    answer = depth;
                    break;   
                }
                
                for(int i = 0; i < words.length; i++){
                    if(!visited[i] && diffCnt(currWord, words[i])){
                        visited[i] = true;
                        q.offer(new Info(words[i], depth + 1));
                    }
                }
            }
        }
        return answer;
    }
    
    private static boolean diffCnt(String a, String b){
        int cnt = 0;
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        
        for(int i = 0; i < arrA.length; i++){
            if(arrA[i] != arrB[i]) cnt++;
        }
        if(cnt == 1) return true;
        return false;
    }
}