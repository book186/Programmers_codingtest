import java.util.Stack;

/*
 * [1,5,3,5,1,2,1,4]
 * 0 ,4, 2, 4, 0, 1, 0, 3
 * 
 * [0,0,0,0,0]
 * [0,0,1,0,3]
 * [0,2,5,0,1]
 * [4,2,4,4,2]
 * [3,5,1,3,1]
 * 
 * moves 하나당 board는 board의 길이만큼 다 훑어야함.
 * moves for문
 * 	board 2중 for문
 * 		board[j][i - 1] != 0 일때,
 * 			if stack이 empty이면 board[j][i - 1]을 push
 * 			else
 * 				if stack == board[j][i - 1]이면 stack pop , answer는 +2
 * 				else stack에 board[j][i - 1] push
 * 			다 돌고나면 board[j][i - 1] = 0으로 만들고 break (인형을 뽑았기 때문)
 */
public class Lv1_craingame {
	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> basket = new Stack<>();
		
		for (int i : moves) {
			for (int j = 0 ; j < board.length; j++) {
				if (board[j][i - 1] != 0) {
					if (basket.empty()) {
						basket.push(board[j][i - 1]);
					} else {
						if (basket.peek() == board[j][i - 1]) {
							basket.pop();
							answer += 2;
						} else {
							basket.push(board[j][i - 1]);
						}
					}
					board[j][i - 1] = 0;
					break;
				}
			}
		}
		
		return answer;
	}
	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		
		int answer = solution(board, moves);
		System.out.println(answer);
	}
}
/*
 * [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]	[1,5,3,5,1,2,1,4]	4
 */
