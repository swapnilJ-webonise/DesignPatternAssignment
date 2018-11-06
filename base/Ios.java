package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import strategy.PaymentStrategy;

public class Ios extends MobilePhone implements Multimedia {

	BufferedReader message = new BufferedReader(new InputStreamReader(System.in));
	private PaymentStrategy iosPaymentStrategy;

	public int iosOperations() throws NumberFormatException, IOException {
		System.out.println(
				"\n 1. Make call (Single Sim)\n 2. Send Message (Single Sim)\n 3. Record a Video\n 4. Open Appstore\n 5. Install App\n 6. Uninstall App\n 7. List of Apps\n 8. Payment Operation ");
		BufferedReader requestOperation = new BufferedReader(new InputStreamReader(System.in));
		int operationNo = Integer.parseInt(requestOperation.readLine());
		return operationNo;
	}

	@Override
	public int makeCall(int simno, String contactName) {
		if (simno == 1) {
			System.out.println("You're calling " + contactName + " from Sim " + simno);
		} else {
			System.out.println("Your phone does not support Dual Sim");
		}
		return 0;
	}

	@Override
	public void sendMessage(int simno, String contactName) {
		try {
			if (simno == 1) {
				System.out.println("Enter Message : ");
				String textMessage = message.readLine();
				System.out.println(
						" Your are sending message :" + textMessage + " to " + contactName + " from Sim No: " + simno);
			} else {
				System.out.println("Wrong Sim No");
			}
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	public void openAppStore() {
		System.out.println("Opening AppStore..");
	}

	public void openFaceTime() {
		System.out.println("Opening FaceTime..");
	}

	public void takePhoto() {
		System.out.println("Opening Camera..");
	}

	@Override
	public void recordVideo() {
		System.out.println("Opening Camera..");
	}

	public void setAndroidPaymentStrategy(PaymentStrategy iosPaymentStrategy) {
		this.iosPaymentStrategy = iosPaymentStrategy;
	}

	public void doPaymentFromAndroid(double amount) {
		iosPaymentStrategy.payAmount(amount);
	}
}
