package com.example.model;

import com.example.entity.Employee;

import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CustomerException extends Exception{

    public CustomerException(String str) {
        super();
        System.out.println(str);
        EmployeeManagement.operations();

    }
}

public class EmployeeManagement {

    public static Map<Integer, Employee> map = new HashMap<Integer, Employee>();

    public static void  addEmployee(String name, int age, int id)throws CustomerException{
        Employee emp = new Employee(name, age, id);
        map.put(id, emp);
        operations();
    }
    public static void deleteEmployee(int empId) throws CustomerException{
        if (map.containsKey(empId)) {
            map.remove(empId);
            System.out.println("Deleted");
        }else{
            throw new CustomerException("Employee not found");
        }
        operations();
    }
    public static void searchEmployee(int empId) throws CustomerException, NullPointerException{
        if (map.containsKey(empId)) {
            System.out.println("Emp details: " + map.get(empId));
        }else{
            throw new CustomerException("Employee not found");
        }
        operations();
    }
    public static void  getAllEmployee() throws NullPointerException {
        System.out.println(map.toString());
    }
    public static void operations(){
        System.out.println("Employee management system");
        System.out.println("1. Add ");
        System.out.println("2. Delete");
        System.out.println("3. Search");
        System.out.println("4. Get all");

        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        if (userInput == 1){
            System.out.println("Enter emp details(Name, age, id) ");
            Scanner scanner3 = new Scanner(System.in);
            String name = scanner3.nextLine();
            int age = scanner3.nextInt();
            int id = scanner3.nextInt();
            try{
                addEmployee(name, age, id);
            }catch (CustomerException e){
                System.out.println(e);
            }

        }else if(userInput ==2){
            System.out.println("Enter employee ID: ");
            Scanner scanner2 = new Scanner(System.in);
            int empId = scanner2.nextInt();
            try{
                deleteEmployee(empId);
            }catch(CustomerException e){
                System.out.println(e);
            }

        }else if(userInput == 3){
            System.out.println("Enter employee ID: ");
            Scanner scanner1 = new Scanner(System.in);
            int empId = scanner1.nextInt();
            try{
                searchEmployee(empId);
            }catch(CustomerException e){
                System.out.println(e);
            }

        }else if (userInput == 4){
            System.out.println("Here is the list of all the employee");

            try{
                getAllEmployee();
            }catch(NullPointerException e){
                System.out.println(e);
            }
        }

    }

    public static void main(String[] args) {
        operations();
    }
}