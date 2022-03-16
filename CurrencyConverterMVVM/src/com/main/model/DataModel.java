package com.main.model;

import javafx.collections.ObservableList;

public interface DataModel {
    double convertation(String sourceCurrency, String finalCurrency, double sourceNumber);
    void updateData();
    public ObservableList<String> getRatesNames();
}
