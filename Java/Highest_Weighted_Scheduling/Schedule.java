import java.util.*;

public class Schedule {
	private ArrayList<Job> SCHEDULE;
	
	public Schedule() {
		SCHEDULE = new ArrayList<Job>();
	}
	
	public void addJob(Job job) {
		SCHEDULE.add(job);
	}
	
	public void removeJob(Job job) {
		int i = SCHEDULE.indexOf(job);
		SCHEDULE.remove(i);
	}
	
	public Job getJob(int i) {
		return SCHEDULE.get(i);
	}
	
	public void sortByEndTime() {
		ArrayList<Job> temp = new ArrayList<Job>();
		Job min_j;
		
		while (SCHEDULE.size() > 0) {
			min_j = SCHEDULE.get(0);
			for (int i=1;i<SCHEDULE.size();i++) {
				if (SCHEDULE.get(i).getEnd() < min_j.getEnd()) {
					min_j = SCHEDULE.get(i);
				}
			}
			
			temp.add(min_j);
			SCHEDULE.remove(SCHEDULE.indexOf(min_j));
		}
		
		SCHEDULE = temp;
	}
	
	public int size() {
		return SCHEDULE.size();
	}
	
	public String toString() {
		String s = "";
		for (Job j: SCHEDULE) {
			s = s + SCHEDULE.indexOf(j) + "\t" + j.toString() + "\n";
		}
		
		return s;
	}
}