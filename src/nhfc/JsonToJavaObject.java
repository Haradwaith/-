/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhfc;


import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author Clelia
 */
public class JsonToJavaObject {
    
    
    public JsonToJavaObject () {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "{'name' : 'mkyong'}";

        //JSON from file to Object
        Staff obj = mapper.readValue(new File("c:\\file.json"), Staff.class);
        

        //JSON from URL to Object
        Staff obj = mapper.readValue(new URL("http://mkyong.com/api/staff.json"), Staff.class);

        //JSON from String to Object
        Staff obj = mapper.readValue(jsonInString, Staff.class);
    }
}
