package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FeaturePhone extends MobilePhone implements Connectivity {
	BufferedReader message = new BufferedReader(new InputStreamReader(System.in));

	@Override
	public int makeCall(int simno, String contactName) {
		System.out.println("You're calling " + contactName + " from Sim " + simno);
		return 0;
	}

	@Override
	public void sendMessage(int simno, String contactName) {
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

	public void openTorch() {
		System.out.println("Opening Torch.");
	}

	@Override
	public void bluetooth() {
		System.out.println("Bluetooth in on");
	}

	public int featurePhoneOperations() throws NumberFormatException, IOException {
		System.out.println(
				"\n 1. Make call (Dual Sim)\n 2. Send Message (Dual Sim)\n 3. Open a Torch\n 4. Open Bluetooth ");
		BufferedReader requestOperation = new BufferedReader(new InputStreamReader(System.in));
		int operationNo = Integer.parseInt(requestOperation.readLine());
		return operationNo;
	}
}
