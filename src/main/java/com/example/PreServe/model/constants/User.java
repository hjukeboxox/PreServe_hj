package com.example.PreServe.model.constants;

public enum User {

    MANAGER("Manager",0),
    PARTNER("Partner",1),
    CUSTOMER("Customer",2);


    private String s;
    private int number;


    User(String s, int number) {
        this.s = s;
        this.number = number;
    }
}
