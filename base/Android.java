package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import strategy.PaymentStrategy;

public class Android extends MobilePhone implements Connectivity, Multimedia {
    public int androidOperations() throws NumberFormatException, IOException {
    System.out.println(
        "\n 1. Make call (Dual Sim)\n 2. Send Message (Dual Sim)\n 3. Record a Video\n 4. Open Playstore\n 5. Install App\n 6. Uninstall App\n 7. List of Apps\n 8. Payment Operation ");
    BufferedReader requestOperation = new BufferedReader(new InputStreamReader(System.in));
    int operationNo = Integer.parseInt(requestOperation.readLine());
    return operationNo;
  }

  @Override
  public int makeCall(int simno, String contactName) {
    System.out.println("You're calling " + contactName + " from Sim " + simno);
    return 1;
  }

  @Override
  public void sendMessage(int simno, String contactName) {
    BufferedReader message = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter Message : ");
    String textMessage;
    try {
      textMessage = message.readLine();
      System.out.println(
          " Your are sending message :" + textMessage + " to " + contactName + " from Sim No: " + simno);
    } catch (IOException exception) {
      System.out.println(exception.getMessage());
    }
  }

  @Override
  public void recordVideo() {
    System.out.println("You are recording video...");
  }

  @Override
  public void takePhoto() {
    System.out.println("You are taking photo");
  }

  @Override
  public void bluetooth() {
    System.out.println("Bluetooth in on");
  }

  public void openPlaystore() {
    System.out.println("Opening Play Store");
  }
  
  private PaymentStrategy androidPaymentStrategy;
  public void setAndroidPaymentStrategy (PaymentStrategy androidPaymentStrategy) {
    this.androidPaymentStrategy = androidPaymentStrategy;
  }
  
  public void doPaymentFromAndroid(double amount) {
    androidPaymentStrategy.payAmount(amount);
  }
}
