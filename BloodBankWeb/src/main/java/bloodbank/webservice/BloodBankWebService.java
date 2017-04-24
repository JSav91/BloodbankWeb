package bloodbank.webservice;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import bloodbank.bean.UserBean;
import bloodbank.database.DatabaseManager;

@Path("/bloodbank")
public class BloodBankWebService {
	
	@GET
	@Path("/getalluser")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllUsers(){
	
		try {
			System.out.println("Hi");
			ArrayList<UserBean> list= new DatabaseManager().getAllData();
			Gson gson= new Gson();
			String string= gson.toJson(list);
			
			JsonArray jsonArray = new JsonParser().parse(string).getAsJsonArray();
			System.out.println(string);
			return jsonArray.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@POST
	@Path("/adduser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addUser(String user){
	
		try {
			JsonParser jsonParser = new JsonParser();
			System.out.println(user);
			JsonObject jo = (JsonObject)jsonParser.parse(user);
			 Gson gson = new GsonBuilder().setPrettyPrinting().create();
			 UserBean bean=gson.fromJson(jo, UserBean.class);
			 System.out.println(bean.getGender());
			 new DatabaseManager().insertBean(bean);
			 ArrayList<UserBean> list= new DatabaseManager().getAllData();
			 String string= gson.toJson(list);
			 JsonArray jsonArray = new JsonParser().parse(string).getAsJsonArray();
			 System.out.println(string);
			return jsonArray.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@POST
	@Path("/updateuser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<UserBean>  updateUser(){
	
		try {
			return new DatabaseManager().getAllData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
