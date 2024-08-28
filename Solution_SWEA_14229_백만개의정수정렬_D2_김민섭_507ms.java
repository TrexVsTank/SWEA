import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 클래스 시작
public class Solution_SWEA_14229_백만개의정수정렬_D2_김민섭_507ms {
	
	static int sorted[];
	
	// 메인 시작
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int [1000000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		sorted = new int[arr.length];
		
		merge_sort(arr, 0, arr.length-1);
		
		System.out.println(arr[500000]);
		
	} // 메인 끝
	
	private static void merge_sort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		int mid = (left+right)/2;
		merge_sort(arr, left, mid);
		merge_sort(arr, mid+1, right);
		merge(arr, left, mid, right);
	}
	
	private static void merge(int[] arr, int left, int mid, int right) {
		int L = left;
		int R = mid+1;
		int idx = left;
		while (L < mid+1 && R < right+1) {
			if (arr[L] < arr[R]) {
				sorted[idx] = arr[L];
				L++;
				idx++;
			} else {
				sorted[idx] = arr[R];
				R++;
				idx++;
			}
		}
		while (L < mid+1) {
			sorted[idx] = arr[L];
			L++;
			idx++;
		}
		while (R < right+1) {
			sorted[idx] = arr[R];
			R++;
			idx++;
		}
		for (int i = left; i <= right; i++) {
			arr[i] = sorted[i];
		}
	}
	
} // 클래스 끝