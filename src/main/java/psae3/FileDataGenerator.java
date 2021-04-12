/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psae3;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
        
/**
 *
 * @author Julia Rzepka
 */
public class FileDataGenerator{
    
    public FileDataGenerator() throws IOException{
        Files.createDirectory(Paths.get("D:/Laboratory5/Task1"));
        for (int i = 0; i < 5; i++) {
            Files.createFile(Paths.get("D:/Laboratory5/Task1/plik"+i+".txt"));
        }
    }
       
    public void saveToFile() throws FileNotFoundException, IOException {
        for (int i = 0; i < 5; i++) {
            String filePath = ("D:/Laboratory5/Task1/plik"+i+".txt");
            BufferedWriter outputStream = null;

            Person person1=new Person();
            Person person2=new Person();
            Person person3=new Person();
            Person person4=new Person();
            Person person5=new Person();
            
            try {
                outputStream = new BufferedWriter(new FileWriter(filePath));
                outputStream.write(person1.getName()+" "+person1.getSurname()+ " "+person1.getAge()+" "+person1.getSalary()+"\n");
                outputStream.write(person2.getName()+" "+person2.getSurname()+ " "+person2.getAge()+" "+person2.getSalary()+"\n");
                outputStream.write(person3.getName()+" "+person3.getSurname()+ " "+person3.getAge()+" "+person3.getSalary()+"\n");
                outputStream.write(person4.getName()+" "+person4.getSurname()+ " "+person4.getAge()+" "+person4.getSalary()+"\n");
                outputStream.write(person5.getName()+" "+person5.getSurname()+ " "+person5.getAge()+" "+person5.getSalary());
            } finally {
                if (outputStream != null) {
                  outputStream.close();
                }
            }
        }      
    } 
}
