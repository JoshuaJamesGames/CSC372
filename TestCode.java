import java.util.Scanner;

public class TestCode {
   
    static int count;
    static int fact;

    public static void getFactorial(int fact)
    {
        if (count <= 1)
        {
            return;
        }
        count--;
        fact = fact * (count);
        System.out.println(fact);
        getFactorial(fact);
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);


        fact = scnr.nextInt();
        count = fact;

        getFactorial(fact);
        System.out.println(fact);
    }
    
}

