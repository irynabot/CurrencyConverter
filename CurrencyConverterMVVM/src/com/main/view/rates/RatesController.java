package com.main.view.rates;
import com.main.viewmodel.rates.RatesVM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.main.model.Currency;
import javafx.scene.control.cell.PropertyValueFactory;

public class RatesController {
    @FXML
    ComboBox<String> addComboBox;

    @FXML
    Button addButton;
    @FXML
    TableColumn<Currency,String> nameColumn;

    @FXML
    TableColumn<Currency,Double> amountColumn;

    @FXML
    TableView<Currency> table;

    private RatesVM ratesVM;
    private ObservableList<Currency> list = FXCollections.observableArrayList();
    public void init(RatesVM ratesViewModel)
    {
        ratesVM = ratesViewModel;
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("rate"));
        table.setItems(list);
        addComboBox.setItems(ratesVM.getCurrNames());
        addComboBox.valueProperty().bindBidirectional(ratesVM.getAddedCurrency());
    }

    public void onAddButton(ActionEvent actionEvent)
    {
        list.add(ratesVM.getCurrencyByName());
        addComboBox.getItems().remove(addComboBox.getValue());
    }
}
