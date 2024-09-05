import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 클래스
public class Solution_SWEA_1861_정사각형방_D4_김민섭_159ms {
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		// 동서남북
		int[][] dir = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		// 테케
		for (int t = 1; t <= T; t++) {
			
			// [입력] 방 크기 1 ~ 1000
			int N = Integer.parseInt(br.readLine());
			
			// 숫자별 행, 열, 길이
			int[][] coor = new int[N*N+1][3];
			// 방 1 ~ N^2
			int[][] arr = new int[N][N];
			// [입력]
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
					arr[i][j] = num;
					coor[num] = new int[] {i, j, 1};
				}
			}
			
			// 최대길이
			int max = 0;
			// 최대길이 & 가장 작은 값
			int num = 0;
			
			for (int i = N*N; i >= 1; i--) { // N제곱 부터 1 까지
				int r = coor[i][0];
				int c = coor[i][1];
				for (int[] d : dir) { // 동서남북
					int R = r+d[0];
					int C = c+d[1];
					if (checker(R, C, N) && arr[R][C] == i+1) {
						coor[i][2] = coor[i+1][2] + 1;
						if (max <= coor[i][2]) { // 최대값 중복 or 갱신
							max = coor[i][2];
							num = i;
						}
					}
				}
			}
			
			// 어펜드
			sb.append("#").append(t).append(" ").append(num).append(" ").append(max).append("\n");
			
		} // 테케 끝
		
		// 출력
		System.out.println(sb);
		
	} // 메인 끝
	
	// 체커
	static boolean checker(int row, int col, int N) {
		return 0 <= row && row < N && 0 <= col && col < N;
	} // 체커 끝
	
} // 클래스 끝