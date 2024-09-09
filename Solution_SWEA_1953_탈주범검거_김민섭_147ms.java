import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 클래스
public class Solution_SWEA_1953_탈주범검거_김민섭_147ms {
	
	static StringBuilder sb = new StringBuilder();
	
	static int dir1[][] = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
	static int dir2[][] = { {1, 0}, {-1, 0} };
	static int dir3[][] = { {0, 1}, {0, -1} };
	static int dir4[][] = { {0, 1}, {-1, 0} };
	static int dir5[][] = { {0, 1}, {1, 0} };
	static int dir6[][] = { {0, -1}, {1, 0} };
	static int dir7[][] = { {0, -1}, {-1, 0} };
	
	static int dir[][][] = { {}, dir1, dir2, dir3, dir4, dir5, dir6, dir7 };
	
	static int N;
	static int M;
	static int R;
	static int C;
	static int L;
	
	static int arr[][];
	static boolean visited[][];
	
	static int result;
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// [입력] 테케스트 케이스 수
		int T = Integer.parseInt(br.readLine());
		
		// 테케
		for (int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// [입력] 행 열 행 열 시간
			N = Integer.parseInt(st.nextToken()); // 5 ~ 50
			M = Integer.parseInt(st.nextToken()); // 5 ~ 50
			R = Integer.parseInt(st.nextToken()); // 0 ~ 49
			C = Integer.parseInt(st.nextToken()); // 0 ~ 49
			L = Integer.parseInt(st.nextToken()); // 1 ~ 20
			
			// [입력] 1 십자 2 상하 3 좌우 4 동북 5 동남 6 서남 7 서북
			arr = new int[N][M];
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int m = 0; m < M; m++) {
					arr[n][m] = Integer.parseInt(st.nextToken());
				}
			}
			
			// bfs
			bfs();
			
			// 어펜드
			sb.append("#").append(t).append(" ").append(result).append("\n");
			
		} // 테케 끝
		
		// 출력
		System.out.println(sb);
		
	} // 메인 끝
	
	// BFS
	static void bfs() {
		
		Queue<int[]> queue = new ArrayDeque<>();
		visited = new boolean[N][M];
		
		visited[R][C] = true;
		result = 1;
		queue.offer(new int[] {R, C});
		
		for (int l = 0; l < L-1; l++) {
			int S = queue.size();
			for (int s = 0; s < S; s++) {
				int[] q = queue.poll();
				int r = q[0];
				int c = q[1];
				int pipeType = arr[r][c];
				for (int[] d : dir[pipeType]) {
					int R = r + d[0];
					int C = c + d[1];
					if (d[0] == 0 && d[1] == 1) { // 동
						if ( checker(R, C) && !visited[R][C] && (arr[R][C] == 1 || arr[R][C] == 3 || arr[R][C] == 6 || arr[R][C] == 7) ) {
							visited[R][C] = true;
							result++;
							queue.offer(new int[] {R, C});
						}
					} else if (d[0] == 0 && d[1] == -1) { // 서
						if ( checker(R, C) && !visited[R][C] && (arr[R][C] == 1 || arr[R][C] == 3 || arr[R][C] == 4 || arr[R][C] == 5) ) {
							visited[R][C] = true;
							result++;
							queue.offer(new int[] {R, C});
						}
					} else if (d[0] == 1 && d[1] == 0) { // 남
						if ( checker(R, C) && !visited[R][C] && (arr[R][C] == 1 || arr[R][C] == 2 || arr[R][C] == 4 || arr[R][C] == 7) ) {
							visited[R][C] = true;
							result++;
							queue.offer(new int[] {R, C});
						}
					} else if (d[0] == -1 && d[1] == 0) { // 북
						if ( checker(R, C) && !visited[R][C] && (arr[R][C] == 1 || arr[R][C] == 2 || arr[R][C] == 5 || arr[R][C] == 6) ) {
							visited[R][C] = true;
							result++;
							queue.offer(new int[] {R, C});
						}
					}
				}
			}
		}
	} // BFS 끝
	
	// 체커
	static boolean checker(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	} // 체커 끝
	
} // 클래스 끝