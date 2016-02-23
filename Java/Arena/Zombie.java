public class Zombie implements Enemy {
	int max_health,
		curr_health,
		max_armor,
		curr_armor,
		max_dmg,
		curr_dmg;
		
	String name = "";
	
	private String type = "zombie";
	
	public Zombie(String name, int health, int armor, int dmg) {
		this.max_health = health;
		this.curr_health = health;
		this.max_armor = armor;
		this.curr_armor = armor;
		
		this.name = name;
	}
	
	public int dealDamage() {
		return this.curr_dmg;
	}

	public String announce() {
		if (name == "") return "An unnamed zombie approaches";
		return name + " approaches";
	}
	
	public String getType() {
		return this.type;
	}
}