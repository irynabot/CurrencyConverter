package com.main.viewmodel.rates;
import com.main.model.Currency;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import com.main.model.DataModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class RatesVM {
    private StringProperty addedCurrency;
    private  DataModel model;
    private ObservableList<Currency> currList;
    public RatesVM(DataModel dataModel)
    {
        model = dataModel;
        addedCurrency = new SimpleStringProperty();
        currList = FXCollections.observableArrayList();
    }
    public Currency getCurrencyByName()
    {
        return model.getCurrencyByName(addedCurrency.getValue());
    }
    public void updateData(ObservableList<Currency> list)
    {
        model.getCurrencyUpdates(list);
    }
    public StringProperty getAddedCurrency(){return addedCurrency;}
    public ObservableList<String> getCurrNames()
    {
        return model.getRatesNames();
    }
}
