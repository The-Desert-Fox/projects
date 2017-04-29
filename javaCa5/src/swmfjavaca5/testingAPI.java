/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swmfjavaca5;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.json.*;

/**
 *
 * @author S
 */
public class testingAPI {
    public static void main(String args[])throws Exception {
        ArrayList<Person> qwer = searchAPI("Tom");
        
        for(int i = 0; i < qwer.size(); i++)
        {
            System.out.println(qwer.get(i));
        }
    }
    
    public static ArrayList<Person> searchAPI(String search) throws IOException{
        ArrayList<Person> result = new ArrayList<Person>();
        URL tvmaze = new URL("http://api.tvmaze.com/search/people?q=" + search);
        URLConnection yc = tvmaze.openConnection();
        // Connecting to tvmaze
        
        InputStream in = yc.getInputStream();
        // Getting the information off of tvmaze
        
        JsonReader reader = Json.createReader(in);
        // Turning inputstream into Json
        
        JsonArray array = reader.readArray();
        // Creating an array of Json objects because that is how tvmaze gives it to us
        
        // Taking each Json object out of the array and getting the information out of it 
        for (int i = 0; i < array.size(); i++) {
            JsonObject object = array.getJsonObject(i);
            double score = object.getJsonNumber("score").doubleValue();
            JsonObject personObject = object.getJsonObject("person");
            int id = personObject.getJsonNumber("id").intValue();
            String personLink = personObject.getJsonString("url").toString();
            String name = personObject.getJsonString("name").toString();
            ArrayList<String> imageURL = new ArrayList<>();
            if (!personObject.isNull("image")) 
            {
                JsonObject imageObject = personObject.getJsonObject("image");
                String medium = imageObject.getJsonString("medium").toString();
                imageURL.add(medium);
                String original = imageObject.getJsonString("original").toString();
                imageURL.add(original);
            }
            JsonObject linkObject = personObject.getJsonObject("_links");
            JsonObject selfObject = linkObject.getJsonObject("self");
            String queryName = selfObject.getJsonString("href").toString();
            Person person = new Person(score, queryName, name, id, imageURL, personLink,0,"");
            result.add(person);
        }
        
        return result;
    }
}
