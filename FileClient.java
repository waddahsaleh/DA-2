import java.io.*; 
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.net.InetAddress;


public class FileClient
{
   public static void main(String argv[]) 
   {
	   
	   //client code
	      try 
		  {
	    	 String feature = null;
	   	     Scanner sc= new Scanner(System.in);
	   	     //
	         Registry reg = LocateRegistry.getRegistry(InetAddress.getLocalHost().getHostName()); 
	
	         FileInterface fi = (FileInterface) reg.lookup("FileServer");
	         
	         //opening options for user
	   	     System.out.println("Which feature do you want to use? \n");
	   	     
	   	     System.out.println("Please Choose 1 Service/Feature \n" );
	   	     System.out.println("Enter pyth: Pythagorean Calculator \n");
	   	   	 System.out.println("Enter mort: Mortgage Calculator \n" );
	   	   	 System.out.println("Enter pass: Password Creater & Saves Password to Text File \n" );
	   	   	 System.out.println("Enter switch: Switch Case for Letters \n" );
			 System.out.println("Enter reverse: reverse order of words \n" );
	   	   	 
	   	   	 feature = sc.nextLine();
	   	   	 
	   	     
	         //If Function 1: Pythagorean Calculator 
	         if(feature.equalsIgnoreCase("pyth"))
			 {
	        	System.out.println("Enter 1st Side Length of Triangle");
				String side1= sc.nextLine(); 
				System.out.println("Enter 2nd Side Length of Triangle: ");
				String side2= sc.nextLine(); 
	            pythTheorem(fi, side1, side2);
				
	         }
	         
	         //If Function 2: Mortgage Calculator 
	         else if(feature.equalsIgnoreCase("mort"))
			 {
	         	System.out.println("Enter Mortgage Amount (i.e 420000): ");
	        	String purchasePrice= sc.nextLine();
				System.out.println("Enter down payment (i.e 21000 (5% or more of purchase amount)): ");
	        	String downPayment= sc.nextLine();
				System.out.println("Enter Interest Rate (i.e 3.2): ");
				String interestRate= sc.nextLine();
				System.out.println("Enter Total duration in years (i.e 7): ");
				String loanTermInYears= sc.nextLine();
				System.out.println("Enter other monthly expenses (i.e 500): ");
				String otherExpenses= sc.nextLine();
				mortgageCalculator(fi, purchasePrice, downPayment, loanTermInYears, interestRate, otherExpenses);

	        }
	         //If Function 3: Password Creater & Saves Password to Text File 
	         else if(feature.equalsIgnoreCase("pass"))
	         {
	        
				System.out.println("What length password?: ");
				String length1= sc.nextLine();
				passwordChecker(fi, length1);
	         }
	         
	         //If Function 4: CaseSwitcher
	         else if(feature.equalsIgnoreCase("switch"))
	         {
	    		System.out.println("Enter a word to switch case with: ");
				String wordInput = sc.nextLine(); 
	     		caseSwitcher(fi,wordInput);
	    	 }
			 //IF FUNCTION 5: wordswitcher
			 else if(feature.equalsIgnoreCase("reverse"))
	         {
	    		System.out.println("Enter a word/sentence to reverse order: ");
				String senInput = sc.nextLine(); 
	     		wordSwitcher(fi,senInput);
	    	 }
	         
	     }
	      
	      catch(Exception e) 
		  { 
	    	  System.err.println("FileServer exception: "+ e.getMessage());
	          e.printStackTrace();
	      }
         
      }
 
  //Function 1 PYTHAGOREAN CALCULATOR 
   public static void pythTheorem(FileInterface fileInterface, String side1, String side2) throws IOException 
   {
	   try
	   {
		   System.out.println("The final side using Pythagorean Theorem is: " + fileInterface.pythTheorem(Double.parseDouble(side1), Double.parseDouble(side2)));
	   }
	   catch (Exception e)
	   {
		   System.out.println("Wrong input!");
	   }
   }
 //Function 2 MORTGAGE CALCULATOR 
   public static void mortgageCalculator(FileInterface fileInterface, String purchasePrice, String downPayment, String loanTermInYears, String interestRate, String otherExpenses) throws IOException 
   {
	   try
	   { 
		   System.out.println("The mortgage monthly is: " + fileInterface.mortgageCalculator(Double.parseDouble(purchasePrice), Double.parseDouble(downPayment), Double.parseDouble(loanTermInYears), Double.parseDouble(interestRate), Double.parseDouble(otherExpenses) ));
	   }
	   catch (Exception e)
	   {
		   System.out.println("Wrong input!");
	   }
   }
 //Function 3 CREATE PASSWORD AND SAVE TO FILE 
   public static void passwordChecker(FileInterface fileInterface, String length1) throws IOException 
   {
	   try
	   { 
		   System.out.println("Your password for that length is: " + fileInterface.passwordChecker((length1)));
	   }
	   catch (Exception e) 
	   {
		   System.out.println("Wrong input!");
	   }
   }

 //Function 4 SWITCH LETTER CASE 
   public static void caseSwitcher(FileInterface fileInterface, String wordInput) throws IOException 
   {
	   try
	   {
		   System.out.println("The word with switched case is: " + fileInterface.caseSwitcher((wordInput)));
	   }
	   catch (Exception e)
	   {
		   System.out.println("Wrong input!");
	   }
   }

//Function REVERSE ORDER OF WORDS 
public static void wordSwitcher(FileInterface fileInterface, String senInput) throws IOException 
   {
	   try
	   {
		   System.out.println("The words with switched order are: " + fileInterface.wordSwitcher((senInput)));
	   }
	   catch (Exception e)
	   {
		   System.out.println("Wrong input!");
	   }
   }
}