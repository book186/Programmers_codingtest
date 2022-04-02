/*
 * 		  1		 2		3
 * 		  4		 5		6
 * 		  7		 8		9
 * 		  10	 11		12
 * 
 * 		[0][0] [0][1] [0][2]
 * 		[1][0] [1][1] [1][2]
 *		[2][0] [2][1] [2][2]
 *		[3][0] [3][1] [3][2]
 *		x = i/3  
 *		i%3=1 -> y=0
 *		i%3=2 -> y=1
 *		i%3=0 -> y=2
 */
/*
 * [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	"right"		"LRLLLRLLRRL"
 * [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	"left"		"LRLLRRLLLRR"
 * l 20 20 21 01 01 
 * r 32 31 31 31 21
 * [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]		"right"		"LLRLLRLLRL"
 */
public class Lv1_keypad {
	public static String solution(int[] numbers, String hand) {
		String answer = "";
		int leftX = 3;
		int leftY = 0;
		int rightX = 3;
		int rightY = 2;
		int centerX = 3;
		int centerY = 1;
		
		for (int i : numbers) {
			if (i == 1 || i == 4 || i ==7) {
				answer += "L";
				leftX = i / 3;
				leftY = 0;
			} else if (i == 3 || i == 6 || i == 9) {
				answer += "R";
				rightX = (i / 3) - 1;
				rightY = 2;
			} else { // i == 2, 5, 6, 8, 11(0)
				if (i == 0 ) {
					i = 11;
				}
				
				centerX = i / 3;
				centerY = 1;
				int leftLength = Math.abs(centerX - leftX) + Math.abs(centerY - leftY);
				int rightLength = Math.abs(centerX - rightX) + Math.abs(centerY - rightY);
				if (leftLength == rightLength) {
					if (i == 11) {
						i = 0;
					}
					
					if ("right".equals(hand)) {
						answer += "R";
						rightX = centerX;
						rightY = centerY;
					} else {
						answer += "L";
						leftX = centerX;
						leftY = centerY;
					}
				} else if (leftLength > rightLength) {
					if (i == 11) {
						i = 0;
					}
					
					answer += "R";
					rightX = centerX;
					rightY = centerY;
				} else if (leftLength < rightLength) {
					if (i == 11) {
						i = 0;
					}
					
					answer += "L";
					leftX = centerX;
					leftY = centerY;
				}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		
		String answer = solution(numbers, hand);
		
		System.out.println(answer);
	}
}


/*
 * 1. 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
 * 2. 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
 * 3. 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
 * 4. 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
 * 4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
*/
