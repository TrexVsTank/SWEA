import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 클래스
class UserSolution {
	
	// 학생
	class Student implements Comparable<Student> {
		int id;
		int grade;
		String gender;
		int score;
		public Student(int id, int grade, String gender, int score) {
			this.id = id;
			this.grade = grade;
			this.gender = gender;
			this.score = score;
		}
		@Override
		public int compareTo(Student o) {
			if (this.score == o.score) {
				return this.id - o.id;
			}
			return this.score - o.score;
		}
	} // 학생
	
	// 인덱스파인더
	static int indexFinder(List<Student> list, Student s) {
		int left = 0;
		int right = list.size()-1;
		int mid = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			if (s.compareTo(list.get(mid)) < 0) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	} // 인덱스파인더 끝
	// 인덱스파인더
	static int indexFinder(List<Student> list, int s) {
		int left = 0;
		int right = list.size()-1;
		int mid = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			if (list.get(mid).score >= s) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	} // 인덱스파인더 끝
	
	static Map<Integer, Student> uStudent;
	static Map<String, List<List<Student>>> uGender;
	
	// [시작]
	public void init() {
		uStudent = new HashMap<>();
		uGender = new HashMap<>();
		List<List<Student>> uMale = new ArrayList<>();
		List<List<Student>> uFemale = new ArrayList<>();
		for (int g = 0; g <= 4; g++) {
			uMale.add(new ArrayList<>());
			uFemale.add(new ArrayList<>());
		}
		uGender.put("male", uMale);
		uGender.put("female", uFemale);
		return;
	} // [시작 끝]

	// [추가]
	public int add(int mId, int mGrade, char mGender[], int mScore) {
		int id = mId;
		int grade = mGrade;
		String gender = new String(mGender).trim();
		int score = mScore;
		Student A = new Student(id, grade, gender, score);
		uStudent.put(id, A);
		List<Student> group = uGender.get(gender).get(grade);
		group.add(indexFinder(group, A), A);
		return group.get(group.size()-1).id;
	} // [추가 끝]

	// [삭제]
	public int remove(int mId) {
		Student A = uStudent.getOrDefault(mId, null);
		if (A == null) {
			return 0;
		}
		String gender = A.gender;
		int grade = A.grade;
		List<Student> group = uGender.get(gender).get(grade);
		group.remove(A);
		if (group.isEmpty()) {
			return 0;
		}
		return group.get(0).id;
	} // [삭제 끝]

	// [조회]
	public int query(int mGradeCnt, int mGrade[], int mGenderCnt, char mGender[][], int mScore) {
		int MIN_SCORE = 2_000_000_000;
		int MIN_ID = 0;
		for (int gr = 0; gr < mGradeCnt; gr++) {
			for (int ge = 0; ge < mGenderCnt; ge++) {
				String gender = new String(mGender[ge]).trim();
				int grade = mGrade[gr];
				List<Student> group = uGender.get(gender).get(grade);
				int index = indexFinder(group, mScore);
				if (index == group.size()) {
					continue;
				}
				if (group.get(index).score == MIN_SCORE && group.get(index).id < MIN_ID) {
					MIN_ID = group.get(index).id;
				}
				if (group.get(index).score < MIN_SCORE) {
					MIN_SCORE = group.get(index).score;
					MIN_ID = group.get(index).id;
				}
			}
		}
		return MIN_ID;
	} // [조회 끝]
	
} // 클래스 끝
