import java.util.*;

class Fight {
	public static void main(String[] args) {
		ArrayList<String> name_list = new ArrayList<String>();
		Random rand_gen = new Random();
		name_list = addNames(name_list);
		
		// Get a random name
		int index = rand_gen.nextInt(name_list.size());
		String enemy_name = name_list.get(index);
		
		Troll t = new Troll(enemy_name, 50, 0, 8);
		Skeleton s = new Skeleton(enemy_name, 20, 15, 15);
		Zombie z = new Zombie(enemy_name, 30, 10, 10);

		System.out.println(e.announce());
		System.out.println("(" + e.getType() + ")");
	}
	
	private static ArrayList addNames(ArrayList name_list) {
		name_list.add("Jannet");
		name_list.add("Greg (your former boss)");
		name_list.add("xXxCh@dPunch3rxXx the white knight");
		
		return name_list;
	}
}