package com.main.view.rates;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.main.model.Currency;
public class RatesController {
    @FXML
    TextField addTextField;

    @FXML
    Button addButton;
    @FXML
    TableColumn<Currency,String> nameColumn;

    @FXML
    TableColumn<Currency,Double> amountColumn;

    @FXML
    TableView<Currency> table;

}
