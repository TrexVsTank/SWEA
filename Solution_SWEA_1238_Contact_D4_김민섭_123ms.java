import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 클래스
public class Solution_SWEA_1238_Contact_D4_김민섭_123ms {
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		
		// 테케
		for (int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			// [입력] 데이터 길이
			int N = Integer.parseInt(st.nextToken());
			
			// [입력] 출발지
			int S = Integer.parseInt(st.nextToken());
			
			// [입력] 간선
			List<List<Integer>> link = new ArrayList<>();
			for (int i = 0; i <= 1001; i++) {
				link.add(new ArrayList<>());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N/2; i++) {
				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());
				link.get(num1).add(num2);
			}
			
			// 비용 배열
			int[] cost = new int[101];
			for (int i = 0; i <= 100; i++) {
				cost[i] = Integer.MAX_VALUE;
			}
			cost[S] = 0;
			
			// 방문여부 배열
			boolean[] visited = new boolean[101];
			
			// 최종출력 변수
			int maximum = 0;
			List<Integer> result = new ArrayList<>();;
			
			// 다익스트라
			Queue<Integer> queue = new ArrayDeque<>();
			queue.offer(S);
			while (!queue.isEmpty()) {
				int q = queue.poll();
				for (int l = 0; l < link.get(q).size(); l++) {
					int E = link.get(q).get(l);
					if (cost[E] > cost[q] + 1) {
						cost[E] = cost[q] + 1;
					}
				}
				visited[q] = true;
				int min_cost = Integer.MAX_VALUE;
				int min_index = -1;
				for (int i = 1; i <= 100; i++) {
					if (!visited[i] && cost[i] < min_cost) {
						min_cost = cost[i];
						min_index = i;
					}
				}
				if (min_index != -1) {
					if (maximum == cost[min_index]) {
						result.add(min_index);
					}
					if (maximum < cost[min_index]) {
						maximum = cost[min_index];
						result = new ArrayList<>();
						result.add(min_index);
					}
					queue.offer(min_index);
				}
			}
			
			// 어펜드
			Collections.sort(result);
			sb.append("#").append(t).append(" ").append(result.get(result.size()-1)).append("\n");
			
		} // 테케 끝
		
		// 출력
		System.out.println(sb);
		
	} // 메인 끝
	
} // 클래스 끝
