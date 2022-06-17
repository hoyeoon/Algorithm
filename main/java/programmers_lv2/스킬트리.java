package programmers_lv2;

public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        outer : for(String skill_tree : skill_trees){
            int curr_idx = 0;

            for(int i = 0; i < skill_tree.length(); i++){
                int idx = skill.indexOf(skill_tree.charAt(i));

                if(idx == -1) continue;

                if(curr_idx < idx){
                    continue outer;
                } else{
                    curr_idx++;
                }
            }
            answer++;
        }
        return answer;
    }
}
