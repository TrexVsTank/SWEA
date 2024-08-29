import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 클래스
public class Solution_SWEA_2806_NQueen_D3_김민섭_140ms {
	
	static int N;
	static int col_of_queens[];
	static int result;
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		// 테케
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			result = 0;
			
			N = Integer.parseInt(br.readLine()); // 1 ~ 10
			
			col_of_queens = new int[N];
			
			n_queen(0);
			
			sb.append(result).append("\n");
			
		} // 테케 끝
		
		System.out.println(sb);
		
	} // 메인 끝
	
	// 엔퀸
	static void n_queen(int index_row) {
		if (index_row == N) {
			result++;
			return;
		}
		for (int c = 0; c < N; c++) {
			if (can_rocated_on(index_row, c)) {
				col_of_queens[index_row] = c;
				n_queen(index_row+1);
				col_of_queens[index_row] = 0;
			}
		}
	} // 엔퀸 끝
	
	// 배치가능판단
	static boolean can_rocated_on(int row, int col) {
		boolean result = true;
		for (int r = 0; r < row; r++) {
			if (r == row) {
				continue;
			}
			if (col_of_queens[r] == col || Math.abs(row-r) == Math.abs(col - col_of_queens[r])) {
				result = false;
				break;
			}
		}
		return result;
	} // 배치가능판단 끝
	
} // 클래스 끝