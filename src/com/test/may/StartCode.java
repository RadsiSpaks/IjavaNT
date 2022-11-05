package com.test.may;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartCode {

    public void start(String text) {

        Scanner scanner = new Scanner(text);

        StringBuilder resultLinesStringBuilder = new StringBuilder();

        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            char [ ] lineList = line.toCharArray();

            boolean pass = false;

            List<String> resultLineList = new ArrayList<>();

            for (Character i : lineList) {

                if (i.toString().equals(" ")) {

                    if (pass) {

                        resultLineList.add(i.toString());
                    }

                } else {

                    pass = true;
                    resultLineList.add(i.toString());
                }
            }

            StringBuilder resultLineSB = new StringBuilder();

            for (String i : resultLineList) {

                resultLineSB.append(i);
            }

            String resultLine = resultLineSB.toString();
            resultLinesStringBuilder.append(resultLine).append("\n");
        }

        String text2 = resultLinesStringBuilder.toString();

        Scanner scanner2 = new Scanner(text2);

        while (scanner2.hasNext()) {

            String next2 = scanner2.nextLine();

            if (next2.startsWith("writelnstr")) {

                Write.WriteStrClass.wls(next2);

            } else if (next2.startsWith("string")) {

                AddValue.AddStringValue.asv(next2);

            } else if (next2.startsWith("integer")) {

                AddValue.AddStringValue.aiv(next2);

            } else if (next2.startsWith("str %")) {

                AddValue.AddStringValue.rsv(next2);

            } else if (next2.startsWith("int %")) {

                AddValue.AddStringValue.riv(next2);

            } else if (next2.startsWith("//")) {

                continue;

            }
        }
    }

    private static class AddValue {

        public static class AddStringValue {

            public static void aorsoiv(String next2, boolean pass, Type type) {

                if (pass) {

                    if (type == Type.STRING) {

                        next2 = next2.replace("string ", "");

                    } else if (type == Type.INT) {

                        next2 = next2.replace("integer ", "");

                    }

                } else {

                    if (type == Type.STRING) {

                        next2 = next2.replace("str ", "");

                    } else if (type == Type.INT) {

                        next2 = next2.replace("int ", "");

                    }
                }

                char [ ] next2List = next2.toCharArray();

                StringBuilder nameStringBuilder = StartCompilation.getUpTo(" ", next2List);
                String name = String.valueOf(nameStringBuilder);

                name = name.replace("%", "");

                next2 = next2.replace(name, "");
                next2List = next2.toCharArray();

                boolean inQuotationMarks = false;
                StringBuilder text = new StringBuilder();

                for (Character i3 : next2List) {

                    // Тест то что текст в кавычках.

                    if (i3.toString().equals("\"")) {

                        inQuotationMarks = !inQuotationMarks; // Изменяем переменную inQuotationMarks на ее противоположность.
                    }

                    // Убираем лишние пробелы

                    if (!(i3.toString().equals(" ") && !inQuotationMarks)) {

                        text.append(i3);
                    }
                }

                String text2 = text.toString();
                text2 = text2.replace("%", "");

                text2 = text2.replace("=","");
                text2 = text2.replace(";","");

                String valueString = null;
                int valueInt = 0;

                if (type == Type.STRING) {

                    valueString = Write.WriteStrClass.writelnstr3(text2, false, true);

                } else if (type == Type.INT) {

                    valueInt = Main.getPrimaryValue(text2);
                }

                Value value = null;

                if (type == Type.STRING) {

                    value = new Value(type, name, valueString);

                } else if (type == Type.INT) {

                    value = new Value(type, name, valueInt);

                }


                if (pass) {

                    FunctionsValues.values.add(value);

                } else {

                    for (Value i : FunctionsValues.values) {

                        if (i.name.equals(name)) {

                            if (type == Type.STRING) {

                                i.valueString = valueString;

                            } else if (type == Type.INT) {

                                i.valueInt = valueInt;

                            }

                            break;
                        }
                    }
                }
            }

            public static void rsv(String next2) {

                aorsoiv(next2, false, Type.STRING);
            }

            public static void asv(String next2) {

                aorsoiv(next2, true, Type.STRING);
            }

            public static void riv(String next2) {

                aorsoiv(next2, false, Type.INT);
            }

            public static void aiv(String next2) {

                aorsoiv(next2, true, Type.INT);
            }
        }
    }

    private static class Write {

        public static class WriteStrClass {

            public static void wls(String next3) {

                writelnstr(next3, true);
            }

            private static void writelnstr(String next3, boolean ln) {

                next3 = next3.replace("writelnstr", "");
                next3 = next3.replace("(", "");
                next3 = next3.replace(")", "");
                next3 = next3.replace(";", "");

                char [ ] next3List = next3.toCharArray();

                writelnstr2(next3List, ln);
            }

            private static void writelnstr2(char [ ] next3List, boolean ln) {

                boolean inQuotationMarks = false;
                StringBuilder text = new StringBuilder();

                for (Character i3 : next3List) {

                    // Тест то что текст в кавычках.

                    if (i3.toString().equals("\"")) {

                        inQuotationMarks = !inQuotationMarks; // Изменяем переменную inQuotationMarks на ее противоположность.
                    }

                    // Убираем лишние пробелы

                    if (!(i3.toString().equals(" ") && !inQuotationMarks)) {

                        text.append(i3);
                    }
                }

                writelnstr3(text.toString(), ln, false);
            }

            public static String writelnstr3(String text, boolean ln, boolean pass) {

                String text2 = text;
                String [ ] list = text2.split("\\+");

                List<String> lines = new ArrayList<>();

                for (String i : list) {

                    char [ ] listI = i.toCharArray();

                    for (Character iListI : listI) {

                        if (iListI.toString().equals("\"")) {

                            String i2 = i;
                            i2 = i2.replace("\"", "");

                            lines.add(i2);

                        } else if (iListI.toString().equals("%")) {

                            String nameValue = i.replace("%", "");
                            String value = FunctionsValues.getStringValueByValueName(nameValue);

                            int value2 = 828364638;

                            if (value == null) {

                                value2 = FunctionsValues.getIntegerValueByValueName(nameValue);
                            }

                            if (value2 == 828364638) {

                                lines.add(value);

                            } else {

                                lines.add(String.valueOf(value2));

                            }
                        }

                        break;
                    }
                }

                StringBuilder printStringBuilder = new StringBuilder();

                for (String line : lines) {

                    printStringBuilder.append(line);
                }

                String print = printStringBuilder.toString();

                if (pass) {

                    return print;
                }

                if (ln) {

                    System.out.println(print);

                } else {

                    System.out.print(print);
                }

                return print;
            }
        }
    }
}