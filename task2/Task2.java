package exceptionsSeminar2.task2;

/**
 * Обработайте возможные исключительные ситуации. "Битые" значения
 * в исходном массиве считайте нулями. Можно внести в код правки,
 * которые считаете необходимыми
 */
public class Task2 {
    public static void main(String[] args) {
        String[][] arr0 = new String[][] {
                {"1", "1", "1", "1", "1"},
                {"1", "1", "1", "1", "1"},
                {"1", "1", "1", "1", "1"},
                {"1", "1", "1", "1", "1"},
                {"1", "1", "1", "1", "1"}
        };

        String[][] arr = new String[][] {
                {"1", "1"},
                {"1", "1", "1", "1", "1"},
                {"1", "2"},
                {"3", "3"},
                {"2", "r"}
        };

        System.out.println(sum2d(arr));
    }

    private static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                String s = arr[i][j];
//                if (s.matches("[\\d]")) {
//                    System.out.println(sum);
//                    double val = Double.parseDouble(s);
//                    sum += val;
//                } else {
//                    throw new RuntimeException("Невалидные данные!");
//                }

                try {
                    System.out.println(sum);
                    double val = Double.parseDouble(s);
                    sum += val;
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Невалидные данные!");
                }
            }
        }
        return sum;
    }
}
