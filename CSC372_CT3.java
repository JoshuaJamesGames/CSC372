import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;
import java.util.Vector;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class CSC372_CT3 extends Application {
   
   
   @Override
   public void start(Stage applicationStage) {
      Scene scene;         // Scene contains all content
      GridPane mainPane = new GridPane();   // Positions components within scene
      mainPane.setPrefSize(400, 250);

      Menu optionsMenu = new Menu("Options");
      MenuBar mainMenu = new MenuBar(optionsMenu);

      MenuItem printDateTime = new MenuItem("Print Date & Time");
      MenuItem saveDateTime = new MenuItem("Save text to log.txt");
      MenuItem randomOrange = new MenuItem("Orange");
      MenuItem exit = new MenuItem("Exit");

      TextField dateTimeField = new TextField();
      dateTimeField.setPromptText("Use the Menu to Populate");
      dateTimeField.setEditable(false);
      
      optionsMenu.getItems().addAll(printDateTime, saveDateTime, randomOrange, exit);
      mainPane.add(mainMenu, 0, 0);
      mainPane.add(dateTimeField, 0, 1);

      scene = new Scene(mainPane); // Create scene containing the grid pane
      
      
    
      // Set an event handler to handle button presses
      printDateTime.setOnAction(new EventHandler<ActionEvent>() {
         /* Method is automatically called when an event 
            occurs (e.g, button is pressed) */
         @Override
         public void handle(ActionEvent event) {
            String currentDateTime = new Date().toString();
            dateTimeField.setText(currentDateTime);
            
         } 
      });

      saveDateTime.setOnAction(new EventHandler<ActionEvent>() {
         /* Method is automatically called when an event 
            occurs (e.g, button is pressed) */
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
         /* Method is automatically called when an event 
            occurs (e.g, button is pressed) */
         @Override
         public void handle(ActionEvent event) {

            dateTimeField.setText("Orange");
            
         } 
      });

      exit.setOnAction(new EventHandler<ActionEvent>() {
         /* Method is automatically called when an event 
            occurs (e.g, button is pressed) */
         @Override
         public void handle(ActionEvent event) {
            applicationStage.close();
            
         } 
      });

      applicationStage.setScene(scene);    // Set window's scene  
      applicationStage.setTitle("Menu Interface II"); // Set window's title
      applicationStage.show();             // Display window
   }

   public Color getOrange(){

      int colorNum = new Random().nextInt(2);
      Color orangeColors[] ={
         Color.rgb(255, 245, 238),
         Color.rgb(247, 231, 206)
      };

      return orangeColors[colorNum];

   }
   
   public static void main(String [] args) {
      launch(args); // Launch application
   }
}