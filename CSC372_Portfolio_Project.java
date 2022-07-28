import java.util.Scanner;

/*
Write a Java program that incorporates a loop that prompts a user for vehicle data. 
Vehicle data are private fields in a Vehicle class that include:

String make
String model
double miles per gallon

Each vehicle object is stored in a linked list.

After the user completes the data entry, output the contents of the linked list 
in ascending sorted order by miles-per-gallon to a text file that can be opened 
and viewed using a simple plain-text editor such as notepad.

Validate numeric data for miles-per-gallon.
*/

public class CSC372_Portfolio_Project {

    public static void main(String[] args) {
        //Intro
        introduction();

        //Collect Input

        //Sort

        //Output

        //Conclusion   
    }
    

    static void introduction(){
        System.out.println("Welcome to the Vehicle Miles Per Gallon sorter!");
        System.out.println("Let's collect 10 vehicles from you.");
    }

    public static void getVehicles(int numVehicles, LinkedList<Vehicle> vehicleList){
        
        Scanner scnr = new Scanner(System.in);

        String makeInput;
        String modelInput;
        double mpgInput;

        for(int i = 0; i < numVehicles; i++){

            System.out.print("What is the make of vehicle #" + (i+1) + ": ");
            makeInput = scnr.next();

            System.out.print("What is the model of the" + makeInput + ": ");
            modelInput = scnr.next();

            System.out.print("What is the MPG of the " +makeInput + " " + modelInput +": ");
            mpgInput = scnr.nextDouble();

            vehicleList.add(new Vehicle(makeInput, modelInput, mpgInput));
        }
        scnr.close();
    
    }

}
