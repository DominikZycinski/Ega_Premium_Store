package com.example.domin.ega_premium_store.DBFlow;


import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDatabase.class)
public class MobUser extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    int id = 0;

    @Column
    String name;

    @Column
    int age;


    public void InsertData(String Name, int Age ){

        this.name = Name;
        this.age = Age;
    }


    public int GetId(){
        return id;
    }

    public String GetName(){
        return name;
    }

    public int GetAge(){
        return age;
    }



}
