package groupproject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

// ISSUES
// Cannot load the employeeList arrayList from a .txt file
// Email can be changed to another, preexisting email. ISSUE RESOLVED
// InputMismatch still possiable. Need to ensure user input id of correct type.

public class EmployeeStore {
    private ArrayList<Employee> employeeList = new ArrayList<>();
    
    public void loadEmployeeList(Scanner file) throws FileNotFoundException
    {
        
        while(file.hasNext())
        {      
            String name = file.next();
            System.out.print(name);
            String password = file.next();
            String date = file.next();
            String emailAddress = file.next();
            int phone = file.nextInt();
            int employeeID = file.nextInt();  
            employeeList.add( new Employee(name, password, date, emailAddress, phone, employeeID));        
            //employeeList.add( new Employee(name, date, emailAddress, phone));
        }
        
        file.close();
    }
    
    // Default that will load information into the array
    public void loadEmployeeList()
    {
        employeeList.add( new Employee("John", "1345adg", "11-01-11", "simon", 1451451,1));  
        employeeList.add( new Employee("Paul", "msdmf332", "12-12-14", "Paul", 272541451,2));
        employeeList.add( new Employee("Ringo", "msdmf332", "16-05-03", "Ringo", 272541451,3));
        employeeList.add( new Employee("George", "msdmf332", "16-05-03", "George", 272541451,4));
        employeeList.add( new Employee("Martin", "msdmf332", "16-05-03", "Martin", 272541451,5));
        employeeList.add( new Employee("Paul", "msdmf332", "16-05-03", "Paul", 272541451,6));
    }
    
    
    // Add an employee
    public void addEmployee()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print( "Enter name: " );
        String name = sc.nextLine();
        
        int employeeID = employeeIdGen();
        
        System.out.print( "Enter Phone number: " );
        int phone = sc.nextInt();
        
        System.out.print( "Enter Date of Birth: " );
        String date = sc.nextLine();
        
        System.out.print( "Enter Email Address: " );
        String email = sc.nextLine();
        String checkedEmail = checkEmail(email);     
        
        System.out.print( "Enter Password: " );
        String password = sc.nextLine();
        
        employeeList.add( new Employee(name, password, date, checkedEmail, phone, employeeID));
        System.out.println( "You are now an employee." );
        System.out.println( "Your ID is " + employeeID );
        
        
    }
    
    public void addEmployee(String name,int number, String dateOfBirth, String emailAddress, String password)
    {
        int employeeID = employeeIdGen();
        String checkedEmail = checkEmail(emailAddress); 
        employeeList.add( new Employee(name, password, dateOfBirth, checkedEmail, number, employeeID));
    }
    
    // Displays all details of employees
    public void displayEmployeeList(){
        for( Employee p : employeeList)
            System.out.println( p );
    }
    
    // Displays details of a given employee
    public void displayEmployeeList(ArrayList<Employee> e){
        for( Employee p : e)
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
    // If more than 1 employees have the same name all will be returned
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
    
    //Returns an Employee object given an email
    public Employee returnEmployeeEmail(String email)
    {
        Employee employee = new Employee();
        for( int i = 0; i < employeeList.size(); i++)
        {
            Employee e = employeeList.get(i); // Getting the employee object
            String ename = e.getEmailAddress(); // Getting the name from the object
            if(ename.equals(email))// Deciding if their the same
            {
                employee = e;// Adding them to an arraylist
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
            id = r.nextInt(100000);
            
            if(idChecker(id))
            {
                end = !end;
            }
        }
        
        return id;
    }
    
    // Ensure the randomly generated id is unique
    public boolean idChecker(int id)
    {
        boolean check = true;
        
        for(int i = 0; i < employeeList.size(); i++)
        {
            Employee getEmployee = employeeList.get(i);
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
        boolean end = true;
        String newEmail = email;

        while(end)
        {
            if(!emailChecker(newEmail))
            {
                end = !end;
            }
            else
            {
                System.out.println("The address " + newEmail + " already exists. \n Try again");
                newEmail = sc.next();
            }
        }
        
        return newEmail;
    }
    
    // Ensures the email Address is unique
    public boolean emailChecker(String email)
    {
        boolean check = false;
        for(int i = 0; i < employeeList.size(); i++)
        {
            Employee getEmployee = employeeList.get(i);
            if(email.equals(getEmployee.getEmailAddress()))
            {
                check = true;
            }
        }
        
        return check;
    }
    
    // Editing an employees details given the Employee object
    // Needs the store so it can check emails when their being changed
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
                System.out.println("");
            }
        }
        
        return e;
    }
    
    //Delete employee details given an employee object
    public Employee deleteEmployee(Employee e)
    {
        Scanner sc = new Scanner(System.in);
        int menu = -1;
        //date and employeeid must be unchanged
        System.out.println("\n 1: Edit name"
                + "\n 2: Edit email address"
                + "\n 3: Edit phone number"
                + "\n 4: Edit password"
                + "\n 0: Exit Programme");
        
        while(menu != 0)
        {
            if(menu == 1)
            {
                e.setName(null);
            }
            else if(menu == 2)
            {
                e.setEmailAddress(null);
            }
            else if(menu == 3)
            {
                e.setPhone(0);
            }
            else if(menu == 4)
            {
                e.setPassword(null);
            }
            
        }
        
        return e;
    }
}
