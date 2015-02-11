/*
	Author:		Mohammed Al Marhoon
	
	How to use: pick a number between 1-3 and then play the hangman game.
				you only have 10 guesses.



*/
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

class HangMan {
	public static void main(String [] args) {
		Random rand = new Random();
		WordPicker pick = new WordPicker();
		ArrayList<Integer> word = new ArrayList<>();
		
		Scanner in = new Scanner(System.in);
		System.out.printf("%40s\n%s\n","HangMan","Keep in mind you only have 20 guesses.");	//Name of the game.
		System.out.printf("%s\n%s\n%s\n%s\n%s\n","Choose a category","1- word","2- country","3- name","4- Random");
		System.out.printf("%s","Please select a number : ");
		int j = in.nextInt();
		
		if(j==4){							//pick a random category.
			j = rand.nextInt(3) + 1;
		}
		
		String guess =pick.getWord(j);		//getting a random word.
		guess = guess.toLowerCase();		//convert it to lowercase.
		
		
		for(int i=0;i<guess.length();i++){
			word.add(0);					//let the ArrayList be 0.
		}
        
        for(int i=0;i<guess.length();i++){  //check if there is a space in the word
            if(guess.charAt(i)==' '){
                word.set(i,1);
            }
        }
        
		
		int num = 20; //the player only have 20 guesses.
		int guessedLet=0;
		while(num >0 ){
		
			for(int i=0;i<guess.length();i++){
				if(word.get(i)==0){			//if it's 0 == not gueesed.
					System.out.print("_ ");
				}
				else{						//if it's 1 already guessed.
					System.out.print(guess.charAt(i));
				}
			}
			
			System.out.println();		//new line.
			System.out.printf("%s","Guess a letter: ");
			char let =in.next().charAt(0);
			let=Character.toLowerCase(let);
			
			for(int i=0;i<guess.length();i++){
				if(let==guess.charAt(i)){
					if(word.get(i)==1){		// check if the letter was guessed previously. 
						num++;
					}
					else{
						word.set(i,1);
						guessedLet++;
					}
				}
				else{
					;//do nothing for now
				}
			}
			num--;	
			if(guessedLet==guess.length()){
				System.out.println("You guessed the correct word.");
				System.out.println("You took "+(20-num)+" tries.");
				num=0;
			}
		}
		if(guessedLet!=guess.length()){
			System.out.println("You didn't guess the correct word.");
		}
		System.out.println("The word was : "+guess);
	}
}	














