import java.util.HashMap;
import java.util.Map;

public class Lv1_nogoalparticipant {
	public static String solution(String[] participant, String[] completion) {
		/*
		String answer = "";
		Arrays.sort(participant);
		Arrays.sort(completion);

		for (int i = 0 ; i < completion.length; i++) {
			if (!participant[i].equals(completion[i]) ) {
				answer = participant[i];
				return answer;
			}
		}
		
		answer += participant[participant.length - 1];
		return answer;
		*/
		String answer = "";
		Map<String, Integer> map = new HashMap<>();
		
		for (String str : participant) {
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		
		for (String str : completion) {
			map.put(str, map.get(str) -1);
		}
		
		for (String str : map.keySet()) {
			if (map.get(str) > 0) {
				answer += str;
				return answer;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		String answer = solution(participant, completion);
		System.out.println(answer);
	}
}
/*
 * ["leo", "kiki", "eden"]								["eden", "kiki"]							"leo"
 * ["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
 * ["mislav", "stanko", "mislav", "ana"]				["stanko", "ana", "mislav"]					"mislav"
 */
