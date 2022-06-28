import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;


public class BankBalanceFrame extends JFrame implements ActionListener{
    private JFormattedTextField amountField;
    private JTextField remainingField;
    private JLabel amountLabel, depositLabel, withdrawLabel, balanceLabel, transactionsLabel;
    private JButton depositButton, withdrawButton;
    private JPanel wholePanel, controlPanel, feedBackPanel;
    private JScrollPane transactionPane;
    private JTextArea transactionArea; 


    BankBalanceFrame(){

        setTitle("Bank Balance Application");

        //Set Labels
        amountLabel = new JLabel("Enter Amount");
        depositLabel = new JLabel("Deposit");
        withdrawLabel = new JLabel("Withdraw");
        balanceLabel = new JLabel("Balance Remaining");
        transactionsLabel = new JLabel("Transactions");

        //Set Buttons
        depositButton = new JButton("Save it!");
        depositButton.addActionListener(this);

        withdrawButton = new JButton("Spend it!");
        withdrawButton.addActionListener(this);

        //Set layout manager and constraints
        GridBagLayout gridBLayout = new GridBagLayout();
        GridBagConstraints constraints;

        //Set Panels - using GridBagLayout
        wholePanel = new JPanel();        
        wholePanel.setLayout(gridBLayout);

        controlPanel = new JPanel();
        controlPanel.setLayout(gridBLayout);

        feedBackPanel = new JPanel();
        feedBackPanel.setLayout(gridBLayout);

        

        //Set textFields
        amountField = new JFormattedTextField(NumberFormat.getNumberInstance());
        //Initial value of 0 since we are using NumberFormat
        amountField.setValue(Double.valueOf("0.00"));
        amountField.setColumns(10);
        
        //Initial value of 0.00
        remainingField = new JTextField("0.00");
        remainingField.setColumns(10);
        remainingField.setEditable(false);

        //Set transactionArea
        transactionArea = new JTextArea("History\n",5, 30);
        transactionArea.setVisible(true);
        transactionArea.setLineWrap(true);
        transactionArea.setEditable(false);
        transactionPane = new JScrollPane(transactionArea);
        transactionPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //Assemble
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(10,10,10,0);
        controlPanel.add(amountLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,0,10,10);
        controlPanel.add(amountField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(10,10,10,0);
        controlPanel.add(withdrawLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.insets = new Insets(10,5,10,10);
        controlPanel.add(withdrawButton, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.insets = new Insets(10,10,10,0);
        controlPanel.add(depositLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.insets = new Insets(10,5,10,10);
        controlPanel.add(depositButton, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10,10,0,10);
        feedBackPanel.add(balanceLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;        
        constraints.insets = new Insets(5,10,10,10);
        feedBackPanel.add(remainingField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;        
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,10,0,10);
        feedBackPanel.add(transactionsLabel, constraints);        

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 3;     
        constraints.insets = new Insets(5,10,10,10);
        feedBackPanel.add(transactionPane, constraints);
        
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10,10,10,10);
        wholePanel.add(controlPanel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.insets = new Insets(10,10,10,10);
        wholePanel.add(feedBackPanel, constraints);
        
        add(wholePanel);        

    }

    //Since we are implementing ActionListener - we must Override actionPerformed()
    //Only 2 buttons that interact with the user
    @Override
    public void actionPerformed(ActionEvent event) {
        double balance;
        double enteredAmount;
        double remaining;

        JButton sourceEvent = (JButton) event.getSource();

        //The Simple logic allows for any number to be put in the JFormattedTextField
        //No real error checking as that was not required by the assignment.
        if(sourceEvent == depositButton){

            balance = Double.parseDouble(remainingField.getText());
            enteredAmount = Double.parseDouble(amountField.getValue().toString());
            
            //Add a Deposit Transaction if greater than 0
            if(enteredAmount > 0){
                remaining = balance + enteredAmount;            
                remainingField.setText(String.format("%.2f", remaining));
                transactionArea.append(String.format("Deposited %.2f \n", enteredAmount));
            }else{
                amountField.setText("Enter a Positive Value");
            }
            
        }

        if(sourceEvent == withdrawButton){

            balance = Double.parseDouble(remainingField.getText());
            enteredAmount = Double.parseDouble(amountField.getValue().toString());
            
            //Add a Withdrew Transaction if greater than 0
            if(enteredAmount > 0){
                remaining = balance - enteredAmount;            
                remainingField.setText(String.format("%.2f", remaining));
                transactionArea.append(String.format("Withdrew %.2f \n", enteredAmount));
            }else{
                amountField.setText("Enter a Positive Value");
            }            

        }
    }

}
