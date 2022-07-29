import java.util.Comparator;

public class Student {
    
    int rollno;
    String name;
    String address;

    Student(int rollno, String name, String address){
        
        this.rollno = rollno;
        this.name = name;
        this.address = address;
        
    }

    @Override
    public String toString(){
        return ("Roll Number: " + rollno+ " Name: " + name + " Address: " + address);
    }

    //Comparator interface for sorting by roll number
    static class Sortbyroll implements Comparator<Student> {
 
        //Sort in ascending order of roll number
        public int compare(Student a, Student b){
 
            return a.rollno - b.rollno;
        }
    }
 
    
    //Comparator interface for sorting by name
    static class Sortbyname implements Comparator<Student>{
    
        //Sort in ascending order of name
        public int compare(Student a, Student b){
    
            return a.name.compareTo(b.name);
        }
    }

}