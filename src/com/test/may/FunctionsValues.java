package com.test.may;

import java.util.ArrayList;
import java.util.List;

public class FunctionsValues {

    public static List<Function> functions = new ArrayList<>();
    public static List<Value> values = new ArrayList<>();

    public static String getStringValueByValueName(String name) {

        for (Value i : values) {

            if (i.name.equals(name)) {

                return i.valueString;
            }
        }

        return "error";
    }

    public static int getIntegerValueByValueName(String name) {

        for (Value i : values) {

            if (i.name.equals(name)) {

                return i.valueInt;
            }
        }

        return 0;
    }
}
