/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swmfjavaca5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author S
 */
public class Swmfjavaca5Test {
    
    public Swmfjavaca5Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    

    /**
     * Test of addToLocalstore method, of class Swmfjavaca5.
     */
    @Test
    public void testAddToLocalstore() {
        System.out.println("addToLocalstore");
        ArrayList<Person> p = new ArrayList<Person>();
        Person q = new Person();
        p.add(q);
        Swmfjavaca5.addToLocalstore(p);
        assertEquals(p.size(),1);
        assertEquals(q.getName(),p.get(0).getName());
    }

    /**
     * Test of writeToFile method, of class Swmfjavaca5.
     */
    @Test
    public void testWriteToFile() {
        System.out.println("writeToFile");
        Map<String, Person> localStore = new HashMap<String,Person>();
        Person q = new Person();
        localStore.put("S", q);
        Swmfjavaca5.writeToFile(localStore);
        // TODO review the generated test code and remove the default call to fail.
        Map<String, Person> newlocalStore = new HashMap<String,Person>();
        newlocalStore = Swmfjavaca5.readFromFile();
        assertEquals(localStore.size(),newlocalStore.size());
        assertEquals(localStore.containsKey("S"),newlocalStore.containsKey("S"));
    }

    
    @Test
    public void testReadFromFile() {
        System.out.println("readFromFile");
        Map<String, Person> expResult = new HashMap<String,Person>();
        Map<String, Person> result = Swmfjavaca5.readFromFile();
        assertEquals(expResult.getClass(), result.getClass());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of searchForPersons method, of class Swmfjavaca5.
     */
    @Test
    public void testSearchForPersons() {
        System.out.println("searchForPersons");
        Map<String, Person> localstore = new HashMap<String,Person>();
        Person p = new Person((float)1.5, "Simon", "Watters", 10, new ArrayList<String>(),"StringLink",5,"hello");
        localstore.put("Simon", p);
        String searchPerson = "Simon";
        String result = Swmfjavaca5.searchForPersons(localstore, searchPerson);
        String should = "Person{score=1.5, quearyName=Simon, name=Watters, id=10, imgurl=[], personLink=StringLink, myRating=5, comments=hello}";
        assertEquals(result,should);
        
    }

    /**
     * Test of returnPerson method, of class Swmfjavaca5.
     */
    @Test
    public void testReturnPerson() {
        System.out.println("returnPerson");
        Map<String, Person> localstore = new HashMap<String,Person>();
        Person p = new Person((float)1.5, "Simon", "Watters", 10, new ArrayList<String>(),"StringLink",5,"hello");
        localstore.put("Simon", p);
        
        Person result = Swmfjavaca5.returnPerson(localstore, "Simon");
        assertEquals(p, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of lookUpAPI method, of class Swmfjavaca5.
     */
    @Test
    public void testSearchAPI() throws Exception {
        System.out.println("searchAPI");
        String search = "";
        ArrayList<Person> expResult = new ArrayList<Person>();
        ArrayList<Person> result = Swmfjavaca5.searchAPI(search);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
                
    }

    /**
     * Test of editRating method, of class Swmfjavaca5.
     */
    @Test
    public void testEditRating() {
        System.out.println("editRating");
        Person q = new Person((float)1.5, "Alan Watters", "Alan Watters", 11,new ArrayList<String>(),"StringLink",5,"hello");
        int rating = 0;
        Person expResult = null;
        Person result = Swmfjavaca5.editRating(q, rating);
        boolean r = result.getMyRating() == rating;
        assertTrue(r);
    }

    /**
     * Test of editComment method, of class Swmfjavaca5.
     */
    @Test
    public void testEditComment() {
        System.out.println("editRating");
        Person q = new Person((float)1.5, "Alan Watters", "Alan Watters", 11,new ArrayList<String>(),"StringLink",5,"hello");
        String comment = "New Comment";
        Person result = Swmfjavaca5.editComment(q, comment);
        boolean r = result.getComments().equals(comment);
        assertTrue(r);
    }

    /**
     * Test of exportSearchResultToHTML method, of class Swmfjavaca5.
     */
    @Test
    public void testWriteToHTML() throws Exception {
        
    }
    
}
