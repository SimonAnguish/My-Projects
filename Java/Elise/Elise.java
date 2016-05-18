import java.io.*;
import java.util.*;

class Elise {
	public static void main(String[] args) {
		Language l = new Language();
		l.read("What the fuck did you just fucking say about me, you little bitch? I’ll have you know I graduated top of my class in the Navy Seals, and I’ve been involved in numerous secret raids on Al-Quaeda, and I have over 300 confirmed kills. I am trained in gorilla warfare and I’m the top sniper in the entire US armed forces. You are nothing to me but just another target. I will wipe you the fuck out with precision the likes of which has never been seen before on this Earth, mark my fucking words. You think you can get away with saying that shit to me over the Internet? Think again, fucker. As we speak I am contacting my secret network of spies across the USA and your IP is being traced right now so you better prepare for the storm, maggot. The storm that wipes out the pathetic little thing you call your life. You’re fucking dead, kid. I can be anywhere, anytime, and I can kill you in over seven hundred ways, and that’s just with my bare hands. Not only am I extensively trained in unarmed combat, but I have access to the entire arsenal of the United States Marine Corps and I will use it to its full extent to wipe your miserable ass off the face of the continent, you little shit. If only you could have known what unholy retribution your little “clever” comment was about to bring down upon you, maybe you would have held your fucking tongue. But you couldn’t, you didn’t, and now you’re paying the price, you goddamn idiot. I will shit fury all over you and you will drown in it. You’re fucking dead, kiddo.");
		l.generateNonsense();
//		Groceries g = new Groceries();
	}
}

class Language {
	Vocabulary v;
//	private String vocabulary_path = "./local-data/vocab.csv";
//	private File f = new File(vocabulary_path);
//	
//	private HashMap<String,Word> vl = new HashMap();
//	
	public Language() {
		v = new Vocabulary();
//		// Read the file
//		try {
//			Scanner scanner = new Scanner(f);
//			while (scanner.hasNext()) {
//				String next = scanner.nextLine();
//				vl.put(next.split(",")[0], next.split(",")[1]);
//			}
//			
//		} catch (FileNotFoundException e) {
//			try {
//				vf.createNewFile();
//			} catch(IOException e1) {
//				System.out.printf("IO Exception\n");
//			}
//		}
	}
	
	public void read(String text) {
		String[] text_split = text.split(" ");
		String[] word_list = new String[text_split.length + 4];
		word_list[0] = "";
		word_list[1] = "";
		
		int i = 2;
		for (String word: text_split) {
			word_list[i] = word;
			i++;
		}
		
		Random r = new Random();
		String randomKey = text_split[r.nextInt(text_split.length)];
		
		word_list[i] = randomKey;
		i++;
		word_list[i] = randomKey;
		
		Word w;
		
		for (i=2;i<word_list.length-2;i++) {
			w = new Word(word_list[i]);
			w.addPrefix(word_list[i-2], word_list[i-1]);
			w.addSuffix(word_list[i+1], word_list[i+2]);
			v.addWord(w);
		}
	}
	
	public void generateNonsense() {
		Random r = new Random();
		List<String> keys = new ArrayList<String>(v.vl.keySet());
		String randomKey = keys.get(r.nextInt(keys.size()));
		System.out.printf("%s ", randomKey);
		
		String next_word;
//		System.out.println(Arrays.toString(v.vl.get("kiddo.").getSuffix()));
		
		for (int i=0;i<25;i++) {
			while (randomKey == null) {
				randomKey = keys.get(r.nextInt(keys.size()));
			}
			next_word = v.vl.get(randomKey).getSuffix()[0];
			System.out.printf("%s ", next_word);
			randomKey = next_word;
		}
		
//		System.out.printf("%s %s\n", randomKey, v.vl.get(randomKey).getSuffix()[0]);
	}
//	
//	public void add(String word) {
//		vl.put(word, 1);
//	}
//	
//	public void increaseCount(String word) {
//		if (vl.containsKey(word)) {
//			int v = vl.get(word) + 1;
//			vl.put(word, v);
//		} else {
//			add(word);
//		}
//	}
//
//	public void update() {
//		try {
//			FileWriter write = new FileWriter(vocabulary_path, false);
//			PrintWriter print_line = new PrintWriter(write);
//		
//			for (String v: vl.keySet()) {
//				print_line.printf("%s,%d\n", v, vl.get(v));
//			}
//			
//			print_line.close();
//		} catch (IOException e) {
//			System.out.printf("Cannot open file");
//		}
//	}
//	
//	public void list() {
//		for (String words: vl.keySet()) {
//			System.out.printf("%s, %d\n", words, vl.get(words));
//		}
//	}
}

class Vocabulary {
	public HashMap<String, Word> vl = new HashMap();
	
	public Vocabulary() {}
	
	public void addWord(Word word) {
		vl.put(word.toString(), word);
	}
}

class Word {
	private HashMap<String,Integer> prefix = new HashMap();
	private HashMap<String,Integer> suffix = new HashMap();
	private String word;
	
	public Word(String word) {
		this.word = word;
	}
	
	public void addPrefix(String w1, String w2) {
		String p = w1 + " " + w2;
		prefix.put(p, 1);
	}
	
	public void addSuffix(String w1, String w2) {
		String s = w1 + " " + w2;
		suffix.put(s, 1);
	}
	
	public String[] getPrefix() {
		Random r = new Random();
		List<String> keys = new ArrayList<String>(prefix.keySet());
		String randomKey = keys.get(r.nextInt(keys.size()));
		
		return randomKey.split(" ");
	}

	public String[] getSuffix() {
		String[] empty_array = {"cat","dog"};
		Random r = new Random();
		List<String> keys = new ArrayList<String>(suffix.keySet());
		String randomKey = keys.get(r.nextInt(keys.size()));
		return randomKey.split(" ");
	}
	
	public String toString() {
		return word;
	}
}