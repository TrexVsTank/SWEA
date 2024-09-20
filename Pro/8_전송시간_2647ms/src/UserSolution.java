import java.util.*;

// 유저솔루션
public class UserSolution {
	
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
	} // 엣지
	
	static final int INF = 1_000_000_000;
	static int uN;
	static int uK;
	static List<Edge>[] uEdge;
	static int[] uDist;
	
    // 0. 이닛
    public void init(int N, int K, int mNodeA[], int mNodeB[], int mTime[]) {
    	uN = N;
    	uK = K;
    	uEdge = new ArrayList[uN * 100 + 31];
    	for (int i = 0; i < uN * 100 + 31; i++) {
			uEdge[i] = new ArrayList<>();
		}
    	for (int k = 0; k < uK; k++) {
    		int A = mNodeA[k];
    		int B = mNodeB[k];
    		int C = mTime[k];
			uEdge[A].add(new Edge(B, C));
			uEdge[B].add(new Edge(A, C));
		}
    	uDist = new int[uN * 100 + 31];
    } // 0. 이닛
    
    // 1. 추가
    public void addLine(int mNodeA, int mNodeB, int mTime) {
    	int A = mNodeA;
		int B = mNodeB;
		int C = mTime;
		uEdge[A].add(new Edge(B, C));
		uEdge[B].add(new Edge(A, C));
    } // 1. 추가
    
    // 2. 삭제
    public void removeLine(int mNodeA, int mNodeB) {
    	int A = mNodeA;
		int B = mNodeB;
		uEdge[A].removeIf(Edge -> Edge.eEnd == B);
		uEdge[B].removeIf(Edge -> Edge.eEnd == A);
    } // 2. 삭제
    
    // 3. 체크
    public int checkTime(int mNodeA, int mNodeB) {
    	int A = mNodeA;
    	int B = mNodeB;
    	
    	Arrays.fill(uDist, INF);
    	uDist[A] = 0;
    	
    	boolean[] visited = new boolean[uN * 100 + 31];
    	
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
    			return uDist[currStart];
    		}
    		
    		for (Edge edge : uEdge[currStart]) {
    			if (!visited[edge.eEnd] && uDist[edge.eEnd] > uDist[currStart] + edge.eCost) {
    				uDist[edge.eEnd] = uDist[currStart] + edge.eCost;
    				PQ.offer(new Edge(edge.eEnd, uDist[edge.eEnd]));
    			}
    		}
    	}
    	
    	return 0;
    } // 3. 체크
    
} // 유저솔루션
