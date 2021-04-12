/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psae3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
/**
 *
 * @author Julia Rzepka
 */

public class ProcessingData { 
    private final String filePath;
    private String tab[][][] = new String[5][25][4];
    
      public ProcessingData() {
        this.filePath=("D:/Laboratory5/Task1");
      }
      
    public void loadData() throws IOException {
        
    String parts[];
    BufferedReader fileReader = null;
    for (int j = 0; j < 5; j++){
        for (int i = 0; i < 5; i++) {
            try {
            fileReader = new BufferedReader(new FileReader(filePath+"/plik"+j+".txt"));
            String numberAsString = fileReader.readLine();
        
            parts = numberAsString.split(" ");
            tab[j][i][0] = parts[0]; //name
            tab[j][i][1] = parts[1]; //surname
            tab[j][i][2] = parts[2]; //age
            tab[j][i][3] = parts[3]; //salary
        
        } catch (Exception E){}
        finally {
            if (fileReader != null) {
                fileReader.close();}
        }
        }
    }
    }
    
    public void theOldest() {
        
        int old = 0;
        int ifinal = 0; //for looking for the oldest in each file
        int jfinal = 0; //for looking for the oldest among all file
        
        try {
            PrintWriter pw = new PrintWriter(filePath+"/theoldest.csv");
            StringBuilder sb = new StringBuilder();
            
            sb.append("FileName");
            sb.append(";");
            sb.append("Name");
            sb.append(";");
            sb.append("Surname");
            sb.append(";");
            sb.append("Age");
            sb.append(";");
            sb.append("Salary");
            sb.append("\r\n");
            
            for (int j=0; j<5; j++) {
                for (int i = 0; i < 5; i++) {
                    int age = Integer.parseInt(tab[j][i][2]);
                    if (age>old){
                        old = age;
                        ifinal = i;}
                if (age>Integer.parseInt(tab[jfinal][ifinal][2]))
                    jfinal = j;
                }
            
            sb.append("file"+j+".txt");
            sb.append(";");
            sb.append(tab[j][ifinal][0]);
            sb.append(";");
            sb.append(tab[j][ifinal][1]);
            sb.append(";");
            sb.append(tab[j][ifinal][2]);
            sb.append(";");
            sb.append(tab[j][ifinal][3]);
            sb.append("\r\n");
            old = 0;
            }
             
        sb.append("\n");
        sb.append("The oldest:");
        sb.append(";");
        sb.append(tab[jfinal][ifinal][0]);
        sb.append(";");
        sb.append(tab[jfinal][ifinal][1]);
        sb.append(";");
        sb.append(tab[jfinal][ifinal][2]);
        sb.append(";");
        sb.append(tab[jfinal][ifinal][3]);
        sb.append("\r\n");
        old = 0;
        
        pw.write(sb.toString());
        pw.close();
            
        JOptionPane.showMessageDialog(null,"Record saved");
            
        }
        catch (Exception E)
        {
            JOptionPane.showMessageDialog(null,"Record not saved");
        } 
    }
    
    public void averageSalary() {
        
        double one_file_salary = 0; 
        double final_salary = 0;
        int counter1= 0;
        int counter2= 0;
        
        try {
            PrintWriter pw = new PrintWriter(filePath+"/averagesalary.csv");
            StringBuilder sb = new StringBuilder();
            
            sb.append("FileName");
            sb.append(";");
            sb.append("Average Salary");
            sb.append("\r\n");
            
            for (int j=0; j<5; j++) {
                for (int i = 0; i < 5; i++) {
                    int salary = Integer.parseInt(tab[j][i][3]);
                    one_file_salary = one_file_salary+salary;
                    counter1++;
                    counter2++;
                    final_salary = final_salary+salary;
                }
                
            sb.append("file"+j+"");
            sb.append(";");
            sb.append(one_file_salary/counter1);
            sb.append("\r\n");
                
            one_file_salary = 0;
            counter1 = 0;
            }
        
            sb.append("Average from all files: ");
            sb.append(";");
            sb.append(final_salary/counter2);
            sb.append("\r\n");
            
            pw.write(sb.toString());
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
