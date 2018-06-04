package com.example.domin.ega_premium_store.DBFlow;


import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = MyDatabase.NAME, version = MyDatabase.VERSION)
public class MyDatabase {

    public static final String NAME = "tester";

    public static final int VERSION = 1;

    public String getDBName(){
        return NAME;
    }

}
