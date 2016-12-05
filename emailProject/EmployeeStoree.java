/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roshen
 */
public class EmployeeStoree
{

    private ArrayList<Employeee> employeeBank = new ArrayList<>();

    public EmployeeStoree()
    {

    }

    public void loadData(String file) throws FileNotFoundException
    {
        try
        {
            File dataFile = new File(file);
            Scanner sc = new Scanner(dataFile).useDelimiter(",");

            while (sc.hasNext())
            {
                String name = sc.next();
                System.out.println("Test: " + name);

                int employID = sc.nextInt();
                System.out.println("Test: " + employID);

                String dateOfBirth = sc.next();
                System.out.println("Test: " + dateOfBirth);

                String mail = sc.next();
                System.out.println("Test: " + mail);

                int phoneNum = sc.nextInt();
                System.out.println("Test: " + phoneNum);

                String password = sc.next();
                System.out.println("Test: " + password);

                employeeBank.add(new Employeee(name, employID, dateOfBirth, mail, phoneNum, password));
                //System.out.println(str);
            }
            sc.close();
        } catch (IOException e)
        {
        }
    }


    public void loadEmployeeList()
    {
        employeeBank.add(new Employeee("John Knox", 57447, "26-06-1964", "abcdef@gmail.com", 1234, "helloworld"));
        employeeBank.add(new Employeee("Harry Potter", 12415, "13-04-1977", "qwer@gmail.com", 5678, "aasd"));
        employeeBank.add(new Employeee("Danjo Butcher", 21312, "06-02-1967", "zxcv@gmail.com", 9102, "qwer"));
        employeeBank.add(new Employeee("Bob Ridley", 12312, "17-11-1989", "asdf@gmail.com", 3456, "zxcv"));
        employeeBank.add(new Employeee("Tom Riddle", 46664, "14-10-1987", "hello@gmail.com", 7890, "1234"));
    }

    public void addEmployee()
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = keyboard.nextLine();

        int employeeID = randomNumber();

        System.out.print("Enter Date of Birth: ");
        String dateOfBirth = keyboard.nextLine();

        System.out.print("Enter Email: ");
        String emailAddress = keyboard.nextLine();

        System.out.print("Enter Phone: ");
        int phoneNumber = keyboard.nextInt();

        System.out.print("Enter Password: ");
        keyboard.nextLine();
        String password = keyboard.nextLine();

        employeeBank.add(new Employeee(name, employeeID, dateOfBirth, emailAddress, phoneNumber, password));

    }
    
   // public void addEmployee(String name,int number, String dateOfBirth, String emailAddress, String password)
   // {
   //     int employeeID = randomNumber();
   //     String checkedEmail = checkEmail(emailAddress); 
   //     employeeBank.add(new Employeee(name, employeeID, dateOfBirth, emailAddress, phoneNumber, password));
   // }

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

    public boolean idChecker(int id)
    {
        boolean check = true;
        for (int i = 0; i < employeeBank.size(); i++)
        {
            Employeee getID = employeeBank.get(i);
            if (id == getID.getEmployeeID())
            {
                check = false;
            }
        }

        return check;
    }

    public String checkEmail(String email)
    {

        Scanner sc = new Scanner(System.in);
        boolean end = true;
        String newEmail = email;

        while (end)
        {
            if (!emailChecker(newEmail))
            {
                end = !end;
            }
            else
            {
                System.out.println("The address " + newEmail + " already exists. \n Try again");
                newEmail = sc.nextLine();
            }
        }

        return newEmail;
    }

    public boolean emailChecker(String email)
    {
        boolean check = false;
        for (int i = 0; i < employeeBank.size(); i++)
        {
            Employeee getEmployee = employeeBank.get(i);
            if (email.equals(getEmployee.getEmailAddress()))
            {
                check = true;
            }
        }

        return check;
    }

    // Displays all details of employees
    public void displayEmployeeList()
    {
        for (Employeee p : employeeBank)
        {
            System.out.println(p);
        }
    }

    public void displaySpecificList(ArrayList<Employeee> e)
    {
        for (Employeee p : e)
        {
            System.out.println(p);
        }
    }

    public ArrayList<String> returnEmployeeList()
    {
        ArrayList<String> names = new ArrayList<String>();
        for (int i = 0; i < employeeBank.size(); i++)
        {
            Employeee e = employeeBank.get(i);// Getting the employeeStorer object
            String name = e.getName();// Getting the name from the object
            names.add(name);// adding that name to an arraylist 
        }
        return names;
    }

    public ArrayList<Employeee> returnSpecificEmployee(String name)
    {
        ArrayList<Employeee> employee = new ArrayList<Employeee>();
        for (int i = 0; i < employeeBank.size(); i++)
        {
            Employeee e = employeeBank.get(i); // Getting the employeeStorer object
            String ename = e.getName(); // Getting the name from the object
            if (ename.equals(name))// Deciding if their the same
            {
                employee.add(e);// Adding them to an arraylist
            }
        }

        return employee;
    }

