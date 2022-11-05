package com.test.may;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartCompilation {

    String text;

    StartCompilation(String text) {

        this.text = text;
    }

    public void go() {

        Scanner scanner = new Scanner(text);

        int line = 0;

        while (scanner.hasNext()) {

            line++;

            String next = scanner.nextLine();
            String next2 = next.replace(" ", "");
            String next3 = next;

            if (next2.startsWith("func")) {

                next3 = next3.replace("func ", "");
                char [ ] next3List = next3.toCharArray();

                StringBuilder typeStringBuilder = getUpTo(" ", next3List);
                String typeString = String.valueOf(typeStringBuilder);

                Type type = stringToType(typeString);

                next3 = next3.replace(typeString + " ", "");

                next3List = next3.toCharArray();
                StringBuilder nameStringBuilder = getUpTo("(", next3List);

                String nameString = nameStringBuilder.toString().replace(" ", "");

                next3 = next3.replace(nameString, "");

                next3 = next3.replace(" {", "");
                next3 = next3.replace("{", "");
                next3 = next3.replace("(", "");
                next3 = next3.replace(")", "");

                String [ ] args_ = next3.split(", ");

                Scanner scanner2 = new Scanner(text);

                int curlyBrace = 0;
                int line2 = 0;

                StringBuilder textFunction = new StringBuilder();

                while (scanner2.hasNext()) {

                    line2++;
                    String next21 = scanner2.nextLine();

                    if (line2 < line) {

                        continue;
                    }

                    boolean pass;
                    pass = true;

                    char [ ] next21List = next21.toCharArray();

                    for (Character i : next21List) {

                        if (i.toString().equals("{")) {

                            curlyBrace++;

                        } else if (i.toString().equals("}")) {

                            curlyBrace--;

                        }
                    }

                    if (next21.startsWith("func")) {

                        pass = false;
                    }

                    if (curlyBrace == 0) {

                        break;
                    }

                    if (pass) {

                        textFunction.append(next21).append("\n");
                    }
                }

                APieceOfCode aPieceOfCode = new APieceOfCode(textFunction.toString());

                List<Arg> args = new ArrayList<>();

                for (String argString : args_) {

                    StringBuilder argTypeStringBuilder = getUpTo(" ", argString.toCharArray());
                    String argTypeString = String.valueOf(argTypeStringBuilder);
                    Type argType = stringToType(argTypeString);

                    String arg2 = argString;
                    arg2 = arg2.replace(argTypeString + " ", "");

                    Arg arg = new Arg(argType, arg2);

                    args.add(arg);

                    Function function = new Function(args, type, nameString, aPieceOfCode);
                    FunctionsValues.functions.add(function);
                }
            }
        }
    }

    private static Type stringToType(String typeString) {

        switch (typeString) {

            case "int" -> { return Type.INT; }
            case "string" -> { return Type.STRING; }
            case "boolean" -> { return Type.BOOLEAN; }

            default -> { return null; }
        }
    }

    public static StringBuilder getUpTo(String myChar, char [ ] next3List) {

        StringBuilder typeStringBuilder = new StringBuilder();

        for (Character i : next3List) {

            if (i.toString().equals(myChar)) {

                break;
            }

            typeStringBuilder.append(i);
        }

        return typeStringBuilder;
    }
}
