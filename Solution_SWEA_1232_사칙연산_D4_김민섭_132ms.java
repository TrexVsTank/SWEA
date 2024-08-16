import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// class
public class Solution_SWEA_1232_사칙연산_D4_김민섭_132ms {
	
	static Stack<Integer> numbers = new Stack<>();
	static Nodee arr[];
	// main
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		
		// TEST_CASE
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			arr = new Nodee[N+1];
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int index = Integer.parseInt(st.nextToken());
				String data = st.nextToken();
				int left = 0;
				int right = 0;
				if (st.hasMoreTokens()) {
					left = Integer.parseInt(st.nextToken());
				}
				if (st.hasMoreTokens()) {
					right = Integer.parseInt(st.nextToken());
				}
				
				arr[index] = new Nodee(data, left, right);
//				System.out.println(arr[index].data + " " + arr[index].left + " " + arr[index].right);
			}
			
			Cal(1);
			
			sb.append("#").append(t).append(" ").append(numbers.pop()).append("\n");
			
		} // TEST_CASE_END
		
		System.out.println(sb);
		
	} // end of main
	
	// Nodee
	static class Nodee {
		String data;
		int left;
		int right;
		public Nodee(String data, int left, int right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	} // end of Nodee
	
	// Cal
	static void Cal(int index) {
		if (arr[index].left != 0) {
			Cal(arr[index].left);
		}
		if (arr[index].right != 0) {
			Cal(arr[index].right);
		}
		if (arr[index].data.equals("+")||arr[index].data.equals("-")||arr[index].data.equals("*")||arr[index].data.equals("/")) {
			int b = numbers.pop();
			int a = numbers.pop();
			switch (arr[index].data) {
			case "+":
				numbers.push(a+b);
				break;
			case "-":
				numbers.push(a-b);
				break;
			case "*":
				numbers.push(a*b);
				break;
			case "/":
				numbers.push(a/b);
				break;
			}
		} else {
			numbers.push(Integer.parseInt(arr[index].data));
		}
	} // end of Call
	
} // end of class