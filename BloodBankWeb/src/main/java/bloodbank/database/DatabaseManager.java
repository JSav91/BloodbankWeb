package bloodbank.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bloodbank.bean.UserBean;

public class DatabaseManager {

	public static Connection connection;

	public DatabaseManager() throws Exception
	{
		try
		{
			String connectionURL = "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/ad_6ab48b484eff907";

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "bda662b3a1ddc1", "0766bf1f");
		} catch (Exception e)
		{
			throw e;
		}

	}

	public ArrayList<UserBean> getAllData(){

		Statement stmt;
		ArrayList<UserBean> userList=new ArrayList<UserBean>();
		try {
			stmt = connection.createStatement();
			ResultSet resultSet=stmt.executeQuery("Select * from b_user");

			while(resultSet.next()){
				UserBean userBean= new UserBean();
				userBean.setUserId(resultSet.getInt("user_id"));
				userBean.setGivenName(resultSet.getString("given_name"));
				userBean.setSurname(resultSet.getString("surname"));
				userBean.setDob((resultSet.getString("dob")));
				userBean.setGender(resultSet.getString("gender"));
				userBean.setPhone(resultSet.getString("phone"));
				userBean.setBloodGroup(resultSet.getString("bloodgroup"));
				userBean.setEmail(resultSet.getString("email"));
				userBean.setAddress(resultSet.getString("address"));
				userBean.setLoginName(resultSet.getString("login_username"));
				userBean.setPassword(resultSet.getString("login_password"));
				userBean.setDonor(resultSet.getBoolean("is_donor"));
				userList.add(userBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userList;
	}

	public String insertBean(UserBean bean){		
		try {
			PreparedStatement preparedStmt = connection.prepareStatement("insert into b_user (given_name,surname,dob,gender,phone,bloodgroup,email,address,login_username,login_password,is_donor) values (?,?,?,?,?,?,?,?,?,?,?)");
			
			preparedStmt.setString(1,bean.getGivenName());
			preparedStmt.setString(2,bean.getSurname());
			preparedStmt.setString(3,bean.getDob());
			preparedStmt.setString(4,bean.getGender());
			preparedStmt.setString(5,bean.getPhone());
			preparedStmt.setString(6,bean.getBloodGroup());
			preparedStmt.setString(7,bean.getEmail());
			preparedStmt.setString(8,bean.getAddress());
			preparedStmt.setString(9,bean.getLoginName());
			preparedStmt.setString(10,bean.getPassword());
			preparedStmt.setBoolean(11,bean.isDonor());
			
			int status=preparedStmt.executeUpdate();
			if(status==1){
				return "Success";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String deleteBean(UserBean bean){
		
		try {
			PreparedStatement preparedStmt = connection.prepareStatement("delete from b_user where user_id=?");
			preparedStmt.setInt(1,bean.getUserId());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
