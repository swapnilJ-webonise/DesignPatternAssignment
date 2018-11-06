package decorator;

public interface MobileApps {
  MobilePhoneDecorator installApp(String appName);
  MobilePhoneDecorator unInstallApp(String appName);
}
