import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 클래스
public class Solution_SWEA_1267_작업순서_D6_김민섭_141ms {
	
	static StringBuilder sb = new StringBuilder();
	
	static int V;
	static int E;
	static List<List<Integer>> link;
	static Queue<Integer> queueTopology;
	static int linkCount[];
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = 10;
		
		// 테케
		for (int tc = 1; tc <= TC; tc++) {
			
			// [입력] V 정점 E 간선
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken()); // 3 ~ 1,000
			E = Integer.parseInt(st.nextToken()); // 2 ~ 3,000
			
			// [입력] 간선
			link = new ArrayList<>();
			linkCount = new int[V+1];
			for (int v = 0; v <= V; v++) {
				link.add(new ArrayList<>());
			}
			st = new StringTokenizer(br.readLine());
			for (int e = 0; e < E; e++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				link.get(start).add(end);
				linkCount[end]++;
			}
			
			// 실행 어펜드
			sb.append("#").append(tc).append(" ");
			topology();
			sb.append("\n");
			
		} // 테케 끝
		
		// 출력
		System.out.println(sb);
		
	} // 메인 끝
	
	// 토폴로지
	static void topology() {
		queueTopology = new ArrayDeque<>();
		for (int v = 1; v <= V; v++) {
			if (linkCount[v] == 0) {
				queueTopology.offer(v);
			}
		}
		while (!queueTopology.isEmpty()) {
			int start = queueTopology.poll();
			if (linkCount[start] == 0) {
				sb.append(start).append(" ");
			}
			for (int e : link.get(start)) {
				linkCount[e]--;
				if (linkCount[e] == 0) {
					queueTopology.offer(e);
				}
			}
		}
	} // 토폴로지 끝
	
} // 클래스 끝