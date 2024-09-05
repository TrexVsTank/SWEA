import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 클래스
public class Solution_SWEA_7733_치즈도둑_D4_김민섭_561ms {
	
	static int[][] directions = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
	
	static int N;
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		// 테케
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 1;
			
			int[][] brr = new int[N][N];
			
			// 1일 ~ 100일
			for (int d = 1; d <= 100; d++) {
				
				// 훔쳐먹기
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (arr[i][j] == d) {
							brr[i][j] = -1;
						}
					}
				}
				
				// 덩어리 세기
				int count = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (brr[i][j] != -1 && brr[i][j] != d) {
							count++;
							brr[i][j] = d;
							Queue<int[]> queue = new ArrayDeque<>();
							queue.offer(new int[] {i, j});
							while (!queue.isEmpty()) {
								int[] q = queue.poll();
								for (int[] dir : directions) {
									int R = q[0]+dir[0];
									int C = q[1]+dir[1];
									if (checker(R, C) && brr[R][C] != -1 && brr[R][C] != d) {
										brr[R][C] = d;
										queue.offer(new int[] {R, C});
									}
								}
							}
						}
					}
				}
				
				// 최대값 갱신
				if (max < count) {
					max = count;
				}
				
			}
			
			sb.append("#").append(t).append(" ").append(max).append("\n");
			
		} // 테케 끝
		
		System.out.println(sb);
		
	} // 메인 끝
	
	// 체커
	static boolean checker(int row, int col) {
		return 0<=row&&row<N&&0<=col&&col<N;
	} // 체커 끝
	
} // 클래스 끝