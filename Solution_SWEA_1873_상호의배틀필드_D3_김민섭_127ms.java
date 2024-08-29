import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 클래스
public class Solution_SWEA_1873_상호의배틀필드_D3_김민섭_127ms {
	
	static int D[][] = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} }; // 동 서 남 북
	static int dir;
	static int row;
	static int col;
	static int H;
	static int W;
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		// 테케 시작
		for (int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			H = Integer.parseInt(st.nextToken()); // 2 ~ 20
			W = Integer.parseInt(st.nextToken()); // 2 ~ 20
			
			char[][] map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					if (str.charAt(j) == '>') {
						row = i;
						col = j;
						dir = 0;
						map[i][j] = '.';
					} else if (str.charAt(j) == '<') {
						row = i;
						col = j;
						dir = 1;
						map[i][j] = '.';
					} else if (str.charAt(j) == 'v') {
						row = i;
						col = j;
						dir = 2;
						map[i][j] = '.';
					} else if (str.charAt(j) == '^') {
						row = i;
						col = j;
						dir = 3;
						map[i][j] = '.';
					} else {
						map[i][j] = str.charAt(j);
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine()); // 0 ~ 100
			
			char[] order = new char[N];
			String str = br.readLine();
			for (int i = 0; i < N; i++) {
				order[i] = str.charAt(i);
			}
			
			for (int i = 0; i < N; i++) {
				if (order[i] == 'S') {
					int rs = row;
					int cs = col;
					while (checker(rs+D[dir][0], cs+D[dir][1])) {
						if (map[rs+D[dir][0]][cs+D[dir][1]] == '#') {
							break;
						} else if (map[rs+D[dir][0]][cs+D[dir][1]] == '*') {
							map[rs+D[dir][0]][cs+D[dir][1]] = '.';
							break;
						}
						rs += D[dir][0];
						cs += D[dir][1];
					}
				} else {
					switch (order[i]) {
					case 'R':
						dir = 0;
						if (checker(row+D[dir][0], col+D[dir][1]) && map[row+D[dir][0]][col+D[dir][1]] == '.') {
							row += D[dir][0];
							col += D[dir][1];
						}
						break;
					case 'L':
						dir = 1;
						if (checker(row+D[dir][0], col+D[dir][1]) && map[row+D[dir][0]][col+D[dir][1]] == '.') {
							row += D[dir][0];
							col += D[dir][1];
						}
						break;
					case 'D':
						dir = 2;
						if (checker(row+D[dir][0], col+D[dir][1]) && map[row+D[dir][0]][col+D[dir][1]] == '.') {
							row += D[dir][0];
							col += D[dir][1];
						}
						break;
					case 'U':
						dir = 3;
						if (checker(row+D[dir][0], col+D[dir][1]) && map[row+D[dir][0]][col+D[dir][1]] == '.') {
							row += D[dir][0];
							col += D[dir][1];
						}
						break;
					}
				}
			}
			
			switch (dir) {
			case 0:
				map[row][col] = '>';
				break;
			case 1:
				map[row][col] = '<';
				break;
			case 2:
				map[row][col] = 'v';
				break;
			case 3:
				map[row][col] = '^';
				break;
			}
			
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			
		} // 테케 끝
		
		System.out.println(sb);
		
	} // 메인 끝
	
	// 범위체크
	static boolean checker(int r, int c) {
		if (0 <= r && r < H && 0 <= c && c < W) {
			return true;
		}
		return false;
	} // 범위체크 끝
	
} // 클래스 끝