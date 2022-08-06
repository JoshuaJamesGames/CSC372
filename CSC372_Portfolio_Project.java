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

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CSC372_Portfolio_Project {

    public static void main(String[] args) {
        LinkedList<Vehicle> vehicleList = new LinkedList<Vehicle>();
        Vehicle[] vehicleArray;
        int numVehicles = 10;
        
        //Intro
        introduction(numVehicles);

        //Collect Input
        getVehicles(numVehicles, vehicleList);

        //Sort
        vehicleArray = vehicleList.toArray(new Vehicle[vehicleList.size()]);
        Arrays.sort(vehicleArray);
        vehicleList.clear();
        vehicleList.addAll(vehicleArray);

        //Output
        //Will also save to vehicles.txt
        System.out.println(vehicleList);
        saveVehicles(vehicleList);        

        //Conclusion
        conclusion();   
    }
    
    //Outputs an introduction
    static void introduction(int numVehicles){
        System.out.println("Welcome to the Vehicle Miles Per Gallon sorter!");
        System.out.println("Let's collect " + numVehicles + " vehicles from you.");
    }

    //Collects Input from user
    public static void getVehicles(int numVehicles, LinkedList<Vehicle> vehicleList){
        
        Scanner scnr = new Scanner(System.in);

        String makeInput;
        String modelInput;
        double mpgInput;

        int i = 0;

        while(i < numVehicles){

            System.out.print("\nWhat is the make of vehicle #" + (i+1) + ": ");
            makeInput = scnr.next();

            System.out.print("What model of " + makeInput + ": ");
            modelInput = scnr.next();

            System.out.print("What MPG does the " +makeInput + " " + modelInput +" get: ");
            
            //If there is an input mismatch, ie not a number for MPG - don't add the vehicle
            try{
                mpgInput = scnr.nextDouble();
                vehicleList.add(new Vehicle(makeInput, modelInput, mpgInput));
                i++;
            }catch(InputMismatchException e){
                System.out.println("\nNot a valid MPG: Use a number.");
                System.out.println("Vehicle not added");
                scnr.next();
            }
            
        }
        scnr.close();
    
    }

    //Save the vehicles to a text file named vehicles.txt
    //Using println because toString is handily overriden
    public static void saveVehicles(LinkedList<Vehicle> vehicleList){
        System.out.println("Saving to vehicles.txt");
        try {

            FileOutputStream fileStream = new FileOutputStream("vehicles.txt");
            PrintWriter outFS = new PrintWriter(fileStream);
        
            outFS.println(vehicleList);     

            outFS.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void conclusion(){
        System.out.println("\nGoodbye!");
    }

}
