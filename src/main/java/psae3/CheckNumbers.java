/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psae3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Julia Rzepka
 */
public class CheckNumbers { //third class
    
    private long tab[] = new long[10];
    
    public CheckNumbers() {}
    
    public void generate() throws IOException { //generate numbers to csv file
    GenerateNumbers generate_numbers = new GenerateNumbers();
    generate_numbers.generate();
    } 
    
    public void load() throws IOException { //load numbers to the table
                
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader("D:/Laboratory5/Task2/generated_numbers.csv"));
            for (int i = 0; i < 10; i++) {
            tab[i] = Long.parseLong(fileReader.readLine());
            }
        } catch (Exception E){}
        finally {
        if (fileReader != null) {
            fileReader.close();
        }   
        }  
    } 
    
    
    public void check() throws IOException { //check and add prime numbers to the new table
        
        CheckIfPrime checking = new CheckIfPrime();
        
            try {
                FileWriter fw = new FileWriter("D:/Laboratory5/Task2/prime.csv",true);
                PrintWriter pw = new PrintWriter(fw);
            
                for (int i=0; i<10; i++){
                    if (checking.prime(tab[i])==true)
                    pw.println(tab[i]);
                }

            pw.flush();
            pw.close();
            
            JOptionPane.showMessageDialog(null,"Record saved");
            
            }
        catch (Exception E){
            JOptionPane.showMessageDialog(null,"Record not saved");
        } 
    }
}
        
