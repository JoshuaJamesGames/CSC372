import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;
import java.util.Vector;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
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
            
            Color orange = getOrange();
            mainPane.setBackground(new Background(new BackgroundFill(orange, CornerRadii.EMPTY, Insets.EMPTY)));
            randomOrange.setStyle("-fx-background-color:#"+orange.toString().substring(2, 8));
            
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
   
   public static void main(String [] args) {
      launch(args); // Launch application
   }
}