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
        ArrayList<Student> studentList = new ArrayList<Student>();
        ArrayList<Student> printList = new ArrayList<Student>();
        
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
    public static ArrayList<Student> makeStudentList(){
        ArrayList<Student> studentList = new ArrayList<Student>();

        studentList.add(new Student(2, "Joshua", "Aurora"));
        studentList.add(new Student(1, "Douglas", "Bulawayo"));
        studentList.add(new Student(4, "Kianna", "Burnsville"));
        studentList.add(new Student(7, "Kelsey", "Colorado Springs"));
        studentList.add(new Student(6, "Kyle", "Colorado Springs"));
        studentList.add(new Student(10, "Taylor", "Colorado Springs"));
        studentList.add(new Student(5, "Rehema", "Houston"));
        studentList.add(new Student(9, "Caleb", "Oklahoma City"));
        studentList.add(new Student(3, "Jennifer", "Rhode Island"));
        studentList.add(new Student(8, "Mickayla", "Salisbury"));        

        return studentList;
    }
    
    //Print Students
    public static void printStudents(ArrayList<Student> studentList){
        studentList.forEach((student) -> System.out.println(student));
    }

    //Conclusion
    public static void conclusion(){
        System.out.println("\nGoodbye!");
    }

}
