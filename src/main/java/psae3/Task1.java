/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psae3;

import java.io.IOException;

/**
 *
 * @author Julia Rzepka
 */
public class Task1 { //first task include files filedatagenerator and processingdata
    
    public static void main(String[] args) throws IOException {
        
        FileDataGenerator generator1 = new FileDataGenerator();
        generator1.saveToFile();
        
        ProcessingData data1 = new ProcessingData();
        data1.loadData();
        data1.theOldest();
        data1.averageSalary();
    }
}
