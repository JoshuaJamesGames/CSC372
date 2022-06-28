import javax.swing.JFrame;

public class CSC372_CT2 {

    public static void main(String[] args) {
    // Construct the JFrame object
    BankBalanceFrame appFrame = new BankBalanceFrame();    
      
    //Set window to use System default look and feel      
    JFrame.setDefaultLookAndFeelDecorated(true);

    // Set the program to exit when the user
    // closes the frame
    appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Not setting a Frame size because I am using pack() to auto-size.
    appFrame.pack();
      
    // Make the frame visible to the user
    appFrame.setVisible(true);
   }


}
    

