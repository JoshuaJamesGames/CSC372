/*
Vehicle Class

String make
String model
double miles per gallon

Override toString for easy printing
Include Comparators for sorting
*/

public class Vehicle implements Comparable<Vehicle>{

    private String make;
    private String model;
    private double milesPerGallon;

    Vehicle(String make, String model, double milesPerGallon){

        this.make = make;
        this.model = model;
        this.milesPerGallon = milesPerGallon;

    }

    @Override
    public String toString(){
        return String.format("A %s %s gets %.02f miles per gallon.", make, model, milesPerGallon);
    }

    @Override
    public int compareTo(Vehicle vehicle){
        
        if (this.milesPerGallon - vehicle.milesPerGallon < 0){
            return -1;
        }else if(this.milesPerGallon - vehicle.milesPerGallon > 0){
            return 1;
        }else{
            return 0;
        }
        
    }
   
}
