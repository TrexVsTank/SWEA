import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

// 클래스
public class Solution_SWEA_2382_미생물격리_김민섭_3899ms {
	
	static int dir[][] = { {}, {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		// 테케
		for (int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// [입력]
			int N = Integer.parseInt(st.nextToken()); // 고문장 크기 5 ~ 100
			int M = Integer.parseInt(st.nextToken()); // 고문시간 1 ~ 1,000
			int K = Integer.parseInt(st.nextToken()); // 군집 수 5 ~ 1,000
			
			// 벌레무리
			List<bug> bugs = new ArrayList<>();
			for (int b = 0; b < K; b++) {
				st = new StringTokenizer(br.readLine(), " ");
				bug new_bug = new bug();
				new_bug.row = Integer.parseInt(st.nextToken());
				new_bug.col = Integer.parseInt(st.nextToken());
				new_bug.swarm = Long.parseLong(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());
				new_bug.dr = dir[direction][0];
				new_bug.dc = dir[direction][1];
				bugs.add(new_bug);
			}
			
			// M번 고문
			for (int m = 0; m < M; m++) {
				// 이동
				for (int idx = 0; idx < bugs.size(); idx++) {
					bug b = bugs.get(idx);
					b.row += b.dr;
					b.col += b.dc;
					if (b.row == 0 || b.row == N-1 || b.col == 0 || b.col == N-1) {
						b.swarm /= 2;
						b.dr *= -1;
						b.dc *= -1;
					}
					
				}
				// 합체
				Set<int[]> set = new HashSet<>();
				for (int b = 0; b < bugs.size(); b++) {
					set.add(new int[] {bugs.get(b).row, bugs.get(b).col});
				}
				for (int[] rc : set) {
					int r = rc[0];
					int c = rc[1];
					List<Integer> list = new ArrayList<>();
					for (int b = 0; b < bugs.size(); b++) {
						if (bugs.get(b).row == r && bugs.get(b).col == c) {
							list.add(b);
						}
					}
					long max = -1;
					int idx = -1;
					for (int i : list) {
						if (max < bugs.get(i).swarm) {
							max = bugs.get(i).swarm;
							idx = i;
						}
					}
					if (idx != -1) {
						for (int i : list) {
							if (idx != i) {
								bugs.get(idx).swarm += bugs.get(i).swarm;
								bugs.get(i).swarm = 0;
							}
						}
					}
				}
				// 제거
				for (int idx = bugs.size()-1; idx >= 0; idx--) {
					if (bugs.get(idx).swarm == 0) {
						bugs.remove(idx);
					}
				}
			}
			
			// 어펜드
			long result = 0;
			for (int b = 0; b < bugs.size(); b++) {
				result += bugs.get(b).swarm;
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
			
		} // 테케 끝
		
		// 출력
		System.out.println(sb);
		
	} // 메인 끝
	
	// 벌레
	static private class bug {
		int row;
		int col;
		int dr;
		int dc;
		long swarm;
		public bug() {
		}
	} // 벌레 끝
	
} // 클래스 끝