import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 클래스
class UserSolution {
	
	// (선수)
	class Player implements Comparable<Player> {
		int id;
		int ability;
		int leagueId;
		public Player(int id, int avility, int leagueId) {
			this.id = id;
			this.ability = avility;
			this.leagueId = leagueId;
		}
		@Override
		public int compareTo(UserSolution.Player o) {
			return this.ability == o.ability ? this.id - o.id : o.ability - this.ability;
		}
	} // (선수 끝)
	// (리그)
	class League {
		int id;
		List<Player> members;
		public League(int id) {
			this.id = id;
			this.members = new ArrayList<Player>();
		}
	} // (리그 끝)
	// 인덱스파인더
	static int indexFinder(List<Player> M, Player A) {
		int left = 0;
		int right = M.size()-1;
		int mid = 0;
		while (left <= right) {
			mid = (left+right) / 2;
			if (A.compareTo(M.get(mid)) < 0) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
	
	static int Plen;
	static int Llen;
	static int LPlen;
	static int LPlenMid;
	static League[] uLeague;
	
	// [시작]
    void init(int N, int L, int mAbility[]) {
    	Plen = N;
    	Llen = L;
    	LPlen = N / L;
    	LPlenMid = (LPlen + 1)/2;
    	uLeague = new League[L];
    	for (int l = 0; l < Llen; l++) {
    		uLeague[l] = new League(l);
			for (int p = 0; p < LPlen; p++) {
				int n = p + l * LPlen;
				uLeague[l].members.add(new Player(n, mAbility[n], l));
			}
			Collections.sort(uLeague[l].members);
		}
//    	////
//    	System.out.println("시작");
//    	for (int l = 0; l < Llen; l++) {
//			for (int p = 0; p < LPlen; p++) {
//				System.out.print(uLeague[l].members.get(p).id + " ");
//			}
//			System.out.print("| ");
//		}
//    	System.out.println();
//    	for (int l = 0; l < Llen; l++) {
//    		for (int p = 0; p < LPlen; p++) {
//    			System.out.print(uLeague[l].members.get(p).ability + " ");
//    		}
//    		System.out.print("| ");
//    	}
//    	System.out.println();
//    	////
    } // [시작 끝]
    
    // [무브]
    int move() {
    	int result = 0;
    	List<Player> A = new ArrayList<>();
    	List<Player> B = new ArrayList<>();
    	for (int l = 0; l < Llen-1; l++) {
			A.add(uLeague[l].members.get(uLeague[l].members.size()-1));
			B.add(uLeague[l+1].members.get(0));
			uLeague[l].members.remove(uLeague[l].members.size()-1);
			uLeague[l+1].members.remove(0);
		}
    	for (int l = 0; l < Llen-1; l++) {
			uLeague[l].members.add(indexFinder(uLeague[l].members, B.get(l)), B.get(l));
			uLeague[l+1].members.add(indexFinder(uLeague[l+1].members, A.get(l)), A.get(l));
			result += A.get(l).id + B.get(l).id;
		}
//    	////
//    	System.out.println("무브");
//    	for (int l = 0; l < Llen; l++) {
//			for (int p = 0; p < LPlen; p++) {
//				System.out.print(uLeague[l].members.get(p).id + " ");
//			}
//			System.out.print("| ");
//		}
//    	System.out.println();
//    	for (int l = 0; l < Llen; l++) {
//    		for (int p = 0; p < LPlen; p++) {
//    			System.out.print(uLeague[l].members.get(p).ability + " ");
//    		}
//    		System.out.print("| ");
//    	}
//    	System.out.println();
//    	////
        return result;
    } // [무브 끝]
    
    // [트레이드]
    int trade() {
    	int result = 0;
    	List<Player> A = new ArrayList<>();
    	List<Player> B = new ArrayList<>();
    	for (int l = 0; l < Llen-1; l++) {
    		if (l == 0) {
    			A.add(uLeague[l].members.get(uLeague[l].members.size()/2));
    			B.add(uLeague[l+1].members.get(0));
    			uLeague[l].members.remove(uLeague[l].members.size()/2);
    			uLeague[l+1].members.remove(0);
    		} else {
    			A.add(uLeague[l].members.get(uLeague[l].members.size()/2-1));
    			B.add(uLeague[l+1].members.get(0));
    			uLeague[l].members.remove(uLeague[l].members.size()/2-1);
    			uLeague[l+1].members.remove(0);
    		}
		}
    	for (int l = 0; l < Llen-1; l++) {
			uLeague[l].members.add(indexFinder(uLeague[l].members, B.get(l)), B.get(l));
			uLeague[l+1].members.add(indexFinder(uLeague[l+1].members, A.get(l)), A.get(l));
			result += A.get(l).id + B.get(l).id;
		}
//    	////
//    	System.out.println("트레이드");
//    	for (int l = 0; l < Llen; l++) {
//			for (int p = 0; p < LPlen; p++) {
//				System.out.print(uLeague[l].members.get(p).id + " ");
//			}
//			System.out.print("| ");
//		}
//    	System.out.println();
//    	for (int l = 0; l < Llen; l++) {
//    		for (int p = 0; p < LPlen; p++) {
//    			System.out.print(uLeague[l].members.get(p).ability + " ");
//    		}
//    		System.out.print("| ");
//    	}
//    	System.out.println();
//    	////
        return result;
    } // [트레이드 끝]
    
} // 클래스 끝
