/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhfc;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.net.URL;

/**
 *
 * @author Clelia
 */
public class JsonToJavaObject { 
    
    
    public JsonToJavaObject () {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "{'name' : 'mkyong'}";

        //JSON from file to Object
        Sport obj = mapper.readValue(new File("c:\\file.json"), Sport.class);
        
        //String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
       // Car car = objectMapper.readValue(json, Car.class);  
        

        //JSON from URL to Object
       // Sport obj = mapper.readValue(new URL("http://mkyong.com/api/staff.json"), Sport.class);

        //JSON from String to Object
        //Sport obj = mapper.readValue(jsonInString, Sport.class);
    }
}