//       public Employeee returnEmployeeEmail(String email)
//    {
//        Employee employeeStorer = new Employee();
//        for( int i = 0; i < employeeBank.size(); i++)
//        {
//            Employeee e = employeeBank.get(i); // Getting the employeeStorer object
//            String ename = e.getEmailAddress(); // Getting the name from the object
//            if(ename.equals(email))// Deciding if their the same
//            {
//                employeeStorer = e;// Adding them to an arraylist
//            }
//        }
//        
//        return employeeStorer;
//    }
    
    //Put all strings in the main method
    public void editEmployee(int ID)
    {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Employeee> employeeStorer = new ArrayList<Employeee>();
        Employeee person = new Employeee("", 0, "", "", 0, "");
        for (int i = 0; i < employeeBank.size(); i++)
        {
            Employeee e = employeeBank.get(i); // Getting the employeeStorer object
            int employID = e.getEmployeeID(); // Getting the name from the object

            if (employID == ID)
            {
                person = e;
            }
        }
        int option = -1;
        do
        {
            System.out.println(
                    "\n 1: Edit name"
                    + "\n 2: Edit date of birth"
                    + "\n 3: Edit email address"
                    + "\n 4: Edit phone number"
                    + "\n 5: Edit password"
                    + "\n 0: Exit"
            );
            System.out.print("Select option: ");
            option = keyboard.nextInt();
            keyboard.reset();
            switch (option)
            {
                case 1:
                    System.out.println("Current name: " + person.getName());
                    System.out.print("New Name: ");

                    String bufferReleaser = keyboard.nextLine();
                    String name = keyboard.nextLine();
                    person.setName(name);
                    break;
                case 2:
                    System.out.println("Current Date of Birth: " + person.getDateOfBirth());
                    System.out.print("New Date of Birth: ");
                    String bufferReleaser2 = keyboard.nextLine();
                    String dob = keyboard.nextLine();
                    person.setDateOfBirth(dob);
                    break;
                case 3:
                    System.out.println("Current email address: " + person.getEmailAddress());
                    System.out.print("New email: ");
                    String bufferReleaser3 = keyboard.nextLine();
                    String email = keyboard.nextLine();
                    String checkedEmail = checkEmail(email);
                    person.setEmailAddress(checkedEmail);
                    break;
                case 4:
                    System.out.println("Current phone number " + person.getPhone());
                    System.out.print("New phone number: ");
                    int phone = keyboard.nextInt();
                    person.setPhone(phone);
                    break;
                case 5:
                    System.out.println("Current password " + person.getPassword());
                    System.out.print("New password: ");
                    String bufferReleaser4 = keyboard.nextLine();
                    String password = keyboard.nextLine();
                    person.setPassword(password);
                    break;
            }

        } while (option != 0);
        System.out.println("Updated Information" + "\n" + person);
    }
    
    public void editName(String name, Employee e)
    {
        e.setName(name);
    }
    
    public void editDoB(String date, Employee e)
    {
        e.setDate(date);
    }
    
    public void editEmail(String email, Employee e)
    {
        e.setEmailAddress(email);
    }
    
    public void editPhoneNumber(int phone, Employee e)
    {
        e.setPhone(phone);
    }
    
    public void editPassword(String password, Employee e)
    {
        e.setPassword(password);
    }
}
