import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// class
public class Solution_SWEA_1248_공통조상_D5_김민섭_161ms {
	
	static Stack<Integer> numbers = new Stack<>();
	static Node arr[];
	static int mom;
	static int size;
	
	// main
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		T = 10;
		
		// TEST_CASE
		for (int t = 1; t <= T; t++) {
			size = 0;
			//INPUT
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			arr = new Node[V+1];
			for (int i = 1; i <= V; i++) {
				arr[i] = new Node(i, 0, 0, 0, 0);
			}
			arr[1].floor = 1;
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());
				if (arr[a].left == 0) {
					arr[a].left = b;
				} else if (arr[a].right == 0) {
					arr[a].right = b;
				}
				arr[b].mom = a;
			}
			
			// INPUT_END
			
			set_floor(1);
			find_mom(A, B);
			get_size(mom);
			
			sb.append("#").append(t).append(" ").append(mom).append(" ").append(size).append(" ").append("\n");
			
		} // TEST_CASE_END
		
		System.out.println(sb);
		
	} // end of main
	
	// Node
	static class Node {
		int data;
		int left;
		int right;
		int mom;
		int floor;
		public Node(int data, int left, int right, int mom, int floor) {
			this.data = data;
			this.left = left;
			this.right = right;
			this.mom = mom;
			this.floor = floor;
		}
	} // end of Node
	
	// set_floor
	static void set_floor(int index) {
		if (arr[index].left != 0) {
			arr[arr[index].left].floor = arr[index].floor+1;
			set_floor(arr[index].left);
		}
		if (arr[index].right != 0) {
			arr[arr[index].right].floor = arr[index].floor+1;
			set_floor(arr[index].right);
		}
		if (arr[index].left == 0 && arr[index].right == 0) {
			return;
		}
	} // end of set_floor
	
	// find_mom
	static void find_mom(int a, int b) {
		if (a == b) {
			mom = a;
			return;
		}
		if (arr[a].floor == arr[b].floor) {
			find_mom(arr[a].mom, arr[b].mom);
		} else if (arr[a].floor < arr[b].floor) {
			find_mom(a, arr[b].mom);
		} else {
			find_mom(arr[a].mom, b);
		}
	} // end of find_mom
	
	// get_size
	static void get_size(int a) {
		if (arr[a].left == 0 && arr[a].right == 0) {
			size++;
			return;
		}
		if (arr[a].left != 0 || arr[a].right != 0) {
			if (arr[a].left != 0) {
				get_size(arr[a].left);
			}
			if (arr[a].right != 0) {
				get_size(arr[a].right);
			}
			size++;
		}
		
	} // end_of_get_size
	
} // end of class