/*
Author:		Jerzy Baran
Uow to use:	Create an instance of WordPicker
			Call getWord(WordPicker.WORD_DICTIONARY)
								or	WORD_COUNTRY
								or	WORD_NAME
*/

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
		int noLines = getNumberOfLines(file);
		int randomLine = randomNumber.nextInt(noLines - 1);

		for(int i = 0; i < randomLine; i++) {

			word = scanner.nextLine();
		}

		scanner.close();

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

	private int getNumberOfLines(File f) {

		try {

			Scanner s = new Scanner(f);
			int n = 0;
			while(s.hasNextLine()) {

				s.nextLine();
				n++;
			}

			return n;
		}
		catch(IOException e) {

			System.out.println("ERROR: could not get # of lines");
		}

		return 0;
	}
}