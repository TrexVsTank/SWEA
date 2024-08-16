import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Solution_SWEA_21736_민쌤의미술시간_D2_김민섭_122ms

public class Solution_SWEA_21736_민쌤의미술시간_D2_김민섭_122ms { // class
	
	static int board[][];
	
	public static void main(String[] args) throws IOException { // main
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) { // teke
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			board = new int[N][M];
			
			Map<Integer, Integer> counter = new HashMap<>();
			counter.put(0, 0);
			
			for (int k = 0; k < K; k++) {
				StringTokenizer stK = new StringTokenizer(br.readLine(), " ");
				int r1 = Integer.parseInt(stK.nextToken());
				int c1 = Integer.parseInt(stK.nextToken());
				int r2 = Integer.parseInt(stK.nextToken());
				int c2 = Integer.parseInt(stK.nextToken());
				int col = Integer.parseInt(stK.nextToken());
				paint(board, r1, c1, r2, c2, col);
				counter.put(col, 0);
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					counter.put(board[i][j], counter.get(board[i][j])+1);
				}
			}
			
			int max = 0;
			for (int k : counter.keySet()) {
				if (max < counter.get(k)) {
					max = counter.get(k);
				}
			}

			sb.append("#").append(t).append(" ").append(max).append("\n");
			
		} // end of teke
		
		System.out.println(sb);
		
	} // end of main
	
	// paint
	static void paint(int[][] arr, int row1, int col1, int row2, int col2, int color) {
		int checker = 0;
		for (int r = row1; r <= row2; r++) {
			for (int c = col1; c <= col2; c++) {
				if (arr[r][c] > color) {
					checker++;
				}
			}
		}
		if (checker == 0) {
			for (int r = row1; r <= row2; r++) {
				for (int c = col1; c <= col2; c++) {
					if (arr[r][c] < color) {
						arr[r][c] = color;
					}
				}
			}
		}
	}
	// end of paint
	
} // end  of class
