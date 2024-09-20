import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class UserSolution {
	
	// 체커
	static boolean checker(int row, int col) {
		return 0 <= row && row < uN && 0 <= col && col < uN;
	} // 체커
	
	// 엣지
	class Edge implements Comparable<Edge> {
		int eEnd;
		int eCost;
		Edge(int end, int cost) {
			this.eEnd = end;
			this.eCost = cost;
		}
		@Override
		public int compareTo(UserSolution.Edge o) {
			return this.eCost - o.eCost;
		}
	}
	
	// static
	static final int INF = 1_000_000_000;
	static int[][] dir = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
	static int uN;
	static int uRange;
	static int[][] uMap;
	static List<List<Edge>> uEdge;
	static int uId;
	// static
	
	// 0. 이닛
	void init(int N, int mRange, int mMap[][]) {
		uN = N;
		uRange = mRange;
		uMap = new int[uN][uN];
		for (int r = 0; r < uN; r++) {
			for (int c = 0; c < uN; c++) {
				uMap[r][c] = mMap[r][c] - 2;
			}
		}
		uEdge = new ArrayList<>();
	} // 0. 이닛
	
	// 1. 대여소 추가
	void add(int mID, int mRow, int mCol) {
		uId = mID+1;
		uMap[mRow][mCol] = mID;
		uEdge.add(new ArrayList<>());
		boolean[][] visited = new boolean[uN][uN];
		Queue<int[]> queue = new ArrayDeque<>();
		visited[mRow][mCol] = true;
		queue.offer(new int[] {mRow, mCol});
		
		int dist = 1;
		while (!queue.isEmpty() && dist <= uRange) {
			int S = queue.size();
			for (int s = 0; s < S; s++) {
				int[] q = queue.poll();
				for (int[] d : dir) {
					int R = q[0] + d[0];
					int C = q[1] + d[1];
					if (checker(R, C) && !visited[R][C] && uMap[R][C] != -1) {
						visited[R][C] = true;
						queue.offer(new int[] {R, C});
						if (uMap[R][C] >= 0) {
							int A = mID;
							int B = uMap[R][C];
							int Co = dist;
							uEdge.get(A).add(new Edge(B, Co));
							uEdge.get(B).add(new Edge(A, Co));
						}
					}
				}
			}
			dist++;
		}
		
	} // 1. 대여소 추가
	
	// 2. 거리
	int distance(int mFrom, int mTo) {
		int A = mFrom;
		int B = mTo;
		
		int[] dist = new int[uId];
		Arrays.fill(dist, INF);
		dist[A] = 0;
		
		boolean[] visited = new boolean[uId];
		
		PriorityQueue<Edge> PQ = new PriorityQueue<>();
		PQ.offer(new Edge(A, 0));
		
		while (!PQ.isEmpty()) {
			Edge currEdge = PQ.poll();
			int currStart = currEdge.eEnd;
			
			if (visited[currStart]) {
				continue;
			}
			visited[currStart] = true;
			
			if (currStart == B) {
				return dist[currStart];
			}
			
			for (Edge edge : uEdge.get(currStart)) {
				if (!visited[edge.eEnd] && dist[edge.eEnd] > dist[currStart] + edge.eCost) {
					dist[edge.eEnd] = dist[currStart] + edge.eCost;
					PQ.offer(new Edge(edge.eEnd, dist[edge.eEnd]));
				}
			}
		}
		
		return -1;
	} // 2. 거리
	
}