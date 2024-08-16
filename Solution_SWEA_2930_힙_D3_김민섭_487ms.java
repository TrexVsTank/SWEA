import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// class
public class Solution_SWEA_2930_힙_D3_김민섭_487ms {
	
	// main
	public static void main(String[] args) throws IOException {
		
		// sb
		StringBuilder sb = new StringBuilder();
		
		// br
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// T
		int T = Integer.parseInt(br.readLine());
		
		// TESTCASE
		for (int t = 1; t <= T; t++) {
			
			sb.append("#").append(t);
			
			// Q
			PriorityQueue<Integer> Q = new PriorityQueue<>((a, b) -> {return b-a;});
			
			// N
			int N = Integer.parseInt(br.readLine());
			
			for (int n = 0; n < N; n++) {
				// st
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				if (Integer.parseInt(st.nextToken()) == 1) {
					Q.add(Integer.parseInt(st.nextToken()));
				} else if (Q.isEmpty()) {
					sb.append(" ").append(-1);
				} else {
					sb.append(" ").append(Q.poll());
				}
			}
			
			sb.append("\n");
			
		} // TESTCASE_END
		
		System.out.println(sb);
		
	} // end of main
	
} // end of class