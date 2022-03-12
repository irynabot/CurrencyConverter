package com.example.currencyconverter;

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

public class Controller {

    @FXML
    private TextField amount;

    @FXML
    private Button convertCurrencyButton;

    @FXML
    private Text result;

    @FXML
    private TextField sourcecurrency;

    @FXML
    private TextField resultcurrency;


    @FXML
    void initialize()
    {
        convertCurrencyButton.setOnAction(actionEvent -> {
            double amountNumber = 0;
            try
            {
                amountNumber = Double.parseDouble(amount.getText());
            }
            catch (Exception e)
            {
                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setHeaderText("Input not valid");
                errorAlert.setContentText("You should input the number into amount field");
                errorAlert.showAndWait();
                return;
            }
            if (!sourcecurrency.equals("") && !resultcurrency.equals("") && !amount.equals("")) {
                String output = getURLContent("https://openexchangerates.org/api/latest.json?app_id=014ca641c5e049a4bdbdc03b63f4c5c4");


                if (!output.isEmpty()) {
                    JSONObject obj = new JSONObject(output);
                    double sourceRate = 1, resultRate = 0;
                    try
                    {
                        sourceRate = obj.getJSONObject("rates").getDouble(sourcecurrency.getText());
                    }
                    catch (Exception e)
                    {
                        Alert errorAlert = new Alert(AlertType.ERROR);
                        errorAlert.setHeaderText("Input not valid");
                        errorAlert.setContentText("Source rate was not found");
                        errorAlert.showAndWait();
                        return;
                    }
                    try
                    {
                        resultRate = obj.getJSONObject("rates").getDouble(resultcurrency.getText());
                    }
                    catch (Exception e)
                    {
                        Alert errorAlert = new Alert(AlertType.ERROR);
                        errorAlert.setHeaderText("Input not valid");
                        errorAlert.setContentText("Result rate was not found");
                        errorAlert.showAndWait();
                        return;
                    }
                    double resultnumber = (amountNumber * resultRate) / sourceRate;
                    result.setText(""+String.format("%.2f",resultnumber)+" "+resultcurrency.getText());

                }
            }
        });
    }
    private static String getURLContent(String urlAdress) {
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
}