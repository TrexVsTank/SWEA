import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 클래스
public class Solution_SWEA_7465_창용마을무리의개수_D4_김민섭_143ms {
	
	static int group[];
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		// 테케
		for (int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			// [입력] 사람 수 1 ~ 100
			int N = Integer.parseInt(st.nextToken());
			// [입력] 관계 수 0 ~ N*(N-1)/2
			int M = Integer.parseInt(st.nextToken());
			
			if (N == 0 || M == 0) {
				sb.append("#").append(t).append(" ").append(N).append("\n");
				continue;
			}
			
			// [입력]관계
			int[][] link = new int[M][2];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());
				link[i][0] = num1;
				link[i][1] = num2;
			}
			
			// 그룹
			group = new int[N+1];
			for (int i = 1; i <= N; i++) {
				group(i);
			}
			
			// 짝짓기
			for (int i = 0; i < M; i++) {
				if (get_group(link[i][0]) != get_group(link[i][1])) {
					union(link[i][0], link[i][1]);
				}
			}
			
			// 카운팅
			Set<Integer> set = new HashSet<>();
			for (int i = 1; i <= N; i++) {
				set.add(get_group(i));
			}
			
			sb.append("#").append(t).append(" ").append(set.size()).append("\n");
			
		} // 테케 끝
		
		System.out.println(sb);
		
	} // 메인 끝
	
	// 그룹생성
	static void group(int num) {
		group[num] = num;
	} // 그룹생성 끝
	
	// 겟그룹
	static int get_group(int num) {
		if (group[num] == num) {
			return num;
		}
		return group[num] = get_group(group[num]);
	} // 겟그룹 끝
	
	// 유니온
	static void union(int man1, int man2) {
		group[get_group(man2)] = get_group(man1);
	} // 유니온 끝
	
} // 클래스 끝