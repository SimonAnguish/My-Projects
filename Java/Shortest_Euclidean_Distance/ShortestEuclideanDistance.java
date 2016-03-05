import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;
import java.awt.*;

class ShortestEuclideanDistance {
	static int MAX_COUNT_POINTS = 100000;
	
	public static void main(String[] args) {
		double delta;
		double new_distance;
		
		int pointArray[][] = buildPointArray();
		delta = calculateDistance(pointArray[0], pointArray[1]);
		new_distance = delta;
		for(int i=0;i<pointArray.length;i++) {
			for (int j=0;j<pointArray.length;j++) {
				if (i != j) {
					new_distance = calculateDistance(pointArray[j], pointArray[i]);
				}
				if (new_distance < delta)
					delta = new_distance;
			}
		}
		System.out.println("Delta: " + delta);
	}
	
	 public static int[][] buildPointArray() {
		// Initialize x and y
		// Initialize whether a copy was found
		int x, y;
		boolean foundCopy = false;
		
		// Initialize a list of x coordinates and y coordinates
		ArrayList<Integer> xCoords = new ArrayList<Integer>();
		ArrayList<Integer> yCoords = new ArrayList<Integer>();
		
		Random rand = new Random();
		
		int pointArray[][] = new int[MAX_COUNT_POINTS][2];
		
		x = rand.nextInt(100);
		y = rand.nextInt(100);
		
		xCoords.add(x);
		yCoords.add(y);
		
		pointArray[0][0] = x;
		pointArray[0][1] = y;
		
		for(int i=1;i<MAX_COUNT_POINTS;i++) {
			
			do {
				x = rand.nextInt(100);
				y = rand.nextInt(100);
				for (int j=0;j<xCoords.size();j++) {
					if (x == xCoords.get(j) && y == yCoords.get(j))
						foundCopy = true;
				}
			
			} while (foundCopy);
			
			xCoords.add(x);
			yCoords.add(y);
			
			pointArray[i][0] = x;
			pointArray[i][1] = y;
		}
		
		return pointArray;
	}

	public static double calculateDistance(int p1[], int p2[]) {
		return Math.sqrt(Math.pow(Math.abs(p1[0] - p2[0]),2) + Math.pow(Math.abs(p1[1] - p2[1]),2));
	}
	}