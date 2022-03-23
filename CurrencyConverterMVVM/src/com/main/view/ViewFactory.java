package com.main.view;

import com.main.view.rates.RatesController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.main.view.converter.ConverterController;
import com.main.viewmodel.ViewModelFactory;

import java.io.IOException;

public class ViewFactory {
    private ViewModelFactory viewModelFactory;

    public ViewModelFactory getViewModelFactory() {
        return viewModelFactory;
    }

    public ViewFactory(ViewModelFactory vmFactory)
    {
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
            ratesController.init(viewModelFactory.getRatesVM());
            localstage.setTitle("Rates");
        }

        scene = new Scene(root);
        localstage.setScene(scene);
        localstage.show();

    }

}
