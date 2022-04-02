
public class Lv1_sosu {
	public static int solution(int[] nums) {
		int answer = 0;
		int sosu = 0;
		
		for (int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				for(int q = j + 1; q < nums.length; q++) {
					sosu = nums[i] + nums[j] + nums[q];
					
					if (check(sosu)) {
						answer += 1;
					}
				}
			}
		}
		
		return answer;
	}
	
	private static boolean check(int sosu) {
		for (int i = 2; i <= Math.sqrt(sosu); i++) {
			if (sosu % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		int answer = solution(nums);
		System.out.println(answer);
	}
}
/*
 * [1,2,3,4]		1
 * [1,2,7,6,4]		4
 */
