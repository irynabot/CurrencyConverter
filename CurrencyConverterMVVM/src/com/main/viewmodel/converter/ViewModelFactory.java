package com.main.viewmodel.converter;

import com.main.model.DataModelFactory;

public class ViewModelFactory {

    private View1VM piechartVM;

    public ViewModelFactory(DataModelFactory modelFactory)
    {
        piechartVM = new View1VM(modelFactory.getDataModel());
    }

    public View1VM getPiechartVM() {
        return piechartVM;
    }
}
