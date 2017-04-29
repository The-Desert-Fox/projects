/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swmfjavaca5;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map; 
import java.util.TreeMap;
import java.util.*;
import java.io.*;
import java.net.URLConnection;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author S
 */
public class test {
    
    public static Map<String,Person> localStore = new HashMap<String,Person>();
    public static void main(String[] args) throws MalformedURLException, IOException{
        ArrayList<String> urls = new ArrayList<String>();
        urls.add("Exampleurl");
        Person p = new Person((float)1.5, "Simon Watters", "Simon Watters", 10, new ArrayList<String>(),"StringLink",5,"hello");
        Person q = new Person((float)1.5, "Alan Watters", "Alan Watters", 11, urls,"StringLink",5,"hello");
        Person e = new Person();
        //System.out.println(e.toString());
        localStore.put("Simon", p);
        localStore.put("Alan", q);
       
        writeToHTML(localStore);
    }
    
    public static void writeToHTML(Map<String,Person> localstore){
        FileWriter fWriter = null;
        BufferedWriter writer = null;
        
        try {
            
            fWriter = new FileWriter("localstore.html");
            writer = new BufferedWriter(fWriter);
            for(Person v: localstore.values()){
                
                String out ="<tr>" + "<td>" + v.getScore() + "</td>"
                + "<td>" + v.getName() + "</td>"
                + "<td>" + v.getId() + "</td>"
                + "<img src='"+ v.getImgurl() + "' </img>"
                + "<td>" + v.getPersonLink() + "</td>"
                + "<td>" + v.getComments() + "</td>" + "/tr";
                
                writer.write(out);
            }
            
            //writer.write();
            writer.newLine(); //this is not actually needed for html files - can make your code more readable though 
            writer.close(); //make sure you close the writer object 
        } catch (Exception e) {
            //catch any exceptions here
        }
    }
    
    /*
    public static void toHTML(){
        return "<td>" + this.score + "</td>"
                + "<td>" + this.name + "</td>"
                + "<td>" + this.id + "</td>"
                + "<td>" + this.imgurl + "</td>"
                + "<td>" + this.personLink + "</td>"
                + "<td>" + this.comments + "</td>";
    }
    */
    
    
      
    
    
}
