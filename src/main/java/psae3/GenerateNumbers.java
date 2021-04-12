/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psae3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;

/**
 *
 * @author Julia Rzepka
 */
public class GenerateNumbers { //second class
    
    public GenerateNumbers() {}
    
    public void generate() throws IOException {
    
        try {
            FileWriter fw = new FileWriter("D:/Laboratory5/Task2/generated_numbers.csv",true);
            PrintWriter pw = new PrintWriter(fw);
            
            for (int i=0; i<10; i++){
                
                long min  = 1_000_000_000L;
                long max = 100_000_000_000L;
                ThreadLocalRandom random = ThreadLocalRandom.current();
                long random_number = random.nextLong(min,max);
                
                pw.println(random_number);
            }

        
            pw.flush();
            pw.close();
            
            JOptionPane.showMessageDialog(null,"Record saved");
            
        }
        catch (Exception E)
            {
            JOptionPane.showMessageDialog(null,"Record not saved");
            E.printStackTrace();
            } 
    }
}
