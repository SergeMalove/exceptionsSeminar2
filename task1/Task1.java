package exceptionsSeminar2.task1;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Изучите данный код. Все ли с ним хорошо? Если нет,
 * скорректируйте код, попробуйте обосновать свое решение.
 */
public class Task1 {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println(
                "Укажите индекс элемента массива, " +
                        "в который хотите записать значение 1");
        int index = 0;
        if (scanner.hasNextInt()) {
            index = scanner.nextInt();
        } else {
            System.out.println("Неверный формат данных.");
        }

        try {
            arr[index] = 1;
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Указан индекс за пределами массива");
        }
    }
}
