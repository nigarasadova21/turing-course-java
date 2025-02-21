package algorithms;

import java.util.stream.Collectors;
import java.util.List;


public class MobileNumberFormatter {
    public static void main(String[] args) {
        List<String> numbers = List.of("0501234567", "0559876543", "0707654321");

//        List<String> formattedNumbers = numbers.stream()
        String formattedNumbers = numbers.stream()
                .map(number -> number.startsWith("0") ? "+994" + number.substring(1) : number)
//                .collect(Collectors.toList());
//
//        formattedNumbers.forEach(System.out::println);
                .collect(Collectors.joining(","));
        System.out.println(formattedNumbers);
    }
}

