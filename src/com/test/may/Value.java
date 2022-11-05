package com.test.may;

public class Value {

    Type type;

    public int valueInt;

    public String valueString;
    public String name;

    public boolean valueBoolean;

    Value(Type type, String name, int number) {

        this.valueInt = number;
        this.type = type;
        this.name = name;
    }

    Value(Type type, String name, String text) {

        this.valueString = text;
        this.type = type;
        this.name = name;
    }

    Value(Type type, String name, boolean booleanValue) {

        this.valueBoolean = booleanValue;
        this.type = type;
        this.name = name;
    }
}
