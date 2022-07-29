public class T {
    
    int rollno;
    String name;
    String address;

    T(int rollno, String name, String address){
        
        this.rollno = rollno;
        this.name = name;
        this.address = address;
        
    }

    @Override
    public String toString(){
        return ("Roll Number: " + rollno+ " Name: " + name + " Address: " + address);
    }

}