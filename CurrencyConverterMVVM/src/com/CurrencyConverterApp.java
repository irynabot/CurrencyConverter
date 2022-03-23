package com;

import com.main.model.DataModel;
import javafx.application.Application;
import javafx.stage.Stage;
import com.main.model.DataModelFactory;
import com.main.view.ViewFactory;
import com.main.viewmodel.ViewModelFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CurrencyConverterApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appclicationContext.xml");
        ViewFactory viewFactory = context.getBean("viewFactory", ViewFactory.class);
        viewFactory.start();
        runAutoUpdate(context.getBean("dataModelFactory",DataModelFactory.class).getDataModel());
        context.close();
    }

    private void runAutoUpdate(DataModel dataModel) {
        Thread thread = new Thread(() ->{

            while (true){
                dataModel.updateData();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}
