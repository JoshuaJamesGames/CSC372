//Extends BankAccount with added interest rate attribute
//Allows Overdraft for a $30.00 fee

public class CheckingAccount extends BankAccount{
    //Since a class could extend...protected instead of private
    protected double interestRate;

    //Parameterless Custructor calls the parent constructor
    public CheckingAccount(){
        super();
        interestRate = 0.0;
    }
    //Set Interest Rate
    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }
    //Get Interest Rate
    public double getInterestRate(){
        return interestRate;
    }
    //Allows overdraft withdrawal for $30.00 fee each time.
    public void processWithdrawal(double amount){
        //add a $30.00 fee and display a message
        if((balance - amount) >= 0){
            balance -= amount;
        }else{
            balance -= (amount + 30.00);
            
            System.out.println("\nA $30.00 fee has been accessed as an overdraft charge.");
            System.out.println("Your current balance is now: $" + balance);
            
        }
        
    }
    //Calls the parent (BankAccount) accountSummary() and extends it with Interest Rate
    public void displayAccount(){
        super.accountSummary();
        System.out.println("Interest Rate: " + interestRate +"%");
    }

}
