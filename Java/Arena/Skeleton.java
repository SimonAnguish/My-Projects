public class Skeleton implements Enemy{
	int max_health,
		curr_health,
		max_armor,
		curr_armor,
		max_dmg,
		curr_dmg;
		
	String name = "";
	
	String type = "skeleton";
		
	public Skeleton(String name, int health, int armor, int dmg) {
		this.max_health = health;
		this.curr_health = health;
		this.max_armor = armor;
		this.curr_armor = armor;
		
		this.name = name;
	}
	
	public Skeleton(int health, int armor, int dmg) {
		this.max_health = health;
		this.curr_health = health;
		this.max_armor = armor;
		this.curr_armor = armor;
	}
	
	public int dealDamage() {
		return this.curr_dmg;
	}
	
	public String announce() {
		if (name == "") return "An unnamed skeleton approaches";
		return name + " approaches";
	}

	public String getType() {
		return this.type;
	}
}