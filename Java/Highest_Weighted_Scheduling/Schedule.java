import java.util.*;

public class Schedule {
	ArrayList<Job> SCHEDULE = new ArrayList<Job>();
	
	public Schedule() {
		
	}
	
	public void addJob(Job job) {
		SCHEDULE.add(job);
	}
}