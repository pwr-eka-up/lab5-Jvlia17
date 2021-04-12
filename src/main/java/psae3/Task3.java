/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psae3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
/**
 *
 * @author Julia Rzepka
 */
public class Task3 { //third task include file statistics
    public static void main (String[] args) throws IOException
    {
      Statistics file=new Statistics();
      file.loadFile();
      
      ArrayList<Map.Entry<String, Integer>> listValue = file.makeAList();

      Statistics.saveToCsv(listValue);
    }
}
