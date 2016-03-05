import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Comparator;
import java.awt.*;
// I KNOW THIS ISN'T OPTIMIZED YET
// I'M WORKING ON IT
// -SIMON

class ShortestEuclideanDistance {
	static int MAX_COUNT_POINTS = 50;
	
	public static void main(String[] args) {
		// Generate the random point array
		int pointArray[][] = buildRandomPointArray();
		
		// Display the answer
		System.out.println("Delta (Brute Force): " + ShortestEuclideanDistanceBruteForce(pointArray));
		System.out.println("Delta (Optimal): " + ShortestEuclideanDistance(pointArray));
	}
	
	 public static int[][] buildRandomPointArray() {
		// Initialize:
		// x and y
		// whether a copy was found
		// random
		// array of x,y coordinates
		// x and y coordinates to check if they've been used yet
		int x, y;
		boolean foundCopy = false;
		Random rand = new Random();
		int pointArray[][] = new int[MAX_COUNT_POINTS][2];
		ArrayList<Integer> xCoords = new ArrayList<Integer>();
		ArrayList<Integer> yCoords = new ArrayList<Integer>();
		
		// Fill up the pointArray with (x,y) coordinate values
		for(int i=0;i<MAX_COUNT_POINTS;i++) {
			// Generate the random numbers
			do {
				// Calculate x and y
				x = rand.nextInt((int)Math.ceil(Math.pow(MAX_COUNT_POINTS,1.5)));
				y = rand.nextInt((int)Math.ceil(Math.pow(MAX_COUNT_POINTS,1.5)));
				// Check if the value is already in the set
				for (int j=0;j<xCoords.size();j++) {
					if (x == xCoords.get(j) && y == yCoords.get(j))
						foundCopy = true;
				}
			
			} while (foundCopy);
			
			// Add x to the known xCoordinates
			xCoords.add(x);
			
			// Add y to the known yCoordinates
			yCoords.add(y);
			
			// Plot x and y in the pointArray
			pointArray[i][0] = x;
			pointArray[i][1] = y;
		}
		
		return pointArray;
	}

	public static double calculateDistance(int p1[], int p2[]) {
		return Math.sqrt(Math.pow(Math.abs(p1[0] - p2[0]),2) + Math.pow(Math.abs(p1[1] - p2[1]),2));
	}
	
	public static double ShortestEuclideanDistanceBruteForce(int pointArray[][]) {
		// Initialize:
		// Delta is the minimum distance found
		// new_distance is the current distance to test
		double delta;
		double new_distance;
		
		// Calculate the distance between the first two points to test
		delta = calculateDistance(pointArray[0], pointArray[1]);
		new_distance = delta;
		
		// For each of the points, check if each other points is farther or closer than delta
		for(int i=0;i<pointArray.length;i++) {
			for (int j=0;j<pointArray.length;j++) {
				if (i != j) {
					new_distance = calculateDistance(pointArray[j], pointArray[i]);
				}
				if (new_distance < delta)
					delta = new_distance;
			}
		}
		
		// Return the smallest distance found
		return delta;
	}
	
	public static double ShortestEuclideanDistance(int points[][]) {
		if (points.length <= 3) {
			return ShortestEuclideanDistanceBruteForce(points);
		}
		
		int firstHalf = (int) Math.ceil(points.length/2);
		int secondHalf = points.length - firstHalf;
		double partitionLine;
		int partitionOne[][] = new int[firstHalf][2];
		int partitionTwo[][] = new int[secondHalf][2];
		int partitionDelta[][] = new int[points.length][2];
		int delta_counter = 0;
		
		// Compute separation line L such that half the points are on one side and half on the other side.
		// L is between firstHalf and secondHalf
		// Sort
		Arrays.sort(points, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[0], b[0]);
			}
		});
		
		partitionLine = (double) (points[firstHalf][0] + points[firstHalf+1][0]) / 2;
		
		for (int i=0;i<points.length;i++) {
			if (i < firstHalf) {
				partitionOne[i][0] = points[i][0];
				partitionOne[i][1] = points[i][1];
			} else {
				partitionTwo[i-firstHalf][0] = points[i][0];
				partitionTwo[i-firstHalf][1] = points[i][1];
				
			}
		}
		
		double shortestLengthLeft = ShortestEuclideanDistance(partitionOne);
		double shortestLengthRight = ShortestEuclideanDistance(partitionTwo);
		
		double delta = Math.min(shortestLengthLeft, shortestLengthRight);
		
		for (int i=0;i<points.length;i++) {
			if (Math.abs(points[i][0] - partitionLine) < delta) {
				partitionDelta[delta_counter][0] = points[i][0];
				partitionDelta[delta_counter][1] = points[i][1];
			}
		}
		
		return delta;
	}
}