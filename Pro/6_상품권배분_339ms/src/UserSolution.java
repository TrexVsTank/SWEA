import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// 클래스
class UserSolution {
	
	// 부서
	class Department {
		Department parent;
		int id;
		int num;
		int total;
		List<Department> child;
		Department() {
		}
		Department(int id, int num) {
			this.parent = null;
			this.id = id;
			this.num = num;
			this.total = num;
			this.child = new ArrayList<>();
		}
	} // 부서 끝
	
	static Department[] uTop;
	static Map<Integer, Department> uMap;
	static int uTotal;
	
	// 이닛
	public void init(int N, int mId[], int mNum[]) {
		uMap = new HashMap<>();
		uTop = new Department[N];
		uTotal = 0;
		for (int n = 0; n < N; n++) {
			Department currDep = new Department(mId[n], mNum[n]);
			uMap.put(mId[n], currDep);
			uTop[n] = currDep;
			uTotal += mNum[n];
		}
		return;
	} // 이닛 끝
	
	// 추가
	public int add(int mId, int mNum, int mParent) {
		
		if (uMap.get(mParent).child.size() == 3) {
			return -1;
		}

		Department currDep = new Department(mId, mNum);
		uMap.put(mId, currDep);

		Department parentDep = uMap.get(mParent);
		parentDep.total += mNum;
		parentDep.child.add(currDep);
		currDep.parent = parentDep;
		
		int result = parentDep.total;
		
		while (parentDep.parent != null) {
			parentDep.parent.total += mNum;
			parentDep = parentDep.parent;
		}
		
		uTotal += mNum;
		
		return result;
	} // 추가 끝
	
	// 삭제
	public int remove(int mId) {
		if (uMap.get(mId) == null) {
			return -1;
		}
		Department currDep = uMap.get(mId);
		int num = currDep.total;
		Department parentDep = currDep.parent;
		parentDep.child.remove(currDep);
		
		uMap.remove(mId);
		Queue<Department> queue = new ArrayDeque<>();
		queue.offer(currDep);
		while (!queue.isEmpty()) {
			Department q = queue.poll();
			for (Department d : q.child) {
				queue.offer(d);
			}
			uMap.remove(q.id);
		}
		
		parentDep.total -= num;
		while (parentDep.parent != null) {
			parentDep.parent.total -= num;
			parentDep = parentDep.parent;
		}
		
		uTotal -= num;
		
		return num;
	} // 삭제 끝
	
	// 분배
	public int distribute(int K) {
		
		if (uTotal <= K) {
			int max = 0;
			for (int n = 0; n < uTop.length; n++) {
				max = Math.max(max, uTop[n].total);
			}
			return max;
		}
		
		int left = 0;
		int right = K;
		int result = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			int count = K;
			int max = 0;
			for (int n = 0; n < uTop.length; n++) {
				int temp = Math.min(mid, uTop[n].total);
				count -= temp;
				max = Math.max(max, temp);
			}
			if (count >= 0) {
				left = mid + 1;
				result = Math.max(max, result);
			} else {
				right = mid - 1;
			}
		}
		
		return result;
	} // 분배 끝
	
} // 클래스 끝

