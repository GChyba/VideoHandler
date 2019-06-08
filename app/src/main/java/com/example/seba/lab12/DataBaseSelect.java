package com.example.seba.lab12;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DataBaseSelect {

    public Cursor LoadOneFieldFromTable(Context context, String tableName, String fieldName){
        SQLiteDatabase base = context.openOrCreateDatabase(DataBaseStructure.BaseFile,SQLiteDatabase.OPEN_READWRITE,null);
        String columns[] = {fieldName};
        Cursor c = base.query(tableName,columns,null,null,null,null,null);
        c.moveToFirst();
        base.close();
        return c;
    }

    public List<String> LoadOneFieldFromTableList(Context context, String tableName, String fieldName){
        List<String>  listSummary = new ArrayList<String>();
        SQLiteDatabase base = context.openOrCreateDatabase(DataBaseStructure.BaseFile, SQLiteDatabase.OPEN_READWRITE, null);
        String columns[]={fieldName};
        Cursor c = base.query(tableName, columns, null,null,null,null,null);
        int d1Cursor;
        d1Cursor = c.getCount();
        int i=0;
        c.moveToFirst();
        while(i<d1Cursor){
            listSummary.add(c.getString(0));
            c.moveToNext();
                i=i+1;
        }
        base.close();
        return listSummary;
    }

    public List<Integer> loadOneFieldFromListInteger(Context context, String tableName, String fieldName){
        List<Integer> listSummary = new ArrayList<Integer>();
        SQLiteDatabase base = context.openOrCreateDatabase(DataBaseStructure.BaseFile, SQLiteDatabase.OPEN_READWRITE, null);
        String columns[]={fieldName};
        Cursor c = base.query(tableName, columns, null,null,null,null,null);
        int d1Cursor;
        d1Cursor = c.getCount();
        int i=0;
        c.moveToFirst();
        while(i<d1Cursor){
            listSummary.add(c.getInt(0));
            c.moveToNext();
            i=i+1;
        }
        base.close();
        return listSummary;
    }
}
