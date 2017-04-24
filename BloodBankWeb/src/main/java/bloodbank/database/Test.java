package bloodbank.database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
	
	public static void main(String[] args) {
	/*	try {
			new BloodBankWebService().getAllUsers();
			DatabaseManager DatabaseManager=new DatabaseManager();
			DatabaseManager.getAllData();
			
			  try {

					URL url = new URL("http://localhost:8080/BloodBankWeb/bloodbank/getalluser");
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					System.out.println("1");
					
					conn.setRequestMethod("GET");
					conn.setRequestProperty("Accept", "application/json");
					System.out.println("2");

					if (conn.getResponseCode() != 200) {
								System.out.println(conn.getResponseCode());
					}
					System.out.println("3");

					BufferedReader br = new BufferedReader(new InputStreamReader(
						(conn.getInputStream())));

					String output;
					System.out.println("Output from Server .... \n");
					while ((output = br.readLine()) != null) {
						System.out.println(output);
					}

					conn.disconnect();

				  } catch (MalformedURLException e) {

					e.printStackTrace();

				  } catch (IOException e) {

					e.printStackTrace();

				  }

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/
        try {
			Date birthDate = new SimpleDateFormat("dd/MM/yyyy").parse("10/12/1991");

			//create calendar object for birth day
			  Calendar birthDay = Calendar.getInstance();
			  birthDay.setTimeInMillis(birthDate.getTime());
			  //create calendar object for current day
			  long currentTime = System.currentTimeMillis();
			  Calendar now = Calendar.getInstance();
			  now.setTimeInMillis(currentTime);
			  //Get difference between years
			 int years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
			 System.out.println(years);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
