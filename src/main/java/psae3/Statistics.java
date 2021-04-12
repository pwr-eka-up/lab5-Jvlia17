/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psae3;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Julia Rzepka
 */
public class Statistics {
    
    private ArrayList<String> listOfWords;
    
    public Statistics() 
    {this.listOfWords=new ArrayList<>();}
    
    public void loadFile()
    {
        String[] pathnames; // Creates an array in which we will store the names of files and directories
        File f = new File("D:/Laboratory5/Task3/1000 Novels Corpus");
        pathnames = f.list();
        
        Scanner sc=new Scanner(System.in);
        String word;
        //for (String pathname : pathnames) { //i wanted to read through all files in this directory, but unfortunetely - some memory error occured
        try (BufferedReader br = new BufferedReader(new FileReader("D:/Laboratory5/Task3/1000 Novels Corpus/amicis_serce_1994.txt"))) {
            while ((word=br.readLine()) != null) {
                String[] tab = word.split("[\\s+,-.;:!?()*]");
                for (int a=0; a<tab.length; a++)
                    if(tab[a]!=" ") {
                        tab[a]=tab[a].toLowerCase(Locale.ROOT);
                        this.listOfWords.add(tab[a]);
                    }
            }
            System.out.println("File load succesfully");
        }
        
        catch (IOException e) {
            System.out.println("File load failed");
            e.printStackTrace();
        }
    //}
    }
    
    public TreeSet<String> createSetOfWords()
    {
        TreeSet<String> setOfWords=new TreeSet<String>();
        setOfWords.addAll(listOfWords);
        return setOfWords;
    }
    
    public HashMap<String, Integer> makeAMap()
    {
        HashMap<String, Integer> wordMap=new HashMap();
        TreeSet<String> setOfWords= this.createSetOfWords();
        for (String x:setOfWords)
        {
            int counter=0;
            for (String y:listOfWords)
                if (x.equals(y))
                    counter++;
            wordMap.put(x, counter);
        }
        return wordMap;
    }
    
    public ArrayList<Map.Entry<String, Integer>> makeAList()
    {
        HashMap<String, Integer> mapOfWords=this.makeAMap();
        ArrayList<Map.Entry<String, Integer>> listValue = new ArrayList<>();
        listValue.addAll(mapOfWords.entrySet());

        return listValue;
    }
    
    public static void saveToCsv(ArrayList<Map.Entry<String, Integer>> lista) throws IOException {
        
        try {
            PrintWriter pw = new PrintWriter("D:/Laboratory5/Task3/words.csv");
            StringBuilder sb = new StringBuilder();;
            
            sb.append("word");
            sb.append(";");
            sb.append("file1");
            sb.append("\r\n");
                
            for (Map.Entry<String, Integer> x: lista){
                sb.append(x.getKey().toString());
                sb.append(";");
                sb.append(x.getValue().toString());
                sb.append("\r\n");
            }
                    
            pw.write(sb.toString());
            pw.close();
            
            JOptionPane.showMessageDialog(null,"Record saved");
            
        }
        catch (Exception E){
            JOptionPane.showMessageDialog(null,"Record not saved");
            E.printStackTrace();
        } 
    }  
}
