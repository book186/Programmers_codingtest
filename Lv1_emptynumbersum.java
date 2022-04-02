
public class Lv1_emptynumbersum {
	public static int solution(int[] numbers) {
		int answer = 0;
		int zerotonine = 0;
		
		for (int i = 0; i <= 9; i++) {
			zerotonine += i;
		}
		
		for (int i : numbers) {
			answer += i;
		}
		
		answer = zerotonine - answer;
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,6,7,8,0};
		
		int answer = solution(numbers);
		System.out.println(answer);
	}
}
/*
 * [1,2,3,4,6,7,8,0]	14
 * [5,8,4,0,6,7,9]		6
*/