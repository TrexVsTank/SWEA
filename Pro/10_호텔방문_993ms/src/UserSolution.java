
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// 유저솔루션
class UserSolution {
	
	// 엣지
	class Edge implements Comparable<Edge> {
		int eEnd;
		int eCost;
		public Edge(int end, int cost) {
			this.eEnd = end;
			this.eCost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return this.eCost - o.eCost;
		}
	} // 엣지
	
	static int uN;
	static int[] uHotel; 
	static Map<Integer, List<Integer>> uBrand;
	static List<List<Edge>> uEdge;
	
	// 100. 시작
    void init(int N, int mBrands[]) {
    	uN = N;
    	uHotel = new int[uN];
    	uBrand = new HashMap<>();
    	uEdge = new ArrayList<>();
    	for (int i = 0; i < uN; i++) {
    		if (uBrand.get(mBrands[i]) == null) {
    			uBrand.put(mBrands[i], new ArrayList<>());
    		}
			uHotel[i] = mBrands[i];
			uBrand.get(mBrands[i]).add(i);
			uEdge.add(new ArrayList<>());
		}
    } // 100. 시작
    
    // 200. 연결
    void connect(int mHotelA, int mHotelB, int mDistance) {
    	uEdge.get(mHotelA).add(new Edge(mHotelB, mDistance));
    	uEdge.get(mHotelB).add(new Edge(mHotelA, mDistance));
    } // 200. 연결
    
    // 300. 합병
    int merge(int mHotelA, int mHotelB) {
    	int brandA = uHotel[mHotelA];
    	int brandB = uHotel[mHotelB];
    	if (brandA == brandB) {
    		return uBrand.get(brandA).size();
    	}
    	for (int i : uBrand.get(brandB)) {
    		uHotel[i] = brandA;
    		uBrand.get(brandA).add(i);
    	}
    	uBrand.remove(brandB);
    	return uBrand.get(brandA).size();
    } // 300. 합병
    
    // 400. 이동
    int move(int mStart, int mBrandA, int mBrandB) {
    	int Alen = 0;
    	int Blen = 0;
    	
    	int start = mStart;
    	int brandA = mBrandA;
    	int brandB = mBrandB;
    	
    	boolean[] visited = new boolean[uN];
    	
    	int[] dist = new int[uN];
    	Arrays.fill(dist, 1_000_000_000);
    	dist[start] = 0;
    	
    	PriorityQueue<Edge> PQ = new PriorityQueue<>();
    	PQ.offer(new Edge(start, 0));
    	
    	while (!PQ.isEmpty()) {
    		
    		Edge currEdge = PQ.poll();
    		int currStart = currEdge.eEnd;
    		int currCost = currEdge.eCost;
    		
    		if (visited[currStart]) {
    			continue;
    		}
    		visited[currStart] = true;
    		
    		if (Alen == 0 && uHotel[currStart] == brandA) {
    			Alen = dist[currStart];
    			if (Alen != 0 && Blen != 0) {
    				break;
    			}
    		} else if (Blen == 0 && uHotel[currStart] == brandB) {
    			Blen = dist[currStart];
    			if (Alen != 0 && Blen != 0) {
    				break;
    			}
    		}
    		
    		
    		for (Edge each : uEdge.get(currStart)) {
    			if (!visited[each.eEnd] && dist[each.eEnd] > dist[currStart] + each.eCost) {
    				dist[each.eEnd] = dist[currStart] + each.eCost;
    				PQ.offer(new Edge(each.eEnd, dist[each.eEnd]));
    			}
    		}
    	}
    	
        return Alen + Blen;
    } // 400. 이동
} // 유저솔루션
