import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;
import java.awt.*;
// I KNOW THIS ISN'T OPTIMIZED YET
// I'M WORKING ON IT
// -SIMON

class ShortestEuclideanDistance {
	static int MAX_COUNT_POINTS = 10000;
	
	public static void main(String[] args) {
		// Generate the random point array
		int pointArray[][] = buildRandomPointArray();
		
		// Display the answer
		System.out.println("Delta: " + ShortestEuclideanDistance(pointArray));
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
	
	public static double ShortestEuclideanDistance(int pointArray[][]) {
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
}