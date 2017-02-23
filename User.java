public class User {
  String userID;
  boolean isVIP;
  
  public User() {
  }
  
  public User(String userID, boolean isVIP) {
    userID = "";
    isVIP = false;
  }
  
  public void setUserID(String id) {
    userID = id;
  }
  
  public void setVIP(boolean check) {
    isVIP = check;
  }
  
  public String getUserID() {
    return userID;
  }
  
  public boolean getVIP() {
    return isVIP;
  }
  
  
}