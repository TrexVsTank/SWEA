import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

// Solution_SWEA_1222_계산기1_D4_김민섭_125ms

public class Solution_SWEA_1222_계산기1_D4_김민섭_125ms {
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		
		for (int t = 1; t <= T; t++) { // 테케 시작
			
			int N = Integer.parseInt(br.readLine());
			
			String str = br.readLine();
			
			Stack<String> sta = new Stack<>();
			
			String postfix = InfixTopostfix(str);
			
			int result = postfixCalculate(postfix);
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
			
		} // 테케 끝
		
		System.out.println(sb);
		
	} // end of main
	
	////
	static Map<Character, Integer> map = new HashMap<>();
	
	static {
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
//		map.put('(', 0);
	}
	
	static String InfixTopostfix(String infix) {
		String postfix = "";
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			// 피연산자
			if ('0' <= c && c <= '9') {
				postfix += c;
			// 여는 괄호는 스택에 push
			} else if (c == '(') {
				stack.push(c);
			// 닫는 괄호는 여는 괄호가 나올 때 까지 pop
			} else if (c == ')') {
				char popItem = stack.pop();
				while (popItem != '(') {
					postfix += popItem;
					popItem = stack.pop();
				}
			// 연산자 스택의 마지막에
			// 우선순위가 낮은 연산자가 올 때까지 pop
			} else {
				while (!stack.isEmpty() &&
						stack.peek() != '(' &&
						map.get(stack.peek()) >= map.get(c)) {
					
					char popItem = stack.pop();
					postfix += popItem;
				}
				stack.push(c);
			}
		}
		// 스택 비워주기
		while (!stack.isEmpty()) {
			postfix += stack.pop();
		}
		return postfix;
	}
	
	static int postfixCalculate(String postfix) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			if ('0' <= c && c <= '9') {
				stack.push(c-'0');
			} else if (c == '+') {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(a+b);
			} else if (c == '*') {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(a*b);
			}
		}
		return stack.pop();
	}
	////
	
} // end of class

