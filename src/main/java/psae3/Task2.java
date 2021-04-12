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
public class Task2 { //second task include files checknumbers checkifprime and gerenatenumbers
    public static void main(String[] args) throws IOException {
        
    CheckNumbers check_numbers = new CheckNumbers();
    check_numbers.generate();
    check_numbers.load();
    check_numbers.check();
    }
}
