import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Employee{
    private String id;
    private String name;
    private String department;
    private String designation;
    private String dateOfJoining;
    private String dateOfBirth;
    private String maritalStatus;
    private String dateOfMarriage;
    private String surname;
    
    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation){
        this.designation = designation;
    }
    public String getDateOfJoining(){
        return dateOfJoining;
    }
    public void setDateOfJoining(String dateOfJoining){
        this.dateOfJoining = dateOfJoining;
    }
    public String getDateOfBirth(){
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }
    public String getMaritalStatus(){
        return maritalStatus;
    }
    public void setMaritalStatus(String maritalStatus){
        this.maritalStatus = maritalStatus;
    }
    public String getDateOfMarriage(){
        return dateOfMarriage;
    }
    public void setDateOfMarriage(String dateOfMarriage){
        this.dateOfMarriage = dateOfMarriage;
    }
    private List<Employee> employees;
    private boolean exitRequested;

    public Employee()  {
        this.employees = new ArrayList<>();
        this.exitRequested = false;
    }

    public void run()  {
        run1();
        while (true) {
            showMenu();
            if (exitRequested) {
                System.out.println("Exiting the Employee Management System. Goodbye!");
                break;
            }
        }
    }
    public synchronized void run1() {
    try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void showMenu() {
        int option;
        Scanner sc = new Scanner(System.in);
        run1();
        System.out.println("--------Menu--------");
        System.out.println("1. Enter Data");
        System.out.println("2. Display Data");
        System.out.println("3. Exit");
        System.out.println("\n*--------Choose an option--------*");

        while (!sc.hasNextInt()) {
            System.out.println("Please enter a valid option");
            sc.next(); // consume the invalid input
        }
        option = sc.nextInt();

        switch (option) {
            case 1:
                enterData();
                break;
            case 2:
                displayData();
                break;
            case 3:
                exitMenu();
                break;
            default:
                System.out.println("Incorrect menu option");
                break;
        }
    }
    public void enterData() {
        Scanner sc = new Scanner(System.in);

        char choice = 'y';

        while (choice == 'y') {
            Employee employee = new Employee();
            run1();
            System.out.println("Enter Employee Id: ");
            employee.setId(sc.next());
            run1();
            System.out.println("Enter Employee Surname: ");
            employee.setSurname(sc.next());
            run1();
            System.out.println("Enter Employee Name: ");
            employee.setName(sc.next());
            run1();
            System.out.println("Enter Employee Department: ");
            employee.setDepartment(sc.next());
            run1();
            System.out.println("Enter Employee Designation: ");
            employee.setDesignation(sc.next());
            run1();
            System.out.println("Enter Date of Joining (yyyy-MM-dd): ");
            while (true) {
                try {
                    employee.setDateOfJoining(validateAndParseDate(sc.next()));
                    break;
                } catch (ParseException e) {
                    System.out.println("Please enter a valid date (yyyy-MM-dd)");
                }
            }
            run1();
            System.out.println("Enter Date of Birth (yyyy-MM-dd): ");
            while (true) {
                try {
                    employee.setDateOfBirth(validateAndParseDate(sc.next()));
                    break;
                } catch (ParseException e) {
                    System.out.println("Please enter a valid date (yyyy-MM-dd)");
                }
            }
            run1();
            System.out.println("Enter Marital Status (married/single): ");
            while (true) {
                String maritalStatus = sc.next().toLowerCase();
                if (maritalStatus.equals("married") || maritalStatus.equals("single")) {
                    employee.setMaritalStatus(maritalStatus);
                    break;
                } else {
                    System.out.println("Please enter 'married' or 'single'");
                }
            }

            if (employee.getMaritalStatus().equals("married")) {
                run1();
                System.out.println("Enter date of marriage (yyyy-MM-dd): ");
                while (true) {
                    try {
                        employee.setDateOfMarriage(validateAndParseDate(sc.next()));
                        break;
                    } catch (ParseException e) {
                        run1();
                        System.out.println("Please enter a valid date (yyyy-MM-dd)");
                    }
                }
            }
            employees.add(employee);
            run1();
            System.out.println("Do you wish to add more records? (yes/no): ");
            String ch = sc.next().toLowerCase();
            choice = ch.charAt(0);

            while (choice != 'y' && choice != 'n') {
                System.out.println("Please enter 'yes' (y) or 'no' (n).");
                ch = sc.next().toLowerCase();
                choice = ch.charAt(0);
            }
        }
    }
    

    public void displayData()
    {
        if (employees.isEmpty()) {
            run1();
            System.out.println("No employee records available.");
            return;
        }
        run1();
        System.out.println("Employee Details: ") ;
        for (Employee employee : employees){
            run1();
            System.out.println("Employee ID: " + employee.getId());
            run1();
            System.out.println("Surname: " + employee.getSurname());
            run1();
            System.out.println("Name: " + employee.getName());
            run1();
            System.out.println("Department: " + employee.getDepartment());
            run1();
            System.out.println("Designation: " + employee.getDesignation());
            run1();
            System.out.println("Date of Joining: " + employee.getDateOfJoining());
            run1();
            System.out.println("Date of Birth: " + employee.getDateOfBirth());
            run1();
            System.out.println("Marital Status: " + employee.getMaritalStatus());
            run1();
            if (employee.getMaritalStatus().equals("married")) {
                System.out.println("Date of Marriage: " + employee.getDateOfMarriage());
            }
            System.out.println();
        }
    }

    public void exitMenu() {
        exitRequested = true;
    }

    private String validateAndParseDate(String inputDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        Date parsedDate = sdf.parse(inputDate);
        return sdf.format(parsedDate);
    }

    public static void main(String[] args) throws Exception {
        Employee obj = new Employee() ;
        obj.run1();
        Employee run = new Employee();
        run.run();

    }
}