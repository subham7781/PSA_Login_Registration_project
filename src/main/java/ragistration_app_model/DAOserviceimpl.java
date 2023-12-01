package ragistration_app_model;

import java.sql.*;

import com.mysql.cj.xdevapi.Statement;

public class DAOserviceimpl implements DAOservice {
	private Connection con;
	private java.sql.Statement stmnt;

	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/regs", "root", "Subham@123");
			stmnt = con.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean verifyLogin(String email, String password) {
		try {
			ResultSet result = stmnt
					.executeQuery("select * from login where username='" + email + "' and password='" + password + "'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveRegistration(String name, String city, String email, String mobil, String pass) {
		try {
			stmnt.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobil+"','"+pass+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet readallReg() {
		try {
			ResultSet result = stmnt.executeQuery("select * from registration");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteByEmail(String email) {
		try {
			stmnt.executeUpdate("delete from registration where email='" + email + "'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateReigistration(String email, String mobil) {
		try {
			stmnt.executeUpdate("update registration set mobil='" + mobil + "' where email='" + email + "'");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
