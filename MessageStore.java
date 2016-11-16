/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Roshen
 */
public class MessageStore
{

   private ArrayList<Message> messageBank = new ArrayList<>();

    public MessageStore()
    {

    }

    public void addMessage()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("From: ");
        String fromAddress = keyboard.nextLine();
        System.out.print("To: ");
        String toAddress = keyboard.nextLine();
        System.out.print("Subject: ");
        String subject = keyboard.nextLine();
        //int date;
        System.out.print("Priority (Low/Medium/High): ");
        String priority = keyboard.nextLine();
        System.out.print("Message: ");
        String messageBody = keyboard.nextLine();
        int messageID = randomNumber();
        messageID++; 

    messageBank.add(new Message(fromAddress, toAddress, subject, priority, messageBody, messageID));
    }
    
    public int randomNumber()
    {
        boolean trigger = false;
        int messageID = 0;
        while(!trigger)
        {
            Random x = new Random();
            int num = x.nextInt(5 + 1); 
            for(int y = 0; y <= messageBank.size(); y++)
            {
                Message getMessage = messageBank.get(y);
                if(num == getMessage.getMessageID())
                {
                    trigger = false;
                }
                else
                {
                    trigger = true;
                }
            }
            messageID = num;
        }
        return messageID;
    }
    
    public void printAllMessage()
    {
        for(Message x : messageBank)
        {
            System.out.println(x);
        }
    }
}
