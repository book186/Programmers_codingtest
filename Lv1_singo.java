import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/*
1. id_list�� HashMap<String, Integer> idList�� ��� : id, cnt
2. report�� HashMap<String, HashSet<String>> toReport�� ��� : id, �Ű��ѻ��
  (�Ű���ѻ���� K, �Ű��ѻ���� V�� ���µ�.. �Ű��ѻ���� �ߺ��Ǹ� �ȵǱ� ������)
  (�̶� report�� splie�ؼ� �־��ֱ�)
3. toReport�� key����ŭ�� ����
4. toReport�� K�� size�� k���� ũ�ų� ������쿡�� �Ʒ� ����
5. toReport�� V �Ű��ѻ�� ��ŭ for�� ���鼭 Ž��
6. Integer cnt�� idList�� V cnt�� �޾Ƽ� +1 ���ְ� answer�� �־ ����
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