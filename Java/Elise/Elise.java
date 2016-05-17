import java.io.*;
import java.util.*;

class Elise {
	public static void main(String[] args) {
		Groceries g = new Groceries();
		
		g.listGroceries();
		g.addGrocery();
		g.updateGroceries();
	}
}

class Vocabulary {
	private ArrayList<Integer> vocab = new ArrayList<Integer>();
	
	public Vocabulary() {}
	
	public void addWord(String word) {
		
	}
}

class Groceries {
	private String groceries_path = "./local-data/groceries.csv";
	private File f = new File(groceries_path);
	
	private HashMap<String,Double> gl = new HashMap();
	
	public Groceries() {
		// Read the file
		try {
			Scanner scanner = new Scanner(f);
			while (scanner.hasNext()) {
				String next = scanner.nextLine();
				gl.put(next.split(",")[0], Double.parseDouble(next.split(",")[1]));
			}
		} catch (FileNotFoundException e) {
			try {
				f.createNewFile();
			} catch(IOException e1) {
				System.out.printf("IO Exception\n");
			}
		}
	}
	
	public Groceries(File f) {}
	
	public void addGrocery() {
		Scanner keyboard = new Scanner(System.in);
		System.out.printf("Grocery: ");
		String g = keyboard.nextLine();
		System.out.printf("Price: ");
		Double p = keyboard.nextDouble();
		
		gl.put(g, p);
	}
	
	public void listGroceries() {
		for (String names: gl.keySet()) {
			System.out.printf("%s, %f\n", names, gl.get(names));
		}
	}
	
	public void removeGrocery() {
		Scanner keyboard = new Scanner(System.in);
		System.out.printf("Remove: ");
		String item = keyboard.next();
		removeGrocery(item);
	}
	
	public void removeGrocery(String item) {
		gl.remove(item);
	}
	
	public void updateGroceries() {
		try {
			FileWriter write = new FileWriter(groceries_path, false);
			PrintWriter print_line = new PrintWriter(write);
		
			for (String g: gl.keySet()) {
				print_line.printf("%s,%f\n", g, gl.get(g));
			}
			
			print_line.close();
		} catch (IOException e) {
			System.out.printf("Cannot open file");
		}
	}
}