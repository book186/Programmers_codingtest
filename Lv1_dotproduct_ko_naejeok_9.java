
public class Lv1_dotproduct_ko_naejeok {
	public static int solution(int[] a, int[] b) {
		int answer = 0;
		
		for (int i = 0; i < a.length; i++) {
			answer += a[i] * b[i];
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		int[] b = {-3,-1,0,2};
		int aswer = solution(a, b);
		
		System.out.println(aswer);
	}
}
/*
 * [1,2,3,4]		[-3,-1,0,2]		3
 * a와 b의 내적은 1*(-3) + 2*(-1) + 3*0 + 4*2 = 3 입니다.
 * 
 * [-1,0,1]			[1,0,-1]		-2
 * a와 b의 내적은 (-1)*1 + 0*0 + 1*(-1) = -2 입니다.
 */
