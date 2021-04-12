/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psae3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Julia Rzepka
 */
public class Person {
    private String name;
    private String surname;
    private int age;
    private int salary;
    
    public Person() throws FileNotFoundException{  //default constructor
        this.name=text_name();
        this.salary=rand_salary();
        this.surname=text_surname();
        this.age=rand_age();
    }
    
    public int getAge() { //getter
    return age;
    }
    
    public int getSalary() { //getter
        return salary;
    }
    
    public String getName() { //getter
        return name;
    }
    
    public String getSurname() { //getter
        return surname;
    }
    
    public void setAge(int ageParameter) { //setter  
        age = ageParameter;
    }
    
    public void setSalary(int salaryParameter) { //setter  
        salary = salaryParameter;
    }
    
    public void setName(String nameParameter) { //setter  
        name = nameParameter;
    }
    
    public void setSurname(String surnameParameter) { //setter  
        surname = surnameParameter;
    }
        
    public static int rand_age() {
        int random_age = (int) (Math.random() * 100) + 1;
        return random_age;
    }
    
    public static int rand_salary() {
        int random_salary = (int) (Math.random() * 5000);
        return random_salary;
    }

    public static String text_name() throws FileNotFoundException
    {
        Random random1 = new Random();
        int random_number = random1.nextInt(19);
        Scanner s = new Scanner(new File("first names.txt"));
        ArrayList<String> names = new ArrayList<String>();
        while (s.hasNext()){
            names.add(s.next());
        }
    s.close();
    return names.get(random_number);
    }
    
    public static String text_surname() throws FileNotFoundException
    {
        Random random1 = new Random();
        int random_number = random1.nextInt(19);
        Scanner s = new Scanner(new File("second names.txt"));
        ArrayList<String> surnames = new ArrayList<String>();
        
        while (s.hasNext()){
            surnames.add(s.next());
        }
    s.close();
    return surnames.get(random_number);
    }
}
