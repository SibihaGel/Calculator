import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args)
            throws Exception {

        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        char action;
        String[] data;  // Создаем массив.

        if (exp.contains(" + ")) {
            data = exp.split(" \\+ "); // Делим строку на +
            action = '+';
        } else if (exp.contains(" - ")) {
            data = exp.split(" - ");    // на минус
            action = '-';
        } else if (exp.contains(" * ")) {
            data = exp.split(" \\* ");  // на *
            action = '*';
        } else if (exp.contains(" / ")) {   // на /
            data = exp.split(" / ");
            action = '/';
        } else {
            throw new Exception("Некорректный знак действия");
        }
        if (data[0].length() > 10)
            throw new Exception("Введено больше 10 символов");

        if (data[1].length() > 10)
            throw new Exception("Введено больше 10 символов");
        //if (action == '+') {
        if (data[0].contains(".")) throw new Exception("ERROR");
        if (data[0].contains(",")) throw new Exception("ERROR");
        if (data[1].contains(".")) throw new Exception("ERROR");
        if (data[1].contains(",")) throw new Exception("ERROR");
        //  }

        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }
        if (action == '+') {

            if (Pattern.matches("[0-9]+", data[0]) == true) {

                if (Pattern.matches("[a-zA-Z]+", data[1]) == true) {

                    throw new RuntimeException();

                }  if (Pattern.matches("[а-яёА-ЯЁ]+", data[1]) == true) {

                    throw new RuntimeException();
                }
            }
            printInQuotes(data[0] + data[1]);

        } else
        if (action == '*') {

            int multiplier = Integer.parseInt(data[1]);
            String result = "";

            for (int i = 0; i < multiplier; i++) {
                result += data[0]; }
            printInQuotes(result);
        } else
        if (action == '-') {
            int index = data[0].indexOf(data[1]); //
            if (index == -1) {
                printInQuotes(data[0]);
            } else {
                String result = data[0].substring(0, index); // вычитает значение подстроки от 0 по index (знака -)
                result += data[0].substring(index + data[1].length()); // Возвращает значение с начала index по значение 2 включительно
                printInQuotes(result);
            }
        } else {
            int newLen = data[0].length() / Integer.parseInt(data[1]);
            String result = data[0].substring(0, newLen);
            printInQuotes(result);
        }
    }
    static void printInQuotes(String text) {

        if (text.length() > 40) {
            String rez = text.substring(0, 40);
            System.out.println("\"" + rez + "..." + "\"");
        } else {
            System.out.println("\"" + text + "\"");
        }
    }
}