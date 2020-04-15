
package iss;

import java.net.URI;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * DataPackage Class.
 * Sends the Sensors Data in JSON format from GITHUB Repository 
 *  via HTTP and prints the output to the eclipse console in Java 
 * 
 * @author Kennedy Ganda
 * @author Xiuxiang Wu
 * 
 * @version 1:
 *
 */

public class Data{
	
	public static void main(String []args) {
		
		HttpClient  client = HttpClient.newHttpClient();
		//HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://my-json-server.typicode.com/GandaKen/jsondata")).build();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://github.com/TCC360Project/360Project_Repo/blob/master/jsondata.json")).build();
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
			   .thenApply(HttpResponse:: body)
			   //.thenAccept(System.out::println)
		       .thenApply(DataPackage::parse)
		       .join();
		
	}
	
	/**
	 * Parse method
	 * 
	 * @param responseBody
	 * @return 
	 */
	
	public static Integer parse (int responseBody) {
		
		JSONArray Sensors_Data = new JSONArray(responseBody); 
		
		for(int i =0; i< Sensors_Data.length(); i++) {
			
			JSONObject data = Sensors_Data.getJSONObject(i);
			
			int Temperature = data.getInt("Temperture");
			int Humidity = data.getInt("Humidity");
			int Wind = data.getInt("Wind");
			int Rain = data.getInt("Rain");
			
			System.out.println(Temperature + " " + Humidity+ " " + Wind  + " " + Rain);
			
			
		}
		return null;
		
	}

}
