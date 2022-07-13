import java.util.ArrayList;
import java.util.Scanner;

/*
Implementing Recursion to Provide a Product

Using recursion, create a program that will allow a user to enter five numbers. 
The program will provide the product of all five numbers using recursive methods. 
 */



public class CSC372_CT5 {
    public static void main(String[] args) {
        
    }

    //Intro
    public void introduction(){

    }

    //Collect Input
    public ArrayList<Double> getInput(int numInputs){
        
        ArrayList<Double> inputs = new ArrayList<Double>();
        Scanner scnr = new Scanner(System.in);
        double userInput;

        for(int i = 0; i < numInputs; i++){
            System.out.println("What is input #" + (i+1) + ": ");
            userInput = scnr.nextDouble();
            inputs.add(userInput);
        }
        scnr.close();
        return inputs;

    }

    //Recursive product function
    public double recursiveProductFinder(ArrayList<Double> inputList){
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
    public void conclusion(){

    }

}
