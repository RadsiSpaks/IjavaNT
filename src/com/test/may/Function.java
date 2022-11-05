package com.test.may;

import java.util.List;

public class Function {

    List<Arg> args;
    Type returnType;
    String funcName;
    APieceOfCode aPieceOfCode;

    Function(List<Arg> args, Type returnType, String funcName, APieceOfCode aPieceOfCode) {

        this.args = args;
        this.returnType = returnType;
        this.funcName = funcName;
        this.aPieceOfCode = aPieceOfCode;
    }
}
