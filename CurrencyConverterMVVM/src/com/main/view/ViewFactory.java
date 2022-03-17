package com.main.view;

import com.main.view.rates.RatesController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.main.view.converter.ConverterController;
import com.main.viewmodel.converter.ViewModelFactory;

import java.io.IOException;

public class ViewFactory {
    private Stage stage;
    private ViewModelFactory viewModelFactory;

    public ViewFactory(Stage st, ViewModelFactory vmFactory)
    {
        stage = st;
        viewModelFactory = vmFactory;

    }
    public void start() throws IOException {
        openView("Converter");
        openView("Rates");
    }
    private void openView(String name) throws IOException {
        Scene scene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;
        loader.setLocation(getClass().getResource(name.toLowerCase()+"/"+name+"View.fxml"));
        root = loader.load();
        Stage localstage = new Stage();
        if ("Converter".equals(name)){
            ConverterController converterControllerController = loader.getController();
            converterControllerController.init(viewModelFactory.getPiechartVM());
            localstage.setTitle("Converter");
        }
        if ("Rates".equals(name)){
            RatesController ratesController = loader.getController();
            ratesController.init();
            localstage.setTitle("Rates");
        }

        scene = new Scene(root);
        localstage.setScene(scene);
        localstage.show();

    }

}
