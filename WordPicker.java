import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Random;

class WordPicker {

	//constants so you don't have to remember the numbers
	public static final int WORD_DICTIONARY = 1;
	public static final int WORD_COUNTRY = 2;
	public static final int WORD_NAME = 3;

	private Random randomNumber = new Random();

	private File file;
	private Scanner scanner;

	public String getWord(int category) {

		String fileName = "";
		String word = null;

		if(category == WORD_DICTIONARY)
			fileName = "words.txt";
		else if(category == WORD_COUNTRY)
			fileName = "countries.txt";
		else
			fileName = "names.txt";

		openFile(fileName);
		int randomLine = randomNumber.nextInt(713);  //1-714

		for(int i = 0; i < randomLine; i++) {

			word = scanner.nextLine();
		}

		return word;
	}

	private void openFile(String name) {

		try {
			file = new File(name);
			scanner = new Scanner(file);
		}
		catch(IOException e) {

			System.out.printf("ERROR: could not read from word list file %s\n" + 
				"Stack trace:\n", name);
			e.printStackTrace();
		}
	}
}