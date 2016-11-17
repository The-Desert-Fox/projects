/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

import java.util.Scanner;

/**
 *
 * @author Roshen
 */
public class GroupProject
{

    public static void main(String[] args)
    {
      MessageStore messageStore = new MessageStore();
      
      //Adding Email
//      Scanner keyboard = new Scanner(System.in);
//      int x = keyboard.nextInt();
      messageStore.addMessage(); //NEED TO SORT OUT THE DATE AND UNIQUE ID
      messageStore.addMessage();
      messageStore.addMessage();
      messageStore.addMessage();
      messageStore.addMessage();
      //Printing all the messages in the Array
      messageStore.printAllMessage();
        
        
    }
    
}
