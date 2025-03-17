/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author Nicole Hernandez
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class NumericalSystemViewInterfaz extends Application {

    public static void main(String[] args) {
        Application.launch(NumericalSystemViewInterfaz.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SistemasNumericos.fxml"));

        stage.setScene(new Scene(loader.load()));
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.show();
    }
	
}
