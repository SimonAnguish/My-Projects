import java.util.*;

class Highest_Weighted_Scheduling {
	static Schedule s = buildSchedule();
	public static void main(String[] args) {
		HighestWeightedScheduling();
	}
	
	public static Schedule buildSchedule() {
		Schedule s = new Schedule();
		
		s.addJob(new Job(9, 1.1, 1.2));
		s.addJob(new Job(14,1.3, 7.9));
		s.addJob(new Job(2, 1.45,6.08));
		s.addJob(new Job(2, 7.3, 9.0));
		s.addJob(new Job(2, 4.06,4.08));
		s.addJob(new Job(2, 1.5,2.08));
		
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
		int p[] = new int[s.size()];
		for (int i=0;i<s.size();i++) {
			p[i] = p(i);
//			System.out.printf("i: %d\tp(i): %d\n", i, p[i]);
		}
	}
}