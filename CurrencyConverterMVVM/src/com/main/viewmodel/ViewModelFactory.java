package com.main.viewmodel;

import com.main.model.DataModelFactory;
import com.main.viewmodel.converter.ConverterVM;

public class ViewModelFactory {

    private ConverterVM piechartVM;

    public ViewModelFactory(DataModelFactory modelFactory)
    {
        piechartVM = new ConverterVM(modelFactory.getDataModel());
    }

    public ConverterVM getPiechartVM() {
        return piechartVM;
    }
}
