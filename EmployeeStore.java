package emailproject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class EmployeeStore {
    private ArrayList<Employee> employeeList = new ArrayList<>();
    
    public void loadEmployeeList(String file) throws FileNotFoundException
    {
        
        try {
            Scanner sc = new Scanner(new File(file));

        while(sc.hasNext())
        {
            String name = sc.next();
            int employeeID = sc.nextInt();
            String date = sc.next();
            String emailAddress = sc.next();
            int phone = sc.nextInt();
            String password = sc.next();
            employeeList.add( new Employee(name, employeeID, date, emailAddress, phone, password));
            //employeeList.add( new Employee(name, date, emailAddress, phone));
        }
        
        sc.close();
        }
        catch (IOException e) {
        }
        //employeeList.add( new Employee("John", 4, "010101", "khabvaf", 1451451));
        
    }
    
    public void loadEmployeeList()
    {
        employeeList.add( new Employee("John", 1, "010101", "simon", 1451451,"1345adg"));  
        employeeList.add( new Employee("Paul", 2, "2572245", "sfghbvaf", 272541451,"msdmf332"));
        employeeList.add( new Employee("Paul", 3, "2572245", "sfghbvaf", 272541451,"msdmf332"));
        employeeList.add( new Employee("Paul", 4, "2572245", "sfghbvaf", 272541451,"msdmf332"));
        employeeList.add( new Employee("Paul", 5, "2572245", "sfghbvaf", 272541451,"msdmf332"));
    }
    
    
    // Add an employee
    public void addEmployee()
    {
        SimpleDateFormat d = new SimpleDateFormat("yyyy/MM/dd");
        Scanner sc = new Scanner(System.in);
        System.out.println( "You want to add a new employee?" );
        
        System.out.println( "Enter name: " );
        String name = sc.next();
        
        System.out.println( "Enter Phone number: " );
        int phone = sc.nextInt();
        
        System.out.println( "Generating unique employee ID..." );
        int employeeID = employeeIdGen();
        
        System.out.println( "Getting date..." );
        String date = "";
        // Find out how to get the date
        
        System.out.println( "Enter Email Address: " );
        String email = sc.next();
        String checkedEmail = checkEmail(email);     
        
        System.out.println( "Enter Password: " );
        String password = sc.next();
        
        System.out.println( "Enter Email Address: " );
        employeeList.add( new Employee(name, employeeID, date, checkedEmail, phone, password));
        System.out.println( "You are now an employee." );
        System.out.println( "Your ID is " + employeeID );
        
        
    }
    
    // Displays all details of employees
    public void displayEmployeeList(){
        for( Employee p : employeeList)
            System.out.println( p );
    }
    
    // Returns  arraylist of employees
    public ArrayList<String> returnEmployeeList()
    {
        ArrayList<String> names = new ArrayList<String>() ;
        for( int i = 0; i < employeeList.size(); i++)
        {
            Employee e = employeeList.get(i);// Getting the employee object
            String name = e.getName();// Getting the name from the object
            names.add(name);// adding that name to an arraylist 
        }
        return names;
    }
    
    // Returns a specific empoloyee given a name
    // If 2 employees have the same name both will be returned
    public ArrayList<Employee> returnSpecificEmployee(String name)
    {
        ArrayList<Employee> employee = new ArrayList<Employee>() ;
        for( int i = 0; i < employeeList.size(); i++)
        {
            Employee e = employeeList.get(i); // Getting the employee object
            String ename = e.getName(); // Getting the name from the object
            if(ename.equals(name))// Deciding if their the same
            {
                employee.add(e);// Adding them to an arraylist
            }
        }
        
        return employee;
    }
    
    // Creating random id
    public int employeeIdGen()
    {
        boolean end = true;
        int id = 0;
        Random r = new Random();
        
        while(end)
        {
            id = r.nextInt(100009);
            
            if(idChecker(id))
            {
                end = !end;
            }
        }
        
        return id;
    }
    
    // Ensure the id is unique
    public boolean idChecker(int id)
    {
        boolean check = true;
        
        for(int i = 0; i < employeeList.size(); i++)
        {
            Employee getEmployee = employeeList.get(i);
            System.out.println("Pre-existing id: " + getEmployee.getEmployeeID());
            if(id == getEmployee.getEmployeeID())
            {
                check = false;
            }
        }
        
        
        return check;
    }
    
    // Returns a unique email address
    public String checkEmail(String email)
    {
        Scanner sc = new Scanner(System.in);
        String newemail = "";
        
        if(emailChecker(email))
        {
            newemail = email;
        }
        else
        {
            System.out.println( "That email already exists. Try again." );
            newemail = sc.next();
            checkEmail(newemail);
        }
        return newemail;
    }
    
    // Ensures the email Address is unique
    public boolean emailChecker(String email)
    {
        boolean check = true;
        for(int i = 0; i < employeeList.size(); i++)
        {
            Employee getEmployee = employeeList.get(i);
            
            if(email.equals(getEmployee.getEmployeeID()))
            {
                check = false;
            }
        }
        
        return check;
    }
    
    //Editing an employee
    public Employee editEmployee(Employee e, EmployeeStore store)
    {
        Scanner sc = new Scanner(System.in);
        int menu = -1;
        //date and employeeid must be unchanged
        System.out.println("\n 1: Edit name"
                + "\n 2: Edit email address"
                + "\n 3: Edit phone number"
                + "\n 4: Edit password");
        while(menu != 0)
        {
            menu = sc.nextInt();
            if(menu == 1)
            {
                System.out.println("Current name: " + e.getName());
                System.out.println("Change name to ");
                String name = sc.next();
                e.setName(name);
            }
            else if(menu == 2)
            {
                System.out.println("Current email address: " + e.getEmailAddress());
                System.out.println("Change email to ");
                String email = sc.next();
                String checkedEmail = store.checkEmail(email);
                e.setEmailAddress(checkedEmail);
            }
            else if(menu == 3)
            {
                System.out.println("Current phone number " + e.getPhone());
                System.out.println("Change phone number to ");
                int phone = sc.nextInt();     
                e.setPhone(phone);
            }
            else if(menu == 4)
            {
                
            }
        }
        
        return e;
    }
}
