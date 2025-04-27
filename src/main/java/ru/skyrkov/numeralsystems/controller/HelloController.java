package ru.skyrkov.numeralsystems.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ru.skyrkov.numeralsystems.model.Binary;
import ru.skyrkov.numeralsystems.model.Decimal;
import ru.skyrkov.numeralsystems.model.Hexdecimal;
import ru.skyrkov.numeralsystems.model.NumeralSystem;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import static ru.skyrkov.numeralsystems.util.Util.numeralSystemClasses;

public class HelloController implements Initializable {

    @FXML
    private Label errorLabel;

    @FXML
    private Label errorOperaionLabel;

    @FXML
    private TextField binaryResultField;

    @FXML
    private TextField decimalResultField;

    @FXML
    private TextField hexadecimalResultField;

    @FXML
    private TextField inputNumberField;

    @FXML
    private TextField inputNumberField1;

    @FXML
    private TextField inputNumberField2;

    @FXML
    private TextField operationResultField;

    @FXML
    private ComboBox<String> operationSelectionField;

    @FXML
    private ComboBox<NumeralSystem> systemSelectionField1;

    @FXML
    private ComboBox<NumeralSystem> systemSelectionField2;

    @FXML
    void getOperationResult(ActionEvent event) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        NumeralSystem num1 = systemSelectionField2.getSelectionModel().getSelectedItem().clone();
        NumeralSystem num2 = systemSelectionField2.getSelectionModel().getSelectedItem().clone();
        errorOperaionLabel.setText("");
        try {
            num1.setValue(inputNumberField1.getText());
            num2.setValue(inputNumberField2.getText());
            String result = "";
            switch (operationSelectionField.getSelectionModel().getSelectedItem()){
                case "+":
                    result = num1.getAdditionResult(num2);
                    break;
                case "-":
                    result = num1.getSubtractionResult(num2);
                    break;
            }
            operationResultField.setText(result);
        } catch (Exception e){
            errorOperaionLabel.setText(e.getMessage());
        }

    }

    @FXML
    void resultOfConvert(ActionEvent event) {
        // Получение результатов конвертации
        errorLabel.setText("");
        try {
            NumeralSystem number = systemSelectionField1.getSelectionModel().getSelectedItem();
            number.setValue(inputNumberField.getText());
            binaryResultField.setText(number.getBinary());
            decimalResultField.setText(number.getDecimal());
            hexadecimalResultField.setText(number.getHexdecimal());
        }
        catch (Exception e){
            errorLabel.setText(e.getMessage());
            clearResultFields();
        }
    }

    private void clearResultFields() {
        binaryResultField.setText("");
        decimalResultField.setText("");
        hexadecimalResultField.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeSelectionFields();
    }

    private void initializeSelectionFields() {
        // Заполнение ComboBox с операциями (для калькулятора)
        operationSelectionField.getItems().add("+");
        operationSelectionField.getItems().add("-");
        operationSelectionField.setValue("+");

        // Заполнение ComboBox с системами счисления
        systemSelectionField1.getItems().addAll(numeralSystemClasses);
        systemSelectionField1.setValue(numeralSystemClasses.get(1));
        systemSelectionField2.getItems().addAll(numeralSystemClasses);
        systemSelectionField2.setValue(numeralSystemClasses.get(1));
    }
}
