package pl.memoryGame.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LambdaMorse {

    public static String[] alpha = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
            "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "0", " "};
    public static String[] dottie = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
            "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----", "|"};


    public static String convertToMorse(String text) {

        String collect = IntStream.range(0, (text.length())).boxed().map(text::charAt)
                .map(x -> Character.toChars(x)[0])
                .map(x -> Arrays.stream(alpha)
                        .map(y -> new String[]{y, Integer.toString(
                                IntStream.range(0, alpha.length).boxed()
                                        .filter(z -> alpha[z].equals(y)).findFirst().get())})
                        .filter(y -> y[0].toCharArray()[0] == (x))
                        .findFirst())
                .map(x -> dottie[Integer.parseInt(x.get()[1])])
                .collect(Collectors.joining(":"));

        return collect;
    }

    public static String convertToText(String morseString) {

        morseString.split(":");

        String collect = IntStream.range(0, morseString.split(":").length).boxed()
                .map(x -> new String[]{morseString.split(":")[x], Integer.toString(
                        IntStream.range(0, dottie.length).boxed()
                                .filter(y -> dottie[y].equals(morseString.split(":")[x])).findFirst().get())})
                .map(x -> alpha[Integer.parseInt(x[1])])
                .collect(Collectors.joining());

        return collect;

    }

    public static void main(String[] args) {
        String morseText = LambdaMorse.convertToMorse("aabbbddcc");
        String text = LambdaMorse.convertToText(morseText);

        System.out.println(morseText);
        System.out.println(text);

    }
}
