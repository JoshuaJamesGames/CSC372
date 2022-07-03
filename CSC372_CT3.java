/*
Creating a User Interface II
Create a user interface that has a top bar that includes a menu. The menu should have four items.

When the user selects the first menu option, then the date and time should be printed in a text box.

When the user selects the second menu option, then the text box contents should be written to a text file named "log.txt."

When the user selects the third menu item then the frame background color changes to random color hue of the color orange. 
The menu option should display the initial random hue each time selected for a single execution of the program. 
See https://www.w3schools.com/colors/colors_picker.asp (Links to an external site.)

When the user selects the fourth menu option then the program exits.
*/

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

//JavaFX extends Application rather than JFrame from the last assignment
public class CSC372_CT3 extends Application {
   
   //Override start
   @Override
   public void start(Stage applicationStage) {
      //Scene contains all content
      Scene scene;

      //Root Pane for components within scene         
      GridPane mainPane = new GridPane();   
      mainPane.setPrefSize(400, 250);

      //MenuBar - Required
      Menu optionsMenu = new Menu("Options");
      MenuBar mainMenu = new MenuBar(optionsMenu);
      //Make the menu full width - survives resizing
      mainMenu.prefWidthProperty().bind(mainPane.widthProperty());

      //Four menuItems - Required
      MenuItem printDateTime = new MenuItem("Print Date & Time");
      MenuItem saveDateTime = new MenuItem("Save text to log.txt");
      MenuItem randomOrange = new MenuItem("Orange");
      MenuItem exit = new MenuItem("Exit");

      //TextField - Required for pinting current date and time
      TextField dateTimeField = new TextField();
      dateTimeField.setPromptText("Use the Menu to Populate");
      dateTimeField.setEditable(false);
      dateTimeField.setAlignment(Pos.TOP_CENTER);
      
      //Assemble the components
      optionsMenu.getItems().addAll(printDateTime, saveDateTime, randomOrange, exit);
      mainPane.add(mainMenu, 0, 0);
      mainPane.add(dateTimeField, 0, 1);

      //Initialize scene containing the grid pane
      scene = new Scene(mainPane); 
      
      
    
      //Set an event handlers to handle menuItem presses
      //In here dwells logic
      printDateTime.setOnAction(new EventHandler<ActionEvent>() {
         //Print the current date and time to dateTimeField
         @Override
         public void handle(ActionEvent event) {
            String currentDateTime = new Date().toString();
            dateTimeField.setText(currentDateTime);
            
         } 
      });

      saveDateTime.setOnAction(new EventHandler<ActionEvent>() {
         //Save the contents of the dateTimeField to log.txt
         //This may be an empty line or the default message
         @Override
         public void handle(ActionEvent event) {
            
            String dateTimeValue = dateTimeField.getText();
            try {

               FileOutputStream fileStream = new FileOutputStream("log.txt");
               PrintWriter outFS = new PrintWriter(fileStream);
            
               outFS.println(dateTimeValue);     

               outFS.close();

            } catch (Exception e) {
               dateTimeField.setText(e.getMessage());
            }
            
         } 
          
      });

      randomOrange.setOnAction(new EventHandler<ActionEvent>() {
         //Make the background of the mainPane and randomOrange menuItem a shade of orange
         @Override
         public void handle(ActionEvent event) {
            
            Color orange = getOrange();
            mainPane.setBackground(new Background(new BackgroundFill(orange, CornerRadii.EMPTY, Insets.EMPTY)));
            randomOrange.setStyle("-fx-background-color:#"+orange.toString().substring(2, 8));
            
         } 
      });

      exit.setOnAction(new EventHandler<ActionEvent>() {
         //Handle the close button
         @Override
         public void handle(ActionEvent event) {
            applicationStage.close();
            
         } 
      });
      //Start the application
      applicationStage.setScene(scene);    // Set window's scene  
      applicationStage.setTitle("Menu Interface II"); // Set window's title
      applicationStage.show();             // Display window
   }

   //Programmatically defining Orange turns out to be an enigma for me
   //There are 28000+ shades of accepted orange 
   //between almost yellow-white and dark-brown-red
   //So I have hand-keyed 30 colors and getOrange() selects one at random
   public Color getOrange(){
      //Orange colors from workwithcolor.com/orange-brown-color-hue-range-01.htm

      int colorNum = new Random().nextInt(30);
      Color orangeColors[] ={
         Color.rgb(255, 245, 238),
         Color.rgb(247, 231, 206),
         Color.rgb(255, 229, 180),
         Color.rgb(245,	222, 179),
         Color.rgb(250,	214, 165),
         Color.rgb(251,	206, 177),
         Color.rgb(237,	201, 175),
         Color.rgb(255,	179, 71),
         Color.rgb(222,	184, 135),
         Color.rgb(255,	168, 18),
         Color.rgb(255,	167, 0),
         Color.rgb(229,	170, 112),
         Color.rgb(225,	169, 95),
         Color.rgb(227,	168, 87),
         Color.rgb(195,	176, 145),
         Color.rgb(255,	140, 0),
         Color.rgb(228,	155, 15),
         Color.rgb(237,	145, 33),
         Color.rgb(255,	127, 0),
         Color.rgb(242,	133, 0),
         Color.rgb(237,	135, 45),
         Color.rgb(255,	117, 24),
         Color.rgb(193,	154, 107),
         Color.rgb(255,	103, 0),
         Color.rgb(205,	127, 50),
         Color.rgb(204,	119, 34),
         Color.rgb(210,	105, 30),
         Color.rgb(184,	115, 51),
         Color.rgb(160,	120, 90),
         Color.rgb(204,	85,0)
      };

      return orangeColors[colorNum];

   }

   //Just a single line to launch it all
   public static void main(String [] args) {
      launch(args); 
   }
}