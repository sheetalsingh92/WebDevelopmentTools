/* NUID:001672346 
 @author Sheetal Singh
 */
package assign1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSYE6200Assign1 {

    char[] history = new char[100];
    int historyCounter = 0;
     String fullname="sheetalsingh";

    public static void main(String[] args) throws java.io.IOException {

        // Create an instance of the class, and call the constructor method
        CSYE6200Assign1 prog1 = new CSYE6200Assign1();
        prog1.run();
    }

    /* Constructor */
    public CSYE6200Assign1() {
        // After a 'new' call the constructor is executed first
    }

    public void run() throws java.io.IOException {
        char inChar;
        int sum = 0;
         /* loop to read keyboard input*/
        do {
          
            System.out.println("Enter choice (1,2,3), or \'q\' to quit, then press <enter>.");
            do {
                //read the keyboard input
                inChar = (char) System.in.read();

            } while (inChar == '\n'); // checks if enter is pressed
            // An array(history) to store the inputs and historycounter stores the count of inputs
            history[historyCounter] = inChar;
            historyCounter++;
            switch (inChar) {
                case '1':
                    /* This case basically print the numbers, cube of numbers and sum of all the cubes. */
                    for (int i = 1; i < 10; i++) {
                        System.out.println("The number is->" + i);
                        int cube = i * i * i;
                        System.out.println("Cube of numbers entered is->" + cube);
                        sum += cube;
                    }
                    System.out.println("Sum of cubes is->" + sum);
                    break;

                case '2':
                   /* This converts the input to integer and displays its value */
                    int a = Integer.parseInt(String.valueOf(inChar));
                    System.out.println("Integer value is->" + a);
                    break;
                case '3':
                   /*Print history of last three inputs.Display an asterik(*) for empty entries*/
                    int pass = (historyCounter >= 3)? historyCounter : 3;
                    System.out.print("Last three inputs are-> ");
                    for ( int i = pass - 3; i < pass; i++) {
                        if (history[i] == '\u0000') {
                            System.out.print("*");
                        } else {
                         System.out.print(history[i]);
                        }
                    }
                       
                    System.out.println("\n");
                    break;

                default:
                    System.out.println("Invalid selection->" + inChar);
                    break;
            }
            //check if password is matched
            if (isPassCodeTyped()) {
                System.out.println("The password matched");
            }

        } while (inChar != 'q'); // Exit on quit
        System.out.println("Quiting...");

    }

    private boolean isPassCodeTyped() {
      //store user inputs in string format 
     String b = new String(history, 0, historyCounter);
     
     //trim first character of firstname and three characters from last name.
     //passcode for Sheetal Singh is "ssin"
     String name_trim= (fullname.substring(0, 1))+(fullname.substring(7, fullname.length( ) - 2 ));  
     
     //if inputs matches with trimmed string,return true else return false.
        if (b.equals(name_trim)) {
            return true;
        }
      return false;
    }
}    


    
    
 