package strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PaymentByTezApp implements PaymentStrategy{

  double withdrwalMoney, deopsiteMoney;
  static double accountBalance;
  BufferedReader moneyTransferDetail = new BufferedReader(new InputStreamReader(System.in));

  @Override
  public void payAmount(double amount) {

    try {
      System.out.println("Enter Your UPI Number: ");
      String senderUPINumber = moneyTransferDetail.readLine();
      System.out.println("Enter Recievers UPI Number: ");
      String recieverUPINumber = moneyTransferDetail.readLine();
      moneyTransfer(senderUPINumber,recieverUPINumber,amount);      
    } catch (IOException exception) {
    	System.out.println("Wrong Input !!"+exception.getMessage());
    }     
  }
  
  void moneyTransfer(String senderUPINumber,String recieverUPINumber,double amount) {
    try {
      System.out.println("Your "+amount+" amount sent to "+recieverUPINumber); 
    } catch (Exception exception) {
      System.out.println("Wrong Money Input"+exception.getMessage());
    }
  }
}
