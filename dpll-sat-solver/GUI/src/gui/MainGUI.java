package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGUI extends Application {



    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root,1028, 720);


 /*     scene.getStylesheets().add("gui/style.css");
        l.setLayoutX(50);
        l.setLayoutX(50);
        l.getStyleClass().add("h1"); */

        primaryStage.setScene(scene);
        primaryStage.setTitle("SatSolver");
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
