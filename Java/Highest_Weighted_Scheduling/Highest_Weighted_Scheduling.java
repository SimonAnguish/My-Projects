import java.util.*;

class Highest_Weighted_Scheduling {
	static Schedule s = buildSchedule();
	static int m[] = new int[s.size()];
	static int p[] = new int[s.size()];
	public static void main(String[] args) {
		HighestWeightedScheduling();
	}
	
	public static Schedule buildSchedule() {
		Schedule s = new Schedule();
		
		s.addJob(new Job(3, 0.0, 3.0));
		s.addJob(new Job(1, 2.0, 5.0));
		s.addJob(new Job(2, 4.0, 7.0));
		s.addJob(new Job(6, 6.0, 9.0));
		s.addJob(new Job(4, 8.0, 11.0));
		
		return s;
	}
	
	private static int p(int index) {
		for (int i=index;i!=-1;i--) {
//			System.out.println(s.getJob(i).getEnd() + " | " + s.getJob(index).getStart());
			if (s.getJob(i).getEnd() < s.getJob(index).getStart())
				return i;
		}
		
		return -1;
	}
	
	private static void HighestWeightedScheduling() {
		s.sortByEndTime();
		System.out.println(s.toString());
		
		// p-values for the ith job
//		int p[] = new int[s.size()];
		for (int i=0;i<s.size();i++) {
			p[i] = p(i);
//			System.out.printf("i: %d\tp(i): %d\n", i, p[i]);
		}
		
		int max = Compute_Opt();
		System.out.printf("Highest weight value: %d\n", max);
	}
	
	private static int max(int i, int j) {
		if (i > j) return i;
		if (j > i) return j;
		else return i;
	}
	
	private static int Compute_Opt() {
		m[0] = s.getJob(0).getWeight();
		int val = 0;
		int max = 0;
		for (int j=1;j<s.size();j++) {
			if (p[j] == -1) val = 0;
			else val = m[p[j]];
			m[j] = max(s.getJob(j).getWeight() + val, m[j-1]);
			max = j;
		}
		
		return m[max];
	}
}