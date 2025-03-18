/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author Nicole Hernandez
 */
import Model.NumericalSystem;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NumericalSystemController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCalculate"
    private Button btnCalculate; // Value injected by FXMLLoader

    @FXML // fx:id="btnClean"
    private Button btnClean; // Value injected by FXMLLoader

    @FXML // fx:id="btnCleanConvert"
    private Button btnCleanConvert; // Value injected by FXMLLoader

    @FXML // fx:id="cboConvert"
    private ComboBox<NumericalSystem> cboConvert; // Value injected by FXMLLoader

    @FXML // fx:id="cboFromConvert"
    private ComboBox<NumericalSystem> cboFromConvert; // Value injected by FXMLLoader

    @FXML // fx:id="cboNSOperation"
    private ComboBox<NumericalSystem> cboNSOperation; // Value injected by FXMLLoader

    @FXML // fx:id="cboOperation"
    private ComboBox<NumericalSystem> cboOperation; // Value injected by FXMLLoader

    @FXML // fx:id="lbl1"
    private Label lbl1; // Value injected by FXMLLoader

    @FXML // fx:id="lbl11"
    private Label lbl11; // Value injected by FXMLLoader

    @FXML // fx:id="lbl2"
    private Label lbl2; // Value injected by FXMLLoader

    @FXML // fx:id="lbl21"
    private Label lbl21; // Value injected by FXMLLoader

    @FXML // fx:id="lblOp"
    private Label lblOp; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumOne"
    private TextField txtNumOne; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumTwo"
    private TextField txtNumTwo; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumberOneConversion"
    private TextField txtNumberOneConversion; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextField txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="txtResultConversion"
    private TextField txtResultConversion; // Value injected by FXMLLoader

    private NumericalSystem numericalSystem;
    private ObservableList<NumericalSystem> numericalSystemFromConvert = FXCollections.observableArrayList();
    private ObservableList<NumericalSystem> numericalSystemToConvert = FXCollections.observableArrayList();
    private ObservableList<NumericalSystem> operatorList = FXCollections.observableArrayList();
    private ObservableList<NumericalSystem> numericalSystemOperation = FXCollections.observableArrayList();

    @FXML
    void calculateValue(ActionEvent event) {
        String operator = this.getOperator();
        String numOne = txtNumOne.getText();
        String numTwo = txtNumTwo.getText();
        String numSystem = this.getNumericalSystemOperator();

        if (cboNSOperation.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "No ha seleccionado el Sistema Numerico", ButtonType.CLOSE);
            alert.showAndWait();
            return;
        }
        if (cboOperation.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "No ha seleccionado el Operador", ButtonType.CLOSE);
            alert.showAndWait();
            return;
        }
        if (!numericalSystem.verify(numSystem, numOne)) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "El número 1 no equivale al sistema seleccionado", ButtonType.CLOSE);
            alert.showAndWait();
            return;
        }

        if (!numericalSystem.verify(numSystem, numTwo)) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "El número 2 no equivale al sistema seleccionado", ButtonType.CLOSE);
            alert.showAndWait();
            return;
        }
        if (numericalSystem.divideByCero(numOne, numTwo, this.getOperator())) {
            String result = numericalSystem.operationNumericalSystem(numSystem, numOne, numTwo, operator);
            txtResult.setText(result);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "No se realizan divisiones entre 0", ButtonType.CLOSE);
            alert.showAndWait();
        }

    }

    @FXML
    void cleanConversion(ActionEvent event) {
        txtResultConversion.clear();
        txtNumberOneConversion.clear();
        cboFromConvert.setValue(null);
        cboConvert.setValue(null);
    }

    @FXML
    void cleanResult(ActionEvent event) {
        txtNumOne.clear();
        txtNumTwo.clear();
        txtResult.clear();
    }

    @FXML
    void toConvert(ActionEvent event) {
        String fromConvert = this.getNumericalSystemFromConvert();
        String toConvert = this.getNumericalSystemToConvert();
        String numberToConvert = txtNumberOneConversion.getText();

        if (numericalSystem.verify(fromConvert, numberToConvert)) {
            String result = numericalSystem.convert(fromConvert, toConvert, numberToConvert);
            txtResultConversion.setText(result);
        } else {
            if (numberToConvert.equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No ha ingresado el valor a convertir", ButtonType.CLOSE);
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Número inválido para el sistema seleccionado.", ButtonType.CLOSE);
                alert.showAndWait();
            }
            cboConvert.setValue(null);
        }

    }

    private void numericalSystemConvert() {
        String[] numericalSystem = {"Binario", "Hexadecimal", "Octal", "Decimal"};

        NumericalSystem ns = null;
        for (int j = 0; j < numericalSystem.length; j++) {
            ns = new NumericalSystem(numericalSystem[j]);
            numericalSystemFromConvert.add(ns);
            numericalSystemToConvert.add(ns);
            if (j != 3) {
                numericalSystemOperation.add(ns);
            }
        }
        cboFromConvert.setItems(numericalSystemFromConvert);
        cboConvert.setItems(numericalSystemToConvert);
        cboNSOperation.setItems(numericalSystemOperation);

    }

    private String getNumericalSystemFromConvert() {
        NumericalSystem selectedSystem = cboFromConvert.getSelectionModel().getSelectedItem();

        if (selectedSystem != null) {
            return selectedSystem.getNumericalSystem();
        }

        return null;
    }

    private void operatorSN() {
        String[] operator = {"Suma", "Resta", "Multiplicación", "División"};

        NumericalSystem ns = null;
        for (int j = 0; j < operator.length; j++) {
            ns = new NumericalSystem(operator[j]);
            operatorList.add(ns);
        }
        cboOperation.setItems(operatorList);

    }

    private String getNumericalSystemToConvert() {
        NumericalSystem selectedSystem = cboConvert.getSelectionModel().getSelectedItem();

        if (selectedSystem != null) {
            return selectedSystem.getNumericalSystem();
        }

        return null;
    }

    private String getOperator() {
        NumericalSystem selectedSystem = cboOperation.getSelectionModel().getSelectedItem();

        if (selectedSystem != null) {
            return selectedSystem.getNumericalSystem();
        }

        return null;
    }

    private String getNumericalSystemOperator() {
        NumericalSystem selectedSystem = cboNSOperation.getSelectionModel().getSelectedItem();

        if (selectedSystem != null) {
            return selectedSystem.getNumericalSystem();
        }

        return null;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCalculate != null : "fx:id=\"btnCalculate\" was not injected: check your FXML file 'SistemasNumericos.fxml'.";
        assert btnClean != null : "fx:id=\"btnClean\" was not injected: check your FXML file 'SistemasNumericos.fxml'.";
        assert btnCleanConvert != null : "fx:id=\"btnCleanConvert\" was not injected: check your FXML file 'SistemasNumericos.fxml'.";
        assert cboConvert != null : "fx:id=\"cboConvert\" was not injected: check your FXML file 'SistemasNumericos.fxml'.";
        assert cboFromConvert != null : "fx:id=\"cboFromConvert\" was not injected: check your FXML file 'SistemasNumericos.fxml'.";
        assert cboNSOperation != null : "fx:id=\"cboNSOperation\" was not injected: check your FXML file 'SistemasNumericos.fxml'.";
        assert cboOperation != null : "fx:id=\"cboOperation\" was not injected: check your FXML file 'SistemasNumericos.fxml'.";
        assert lbl1 != null : "fx:id=\"lbl1\" was not injected: check your FXML file 'SistemasNumericos.fxml'.";
        assert lbl11 != null : "fx:id=\"lbl11\" was not injected: check your FXML file 'SistemasNumericos.fxml'.";
        assert lbl2 != null : "fx:id=\"lbl2\" was not injected: check your FXML file 'SistemasNumericos.fxml'.";
        assert lbl21 != null : "fx:id=\"lbl21\" was not injected: check your FXML file 'SistemasNumericos.fxml'.";
        assert lblOp != null : "fx:id=\"lblOp\" was not injected: check your FXML file 'SistemasNumericos.fxml'.";
        assert txtNumOne != null : "fx:id=\"txtNumOne\" was not injected: check your FXML file 'SistemasNumericos.fxml'.";
        assert txtNumTwo != null : "fx:id=\"txtNumTwo\" was not injected: check your FXML file 'SistemasNumericos.fxml'.";
        assert txtNumberOneConversion != null : "fx:id=\"txtNumberOneConversion\" was not injected: check your FXML file 'SistemasNumericos.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SistemasNumericos.fxml'.";
        assert txtResultConversion != null : "fx:id=\"txtResultConversion\" was not injected: check your FXML file 'SistemasNumericos.fxml'.";
        numericalSystem = new NumericalSystem();
        this.numericalSystemConvert();
        this.getNumericalSystemToConvert();
        this.operatorSN();

        txtNumberOneConversion.textProperty().addListener((observable, oldValue, newValue) -> {
            txtNumberOneConversion.setText(newValue.toUpperCase()); // Convierte a mayúsculas automáticamente
        });
    }

}
