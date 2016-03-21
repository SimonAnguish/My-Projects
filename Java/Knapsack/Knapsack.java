import java.util.*;

class Knapsack {
//	static int ITEM_COUNT = 5;
	static int TENSILE_STRENGTH = 11;
	
	public static Sack ks = new Sack();
	public static House h = new House();
	public static void main(String[] args) {
		// Generate the Items from the example in class
		Item i1 = new Item(1, 1);
		Item i2 = new Item(3, 6);
		Item i3 = new Item(5, 18);
		Item i4 = new Item(6, 22);
		Item i5 = new Item(7, 28);
		
		// Add all the items to the 'house'
		h.add(i1);
		h.add(i2);
		h.add(i5);
		h.add(i4);
		h.add(i3);
		
		// Call the algorithm
		int max = Knapsack_A(TENSILE_STRENGTH, h.size()-1);
		System.out.printf("Takeaway Value: %d\n", max);
	}
	
	/*
		Calculates with items we should steal
		@return - Sack: The full sack we have after stealing everything
	*/
	public static int Knapsack_A(int w, int j) {
		if (j == 0) return 0;
		else if (h.get(j).weight > w) return Knapsack_A(w, j-1);
		else {
			int v1 = h.get(j).value + Knapsack_A(w - h.get(j).weight, j-1);
			int v2 = Knapsack_A(w, j-1);
			if (v1 >= v2) {
				// Add object j to the knapsack
				return v1;
			}
			else return v2;
		}
	}
}

class Sack extends ArrayList<Item> {
	public Sack() {}
}

class House extends ArrayList<Item> {
	public House() {}
}

class Item {
	public int weight;
	public int value;
	public int index;
	
	public Item() {
		this.weight = 0;
		this.value = 0;
	}
	
	public Item(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}
	
	public String toString() {
		return "Weight: " + this.weight + "\tValue: " + this.value;
	}
}