/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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

    public boolean adminstratorLogin()
    {
        Scanner keyboard = new Scanner(System.in);
        String username = "username", password = "password", userInput, passInput;
        boolean adminLog = false;
        int loginAttempts = 0;
        System.out.println("--------------------------------");
        System.out.println("       Adminstrator Login       ");
        System.out.println("--------------------------------");

        while (adminLog == false && loginAttempts != 3)
        {
            System.out.print("Username: ");
            userInput = keyboard.nextLine();
            System.out.print("Password: ");
            passInput = keyboard.nextLine();
            if (userInput.equals(username) && passInput.equals(password))
            {
                adminLog = true;

            }
            else
            {
                loginAttempts++;
                System.out.println("Sorry Incorrect Username or Password. Please Try Again!");
            }
            if (loginAttempts == 3)
            {
                System.out.println("-------------------------------------");
                System.out.println("3 Failed Attempts --> SYSTEM LOCKED!! \nPlease Re-run the program");
                System.out.println("-------------------------------------");
            }
        }

        return adminLog;
    }

    public void loadEmployeeList()
    {
        messageBank.add(new Message("a@mail.com", "f@mail.com", "hello", "2016-11-22T09:30Z", "High", "hello world jones", 00001));
        messageBank.add(new Message("a@mail.com", "b@mail.com", "hello", "2016-11-22T09:30Z", "High", "hello world hillary", 00004));
        messageBank.add(new Message("g@mail.com", "c@mail.com", "hello", "2016-11-22T09:30Z", "Low", "hello world jones", 00002));
        messageBank.add(new Message("g@mail.com", "d@mail.com", "hello", "2016-11-22T09:30Z", "Medium", "hello world nick", 00005));
        messageBank.add(new Message("t@mail.com", "e@mail.com", "hello", "2016-11-22T09:30Z", "High", "hello world bob", 00003));
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

        String date = date();

        System.out.print("Priority (Low/Medium/High): ");
        String priority = keyboard.nextLine();

        System.out.print("Message: ");
        String messageBody = keyboard.nextLine();

        int messageID = randomNumber();
        messageBank.add(new Message(fromAddress, toAddress, subject, date, priority, messageBody, messageID));
    }

    public String date()
    {
        Format formatter = new SimpleDateFormat("dd-MM-yy");
        String s = formatter.format(new Date());

        return s;
    }

    public int randomNumber()
    {
        boolean end = true;
        int id = 0;
        Random r = new Random();

        while (end)
        {
            id = r.nextInt(100009);

            if (idChecker(id))
            {
                end = !end;
            }
        }
        return id;
    }

    // Ensure the storedEmail is unique
    public boolean idChecker(int id)
    {
        boolean check = true;
        for (int i = 0; i < messageBank.size(); i++)
        {
            Message getMessage = messageBank.get(i);
            if (id == getMessage.getMessageID())
            {
                check = false;
            }
        }

        return check;
    }

    public void printAllMessage()
    {
        for (Message x : messageBank)
        {
            System.out.println(x);
        }
    }

    public ArrayList<Message> specificMessageByID(int msgID)
    {
        ArrayList<Message> msgs = new ArrayList<Message>();
        for (int i = 0; i < messageBank.size(); i++)
        {
            Message e = messageBank.get(i); // Getting the mails object
            int id = e.getMessageID(); // Getting the name from the object
            if (id == msgID)// Deciding if their the same
            {
                msgs.add(e);// Adding them to an arraylist
            }
        }

        return msgs;
    }

    public ArrayList<Message> specificMessageByEmail(String email, int num)
    {

        ArrayList<Message> mails = new ArrayList<Message>();
        for (int i = 0; i < messageBank.size(); i++)
        {
            Message e = messageBank.get(i); // Getting the mails object
            String storedEmail = ""; // Getting the name from the object
            if (num == 4)
            {
                storedEmail = e.getFromAddress();
            }
            else
            {
                storedEmail = e.getToAddress();
            }

            if (storedEmail.equals(email))// Deciding if their the same
            {
                mails.add(e);// Adding them to an arraylist
            }
        }

        return mails;
    }
    
     public ArrayList<Message> specificMessageByPriority(String prior)
    {
        ArrayList<Message> priorBank = new ArrayList<Message>();
        for (int i = 0; i < messageBank.size(); i++)
        {
            Message e = messageBank.get(i); // Getting the mails object
            String storedPrior = e.getPriority(); // Getting the name from the object
            if (storedPrior.equals(prior))// Deciding if their the same
            {
                priorBank.add(e);// Adding them to an arraylist
            }
        }

        return priorBank;
    }

    public ArrayList<Message> specificMessageBySubstring(String prior)
    {
        ArrayList<Message> stringBank = new ArrayList<Message>();
        for (int i = 0; i < messageBank.size(); i++)
        {
            Message e = messageBank.get(i); // Getting the mails object
            String storedString = e.getMessageBody(); // Getting the name from the object
            if (storedString.toLowerCase().contains(prior.toLowerCase()))// Deciding if their the same
            {
                stringBank.add(e);// Adding them to an arraylist
            }
        }

        return stringBank;
    }

    public ArrayList<Message> specificMessageByDate(String date)
    {
        ArrayList<Message> dateBank = new ArrayList<Message>();
        for (int i = 0; i < messageBank.size(); i++)
        {
            Message e = messageBank.get(i); // Getting the mails object
            String storedDate = e.getDate(); // Getting the name from the object
            if (storedDate.equals(date))// Deciding if their the same
            {
                dateBank.add(e);// Adding them to an arraylist
            }
        }

        return dateBank;
    }

    public ArrayList<Message> arrayList()
    {
        ArrayList<Message> dataBank = new ArrayList<Message>();
        for (int i = 0; i < messageBank.size(); i++)
        {
            Message e = messageBank.get(i); // Getting the mails object
            dataBank.add(e);

        }

        return dataBank;
    }

    // Likely doesnt work
    public ArrayList<Message> getMessagesByGivenDate(int year, int month, int day)
    {
        ArrayList<Message> datesSorted = new ArrayList<Message>();
        ZoneId zoneId = ZoneId.of("UTC");
        ZonedDateTime givenDate = ZonedDateTime.of(year,month,day,0,0,0,0,zoneId);
        ZonedDateTime date;
        Message e = new Message();
        for(int i = 0; i < messageBank.size(); i++)
        {
            e.equals(messageBank.get(i));
            date = e.getDateObj();
            if(date.isEqual(givenDate))
            {
                datesSorted.add(messageBank.get(i));
            }
        }
        return datesSorted;
    }
    
    public static class OrderByID implements Comparator<Message>
    {

        @Override
        public int compare(Message o1, Message o2)
        {
            return o1.getMessageID() > o2.getMessageID() ? 1 : (o1.getMessageID() < o2.getMessageID() ? -1 : 0);
        }
    }
    
    public static class OrderByDate implements Comparator<Message>
    {

        @Override
        public int compare(Message o1, Message o2)
        {
            return o1.getDate().compareTo(o2.getDate());
        }
    }

}
