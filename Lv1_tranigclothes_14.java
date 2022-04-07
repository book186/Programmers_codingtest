import java.util.*;

public class Lv1_tranigclothes_14 {
	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		Set<Integer> lostSet = new HashSet<>();
		Set<Integer> reserveSet = new HashSet<>();
		
		for (int i : lost) {
			lostSet.add(i);
		}
		
		for (int i : reserve) {
			reserveSet.add(i);
			if(lostSet.contains(i)) {
				lostSet.remove(i);
				reserveSet.remove(i);
			}
		}
		
		for (int i : reserveSet) {
			if (lostSet.contains(i - 1)) {
				lostSet.remove(i - 1);
			} else if (lostSet.contains(i + 1)) {
				lostSet.remove(i + 1);
			}
		}
		
		answer = n - lostSet.size();
		
		return answer;
	}
	public static void main(String[] args) {
		//int n = 30;
		//int[] lost = {11,12,3,4,5,6,7,8}; // 8
		//int[] reserve = {11,12,13}; // 3
		
		//int n = 30;
		//int[] lost = {11,12,13}; // 3
		//int[] reserve = {11,12,3,4,5,6,7,8}; // 8
		
		//int n = 30;
		//int[] lost = {11,12,13}; // 3
		//int[] reserve = {11,12,13,14}; // 3
		
		int n = 5;
		int[] lost = {2,4}; // 2
		int[] reserve = {1,3,5}; // 3
		int answer = solution(n, lost, reserve);
		System.out.println(answer);
	}
}
/* 
 * 0) n = lost.length + reserve.lenght ->> answer = n 
 * 1) 총 5명 중에 여유분 없는 학생 : n - reserve.length - lost.length
 * 2) 여유분 학생 (reserve.length) - 없는 학생 (lost.length)
 * 3) 1) + 2) + reserve.length
 *  
 * n     lost    reserve   return
 * 5	[2, 4]	[1, 3, 5]	5
 * 5	[2, 4]	[3]			4
 * 3	[3]		[1]			2
 * 3 - 1- 1 = 1
 * 1) 1 - 1 = 0
 * 1 + 1
 */