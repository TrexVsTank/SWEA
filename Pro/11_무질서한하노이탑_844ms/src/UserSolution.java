import java.util.Arrays;
import java.util.Stack;

// 유저솔루션
class UserSolution {
	
	// HANOI
	static void HANOI(int idx, int to) {
		if (idx == -1 || uCount == 0) {
			return;
		}
		if (uDisk[idx][1] == to) {
			HANOI(idx-1, to);
		} else if (uPoll[uDisk[idx][1]].peek() == uDisk[idx][0] && (uPoll[to].isEmpty() || uPoll[to].peek() > uDisk[idx][0])) {
			uPoll[to].push( uPoll[uDisk[idx][1]].pop() );
			uDisk[idx][1] = to;
			uCount--;
		} else {
			uOrder.push(new int[] {idx, to});
			HANOI(idx-1, 3-uDisk[idx][1]-to);
		}
	} // HANOI
	
	static int[][] uDisk;
	static Stack<Integer>[] uPoll;

	static int uTarget;
	static int uCount;
	static Stack<int[]> uOrder;
	
	// 100. 시작	
    void init(int N[], int mDisk[][]) {
    	uDisk = new int[N[0] + N[1] + N[2]][2]; int idx = 0;
    	uPoll = new Stack[3]; for (int i = 0; i < 3; i++) uPoll[i] = new Stack<>();
    	for (int p = 0; p < 3; p++) {
			for (int d = N[p]-1; d >= 0; d--) {
				int currDisk = mDisk[p][d];
				uPoll[p].push(currDisk);
				uDisk[idx++] = new int[] {currDisk, p};
			}
		}
    	Arrays.sort(uDisk, (a, b) -> { return a[0] - b[0]; } );
    	
    	uTarget = uDisk.length-1;
    	uCount = 0;
    	uOrder = new Stack<>();
    	uOrder.push(new int[] {uTarget, 2});
    } // 100. 시작
    
    // 300. 이동
    void go(int k, int mTop[]) {
    	uCount = k;
    	while (uCount > 0 && !uOrder.isEmpty()) {
    		if (uDisk[uTarget][1] != 2) {
    			int[] temp = uOrder.pop();
    			HANOI(temp[0], temp[1]);
    		} else {
    			while (uTarget >= 0 && uDisk[uTarget][1] == 2)
    			uTarget--;
    		}
    		if (uOrder.isEmpty() && uTarget > 0) {
    			uOrder.push(new int[] {uTarget, 2});
    		}
    	}
    	for (int i = 0; i < 3; i++) {
			mTop[i] = uPoll[i].isEmpty() ? 0 : uPoll[i].peek();
		}
    } // 300. 이동
    
    // 200. 종료
    void destroy() {
    } // 200. 종료
    
} // 유저솔루션
