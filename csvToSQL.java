
/**
 * Class reads a csv file, parses the data, and transfers data to a bad file or sqlite
 *
 * @author Morgan Hunnell
 * @version 09/01/2020
 */

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.io.*;
import java.util.ArrayList;
import java.lang.ArrayIndexOutOfBoundsException;

public class csvToSQL{
    /*
     * Main method creates class object and calls two methods
     */
    public static void main (String[] args) throws java.sql.SQLException, FileNotFoundException, 
    java.io.IOException{
      
        
           
            csvToSQL parser = new csvToSQL();
            parser.separator("C:\\ms3Interview.csv");
            parser.counter();
        
    }
    
     /*
      * Method creates array of csv and splits the data line by line
      */
    private ArrayList<String> separator(String toSplit){
        ArrayList<String> back = new ArrayList<>();
        int i = 0;
        ArrayList<Character> word = new ArrayList<>();
        boolean currentCustomer = false;
        while( i < toSplit.length()){
            if(toSplit.charAt(i) == ','){
                if(currentCustomer == true){
                    word.add(toSplit.charAt(i));
                }
                else if(currentCustomer == false){
                    String addIt = " ";
                    for (char c : word){
                        addIt = addIt + c;
                    }
                    back.add(addIt);
                    word = new ArrayList<>();
                }
            }
            else if(toSplit.charAt(i)=='\"'){
                currentCustomer=!currentCustomer;
                word.add(toSplit.charAt(i));
            }
            else{
                word.add(toSplit.charAt(i));
            }
            i = i + 1;
            if(i==toSplit.length()){
                String addIt = " ";
                for(char c: word){
                    addIt = addIt + c;
                }
                back.add(addIt);
                word = new ArrayList<>();
            }
        }
        return back;
    }
    
    /*
     * Method reads through csv, converts into sqlite, and divides each row into three categories
     */
    public void counter() throws FileNotFoundException, java.sql.SQLException,IOException{

        Scanner s = new Scanner(new File("C:\\ms3Interview.csv"));
        String column = s.next();
        s.useDelimiter(",");
        int recordsReceived = 0;
        int recordsSuccessful = 0;
        int recordsFailed = 0;
        ArrayList <String> Small = this.separator(column);
        int numColumns = Small.size();
        String sqlLite = "jdbc:sqlite::memory:";
        Connection connection = DriverManager.getConnection(sqlLite);
        boolean entryValid = true;
        try{

            if(entryValid == true){
                connection.createStatement().execute("create table customer(A,B,C,D,E,F,G,H,I,J)");  
            }

            ResultSet rs = connection.createStatement().executeQuery("select * from customer");

            while(rs.next()) {
                String A = rs.getString(1);
                String B = rs.getString(2);
                String C = rs.getString(3);
                String D = rs.getString(4);
                String E = rs.getString(5);
                String F = rs.getString(6);
                String G = rs.getString(7);
                String H = rs.getString(8);
                String I = rs.getString(9);
                String J = rs.getString(10);

            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }

        while(s.next()){

            if(column.length() > 0){
                recordsReceived = recordsReceived + 1;
            }
            ArrayList<String> splitLine = this.separator(column);
            boolean valid=true;
            for(String elem : splitLine){
                if(elem.equals(" ")){
                    recordsFailed = recordsFailed + 1;
                } else{
                    recordsSuccessful = recordsSuccessful + 1;
                }

            }
        }

        System.out.println("Records received:" + recordsReceived);
        System.out.println("Records accepted:" + recordsSuccessful);
        System.out.println("Records failed:" + recordsFailed);

        s.close();
    }
    
}
