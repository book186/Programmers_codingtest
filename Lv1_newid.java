/*
 * 1�ܰ� new_id�� ��� �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ�մϴ�.
 * 2�ܰ� new_id���� ���ĺ� �ҹ���, ����, ����(-), ����(_), ��ħǥ(.)�� ������ ��� ���ڸ� �����մϴ�.
 * 3�ܰ� new_id���� ��ħǥ(.)�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ(.)�� ġȯ�մϴ�.
 * 4�ܰ� new_id���� ��ħǥ(.)�� ó���̳� ���� ��ġ�Ѵٸ� �����մϴ�.
 * 5�ܰ� new_id�� �� ���ڿ��̶��, new_id�� "a"�� �����մϴ�.
 * 6�ܰ� new_id�� ���̰� 16�� �̻��̸�, new_id�� ù 15���� ���ڸ� ������ ������ ���ڵ��� ��� �����մϴ�.
 *		���� ���� �� ��ħǥ(.)�� new_id�� ���� ��ġ�Ѵٸ� ���� ��ġ�� ��ħǥ(.) ���ڸ� �����մϴ�.
 * 7�ܰ� new_id�� ���̰� 2�� ���϶��, new_id�� ������ ���ڸ� new_id�� ���̰� 3�� �� ������ �ݺ��ؼ� ���� ���Դϴ�.
 */
public class Lv1_newid {
	public static String solution(String new_id) {
		String answer = new_id.toLowerCase(); // 1�ܰ� �� �ҹ��ڷ�
		answer = answer.replaceAll("[^a-z0-9-_.]", "");
		answer = answer.replaceAll("[.]{2,}", ".");
		
		if (answer.startsWith(".")) {
			answer = answer.substring(1 , answer.length());
		}
		
		if (answer.endsWith(".")) {
			answer = answer.substring(0, answer.length()-1);
		}
		
		if (answer.length() == 0) {
			answer += "a";
		}
		
		if (answer.length() >= 16) {
			answer = answer.substring(0, 15);
		}
		
		if (answer.endsWith(".") ) {
			answer = answer.substring(0, answer.length()-1);
		}
		
		if (answer.length() == 2) {
			answer += answer.charAt(answer.length()-1);
		} else if (answer.length() == 1) {
			for (int i = 0; i < 2; i++) {
				answer += answer.charAt(answer.length()-1);
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		String answer = solution("=.=");
		
		System.out.println(answer);
	}
}
/*
��1	"...!@BaT#*..y.abcdefghijklm"	"bat.y.abcdefghi"
��2	"z-+.^."						"z--"
��3	"=.="							"aaa"
��4	"123_.def"						"123_.def"
��5	"abcdefghijklmn.p"				"abcdefghijklmn"
*/