/*
Option #1:  Implementing a Superclass Bank Account
Part 1: Implement a superclass BankAccount that has the following fields and 
methods.

Fields:

string firstName
string lastName
int accountID
double balance
Methods:  

constructor():  initialize balance to zero

deposit() - will accept a single value double parameter; the parameter value 
is added to the existing balance 

withdrawal() - accepts a single value double dollar amount; 
the parameter value is subtracted from the existing balance

Setters and getters for firstName, lastName, and accountID 

getBalance() getter to return the balance 
accountSummary() - prints all account information

Part 2: Implement a CheckingAccount class that inherits from the BankAccount 
class, that: 

Has an interest rate attribute
Allows overdraft withdrawals and charges a $30 fee
Methods:

processWithdrawal() - will display a negative balance that includes a $30 
overdraft fee and denotes that a fee has been accessed

displayAccount() - should display all superclass attributes and provides an 
additional interest rate 

Ensure that your program has the two required classes and a test class.

Place each Java class into a separate Java source file.
*/

//Testing class
public class CSC372_CT1 {
    public static void main(String[] args) {
        //Create a new CheckingAccount which extends BankAccount
        CheckingAccount testAccount = new CheckingAccount();

        //Print unset testAccount - should have only a 0 balance and default values
        testAccount.accountSummary();

        //Set attributes using appropriate methods
        testAccount.setFirstName("John");
        testAccount.setLastName("Doe");
        testAccount.setAccountID(123456789);
        
        //deposit $300.00
        testAccount.deposit(300.00);
        //Set interest rate (Only possible in a CheckingAccount)
        testAccount.setInterestRate(3.0);

        //Print testAccount after attributes are set
        testAccount.displayAccount();

        //Test Deposit
        testAccount.deposit(50.00);
        //Test Withdrawal
        testAccount.withdrawal(250.00);

        //display testAccount to see change in balance
        testAccount.displayAccount();

        //Try to withdraw using BankAccount.withdrawal() should fail
        testAccount.withdrawal(101.00);

        //Verify withdrawal() failure no overdraft allowed
        testAccount.accountSummary();

        //Use CheckingAccount.processWithdrawal() will succeed and display a message 
        testAccount.processWithdrawal(101.00);

        //Verify changes
        testAccount.displayAccount();





    }
    


}
