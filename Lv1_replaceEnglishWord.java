import java.util.ArrayList;
import java.util.List;

public class Lv1_replaceEnglishWord {

	public static int solution(String s) {
		int answer = 0;
		
		String[] word = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nint"};
		
		for (int i = 0; i < 10; i++) {
			s = s.replaceAll(word[i], Integer.toString(i));
		}
		answer = Integer.parseInt(s);
		
		return answer;
	}
	
	public static void main(String[] args) {
		String s = "one4seveneight";
		int answer = solution(s);
		
		System.out.println(answer);
	}
}
/*
 * "one4seveneight"		1478
 * "23four5six7"		234567
 * "2three45sixseven"	234567
 * "123"				123
 */
