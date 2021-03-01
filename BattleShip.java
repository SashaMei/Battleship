import java.util.*;
public class BattleShip {
	//set up integer ocean board outside all methods
	public static int []oceanBoard = new int [51];
	//create the guessBoard and print guessBoard out
	public static char [] guessBoard = new char[51];
	public final static int SHIP1=2;
	public final static int SHIP2=3;
	public final static int SHIP3=4;
	public static int miss = 0, ship1=0, ship2=0, ship3=0;
	
	
	public static void main(String[] args) 
	{
		int guessNumber;
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		int startPoint = 0;
		String userAnswer;
		//set up ship sizes array and assign value to ship sizes array
		int []shipSizes = {SHIP1, SHIP2, SHIP3};
		do {
			
			for(int k=0; k<oceanBoard.length; k++)
			{
				oceanBoard[k]=0;
			}
			//nested for loop to place ships throw the ship sizes
			for(int i=0; i<shipSizes.length; i++) 
			{
				//create random number 
				int range = oceanBoard.length-shipSizes[i];
				do {
				startPoint = rand.nextInt(range);
				}while(!isOceanBoardAvailable(startPoint, shipSizes[i]));		//changed
				//figure out the starting point whether is available
		
					//replace the values in the ocean board
					 for (int j=startPoint; j<shipSizes[i]+startPoint; j++)
					 {
						
						 oceanBoard[j]=shipSizes[i];
					 }
				 
			}
			//print header
			
							///////////printing out ship location for testing
			/*for (int i=0; i<oceanBoard.length;i++)
			{
				System.out.print(oceanBoard[i]+" ");
				//System.out.print(guessBoard[i]+" ");
			}*/
			
			
			System.out.println("Welcome to Battleship! ");
			System.out.println("The sizes of the ships are:[" + SHIP1+ ","+SHIP2+","+SHIP3+"]");
			System.out.println("Enter a number to fire at the ship. you only get 10 misses!");
			for (int i=0; i<guessBoard.length;i++)
			{
				guessBoard[i]='-';
				//System.out.print(guessBoard[i]+" ");
			}
			//check the guess number with guess board number 
			do {
				System.out.printf("\nHere are your shots so far(H is hit, M is miss): \n");
				//print out ocean board
				for (int i=0; i<oceanBoard.length;i++)
				{
					System.out.print(i+" ");
				}
				System.out.println();
				for (int i=0; i<guessBoard.length;i++)
				{
					System.out.print(guessBoard[i]+" ");
				}
				//prompt user input guess number
				
				System.out.printf("%nFire away! Aim for a location between 0 and 50 %n");
				guessNumber = Integer.parseInt(input.nextLine());
				for (int i=0;i<guessBoard.length;i++) {
					System.out.print(guessBoard[i]+" ");
				}
				
			}while (keepPlaying(guessNumber));
			miss = 0; ship1=0; ship2=0; ship3=0;
			userAnswer=input.nextLine();
		}while(userAnswer.equalsIgnoreCase("Y"));
		System.out.println("Thanks! Good-bye!");
		
		
	}//end main
	
	public static boolean isOceanBoardAvailable(int startPoint,  int shipSize)
	{
		boolean available = false;
		/*for(int i=0; i<oceanBoard.length;i++) {
			oceanBoard[i]=0;
		}*/
		//check each place in board with start point for ship size time
		for (int i=startPoint; i< shipSize+ startPoint; i++)
		{
			if (oceanBoard[i]!=0)
			{
				return false;
			}
			else
			{
				available = true;
			}
		}
		return available;
	}//end method
	
	public static boolean keepPlaying(int guessNumber)
	{
		
		if(oceanBoard[guessNumber]==0)
		{
			guessBoard[guessNumber]='M';
			System.out.println("\nMiss!"); 
			miss++;
			if(miss>10) {
				System.out.println("You've lost! play again? ");
				return false;
			}
			else {
				return true;
			}
		}
		else{
			//if(ship1!=SHIP1 || ship2!=SHIP2 || ship3!=SHIP3) {
				if (oceanBoard[guessNumber]==SHIP1 && guessBoard[guessNumber]!='H'){
					guessBoard[guessNumber]='H';
					System.out.println("\nBoom! That is a hit!!");
					ship1++;
					if(ship1==SHIP1)
						System.out.println("Kablooey! You sank  the boat of size " +SHIP1+"!");
					//return true;
					
				}else if (oceanBoard[guessNumber]==SHIP2&& guessBoard[guessNumber]!= 'H') {
					guessBoard[guessNumber]='H';
					System.out.println("\nBoom! That is a hit!!");
					ship2++;
					if(ship2==SHIP2)
						System.out.println("Kablooey! You sank  the boat of size "+SHIP2+"!");
					//return true;
				}else if (oceanBoard[guessNumber]==SHIP3  && guessBoard[guessNumber]!= 'H') {
					guessBoard[guessNumber]='H';
					System.out.println("\nBoom! That is a hit!!");
					ship3++;
					if(ship3==SHIP3)
						System.out.println("Kablooey! You sank  the boat of size "+SHIP3+"!");
					//return true;
				}else {//oceanBoard[guessNumber]=='H' || oceanBoard[guessNumber]=='M'
					System.out.println("\nYou already fired there! Try again.");
					//return true;
				}
			
			//}
			if(ship1+ship2+ship3==SHIP1+SHIP2+SHIP3) {
				System.out.println("You've won the game! Play again? ");
				return false;
			}
			return true;
		}
	}//end method


}//end class
