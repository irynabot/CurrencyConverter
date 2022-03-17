package com.main.viewmodel.converter;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import com.main.model.DataModel;
import javafx.collections.ObservableList;

public class ConverterVM {
    private StringProperty sourceNumber;
    private StringProperty sourceCurrency;
    private StringProperty finalCurrency;
    private StringProperty result;
    private DataModel model;

    public ConverterVM(DataModel dataModel)
    {
        model = dataModel;
        sourceNumber = new SimpleStringProperty();
        sourceCurrency = new SimpleStringProperty();
        finalCurrency = new SimpleStringProperty();
        result = new SimpleStringProperty();
    }

    public void convert()
    {
        String sourcec = sourceCurrency.getValue();
        String finalc = finalCurrency.getValue();
        double amount  = Double.parseDouble(sourceNumber.getValue());
        double resultNumber = model.convertation(sourcec, finalc, amount);
        result.setValue(resultNumber+" "+finalCurrency.getValue());
    }
    public StringProperty getResult() {
        return result;
    }
    public StringProperty getSourceNumber()
    {
        return sourceNumber;
    }
    public StringProperty getSourceCurrency(){
        return sourceCurrency;
    }
    public StringProperty getFinalCurrency()
    {
        return finalCurrency;
    }
    public ObservableList<String> getCurrNames()
    {
        return model.getRatesNames();
    }


}
