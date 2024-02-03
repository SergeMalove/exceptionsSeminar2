package exceptionsSeminar2.task3;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Запишите в файл следующие строки:
 *
 * Анна=4
 * Елена=5
 * Марина=6
 * Владимир=?
 * Полина=?
 * Константин=?
 * Иван=4
 *
 * Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив (либо HashMap,
 * если студенты с ним знакомы). В отдельном методе нужно будет пройти по структуре данных,
 * если сохранено значение ?, заменить его на соответствующее число.Если на каком-то месте
 * встречается символ, отличный от числа или ?, бросить подходящее исключение.
 * Записать в тот же файл данные с замененными символами ?.
 */
public class Task3 {
    private static final List<String> strings = List.of
            ("Анна=4", "Елена=5", "Марина=6", "Полина=?", "Владимир=?", "Константин=?", "Иван=4");
    //для проверки, заменить какое-то из значений на null

    public static void main(String[] args) {
        fileWrite("Task3.txt", strings);
        System.out.println(fileRead("Task3.txt"));
        fileRewrite("Task3.txt");
    }

    public static void fileWrite(String path, List<String> strings) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(path);
            for (String s: strings) {
                fw.write(s + "\n");
            }
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Map<String, Integer> fileRead(String path) {
        Map<String, Integer> names = new HashMap<>();
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(path));
            String line;

            while ((line = bf.readLine()) != null) {
                String[] split = line.split("=");
                String key = split[0];
                String temp = split[1];
                int value;
                try {
                    value = temp.equals("?") ? key.length() : Integer.parseInt(temp);
                } catch (NumberFormatException e) {
                    value = key.length();
                }
//                if (temp.equals("?")) {
//                    value = key.length();
//                } else if (temp.matches("[\\d]")) {
//                    value = Integer.parseInt(temp);
//                } else {
//                    value = key.length();
//                }
                names.put(key, value);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Невалидные данные");
        }
        finally {
            try {
                bf.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return names;
    }

    public static void fileRewrite(String path) {
        Map<String, Integer> names = fileRead(path);
        List<String> arr = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : names.entrySet()) {
            arr.add(entry.toString());
        }
        fileWrite(path, arr);
    }
}