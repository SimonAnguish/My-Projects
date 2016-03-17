public class Job {
	private int weight;
	private double start;
	private double end;
	
	public Job(int weight, double start, double end) {
		this.weight = weight;
		this.start = start;
		this.end = end;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public double getStart() {
		return start;
	}
	
	public double getEnd() {
		return end;
	}
	
	public String getStartAsTime() {
		int minutes = (int) ((start%1)*60);
		int hours = (int) (start-start%1);
		return hours + ":" + minutes;
	}

	public String getEndAsTime() {
		int minutes = (int) ((end%1)*60);
		int hours = (int) (end-end%1);
		return hours + ":" + minutes;
	}
	
	public String toString() {
		return "Start Time: " + this.getStartAsTime() + "\tEnd Time: " + this.getEndAsTime() + "\t Weight: " + this.getWeight();
	}
}