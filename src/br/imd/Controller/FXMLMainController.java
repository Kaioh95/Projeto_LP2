package br.imd.Controller;

import br.imd.Model.KNNAlgorithm;
import br.imd.View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class FXMLMainController{

    @FXML
    private TextField imagePath;

    @FXML
    private Button browseButton;

    @FXML
    private ImageView imgViewer;

    @FXML
    private ToggleGroup distances;

    @FXML
    private Button aboutButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button runButton;

    @FXML
    void aboutAction(ActionEvent event) {

    }

    public void initialize(){
        runButton.setDisable(true);
    }

    public void blockRunButton(){
        boolean isDisable = !(imagePath.getText().contains(".png"));
        runButton.setDisable(isDisable);
    }

    @FXML
    void browseAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image files extension","*.png");

        fileChooser.getExtensionFilters().add(extFilter);

        File selectedFile = fileChooser.showOpenDialog(Main.getStage());
        try {
            imagePath.setText(selectedFile.getAbsolutePath());

            //Showing the image
            File file = new File(selectedFile.getAbsolutePath());
            Image image = new Image(file.toURI().toString());
            imgViewer.setImage(image);

        } catch (NullPointerException ex){
            imagePath.setText("Invalid Path");
        }
    }

    @FXML
    void exitAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void runAction(ActionEvent event) {
        int option;
        RadioButton distanceSelected = (RadioButton) distances.getSelectedToggle();
        if(distanceSelected.getText().equals("Euclidean Distance"))
            option = 1;
        else if(distanceSelected.getText().equals("Manhattan Distance"))
            option = 2;
        else
            option = 3;

        CSVDataReader data = new CSVDataReader();
        data.readAllData(data.getCsv_path());

        FeatureExtraction fext = new FeatureExtraction();
        List<Float> imgFeatures = fext.extract(imagePath.getText());

        KNNAlgorithm k_nn = new KNNAlgorithm();
        k_nn.k_nn(data.getDataset(), imgFeatures, 3, option);

        Alert result = new Alert(Alert.AlertType.INFORMATION);
        result.setTitle("Results");
        result.setHeaderText("Using: " + distanceSelected.getText());
        if(k_nn.makePrediction())
            result.setContentText("There are people in the picture!");
        else
            result.setContentText("There are no people in the picture!");
        result.show();
    }

}
