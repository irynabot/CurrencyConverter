package com.main.viewmodel.rates;
import com.main.model.Currency;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import com.main.model.DataModel;
import javafx.collections.ObservableList;
public class RatesVM {
    private StringProperty addedCurrency;
    private  DataModel model;

    public RatesVM(DataModel dataModel)
    {
        model = dataModel;
        addedCurrency = new SimpleStringProperty();
    }
    public Currency getCurrencyByName()
    {
        return model.getCurrencyByName(addedCurrency.getValue());
    }
}
