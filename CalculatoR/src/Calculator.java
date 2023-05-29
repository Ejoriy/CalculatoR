import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class Calculator {
    public static void main(String[] args) throws ActionsException, OperandsException, ProverkaException, SSException {
        String[] toRimskie = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV",
                "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV",
                "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV",
                "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV",
                "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV",
                "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV",
                "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV",
                "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
                "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C", "CI"};

        Map<String, Integer> converter = new HashMap<>();
        converter.put("I", 1);
        converter.put("II", 2);
        converter.put("III", 3);
        converter.put("IV", 4);
        converter.put("V", 5);
        converter.put("VI", 6);
        converter.put("VII", 7);
        converter.put("VIII", 8);
        converter.put("IX", 9);
        converter.put("X", 10);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пример: ");
        String phrase = scanner.nextLine().toUpperCase();
        String[] chisla = phrase.split("[+\\-*/]");
        if (!phrase.matches(".*[+\\-*/].*")) {
            throw new ActionsException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
     for (int u = 0;u<chisla.length;u++) {
      if (!chisla[u].matches("[1-9]|10") && !converter.containsKey(chisla[u])) {
          throw new OperandsException("Введенные числа не попадают в диапазон (1-10)");
      }
     }
        if (chisla[0].matches("[1-9]|10") && chisla[1].matches("[1-9]|10")) {
            int x = Integer.parseInt(chisla[0]);
            int y = Integer.parseInt(chisla[1]);
            if (phrase.contains("+")) {
                int sum = x + y;
                System.out.println();
                System.out.println("Сумма = " + sum);
            } else if (phrase.contains("-")) {
                int razn = x - y;
                System.out.println();
                System.out.println("Разность = " + razn);
            } else if (phrase.contains("*")) {
                int proiz = x * y;
                System.out.println();
                System.out.println("Произведение = " + proiz);
            } else if (phrase.contains("/")) {
                int chast = x / y;
                System.out.println();
                System.out.println("Частное = " + chast);
            }
        } else if (converter.containsKey(chisla[0]) && converter.containsKey(chisla[1])) {
            int x = converter.get(chisla[0]);
            int y = converter.get(chisla[1]);
            if (phrase.contains("+")) {
                int sum = x + y;
                for (int i = 0;i<toRimskie.length;i++){
                    if (sum==i) {
                        String sum1 = toRimskie[i-1];
                        System.out.println();
                        System.out.println("Сумма = " + sum1);
                    }
                }
            } else if (phrase.contains("-")) {
                int razn = x - y;
                if (razn<1) {
                    throw new ProverkaException("В римской системе нет отрицательных чисел");
                }
                for (int i = 0;i<toRimskie.length;i++){
                    if (razn==i) {
                        String razn1 = toRimskie[i-1];
                        System.out.println();
                        System.out.println("Разность = " + razn1);
                    }
                }
            } else if (phrase.contains("*")) {
                int proiz = x * y;
                for (int i = 0;i<toRimskie.length;i++){
                    if (proiz==i) {
                        String proiz1 = toRimskie[i-1];
                        System.out.println();
                        System.out.println("Произведение = " + proiz1);
                    }
                }
            } else if (phrase.contains("/")) {
                int chast = x / y;
                if (chast<1) {
                    throw new ProverkaException("В римской системе нет отрицательных чисел");
                }
                for (int i = 0;i<toRimskie.length;i++){
                    if (chast==i) {
                        String chast1 = toRimskie[i-1];
                        System.out.println();
                        System.out.println("Частное = " + chast1);
                    }
                }
            }
        } else {
            throw new SSException("Используются одновременно разные системы счисления");
        }
    }
}
