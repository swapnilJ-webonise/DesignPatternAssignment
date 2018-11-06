package strategy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PaymentByPaytmApp implements PaymentStrategy {

  double withdrwalMoney, deopsiteMoney;
  static double accountBalance;

  @Override
  public void payAmount(double amount) {
    if (amount > accountBalance) {
      addMoneyInWallet();
    } else {
      System.out.println("Money " + accountBalance);

      accountBalance = accountBalance - amount;
      System.out.println("Paymnt of " + amount + " successfully!\n Remaining Balance " + accountBalance);
    }
  }

  void addMoneyInWallet() {
    BufferedReader getBalanceAmount = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Update balance in your account: ");
    try {
      accountBalance = accountBalance + Double.parseDouble(getBalanceAmount.readLine());
      System.out.println("Money added successfully" + accountBalance);

    } catch (Exception exception) {
      System.out.println("Wrong Input...!" + exception.getMessage());
    }
  }
}
