package pl.memoryGame.Calculator;

import java.util.Scanner;

public class Calculate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj x:");
        int x = scanner.nextInt();
        System.out.println("Podaj y:");
        int y = scanner.nextInt();

        System.out.println("Wynik dodawania: " + new Add().evaluate(x, y));
        System.out.println("Wynik odejmowania: " + new Subtract().evaluate(x, y));
        System.out.println("Wynik mnozenia: " + new Multiply().evaluate(x, y));
        System.out.println("Wynik dzielenia: " + new Divide().evaluate(x, y));
    }
}
