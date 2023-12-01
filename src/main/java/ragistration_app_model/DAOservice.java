package ragistration_app_model;

public interface DAOservice {
	public void connectDB();
public boolean verifyLogin(String email,String password);
public void saveRegistration(String name,String city,String email,String mobil,String pass);
public void updateReigistration(String email, String mobil);
}
