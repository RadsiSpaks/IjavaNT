package com.test.may;

public class Start {

    public void go() {

        StartCode startCode = new StartCode();

        for (Function fun : FunctionsValues.functions) {

            if ((fun.args.get(0).type + " " + fun.args.get(0).name).equals("STRING arg") && fun.returnType == null) {

                startCode.start(fun.aPieceOfCode.text);
            }
        }
    }
}
