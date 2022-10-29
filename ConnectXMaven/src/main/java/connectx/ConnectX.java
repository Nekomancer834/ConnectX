/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package connectx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Trent
 */
public class ConnectX extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoad = new FXMLLoader(getClass().getResource("MainMenuFXML.fxml"));
        Parent root = fxmlLoad.load();
        Scene scene = new Scene(root, 600, 480);
        
        stage.setScene(scene);
        stage.show();
    }

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
