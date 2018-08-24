package action;

public class CheckUser {
	public static boolean isUser(String username, String password){
		String name = username.trim();
		String pwd = password.trim();
		if(name.equals("Java") && pwd.equals("helloworld")){
			return true;
		}
		return false;
	}
}
