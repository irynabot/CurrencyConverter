package com.main.view.rates;
import com.main.model.DataModel;
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

    @FXML
    private Button deleteButton;


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
        
        runAutoUpdate();
    }

    public void onAddButton(ActionEvent actionEvent)
    {
        list.add(ratesVM.getCurrencyByName());
        addComboBox.getItems().remove(addComboBox.getValue());
    }

    public void onDeleteButton(ActionEvent actionEvent)
    {
        if (!list.isEmpty()) {
            Currency currency = table.getSelectionModel().getSelectedItem();
            list.remove(currency);
            addComboBox.getItems().add(currency.getName());
            ObservableList<String> currencyNamesList = addComboBox.getItems();
            FXCollections.sort(currencyNamesList);
            addComboBox.setItems(currencyNamesList);
        }
    }
    public void updateTable(ObservableList<Currency> newList)
    {
        list = newList;
    }
    private void runAutoUpdate() {
        Thread thread = new Thread(() ->{

            while (true){
                list = ratesVM.updateData(list);
                try {
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}
