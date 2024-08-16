
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// class
public class Solution_SWEA_1228_암호문1_D3_김민섭_116ms {
	// main
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;
		// testCase
		for (int t = 1; t <= T; t++) {
			// Input
			DLL1 dll = new DLL1();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer stN = new StringTokenizer(br.readLine(), " ");
			for (int n = 0; n < N; n++) {
				int input = Integer.parseInt(stN.nextToken());
				dll.add(n, input);
			}
			int M = Integer.parseInt(br.readLine());
			StringTokenizer stM = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; m++) {
				String l = stM.nextToken();
				int x = Integer.parseInt(stM.nextToken());
				int y = Integer.parseInt(stM.nextToken());
				for (int i = 0; i < y; i++) {
					int num = Integer.parseInt(stM.nextToken());
					dll.add(x+i, num);
				}
			} // end of Input
			
			sb.append("#").append(t).append(" ");
			Node1 current = dll.head;
			for (int i = 0; i < 10; i++) {
				current = current.Next;
				sb.append(current.Data).append(" ");
			}
			sb.append("\n");
			
		} // end of testCase
		
		System.out.println(sb);
		
	} // end of main
} // end of class

// Node1
class Node1 {
	int Data;
	Node1 Prev;
	Node1 Next;
} // end of Node1

// DLL1
class DLL1 {
	Node1 head = new Node1();
	Node1 tail = new Node1();
	int size = 0;
	// 생성자
	public DLL1() {
		head.Next = tail;
		tail.Prev = head;
	} // end of 생성자
	// add
	void add(int index, int input) {
		if (index < 0 || size < index) {
			System.out.println("불가능");
			return;
		}
		Node1 currentNode1 = head;
		for (int i = 0; i < index; i++) {
			currentNode1 = currentNode1.Next;
		}
		Node1 newNode1 = new Node1();
		newNode1.Data = input;
		newNode1.Prev = currentNode1;
		newNode1.Next = currentNode1.Next;
		currentNode1.Next.Prev = newNode1;
		currentNode1.Next = newNode1;
		size++;
	}
	// end of add
} // end of DLL1