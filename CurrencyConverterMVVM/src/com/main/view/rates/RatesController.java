package com.main.view.rates;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.main.model.Currency;
import javafx.scene.control.cell.PropertyValueFactory;

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

    public void init()
    {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("shortname"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("rate"));
        table.setItems(getCurrencies());
    }
    ObservableList<Currency> getCurrencies()
    {
        ObservableList<Currency> list = FXCollections.observableArrayList();
        list.add(new Currency("Ukrainian Hrivna","UAH",27d));
        return list;
    }
}
