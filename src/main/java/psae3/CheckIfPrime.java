/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psae3;

import static java.lang.Math.sqrt;

/**
 *
 * @author Julia Rzepka
 */
public class CheckIfPrime { //first class
 
    public CheckIfPrime() {}
    
    static boolean prime(long value){
        
        if (value <= 1)
            return false;

        for (int j=2; j<=sqrt(value); j++)
            if (value % j==0)
                return false;
  
        return true;
    }    
}
