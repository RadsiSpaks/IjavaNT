package com.test.may;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {

        String text = "";

        System.out.println("Напишите 1 что бы писать код здесь, напишите 2 что бы указать путь к файлу в котором лежит код");
        int num = scanner.nextInt();

        System.out.println();

        switch (num) {

            case 1 -> text = GetCode.one();
            case 2 -> text = GetCode.two();
        }

        StartCompilation start = new StartCompilation(text);
        start.go();

        Start start2 = new Start();
        start2.go();
    }

    public static int getPrimaryValue(String next2) {

        return Integer.parseInt(next2);
    }
}
