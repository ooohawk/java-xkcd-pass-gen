import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class XKCDPasswordGenerator {

	public static void main(String[] args) {
		ArrayList<String> words = read_words();
		ArrayList<String> user_words = new ArrayList<String>();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("How many words would you like in your password? (reccomended: 3-4) ");
		int num_words = scan.nextInt();
		scan.close();
		
		for(int i = 0; i<num_words; i++) {
			String word = get_word(words);
			user_words.add(word);
		}
		
		combine(user_words);
	}
	
	public static String get_word(ArrayList<String> words) {
		Random rand = new Random();
		int ind = rand.nextInt(words.size()) + 0; //index of words to get
		
		return words.get(ind);
	}
	
	public static ArrayList<String> read_words() {
		// filename and line being read
		String filename = "uncommon_words.txt"; //from: http://www.manythings.org/vocabulary/lists/l/words.php?f=noll15
		String line;
		ArrayList<String> uncommon_data = new ArrayList<String>();
		
		try {
			FileReader file = new FileReader(filename);
			BufferedReader buff = new BufferedReader(file);
			
			while(buff.readLine() != null) {
				line = buff.readLine();
				uncommon_data.add(line);
			}
					
			buff.close(); //close buffered reader
					
		}
				
		catch (FileNotFoundException ex) {
			System.out.println("Error while opening file: " + filename);
			ex.printStackTrace();
		}
			
		catch (IOException ex) {
			System.out.println("Error while reading file: " + filename);
			ex.printStackTrace();
		}
				
		return uncommon_data;
	}
	
	public static String combine(ArrayList<String> args) {
		Random rand = new Random();
		String result = "";
		
		for(int i = 0; i < args.size(); i++) {
			result += args.get(i);
		}
		
		String specials = "<>!-=+_@#$%^&*/?~";
		int ind_spec = rand.nextInt(specials.length());
		char special_char = specials.charAt(ind_spec);
		
		StringBuilder result_special = new StringBuilder(result);
		result_special.insert(rand.nextInt(result.length()), special_char);
		System.out.println("Password: " + result_special.toString());
		
		return result_special.toString();
	}

}
