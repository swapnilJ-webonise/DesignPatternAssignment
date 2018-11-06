package decorator;

public class MobilePhoneDecorator {
  
  public String installApp(String appName) {
    System.out.println(appName+" is being install");
    return appName;
  }
  public String unInstallApp(String appName) {
    System.out.println(appName+" is being Uninstall");
    return appName;
  }
 

}
