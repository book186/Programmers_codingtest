import java.util.ArrayList;
import java.util.List;

public class Lv1_positivenegativeplus {
	public static int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;
		List<Integer> inputNum = new ArrayList<>();
		List<Boolean> inputTF = new ArrayList<>();
		
		for (int i : absolutes) {
			inputNum.add(i);
		}
		
		for (boolean i : signs) {
			inputTF.add(i);
		}
		
		for (int i = 0; i < absolutes.length; i++) {
			if (!inputTF.get(i)) {
				answer = answer - inputNum.get(i);
			} else {
				answer += inputNum.get(i);
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] absolutes = {4, 7, 12};
		boolean[] signs = {true, false, true};
		int answer = solution(absolutes, signs);
		System.out.println(answer);
	}
}

/*
 * [4,7,12]		[true,false,true]		9
 * [1,2,3]		[false,false,true]		0
 */
