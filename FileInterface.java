import java.io.FileNotFoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FileInterface extends Remote
{
   public double pythTheorem(double side1, double side2) throws RemoteException;
   public double mortgageCalculator(double purchasePrice, double downPayment, double loanTermInYears, double interestRate, double otherExpenses) throws RemoteException;
   public String passwordChecker(String length1) throws RemoteException;
   public String caseSwitcher(String wordInput) throws RemoteException;
   public String wordSwitcher(String senInput) throws RemoteException;
}