import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// class
public class Solution_SWEA_1231_중위순회_D4_김민섭_108ms {
	
	static StringBuilder sb = new StringBuilder();
	static char tree[];
	
	// main
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		// TEST_CASE
		for (int t = 1; t <= T; t++) {
			// INPUT
			int N = Integer.parseInt(br.readLine());
			int treesize = 1;
			while (N >= treesize) {
				treesize *= 2;
			}
			tree = new char[treesize+1];
			for (int i = 0; i < treesize+1; i++) {
				tree[i] = ' ';
			}
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int index = Integer.parseInt(st.nextToken());
				char alphabet = st.nextToken().charAt(0);
				tree[index] = alphabet;
			} // INPUT_END
			sb.append("#").append(t).append(" ");
			inorder_scout(1);
			sb.append("\n");
		} // TEST_CASE_END
		
		System.out.println(sb);
		
	} // end of main
	
	// inorder_scout
	static void inorder_scout(int index) {
		if (index < 0 || tree.length <= index || tree[index] == ' ') {
			return;
		}
		inorder_scout(index*2);
		sb.append(tree[index]);
		inorder_scout(index*2+1);
	} // end of inorder_scout
	
} // end of class