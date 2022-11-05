package com.test.may;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GetCode {

    public static String one() {

        StringBuilder text = new StringBuilder();

        System.out.println("Напишите \"...\" без кавычек для завершения ");

        boolean pass = false;

        do {

            int num = 0;

            String line = Main.scanner.nextLine();
            text.append(line).append("\n");

            char[] lineList = line.toCharArray();

            for (Character i : lineList) {

                if (i.toString().equals(".")) {

                    num++;

                } else if (num == 3) {

                    pass = true;
                    break;

                } else {

                    num = 0;
                }
            }

        } while (!pass);

        return text.toString();
    }

    public static String two() throws FileNotFoundException {

        StringBuilder text = new StringBuilder();

        Scanner input = new Scanner(System.in);

        String path = input.nextLine();

        File file = new File(path);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {

            String next = scanner.nextLine();

            text.append(next).append("\n");
        }

        return String.valueOf(text);
    }
}
