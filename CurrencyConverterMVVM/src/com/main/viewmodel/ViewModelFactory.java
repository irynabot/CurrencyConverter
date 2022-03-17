package com.main.viewmodel;

import com.main.model.DataModelFactory;
import com.main.viewmodel.converter.ConverterVM;
import com.main.viewmodel.rates.RatesVM;

public class ViewModelFactory {

    private ConverterVM converterVM;
    private RatesVM ratesVM;

    public ViewModelFactory(DataModelFactory modelFactory)
    {
        ratesVM = new RatesVM(modelFactory.getDataModel());
        converterVM = new ConverterVM(modelFactory.getDataModel());
    }

    public ConverterVM getPiechartVM() {
        return converterVM;
    }
    public RatesVM getRatesVM(){return  ratesVM;}
}
