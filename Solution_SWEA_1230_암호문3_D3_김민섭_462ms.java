
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// class
public class Solution_SWEA_1230_암호문3_D3_김민섭_462ms {
	// main
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;
		// testCase
		for (int t = 1; t <= T; t++) {
			// Input
			DLL dll = new DLL();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer stN = new StringTokenizer(br.readLine(), " ");
			for (int n = 0; n < N; n++) {
				int input = Integer.parseInt(stN.nextToken());
				dll.add(n, input);
			}
			int M = Integer.parseInt(br.readLine());
			StringTokenizer stM = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; m++) {
				String order = stM.nextToken();
				if (order.equals("I")) {
					int where = Integer.parseInt(stM.nextToken());
					int num = Integer.parseInt(stM.nextToken());
					for (int n = 0; n < num; n++) {
						int number = Integer.parseInt(stM.nextToken());
						dll.add(where+n, number);
					}
				} else if (order.equals("D")) {
					int where = Integer.parseInt(stM.nextToken());
					int num = Integer.parseInt(stM.nextToken());
					for (int n = 0; n < num; n++) {
						dll.remove(where);
					}
				} else {
					int num = Integer.parseInt(stM.nextToken());
					for (int n = 0; n < num; n++) {
						int number = Integer.parseInt(stM.nextToken());
						dll.add(dll.size-1, number);
					}
				}
			} // end of Input
			
			sb.append("#").append(t).append(" ");
			Node current = dll.head;
			for (int i = 0; i < 10; i++) {
				current = current.Next;
				sb.append(current.Data).append(" ");
			}
			sb.append("\n");
			
		} // end of testCase
		
		System.out.println(sb);
		
	} // end of main
} // end of class

// Node
class Node {
	int Data;
	Node Prev;
	Node Next;
} // end of Node

// DLL
class DLL {
	Node head = new Node();
	Node tail = new Node();
	int size = 0;
	// 생성자
	public DLL() {
		head.Next = tail;
		tail.Prev = head;
	} // end of 생성자
	// add
	void add(int index, int input) {
		if (index < 0 || size < index) {
			System.out.println("삽입불가");
			return;
		}
		Node currentNode = head;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.Next;
		}
		Node newNode = new Node();
		newNode.Data = input;
		newNode.Prev = currentNode;
		newNode.Next = currentNode.Next;
		currentNode.Next.Prev = newNode;
		currentNode.Next = newNode;
		size++;
	} // end of add
	// remove
	void remove(int index) {
		if (index < 0 || size < index) {
			System.out.println("삭제불가");
			return;
		}
		Node currentNode = head;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.Next;
		}
		currentNode.Prev.Next = currentNode.Next;
		currentNode.Next.Prev = currentNode.Prev;
		size--;
	} // end of remove
} // end of DLL