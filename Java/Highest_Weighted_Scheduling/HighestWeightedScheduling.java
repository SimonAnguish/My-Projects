class HighestWeightedScheduling {
	public static void main(String[] args) {
		Schedule s = new Schedule();
		Job job = new Job(9, 1.75, 2.00);
		s.addJob(job);
		System.out.println(job.getStartAsTime() + " | " + job.getEndAsTime());
	}
}