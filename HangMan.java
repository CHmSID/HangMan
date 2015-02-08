import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

class HangMan {
	public static void main(String [] args) {
		String guess ="";
		Random rand = new Random();
		int randomNumber = rand.nextInt(9) + 0;	//generate a random number.
		ArrayList<Integer> word = new ArrayList<>();
		
		
		
		String [] countries = {"brazil","canada","colombia","oman","ireland",
								"france","spain","poland","qatar","egypt"};
		
		//String [] names = {};
		
		
		Scanner in = new Scanner(System.in);
		System.out.printf("%40s\n","HangMan");	//Name of the game.
		System.out.printf("%s\n%s\n%s\n","Choose a category","1-country","2-names");
		System.out.printf("%s","Please select a number (1 or 2): ");
		int j = in.nextInt();
		
		if(j==1){
			 guess = countries[randomNumber];
		}
		else if(j==2){
			;// name.
		}
		else {
			System.out.println("Invalid Input");
		}
		
		
		
		for(int i=0;i<guess.length();i++){
			word.add(0);		//let the ArrayList be 0.
		}
		
		int num=0;
		while(num < guess.length()){
			for(int i=0;i<guess.length();i++){
				if(word.get(i)==0){			//if it's 0 == not gueesed.
					System.out.print("_ ");
				}
				else{						//if it's 1 already guessed.
					System.out.print(guess.charAt(i));
				}
			}
			System.out.printf("%s\n","Guess the letter: ");
			char let =in.next().charAt(0);
			
			for(int i=0;i<guess.length();i++){
				if(let==guess.charAt(i)){
					word.set(i,1);
					num++;
				}
				else{
					;//do nothing for now.
				}
			}
			
		}

		System.out.println("The word was : "+guess);
		
	}
}	














