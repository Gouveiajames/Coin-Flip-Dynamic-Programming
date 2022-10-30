/*Coin Flip!
This program looks at consecutive coin flips and counts the number of outcomes that do not contain 3 or more heads in a row.
Author: James Gouveia Csc 130 T/Th
Feb. 2020 revised 3/8/2020, revised 3/11/2020

Please see design sheet for an explanation of the program.  The design sheet file is named: CSC130_Assignment1_design_doc.pdf */

import java.util.Scanner;
.pds

class coinFlip
{
	//Calculate the number of possible outcomes and return to main
	private static int threeInRow(int itterations)
	{
		//array to hold memoization
		int[] flips = new int[itterations + 1];

		for(int i = 1; i < itterations + 1; i++)
		{
		if(i == 1)
			{
				flips[i] = coinFlip.power(2, i);
			}
		else if(i == 2)
			{
				flips[i] = coinFlip.power(2, i);			
			}
		else if(i == 3)
			{
				flips[i] = (coinFlip.power(2, i) - 1);
			}
		else
			{
				flips[i] = flips[i-1] + flips[i-2] + flips[i-3];
			}
		}
		return flips[itterations];
		
	}

	//power function to calculate the number of possible outcomes
	private static int power(int number, int itterations)
	{
		int temp = 0;
		for(int k = 0; k < itterations; k++)
			{
				if(k == 0)
				{
					temp = number;
				}
				else
				{
					temp = temp * number;
				}		
			}
			return temp;
	}

	public static void main(String[] args)
	{
		System.out.println("\nCoinFlip!\nThis program will return the number of possible outcomes of flipping a coin that do not result in three heads in a row.");
		System.out.println("\nPlease enter the number of tosses in integer form");

		Scanner scan = new Scanner(System.in);
		int numberThrows = scan.nextInt(); 

		System.out.println("The number of possible outcomes that do not contain three heads in a row are: " + coinFlip.threeInRow(numberThrows)+"\n");
	
	}
}


