package com.main.model;

public class DataModelFactory {
    private DataModel dataModel;

    public DataModelFactory() {
    }

    public DataModel getDataModel() {
        if (dataModel == null)
        {
            dataModel = new DataModelImpl();
            dataModel.updateData();
        }
        return dataModel;
    }
}
