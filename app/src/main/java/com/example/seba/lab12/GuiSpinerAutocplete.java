package com.example.seba.lab12;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class GuiSpinerAutocplete {

    DataBaseSelect dataBaseSelect = new DataBaseSelect();

    public ArrayAdapter<String> LoadAdapterFromBaseAutocomplete(Context context, String nameTable, String fieldName){
        List<String> dataList=new ArrayList<>();
        dataList = dataBaseSelect.LoadOneFieldFromTableList(context, nameTable, fieldName);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_dropdown_item_1line,dataList);
        return adapter;
    };
}
