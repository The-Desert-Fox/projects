package emailproject;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class EmailProject {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        EmployeeStore employeeStore = new EmployeeStore(); // Initializing store
        
        employeeStore.loadEmployeeList(); // Adds all employees in file to Array
        
        /*System.out.println("Display all info on all employees");
        employeeStore.displayEmployeeList();
        
        System.out.println();
        System.out.println("Returning all employee names in an arraylist");
        ArrayList<String> n = employeeStore.returnEmployeeList();
        System.out.println(Arrays.toString(n.toArray()));

        System.out.println();
        System.out.println("Display specific employee, select by name");
        ArrayList<Employee> i = employeeStore.returnSpecificEmployee("Danny Trejo");
        System.out.println(Arrays.toString(i.toArray()));
        
        employeeStore.addEmployee();// Testing addEmployee method
        employeeStore.displayEmployeeList(); //seeing if its added
        employeeStore.addEmployee(); // testing email validation
        employeeStore.displayEmployeeList();
        */
        
        Scanner sc = new Scanner(System.in);
        int menu = -1;
        System.out.println(
                "\n 1: Display all info on employees"
                + "\n 2: Return all employee names in a list"
                + "\n 3: Return Specific employee details, select by name"
                + "\n 4: Add an employee "
                + "\n 5: Edit employee details");
        while(menu != 0)
        {
            menu = sc.nextInt();
            if(menu == 1)
            {
                employeeStore.displayEmployeeList();
            }
            else if(menu == 2)
            {
                ArrayList<String> n = employeeStore.returnEmployeeList();
                System.out.println(Arrays.toString(n.toArray()));
            }
            else if(menu == 3)
            {
                System.out.println("Enter a name");
                String name = sc.next();
                ArrayList<Employee> i = employeeStore.returnSpecificEmployee(name);
                System.out.println(Arrays.toString(i.toArray()));
            }
            else if(menu == 4)
            {
                employeeStore.addEmployee();
            }
        }
    }
    
}
