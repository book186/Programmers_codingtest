import java.util.Arrays;

public class Lv1_kstnum_12 {
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		int startNum = 0;
		int endNum = 0;
		int getNum = 0;
		
		for (int i = 0; i < commands.length; i++) {
			startNum = commands[i][0] - 1;
			endNum = commands[i][1] - 1;
			getNum = commands[i][2] - 1;
			
			System.out.println(startNum);
			System.out.println(endNum);
			System.out.println(getNum);
			System.out.println();
			int[] tmp = Arrays.copyOfRange(array, startNum, endNum + 1);
			Arrays.sort(tmp);
			answer[i] = tmp[getNum];
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] command = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		int[] answer = solution(array, command);
		System.out.println(Arrays.toString(answer));
	}
}
/*
 * [1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
*/
/*
 * 예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

 * array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
 * 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
 * 2에서 나온 배열의 3번째 숫자는 5입니다.
*/