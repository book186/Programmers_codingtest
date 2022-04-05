import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lv1_middletest_ko_mouigosa_13 {
	public static int[] solution(int[] answers) {
		int[] answer = {};
		
		List<Integer> maxScore = new ArrayList<Integer>();
		int[] one = {1,2,3,4,5};
		int[] two = {2,1,2,3,2,4,2,5};
		int[] three = {3,3,1,1,2,2,4,4,5,5};
		int oneCnt = 0;
		int twoCnt = 0;
		int threeCnt = 0;

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == one[i%5]) {
				oneCnt ++;
			} 
			if (answers[i] == two[i%8]) {
				twoCnt ++;
			}
			if (answers[i] == three[i%10]) {
				threeCnt ++;
			}
		}
		
		int max = Math.max(oneCnt, Math.max(twoCnt, threeCnt));
		
		if (oneCnt == max) {
			maxScore.add(1);
		}
		if (twoCnt == max) {
			maxScore.add(2);
		}
		if (threeCnt == max) {
			maxScore.add(3);
		}
		
		answer = new int[maxScore.size()];
		
		for (int i = 0; i < answer.length; i++) {
			answer[i] = maxScore.get(i);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] answers = {1,3,2,4,2,1,2,3,5,2,4,2,5,4,2,3,2,4,5,2,1,2,3,2,4,1,2};
		int[] answer = solution(answers);
		System.out.println(Arrays.toString(answer));
	}
}
/*
 * [1,2,3,4,5]	[1]
 * [1,3,2,4,2]	[1,2,3]
 * 
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * >> 12345
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * >> 21232425
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 * >> 3311224455
 */