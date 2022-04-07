import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lv1_failurerate_16 {
	public static int[] solution(int N, int[] stages) {
		int[] answer = {};
		Map<Integer, Integer> values = new HashMap<>();
		Map<Integer, Double> answertmp = new HashMap<>();
		int userCnt = stages.length;
		
		Arrays.sort(stages);
		System.out.println(Arrays.toString(stages));
		
		for (int i = 0; i < stages.length; i++) {
			values.put(stages[i], values.getOrDefault(stages[i], 0) + 1);
		}
		values.remove(N+1);
		
		for (int i : values.keySet()) {
			System.out.println("스테이지 : " + i + ", 갯수 : " + values.get(i));
			answertmp.put(i, (double) values.get(i) / userCnt);
			userCnt -= values.get(i);
		}
		
		for (int i = 1; i <= N; i++) {
			answertmp.put(i, answertmp.getOrDefault(i, 0.0));
		}
		
		for (int i : answertmp.keySet()) {
			System.out.println("스테이지 : " + i + " 실패율 : " + answertmp.get(i));
		}
		
		List<Integer> answerList = new ArrayList<>(answertmp.keySet());
		Collections.sort(answerList, (o1, o2) -> (answertmp.get(o2).compareTo(answertmp.get(o1))));
		
		answer = answerList.stream().mapToInt(i -> i).toArray();
		
		return answer;
	}
	
	public static void main(String[] args) {
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		int[] answer = solution(N, stages);
		System.out.println(Arrays.toString(answer));
	}
}

/*
 * N	stages						result
 * 5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
 * 4	[4,4,4,4,4]					[4,1,2,3]
 * 
 * 실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
 * 
 * stages를 먼저 오름차순으로 정렬
 * 1. stages에서 가장 작은 숫자의 갯수 / stages.length
 * 2. 그다음 작은 숫자 갯수 / 1번의 stages.length - 가장 작은 숫자의 개수
 * 3. 그 다음 작은 숫자 갯수 / 2번의 분모 - 분자
 * ...
 * 4. stages에서 가장 작은 숫자의 갯수 / stages.length == 1 이면 해당 stages가 answer 배열 0번에 들어가고 1,2,3...은 0번 배열값보다 낮은 숫자 오름차순
 */