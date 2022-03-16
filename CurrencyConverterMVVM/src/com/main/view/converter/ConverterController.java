package com.main.view.converter;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.main.viewmodel.converter.View1VM;

import javafx.event.ActionEvent;


public class ConverterController {
    @FXML
    Label resultLabel;

    @FXML
    Button convertButton;

    @FXML
    ComboBox<String> fromBox;

    @FXML
    ComboBox<String> toBox;

    @FXML
    TextField amountField;



    private View1VM viewModel;

    public void init(View1VM pieViewModel) {
        this.viewModel = pieViewModel;
        fromBox.valueProperty().bindBidirectional(viewModel.getSourceCurrency());
        toBox.valueProperty().bindBidirectional(viewModel.getFinalCurrency());
        amountField.textProperty().bindBidirectional(viewModel.getSourceNumber());
        resultLabel.textProperty().bind(viewModel.getResult());
        fromBox.setItems(viewModel.getCurrNames());
        toBox.setItems(viewModel.getCurrNames());
    }
    public void onUpdateButton(ActionEvent actionEvent)
    {
        viewModel.convert();
    }


}
