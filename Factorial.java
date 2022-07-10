public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    public static int factorial(int factor){

        if (factor <= 1){
            return 1;
        }else{
            return factor * factorial(factor -1);
        }        

    }
}
