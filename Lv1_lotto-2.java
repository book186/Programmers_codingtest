import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Lv1_lotto {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        
        List<Integer> myNum = new ArrayList<>();
		Set<Integer> winNum = new HashSet<>();
		int zeroCnt = 0;
		int winCnt = 0;
		int min = 0;
		int max = 0;
		int minResult = 0;
		int maxResult = 0;
		
		for (int n : lottos) {
			myNum.add(n);
		}
		
		for (int n : win_nums) {
			winNum.add(n);
		}
		
		for (int i = 0; i < myNum.size(); i++) {
			if (winNum.contains(myNum.get(i))) {
				winCnt++;
			}
			if (myNum.get(i) == 0) {
				zeroCnt++;
			}
		}
		
		min = winCnt;
		max = winCnt + zeroCnt;
		
		if (min == 6) {
			minResult = 1;
		} else if (min == 5) {
			minResult = 2;
		} else if (min == 4) {
			minResult = 3;
		} else if (min == 3) {
			minResult = 4;
		} else if (min == 2) {
			minResult = 5;
		} else {
			minResult = 6;
		}
		
		if (max == 6) {
			maxResult = 1;
		} else if (max == 5) {
			maxResult = 2;
		} else if (max == 4) {
			maxResult = 3;
		} else if (max == 3) {
			maxResult = 4;
		} else if (max == 2) {
			maxResult = 5;
		} else {
			maxResult = 6;
		}
		
		answer = new int[2];
		
		answer[0] = maxResult;
		answer[1] = minResult;
        
        return answer;
    }
}
