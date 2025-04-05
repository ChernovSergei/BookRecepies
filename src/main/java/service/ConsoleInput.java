package service;

import java.util.Scanner;

public class ConsoleInput implements Input {
    Scanner scanner = new Scanner(System.in);

    @Override
    public String askString(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    @Override
    public int askInteger(String question) {
        System.out.println(question);
        return Integer.parseInt(scanner.nextLine());
    }
}
