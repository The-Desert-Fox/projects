package swmfjavaca5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
/**
 * 
 * 
 */
public class Swmfjavaca5{
     public static Map<String, Person> localstore = new HashMap<String, Person>();
//    Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        List<Person> list = new ArrayList<>();
        localstore = readFromFile();
        
        int choice = menu();
        while(choice != 7){
            switch(choice){
                case 1:
                    Scanner in = new Scanner(System.in);
                    System.out.println("Searching Local store");
                    System.out.println("Enter the person you wish to search for: ");
                    String searchPerson = in.nextLine();
                    String foundPerson = searchForPersons(localstore , searchPerson);
                    
                    
                    if(foundPerson.equals(""))
                    {
                        System.out.println("Looking up api, searching again.");
                        addToLocalstore(searchAPI(searchPerson));
                    }
                    else{
                        System.out.println(foundPerson);
                    }
                    
                    choice = menu();
                    break;
                case 2:
                    System.out.println("List of all people");
                    printAllPersons(localstore);
                    
                    choice = menu();
                    break;
                case 3:
                    System.out.println("Listing all people by id");
                    printAllPersons(listPersonsByID(localstore));
                    
                    choice = menu();
                    break;
                case 4:
                    System.out.println("List people by rating");
                    printAllPersons(listPersonsByRating(localstore));
                    
                    choice = menu();
                    break;
                case 5:
                    Scanner ni = new Scanner(System.in);
                    System.out.println("Edit person, Enter name");
                    String name = ni.next();
                    Person found = new Person();
                    found = returnPerson(localstore, name);
                    System.out.println(found.toString());
                    
                    System.out.println("1) Edit rating" +
                            "/n2) Edit comment" + "/n3) Break Loop");
                    String number = ni.next();
                    int num = Integer.parseInt(number);
                    
                    while(num != 3){
                        switch(num){
                            case 1:
                                System.out.println("Enter rating");
                                int rating = ni.nextInt();
                                found = editRating(found,rating);
                            case 2:
                                System.out.println("Enter comment");
                                String comment = ni.next();
                                found = editComment(found,comment);
                        }
                        localstore.put(found.getName(), found);
                    }
                    choice = menu();
                    break;
                case 6:
                    System.out.println("Exporting to HTML");
                    writeToHTML(localstore);
                    choice = menu();
                    break;
                default:
                    break;
            }
        }
        System.out.println("Writing to a file");
        writeToFile(localstore);
    }
    public static int menu(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("1) Search for a person");
        System.out.println("2) List all People");
        System.out.println("3) List People sorted by personid");
        System.out.println("4) List person sorted by rateing");
        System.out.println("5) Edit Person");
        System.out.println("6) Export to HTML");
        System.out.println("7) Save and exit");
        System.out.print("Enter Here : ");
        return input.nextInt();
    }
    
    public static void addToLocalstore(ArrayList<Person> p){
        for(int i = 0; i < p.size(); i++){
            Person q = p.get(i);
            localstore.put(q.getName(), q);
        }
    }
    
    public static void writeToFile(Map<String,Person> localStore){
        try{
        File fileOne=new File("localstore.dat");
        FileOutputStream fos=new FileOutputStream(fileOne);
        ObjectOutputStream oos=new ObjectOutputStream(fos);

        oos.writeObject(localStore);
        oos.flush();
        oos.close();
        fos.close();
    }catch(Exception e){}
        
    }
    
    public static Map<String,Person> readFromFile(){
        HashMap<String,Person> mapInFile = new HashMap<String,Person>();
        try{
        File toRead=new File("localstore.dat");
        FileInputStream fis=new FileInputStream(toRead);
        ObjectInputStream ois=new ObjectInputStream(fis);

        mapInFile=(HashMap<String,Person>)ois.readObject();
        
        ois.close();
        fis.close();
        
        
    }catch(Exception e){}
        return mapInFile;
    }
    
    public static String searchForPersons(Map<String, Person> localstore, String searchPerson)
    {
        String returnVal = "";
        for(String name : localstore.keySet())
        {
            String key = localstore.get(name).toString();
            if(searchPerson.equals(name)){
                returnVal = key;
            }
        }
        return returnVal;
    }
    
    public static Person returnPerson(Map<String, Person> localstore, String search){
        return localstore.get(search);
    }
    
    public static JsonArray tvmaze(String search) throws IOException{
        ArrayList<Person> result = new ArrayList<Person>();
        URL tvmaze = new URL("http://api.tvmaze.com/search/people?q=" + search);
        URLConnection connection = tvmaze.openConnection();
        // Connecting to tvmaze
        
        InputStream in = connection.getInputStream();
        // Getting the information off of tvmaze
        
        JsonReader reader = Json.createReader(in);
        // Turning inputstream into Json
        
        JsonArray array = reader.readArray();
        return array;
    }
    
    public static ArrayList<Person> searchAPI(String search) throws IOException{
        ArrayList<Person> result = new ArrayList<Person>();
        JsonArray array = tvmaze(search);
        
        // Taking each Json object out of the array and getting the information out of it 
        for (int i = 0; i < array.size(); i++) {
            JsonObject object = array.getJsonObject(i);
            double score = object.getJsonNumber("score").doubleValue();
            JsonObject person = object.getJsonObject("person");
            int id = person.getJsonNumber("id").intValue();
            String personLink = person.getJsonString("url").toString();
            String name = person.getJsonString("name").toString();
            ArrayList<String> imageURL = new ArrayList<>();
            // Making sure that jsons image object is not null
            // If null it skips the if
            // If not null runs the if
            if (!person.isNull("image")) 
            {
                JsonObject imageObject = person.getJsonObject("image");
                String medium = imageObject.getJsonString("medium").toString();
                imageURL.add(medium);
                String original = imageObject.getJsonString("original").toString();
                imageURL.add(original);
            }
            JsonObject linkObject = person.getJsonObject("_links");
            JsonObject selfObject = linkObject.getJsonObject("self");
            String queryName = selfObject.getJsonString("href").toString();
            Person p = new Person(score, queryName, name, id, imageURL, personLink,0,"");
            result.add(p);
        }
        
        return result;
    }
    
    public static void printAllPersons(Map<String, Person> localstore)
    {
        for(String key : localstore.keySet())
        {
            String value = localstore.get(key).toString();
            System.out.println("Key: " + key + " Value: " + value);
        }
    }
    public static Map<String, Person> listPersonsByID(Map<String, Person> localstore)
    {
        
        // 1. Convert Map to List of Map
        List<Map.Entry<String, Person>> list =
                new LinkedList<Map.Entry<String, Person>>(localstore.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        
        Collections.sort(list, new Comparator<Map.Entry<String, Person>>() {
            @Override
            public int compare(Map.Entry<String, Person> o1,
                               Map.Entry<String, Person> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<String, Person> sortedMap = new LinkedHashMap<String, Person>();
        for (Map.Entry<String, Person> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        
        return sortedMap;
    }
    
    public static Map<String, Person> listPersonsByRating(Map<String, Person> localstore)
    {
        // 1. Convert Map to List of Map
        // Map.entry is key and value as a single class, allows iteration over Map.entrySet()
        List<Map.Entry<String, Person>> list = new LinkedList<Map.Entry<String, Person>>(localstore.entrySet());

        // 2. Sort list with Collections.sort(), provideing a custom Comparator
        
        Collections.sort(list, new Comparator<Map.Entry<String, Person>>() {
            @Override
            public int compare(Map.Entry<String, Person> o1,
                               Map.Entry<String, Person> o2) {
                return (o1.getValue()).compareToRating(o2.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map HashMap
        // if no worki make HashMap an LinkedHashMap
        Map<String, Person> sortedMap = new HashMap<String, Person>();
        for (Map.Entry<String, Person> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        
        return sortedMap;
    
    }
    public static Person editRating(Person foundPerson, int rating){
        foundPerson.setMyRating(rating);
        return foundPerson;
    }
    
    public static Person editComment(Person foundPerson, String comment){
        foundPerson.setComments(comment);
        return foundPerson;
    }

    public static void writeToHTML(Map<String,Person> localstore){
        FileWriter fWriter = null;
        BufferedWriter writer = null;
        
        try {
            
            fWriter = new FileWriter("localstore.html");
            writer = new BufferedWriter(fWriter);
            for(Person v: localstore.values()){
                ArrayList<String> image = v.getImgurl();
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
    
    
}