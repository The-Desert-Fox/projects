/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailproject;

/**
 *
 * @author user
 */
class Employee {
    
    // Instance variables
    private String name;
    private int employeeID;
    private String date;
    private String emailAddress;
    private int phone;
    private String password;
    
    // Constructors
    
    // Default constructor
    public Employee()
    {
        this.name = "";
        this.employeeID = 0; 
        this.date = " "; 
        this.emailAddress = "";
        this.phone = 0;
        this.password = "";
    }
      
    // Employees in text file
    public Employee(String name, int employeeID, String date, String emailAddress, int phone, String password)
    {
        this.name = name;
        this.employeeID = employeeID; 
        this.date = date; 
        this.emailAddress = emailAddress;
        this.phone = phone;
        this.password = password;
    }
    
    public Employee(String name, String date, String emailAddress, int phone)
    {
        this.name = name;
        
        this.date = date; 
        this.emailAddress = emailAddress;
        this.phone = phone;
    }
    
    // Get methods
    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        return employeeID;
    }
    
    public String getDate() {
        return date;
    }
    
    public String getEmailAddress() {
        return emailAddress;
    }
    
    public int getPhone() {
        return phone;
    }
    
    public String getPassword() {
        return password;
    }
    
    // Set methods
    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
  
    public void setDate(String date) {
        this.date = date;
    }
   
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    public void setPhone(int phone) {
        this.phone = phone;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" + "name = " + name + ", employeeID = " + employeeID + ", date = " + date + ", emailAddress = " + emailAddress + ", phone = " + phone + '}';
    }
    
    
}
