import java.util.*;

public class Lv1_phoneketmon_15 {
	public static int solution(int[] nums) {
		int answer = 0;
		int getMonster = nums.length / 2;
		Set<Integer> monsterCnt = new HashSet<>();
		
		for (int i : nums) {
			monsterCnt.add(i);
		}
		
		if (getMonster <= monsterCnt.size()) {
			answer = getMonster;
		} else if (getMonster > monsterCnt.size()) {
			answer = monsterCnt.size();
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] num = {3,3,3,2,2,2};
		int answer = solution(num);
		System.out.println(answer);
	}
}
/*
 * nums				result
 * [3,1,2,3]		2
 * [3,3,3,2,2,4]	3
 * [3,3,3,2,2,2]	2
 * 
 * 총 가져갈수있는 몬스터 수(ex. result) = nums.lengt / 2;
 * nums를 HashSet에 넣어서 중복 제거한 후
 * HashSet의 사이즈를 변수에 담은다음에 (ex.monsterCnt)
 * result <= monsterCnt >> answer = result 
 * result > monsterCnt >> answer = monsterCnt
 */
