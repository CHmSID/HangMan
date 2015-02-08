import java.util.Scanner;
import java.util.Random;

class HangMan {
	public static void main(String [] args) {
		String guess ="";
		Random rand = new Random();
		int randomNumber = rand.nextInt(9) + 0;	//generate a random number.
		
		String [] countries = {"brazil","canada","colombia","oman","ireland",
								"france","spain","poland","qatar","egypt"};
		
		//String [] names = {};
		
		
		Scanner in = new Scanner(System.in);
		System.out.printf("%40s\n","HangMan");	//Name of the game.
		System.out.printf("%s\n%s\n%s","Choose a category","1-country","2-names");
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
		
		int wordNum =0;	//the number of _ ;
		
		for(int i=0;i<guess.length();i++){
			wordNum++;
		}
		
		
		while(wordNum>0){
			System.out.println();	//new line.
			System.out.print("The word is : ");
			
			for(int i =0;i<wordNum;i++){
				System.out.print("_");
			}
			System.out.println();	//new line.
			
			char letter = in.next().charAt(0);	//take the first letter.
			
			for(int i=0;i<guess.length();i++){	//see if the input == one of the letters.
				if(letter==guess.charAt(i)){
					System.out.print(letter);
					wordNum--;
				}
				else{
					System.out.print("_");
				}
			}
		}
	}	
		
	}	














