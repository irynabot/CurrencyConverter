package com.main.model;

import javafx.collections.ObservableList;

public interface DataModel {
    double convertation(String sourceCurrency, String finalCurrency, double sourceNumber);
    void updateData();
    public ObservableList<String> getRatesNames();
    public Currency getCurrencyByName(String currName);
    public void getCurrencyUpdates(ObservableList<Currency> list);
}
