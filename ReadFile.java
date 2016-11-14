/* CLASS:  ReadFile 
 * AUTHOR: Jonah
 * DESCRIPTION:  Reads the file of names and saves to an array
 ******************************************************************************/

package sortname;
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ReadFile {
        static String DELETE = "~~~";
        static int DELETE_START = 101;
    public static void readFile() throws IOException {
        File inFile = new File("name.csv");
        Scanner fileScan = new Scanner(inFile);
        final int ARRAY_SIZE = 100;
        
        String[] nameArray = new String[ARRAY_SIZE];
        String[] pagerArray = new String[ARRAY_SIZE];
        String[] shiftArray = new String[ARRAY_SIZE];
        String[] tempArray;
        
        int count = 0;
        
        while(fileScan.hasNext()){
            String tempLine = fileScan.nextLine();
            tempArray = tempLine.split(",");
            nameArray[count] = uppercaseName(tempArray[0]);
            pagerArray[count] = tempArray[1];
            shiftArray[count] = tempArray[2].toUpperCase();
            count++;
            
        }
        count = addToArray(nameArray, pagerArray, shiftArray, count);
        deleteArray(nameArray, pagerArray, shiftArray, count);
        
        ShiftArray object = new ShiftArray(nameArray, pagerArray, shiftArray, count);
        
        
        fileScan.close();
    }
    
    public static String uppercaseName(String name){
        char firstLetter = name.charAt(0);
        String tempString ="" + firstLetter;
        tempString = tempString.toUpperCase();
        char tempChar;
        
        String restName = "";
        for(int i = 1; i < name.length(); i++)
        {
            tempChar = name.charAt(i);
            restName = restName + tempChar;
        }
        String uppercaseName = tempString + restName;
        return uppercaseName;
    }
    
    public static int addToArray(String[] nameArray, String[] pagerArray, String[] shiftArray, int count){
        int choice = JOptionPane.showConfirmDialog(  
                null,
                "Would you like to add someone?" ,
                "",
                JOptionPane.YES_NO_OPTION);
        String jOption;
        if(choice == JOptionPane.YES_OPTION){
            do{
            nameArray[count] = addName();
            pagerArray[count] = addPager();
            shiftArray[count] = addShift();
            jOption = JOptionPane.showInputDialog("Would you like to add another?\n" +
                    "Enter -1 to stop");
            count++;
            }while(jOption.compareTo("-1") != 0);
        }
        return count;
    }
    
    public static String addName(){
        String input = JOptionPane.showInputDialog("Enter the name");
        
        String testInput = input.replaceAll("[0-9]", "~");
        while(testInput.compareTo(input) != 0)
        {
            input = JOptionPane.showInputDialog("Invalid name. \n" +
                    "Enter only letters.");
            testInput = input.replaceAll("[0-9]", "~");
        }
        input = uppercaseName(input);
        return input;
    }
    
    public static String addPager(){
        String input = JOptionPane.showInputDialog("Enter the pager number");
        
        String testInput = input.replaceAll("[^0-9]", "~");
        while(testInput.compareTo(input) != 0)
        {
            input = JOptionPane.showInputDialog("Invalid pager number. \n" +
                    "Enter only numbers.");
            testInput = input.replaceAll("[^0-9]", "~");
        }
        input = uppercaseName(input);
        return input;
    }
    
    public static String addShift(){
        String input = JOptionPane.showInputDialog("Enter the shift");
        
        String testInput = input.replaceAll("[0-9]", "~");
        while(testInput.compareTo(input) != 0)
        {
            input = JOptionPane.showInputDialog("Invalid shift. \n" +
                    "Enter only a letter.");
            testInput = input.replaceAll("[0-9]", "~");
        }
        input = uppercaseName(input);
        return input;
    }
    
    public static void deleteArray(String[] nameArray, String[] pagerArray, String[] shiftArray, int count){
        String arrayString = arrayString(nameArray, count);
        int delete = DELETE_START;
        int intChoice =  JOptionPane.showConfirmDialog(  
                null,
                "Would you like to delete someone?" ,
                "",
                JOptionPane.YES_NO_OPTION);
        if(intChoice == JOptionPane.YES_OPTION){
            String choice = JOptionPane.showInputDialog("Enter the number.\n" +
                    arrayString);
            delete = Integer.parseInt(choice) - 1;
            shiftArray[delete] = DELETE;
        }
        
        
        }
    
    
    public static String arrayString(String[] nameArray, int count){
        String arrayString = "";
        for(int i = 0; i < count; i++)
        {
            arrayString = arrayString + (i+1) + ": " + nameArray[i] + "\n";
                
        }
        return arrayString;
    }
    
    
}
