/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhfc;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author Clelia
 */
public class GetResponse {
  
   public static String getHTML(String urlToRead) throws Exception {
       
      StringBuilder result = new StringBuilder();
      
      URL url = new URL(urlToRead);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      
      //Test response
      int responseCode = conn.getResponseCode();
      
      System.out.println("\nSending 'GET' request to URL : " + url);
      System.out.println("Response Code : " + responseCode);
      
      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String line;
      StringBuffer lineResponse = new StringBuffer();
      
      while ((line = rd.readLine()) != null) {
         lineResponse.append(line);
      }
      rd.close();
      return lineResponse.toString();
   }
   
   public static String sendPost(String urlToRead, String urlParameters) throws Exception {
        
        URL url = new URL(urlToRead);
	HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

	//add reuqest header
	con.setRequestMethod("POST");
	con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

	// Send post request
	con.setDoOutput(true);
	DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	wr.writeBytes(urlParameters);
	wr.flush();
	wr.close();

	int responseCode = con.getResponseCode();
	System.out.println("\nSending 'POST' request to URL : " + url);
	System.out.println("Post parameters : " + urlParameters);
	System.out.println("Response Code : " + responseCode);

	BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	String inputLine;
	StringBuffer response = new StringBuffer();

	while ((inputLine = in.readLine()) != null) {
		response.append(inputLine);
	}
	in.close();

	//print result
	System.out.println(response.toString());
        return response.toString();
   }
   
   public static void main(String[] args) throws Exception {}

 
}
