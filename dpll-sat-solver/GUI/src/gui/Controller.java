package gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller {

    private Model model;
    private final FileChooser fileChooser = new FileChooser();
    private Stage stage;
    private TextField path;
    //Elemente aus der FXML-Datei:
    @FXML
    private Label ausgabeCNF, ergebnis, rekSteps;

    public Controller(){
        this.model = new Model();
    }



    public void importCNF(){
        getCNFFile();
    }

    public void getCNFFile(){
        //path.clear();
        stage = new Stage();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {

            String s = file.getAbsolutePath();
            ausgabeCNF.setText(s);
        } else {
            ausgabeCNF.setText(null);
        }
    }

    public void handleKNF() throws Exception {
            if (checkKNF()) {
                ergebnis.setText("Ja");
            } else {
                ergebnis.setText("Nein");
            }
            rekSteps.setText(SatSolverRekursiv.rek_counter + "");
            SatSolverRekursiv.rek_counter = 0;
    }

    public String getPath(){
        if(ausgabeCNF != null){
            return ausgabeCNF.getText();
        } else{
            return null;
        }
    }

    public boolean checkKNF() throws Exception {

        if(model.knfSatisfiable(model.getKNF(getPath()))) {
            return true;
        } else {
            return false;
        }
    }
}
