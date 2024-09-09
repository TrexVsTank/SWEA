import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 클래스
public class Solution_SWEA_1767_프로세서연결하기_김민섭_447ms {
	
	static int dir[][] = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
	
	static int N;
	static int arr[][];
	static List<int[]> chips;
	
	static int connect;
	static int length;
	
	static int maxConnect;
	static int minLength;
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// [입력]
		int T = Integer.parseInt(br.readLine());
		
		// 테케
		for (int t = 1; t <= T; t++) {
			
			// [입력] 7 ~ 12
			N = Integer.parseInt(br.readLine());
			
			chips = new ArrayList<>();
			maxConnect = 0;
			minLength = 0;
			
			connect = 0;
			length = 0;
			
			// [입력] 1 ~ 12
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if ((i == 0 || i == N-1 || j == 0 || j == N-1) && arr[i][j] == 1) {
						maxConnect++;
						connect++;
					} else if (arr[i][j] == 1) {
						chips.add(new int[] {i, j});
					}
				}
			}
			
			// 연결
			connectLine(0);
			
			// 어펜드
			sb.append("#").append(t).append(" ").append(minLength).append("\n");
			
		} // 테케 끝
		
		// 출력
		System.out.println(sb);
		
	} // 메인 끝
	
	// 연결
	static void connectLine(int index) {
		if (index == chips.size()) {
			return;
		}
		
		for (int[] d : dir) {
			
			int R = chips.get(index)[0] + d[0];
			int C = chips.get(index)[1] + d[1];
			
			boolean canConnect = true;
			
			List<int[]> line = new ArrayList<>();
			
			while (checker(R, C)) {
				if (arr[R][C] != 0) {
					canConnect = false;
					break;
				}
				line.add(new int[] {R, C});
				R += d[0];
				C += d[1];
			}
			
			if (canConnect) {
				for (int[] l : line) {
					arr[l[0]][l[1]] = 2;
				}
				connect++;
				length += line.size();
				
				if (maxConnect < connect) {
					maxConnect = connect;
					minLength = length;
				} else if (maxConnect == connect) {
					minLength = Math.min(minLength, length);
				}
				
				connectLine(index+1);
				
				for (int[] l : line) {
					arr[l[0]][l[1]] = 0;
				}
				connect--;
				length -= line.size();
			}
			
		}
		
		connectLine(index+1);
		
	} // 연결 끝
	
	// 체커
	static boolean checker(int R, int C) {
		return 0 <= R && R < N && 0 <= C && C < N;
	} // 체커 끝
	
} // 클래스 끝