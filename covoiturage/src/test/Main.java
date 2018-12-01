package test;

import com.covoiturage.dao.DBInteraction;
import com.covoiturage.dao.IUser;
import com.covoiturage.dao.UserImpl;
import com.covoiturage.entities.User;

public class Main {

	public static void main(String[] args) {
		
		IUser userManager = new UserImpl();
		
		User user = new User("saad", "benhmid", "saad@gmail.com", DBInteraction.md5("123"));
		
		userManager.register(user);
		
		System.out.println("register success");
		
		System.out.println("auth attempt");
		
		User u = userManager.login("saad@gmail.com", DBInteraction.md5("123"));
		
		System.out.println(u);
	}
}
