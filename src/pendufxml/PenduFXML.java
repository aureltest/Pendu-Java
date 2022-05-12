/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendufxml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;




public class PenduFXML extends Application {
    
    
    
    Scene scene = null;
    
    @Override
    public void start(Stage PrimaryStage) throws Exception {
        
        try{
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            scene = new Scene(root);
            
            PrimaryStage.setScene(scene);
            PrimaryStage.setTitle("Le pendu de la mort qui tue");
            PrimaryStage.show();
            
        }
        catch(IOException e){
        }
//        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
