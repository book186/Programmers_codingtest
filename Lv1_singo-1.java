import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/*
1. id_list를 HashMap<String, Integer> idList에 담기 : id, cnt
2. report를 HashMap<String, HashSet<String>> toReport에 담기 : id, 신고한사람
  (신고당한사람이 K, 신고한사람이 V로 들어가는데.. 신고한사람이 중복되면 안되기 때문에)
  (이때 report는 splie해서 넣어주기)
3. toReport의 key값만큼만 돌기
4. toReport의 K값 size가 k보다 크거나 같을경우에만 아래 진행
5. toReport의 V 신고한사람 만큼 for문 돌면서 탐색
6. Integer cnt에 idList의 V cnt값 받아서 +1 해주고 answer에 넣어서 리턴
*/
class Lv1_singo {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        
        Map<String, Integer> idList = new HashMap<>();
        Map<String, HashSet<String>> toReport = new HashMap<>();
        
        for (String str : id_list) {
            idList.put(str, 0);
            toReport.put(str, new HashSet<>());
        }
        
        for (String str : report) {
            String[] reportTmp = str.split(" ");
            toReport.get(reportTmp[1]).add(reportTmp[0]);
        }
        
        for (String str : toReport.keySet()) {
            if (toReport.get(str).size() >= k) {
                for(String str2 : toReport.get(str)) {
                    Integer cnt = idList.get(str2);
                    idList.put(str2, cnt + 1);
                }
            }
        }

        answer = new int [id_list.length];
        
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = idList.get(id_list[i]);
        }
        return answer;
    }
}
