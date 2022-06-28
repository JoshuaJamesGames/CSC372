//

public class BankAccount {
    protected String firstName;
    protected String lastName;
    protected int accountID;
    protected double balance;

    public BankAccount(){
        balance = 0;
    }
    //Adds to balance
    public void deposit(double amount){
        balance += amount;        
    }
    // This should be overridden by CheckingAccount so it does not have 2 withdrawal methods
    //Since CheckingAccount does allow overdraft, I am not allowing BankAccount to overdraw
    public void withdrawal(double amount){
        if((balance - amount) >= 0){
            balance -= amount;            
        }else{
            System.out.println("\nYou can only withdraw the remaining $" + balance);
        }
        
    }
    //Get Balance
    public double getBalance(){
        return balance;
    }
    //Prints BankAccount info
    public void accountSummary(){
        System.out.printf("\nAccount Holder : %s %s\nAccount ID: %d\nAvailable balance: $%.2f\n",firstName, lastName, accountID, balance);
    }
    //Set First Name
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    //Set Last Name
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    //Set Account ID
    public void setAccountID(int accountID){
        this.accountID = accountID;
    }
    //Get First Name
    public String getFirstName(){
        return firstName;
    }
    //Get Last Name
    public String getLastName(){
        return lastName;
    }
    //Get Account ID
    public int getAccountID(){
        return accountID;
    }
}
