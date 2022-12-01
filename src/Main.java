import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str;
        System.out.print("Введите выражение для счета: ");
        str = in.nextLine(); // считывание строки с клавиатуры.
        String[] expression = str.split(" "); // разбиение строки на символы с помощью пробела.
        if (isCorrectArab(expression)) {
            getArabResult(expression);
        } else if (isCorrectRoman(expression)) {
            getRomanResult(expression);
        }
        in.close();
    }

    static boolean isCorrectArab(String[] string) {
        // проверка строки на наличие ДВУХ арабских цифр.
        String[] arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        int count = 0;

        if (string.length != 3) {
            throw new RuntimeException("throws Exception");
        }

        for (int i = 0; i < arab.length; i++) {
            if (string[0].equals(arab[i])) {
                count++;
            }
            if (string[2].equals(arab[i])) {
                count++;
            }
        }

        if (count == 2) {
            return true;
        } else {
            return false;
        }


    }

    static boolean isCorrectRoman(String[] string) {
        // Проверка строки на наличие ДВУХ римских цифер.
        if (string.length != 3) {
            throw new RuntimeException("throws Exception");
        }
        try {
            int num1 = Roman.valueOf(string[0]).getTranslation();
            int num2 = Roman.valueOf(string[2]).getTranslation();
            return true;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("throws Exception");
        }
    }

    static int mathAction(int num1, int num2, String[] action) {
        // математические операции над числами.
        int res;
        String math_action = action[1];
        switch (math_action) {
            case "+":
                res = num1 + num2;
                break;
            case "-":
                res = num1 - num2;
                break;
            case "*":
                res = num1 * num2;
                break;
            case "/":
                res = num1 / num2;
                break;
            default:
                throw new RuntimeException("throws Exception");
        }
        return res;
    }


    static void getArabResult(String[] expression) {
        int first_number, second_number;
        first_number = Integer.parseInt(expression[0]);
        second_number = Integer.parseInt(expression[2]);
        int result = mathAction(first_number, second_number, expression);
        System.out.println("Результат: " + result);
    }

    static void getRomanResult(String[] expression) {
        int first_number, second_number;
        first_number = Roman.valueOf(expression[0]).getTranslation();
        second_number = Roman.valueOf(expression[2]).getTranslation();
        if (first_number > 10 | first_number < 1 | second_number > 10 | second_number < 1) {
            throw new RuntimeException("throws Exception");
        }
        int result = mathAction(first_number, second_number, expression);
        System.out.println("Результат: " + Roman.getByValue(result));
    }
}


