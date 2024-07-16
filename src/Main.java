import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws IOException {
        System.out.println("Введите выражение из двух целых чисел от 1 до 10: ");
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        System.out.println("Результат: ");
        String result = calc(expression);
        System.out.println(result);
    }
        public static String calc(String input) throws IOException {
            String[] strings = input.split(" ");
            if (strings.length != 3) {
                throw new IOException("Введено неверное выражение");
           }

   boolean isRoman;
   int x = 0;
   int y = 0;
   try {
       RomanNum firstRoman = RomanNum.valueOf(strings[0]);
       RomanNum secondRoman = RomanNum.valueOf(strings[2]);
       isRoman = true;
       x = firstRoman.getArabNum();
       y = secondRoman.getArabNum();

   } catch (Exception notRoman) {
       isRoman = false;
       try {
           x = Integer.parseInt(strings[0]);
           y = Integer.parseInt(strings[2]);
       } catch (Exception e) {
           throw new IOException("Введено неверное выражение");
       } }

int result1 = 0;

switch (strings[1]) {
    case "+": result1 = x+y; break;
    case "-": result1 = x-y; break;
    case "*": result1 = x*y; break;
    case "/": result1 = x/y; break;
    default:
            throw new IOException("Введено неверное выражение");
        }
if (isRoman) {
    if (result1 < 1) {
        throw new IOException("Ошибка: результат работы с римскими числами меньше единицы");
    }
    return resultToRoman(result1);
} else {
    return String.valueOf(result1);
} }

        static String resultToRoman(int result1) {
    String[] RomanArray = new String[99];
        if (result1 == 100) {
            return "C";
        } else {
            RomanNum[] romanNumArr = RomanNum.values();


            for (int i = 0; i < 10; i++) {
                RomanArray[i] = String.valueOf(romanNumArr[i]);
            }
            for (int i = 10; i < 99; i++) {
                RomanNumTens[] romanTensArr = RomanNumTens.values();
                RomanArray[i] = String.valueOf(romanTensArr[i/10]) + String.valueOf(romanNumArr[i%10]);
            }
            return RomanArray[result1 - 1];
        }
} }





