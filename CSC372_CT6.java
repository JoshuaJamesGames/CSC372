import java.util.ArrayList;

/*

Create a Java program that will store 10 student objects in an ArrayList, ArrayList<Student>. 
A student object consists of the following fields:

int rollno
String name
String address

Implement a comparator class to sort student objects by rollno (roll number). 
Implement your own merge sort method and place your code in a separate Java source file. 
Do not use a sort method from the Java collections library.

*/


public class CSC372_CT6 {
    public static void main(String[] args) {
        ArrayList<T> studentList = new ArrayList<T>();
        ArrayList<T> printList = new ArrayList<T>();
        
        //Intro
        introduction();

        //Create 10 students
        studentList.addAll(makeStudentList());
        printList.addAll(makeStudentList());

        //Print the list in original order
        System.out.println("Printing in Original order.\n");
        printStudents(printList);
        
        //Sort by rollno
        printList.clear();        
        printList.addAll(MergeSort.sort(studentList, new MergeSort.Sortbyroll()));
        
        //Print the list in rollno order
        System.out.println("\nPrinting in Roll Number order.\n");
        printStudents(printList);

        //Sort by name
        printList.clear();
        printList.addAll(MergeSort.sort(studentList, new MergeSort.Sortbyname()));

        //Print the list in name order
        System.out.println("\nPrinting in Name order.\n");
        printStudents(printList);

        //Conclusion
        conclusion();
    }
    
    //Intro
    public static void introduction(){
        System.out.println("Welcome to a Sorting sampler!");
        System.out.println("We will store 10 students to an Arraylist.");
        System.out.println("Then print them in order based on different attributes.\n");
    }

    //create ArrayList of Students
    public static ArrayList<T> makeStudentList(){
        ArrayList<T> studentList = new ArrayList<T>();

        studentList.add(new T(2, "Joshua", "Aurora"));
        studentList.add(new T(1, "Douglas", "Bulawayo"));
        studentList.add(new T(4, "Kianna", "Burnsville"));
        studentList.add(new T(7, "Kelsey", "Colorado Springs"));
        studentList.add(new T(6, "Kyle", "Colorado Springs"));
        studentList.add(new T(10, "Taylor", "Colorado Springs"));
        studentList.add(new T(5, "Rehema", "Houston"));
        studentList.add(new T(9, "Caleb", "Oklahoma City"));
        studentList.add(new T(3, "Jennifer", "Rhode Island"));
        studentList.add(new T(8, "Mickayla", "Salisbury"));        

        return studentList;
    }
    
    //Print Students
    public static void printStudents(ArrayList<T> studentList){
        studentList.forEach((student) -> System.out.println(student));
    }

    //Conclusion
    public static void conclusion(){
        System.out.println("\nGoodbye!");
    }

}
