/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapairproject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Image image = null;
 * URL url = new URL(-- The images URL --);
 * image = ImageIO.read(url);
 * jxImageView1.setImage(image); //<- May not be necessary
 */
public class JavaPairProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<String,Person> localStore = new HashMap<String,Person>();
        
        int choice = menu();
        while(choice != 0){
        switch(choice){
            case 1: System.out.println("Searching Local store");
                choice = menu();
                break;
            case 2: System.out.println("List of all people");
                choice = menu();
                break;
            case 3: System.out.println("Listing all people by id");
                choice = menu();
                break;
            case 4: System.out.println("List people by rateing");
                choice = menu();
                break;
            case 5: System.out.println("Edit person");
                choice = menu();
                break;
            case 6: System.out.println("Exporting to HTML");
                choice = menu();
                break;
            
        }
        }
    }

    public static int menu(){
        Scanner input = new Scanner(System.in);
        System.out.println("1) Search for a person");
        System.out.println("2) List all People");
        System.out.println("3) List People sorted by personid");
        System.out.println("4) List person by rateing");
        System.out.println("5) Edit Person");
        System.out.println("6) Export to HTML");
        System.out.println("Save and exit");
        return input.nextInt();
    }
    
}
