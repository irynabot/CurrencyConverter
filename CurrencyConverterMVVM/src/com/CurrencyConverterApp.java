package com;

import com.main.model.DataModel;
import javafx.application.Application;
import javafx.stage.Stage;
import com.main.model.DataModelFactory;
import com.main.view.ViewFactory;
import com.main.viewmodel.converter.ViewModelFactory;


public class CurrencyConverterApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        DataModelFactory dataModelFactory = new DataModelFactory();
        ViewModelFactory viewModelFactory = new ViewModelFactory(dataModelFactory);
        ViewFactory viewFactory = new ViewFactory(stage, viewModelFactory);
        viewFactory.start();
        
        runAutoUpdate(dataModelFactory.getDataModel());
    }

    private void runAutoUpdate(DataModel dataModel) {
        Thread thread = new Thread(() ->{

            while (true){
                dataModel.updateData();
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
