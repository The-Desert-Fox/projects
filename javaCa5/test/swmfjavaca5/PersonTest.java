/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swmfjavaca5;

import java.util.ArrayList;
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
public class PersonTest {
    
    public PersonTest() {
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
     * Test of toString method, of class Person.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Person instance = new Person();
        String expResult = "Person{score=0.0, quearyName=, name=, id=0, imgurl=[], personLink=, myRating=0, comments=}";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getScore method, of class Person.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        Person instance = new Person();
        double expResult = 0.0;
        double result = instance.getScore();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setScore method, of class Person.
     */
    @Test
    public void testSetScore() {
        System.out.println("setScore");
        float score = 0.0F;
        Person instance = new Person();
        instance.setScore(score);
        
        
    }

    /**
     * Test of getQuearyName method, of class Person.
     */
    @Test
    public void testGetQuearyName() {
        System.out.println("getQuearyName");
        Person instance = new Person();
        String expResult = "";
        String result = instance.getQuearyName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setQuearyName method, of class Person.
     */
    @Test
    public void testSetQuearyName() {
        System.out.println("setQuearyName");
        String quearyName = "";
        Person instance = new Person();
        instance.setQuearyName(quearyName);
        
    }

    /**
     * Test of getName method, of class Person.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Person instance = new Person();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setName method, of class Person.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Person instance = new Person();
        instance.setName(name);
        
    }

    /**
     * Test of getId method, of class Person.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Person instance = new Person();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setId method, of class Person.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Person instance = new Person();
        instance.setId(id);
        
    }

    /**
     * Test of getImgurl method, of class Person.
     */
    @Test
    public void testGetImgurl() {
        System.out.println("getImgurl");
        Person instance = new Person();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getImgurl();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getPersonLink method, of class Person.
     */
    @Test
    public void testGetPersonLink() {
        System.out.println("getPersonLink");
        Person instance = new Person();
        String expResult = "";
        String result = instance.getPersonLink();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setPersonLink method, of class Person.
     */
    @Test
    public void testSetPersonLink() {
        System.out.println("setPersonLink");
        String personLink = "";
        Person instance = new Person();
        instance.setPersonLink(personLink);
        
    }

    /**
     * Test of getMyRating method, of class Person.
     */
    @Test
    public void testGetMyRating() {
        System.out.println("getMyRating");
        Person instance = new Person();
        int expResult = 0;
        int result = instance.getMyRating();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setMyRating method, of class Person.
     */
    @Test
    public void testSetMyRating() {
        System.out.println("setMyRating");
        int myRating = 0;
        Person instance = new Person();
        instance.setMyRating(myRating);
        
    }

    /**
     * Test of getComments method, of class Person.
     */
    @Test
    public void testGetComments() {
        System.out.println("getComments");
        Person instance = new Person();
        String expResult = "";
        String result = instance.getComments();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setComments method, of class Person.
     */
    @Test
    public void testSetComments() {
        System.out.println("setComments");
        String comments = "";
        Person instance = new Person();
        instance.setComments(comments);
        
    }

    /**
     * Test of hashCode method, of class Person.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Person instance = new Person();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of equals method, of class Person.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Person instance = new Person();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of toHTML method, of class Person.
     */
    @Test
    public void testToHTML() {
        System.out.println("toHTML");
        Person instance = new Person();
        String expResult = "";
        String result = instance.toHTML();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of compareTo method, of class Person.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Person p = new Person((float)1.5, "Simon", "Watters", 10, new ArrayList<String>(),"StringLink",5,"hello");
        Person q = new Person((float)1.5, "Simon", "Watters", 10, new ArrayList<String>(),"StringLink",5,"hello");
        int expResult = 0;
        int result = p.compareTo(q);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testCompareToAgain(){
        System.out.println("compareToAgain");
        Person p = new Person((float)1.5, "Simon", "Watters", 10, new ArrayList<String>(),"StringLink",5,"hello");
        Person q = new Person((float)1.5, "Simon", "Watters", 11, new ArrayList<String>(),"StringLink",5,"hello");
        int expResult = -1;
        int result = p.compareTo(q);
        assertEquals(expResult, result);
    }

    /**
     * Test of compareToRating method, of class Person.
     */
    @Test
    public void testCompareToRating() {
        System.out.println("compareToRating");
        Person p = new Person((float)1.5, "Simon", "Watters", 10, new ArrayList<String>(),"StringLink",5,"hello");
        Person q = new Person((float)1.5, "Simon", "Watters", 10, new ArrayList<String>(),"StringLink",5,"hello");
        int expResult = 0;
        int result = p.compareToRating(q);
        assertEquals(expResult, result);
        
    }
    
}
