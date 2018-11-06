package base;

import decorator.MobilePhoneDecorator;

public abstract class MobilePhone {
	public abstract int makeCall(int simno, String contactName);
	public abstract void sendMessage(int simno, String contactName);
	private MobilePhoneDecorator mobilePhoneDecorator = new MobilePhoneDecorator();

	public String installApp(String appName) throws InterruptedException {
		return mobilePhoneDecorator.installApp(appName);
	}

	public String unInstallApp(String appName) {
		return mobilePhoneDecorator.unInstallApp(appName);
	}
}