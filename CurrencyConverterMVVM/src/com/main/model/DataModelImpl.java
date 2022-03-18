package com.main.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Date;
public class DataModelImpl implements DataModel {
    private JSONObject currencyRates;

    @Override
    public double convertation(String sourceCurrency, String finalCurrency, double sourceNumber ) {
            double sourceRate = 1, finalRate = 0;
            sourceRate = currencyRates.getJSONObject("rates").getDouble(sourceCurrency);
            finalRate = currencyRates.getJSONObject("rates").getDouble(finalCurrency);
            double resultnumber = (sourceNumber * finalRate) / sourceRate;
            return resultnumber;
    }

    private String getURLContent(String urlAdress) {

            StringBuffer content = new StringBuffer();

            try {
                URL url = new URL(urlAdress);
                URLConnection urlConn = url.openConnection();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line + "\n");
                }
                bufferedReader.close();
            } catch (Exception e) {
                System.out.println("Запрос не удалось осуществить");
            }
            return content.toString();

    }

    public ObservableList<String> getRatesNames()
    {
        ObservableList<String> list = FXCollections.observableArrayList(currencyRates.getJSONObject("rates").keySet());
        FXCollections.sort(list);
        return list;
    }

    @Override
    public Currency getCurrencyByName(String name) {
        Double rate = currencyRates.getJSONObject("rates").getDouble(name);
        return (new Currency(name,rate));
    }

    public void updateData() {
        String output = getURLContent("https://openexchangerates.org/api/latest.json?app_id=014ca641c5e049a4bdbdc03b63f4c5c4");
        currencyRates = new JSONObject(output);
    }
    @Override
    public void getCurrencyUpdates(ObservableList<Currency> list) {
        for (Currency currency : list)
        {
            currency.setRate(currencyRates.getJSONObject("rates").getDouble(currency.getName()));
        }
    }
}
