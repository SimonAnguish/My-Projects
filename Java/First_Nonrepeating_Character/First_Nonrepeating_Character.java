import java.util.Scanner;
import java.util.ArrayList;

class First_Nonrepeating_Character {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.printf("Print the phrase to test: ");
		String s = keyboard.next();
		ArrayList<Character> arr = new ArrayList<Character>();
		ArrayList<Character> blacklist = new ArrayList<Character>();
		for (int i=0; i<s.length();i++) {
			Character c = s.charAt(i);
			if (arr.contains(c)){
				blacklist.add(c);
				arr.remove(arr.indexOf(c));
			}
			else if (!blacklist.contains(c)) {
				arr.add(c);
			}
			System.out.println(c + "|" + blacklist + "|" + arr);
		}
		if (arr.size() == 0) System.out.println("There are no non-repeating characters");
		else System.out.printf("%c", arr.get(0));
	}
}