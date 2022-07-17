import java.util.ArrayList;
import java.util.Scanner;

/*
Implementing Recursion to Provide a Product

Using recursion, create a program that will allow a user to enter five numbers. 
The program will provide the product of all five numbers using recursive methods. 
 */



public class CSC372_CT5 {
    //Mainline logic
    public static void main(String[] args) {
        
        introduction();
        //General error catching for type mismatch
        try{
            
            System.out.println("The product of those numbers is: " + recursiveProductFinder(getInput(5)));
        
        }catch(Exception e){
            System.out.println("There was an input error: " + e);
        }
        
        conclusion();
    }

    //Intro
    public static void introduction(){
        System.out.println("Welcome to the Recursive Product Program!");
        System.out.println("Input 5 numbers and thier product will be calculated.\n");
    }

    //Collect Input - could be re-used for input multiples.
    //Returns and array of doubles given a size argument
    public static ArrayList<Double> getInput(int numInputs){
        
        ArrayList<Double> inputs = new ArrayList<Double>();
        Scanner scnr = new Scanner(System.in);
        double userInput;

        for(int i = 0; i < numInputs; i++){
            System.out.print("What is input #" + (i+1) + ": ");
            userInput = scnr.nextDouble();
            inputs.add(userInput);
        }
        scnr.close();
        return inputs;

    }

    //Recursive product function
    //Returns the first element and multiplies by the remaining first elements until only one remains
    public static double recursiveProductFinder(ArrayList<Double> inputList){
        double product;
        
        if(inputList.size() == 0){
            return 0;
        }
        if(inputList.size() == 1){
            product = inputList.get(0);
            return product;
        }else{
            product = inputList.get(0);
            inputList.remove(0);
            return product * recursiveProductFinder(inputList);
        }

    }
    
    //Outtro
    public static void conclusion(){
        System.out.println("\nGoodbye!");
    }

}
