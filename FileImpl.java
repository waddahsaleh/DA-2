import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.rmi.*;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.lang.Math.*;
import java.rmi.RemoteException;
import java.io.FileWriter;

public class FileImpl extends RemoteServer implements FileInterface {


   private String name;

   public FileImpl(String s) throws RemoteException 
   {
      super();
      name = s;
   }
   //Function 1
   public double pythTheorem(double side1, double side2) throws RemoteException
   {
	  try {
         
		    double hyp= Math.sqrt((Math.pow(side1,2)+Math.pow(side2,2)));
				return hyp;
	  }
	  catch (Exception e)
	  {
        return Double.parseDouble("invalid input"); 
	  } 
   }
   
  //Function 2

    public double mortgageCalculator(double purchasePrice, double downPayment, double loanTermInYears, double interestRate, double otherExpenses) {
        try {
            // Loan amount is the difference between the purchase price and the down payment
            double loanAmount = purchasePrice - downPayment;

            // Monthly interest rate
            double monthlyInterestRate = interestRate / 100 / 12;

            // Total number of payments
            double numberOfPayments = loanTermInYears * 12;

            // Calculate monthly mortgage payment
            double mortgagePayment = (loanAmount * monthlyInterestRate) /
                    (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

            // Add other monthly homeowner expenses to the mortgage payment
            double totalMonthlyPayment = mortgagePayment + otherExpenses;

            return totalMonthlyPayment;
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions appropriately
            return Double.NaN; // Indicates an error or invalid input
        }
    }
  


  //Function 3 
  public String passwordChecker(String lengthInput) {
    try {
        int length = Integer.parseInt(lengthInput);

        if (length <= 0) {
            return "Invalid input. Please enter a positive integer for password length.";
        }

        String passwordCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; // using only letters

        StringBuilder generatedPassword = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * passwordCharacters.length());
            char randomChar = passwordCharacters.charAt(randomIndex);
            generatedPassword.append(randomChar);
        }

        // Saving to file
        try (FileWriter myWriter = new FileWriter("passwords.txt")) {
            myWriter.write(generatedPassword.toString());
        }

        return generatedPassword.toString();
    } catch (NumberFormatException e) {
        return "Invalid input. Please enter a valid integer for password length.";
    } catch (Exception e) {
        return "Error generating password.";
    }
  }
   


  //Function 4
  public String caseSwitcher(String wordInput) throws RemoteException
  {
     try
     {
      String switchedString = ""; 
          for(int i=0; i < wordInput.length(); i++) //decrement so not an infinite loop 
          { 
            char c = wordInput.charAt(i);  

            if(Character.isUpperCase(c)) {
              switchedString = switchedString + Character.toLowerCase(c); //do it for each letter in input 
            }
            if(Character.isLowerCase(c)) {
              switchedString = switchedString + Character.toUpperCase(c); //do it for each letter in input 
            }
          } return switchedString;
    } catch (Exception e) {
		} return ("Invalid input");
  } 



  //Function 5
  public String wordSwitcher(String senInput) throws RemoteException {
    try {
      String[] words = senInput.split("\\s+");
      StringBuilder reversedSentence = new StringBuilder();

      for (String word : words) {
          StringBuilder reversedWord = new StringBuilder(word).reverse();
          reversedSentence.append(reversedWord).append(" ");
      }

      return reversedSentence.toString().trim();
   } catch (Exception e) {
      e.printStackTrace();
      return "Invalid input";
   }
  
  }


}

   


   