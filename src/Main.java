import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int win = 0;
        int loss = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество кругов: ");
        int games = scanner.nextInt();
        System.out.println("W - победа, L - поражение");
        while (games > (win + loss)) {
            int[] doors = randomDoors();
            System.out.println("_____________________________________");
            System.out.println("Круг " + (win + loss));
            System.out.println("Выберите дверь: ");
            System.out.println("[X],[X],[X]");
            int door = scanner.nextInt() - 1;
            ArrayList<Integer> twoDoors = new ArrayList<>();

            for (int i = 0; i < doors.length; i++) {
                if (i != door) {
                    twoDoors.add(i);
                }
            }
            Integer[] twoDoorsArr = twoDoors.toArray(new Integer[2]);

            if (doors[twoDoorsArr[0]] == 0) {
                doors[twoDoorsArr[0]] = -1;
            } else {
                doors[twoDoorsArr[1]] = -1;
            }

            System.out.println("Мы открыли одну из дверей, за ней ничего нет, хотите ли вы игменить выбор?");

            String[] openDoor = new String[3];

            for (int i = 0; i < doors.length; i++) {
                if (doors[i] >= 0) {
                    openDoor[i] = "X";
                } else {
                    openDoor[i] = "O";
                }
            }

            System.out.println("[" + openDoor[0] + "],[" + openDoor[1] + "],[" + openDoor[2] + "]");

            System.out.println("Выберите дверь:");
            door = scanner.nextInt() - 1;
            if (doors[door] == 1) {
                System.out.println("Вы выиграли");
                win++;
            } else {
                System.out.println("Вы проиграли");
                loss++;
            }
        }
        System.out.println("Побед: " + win);
        System.out.println("Поражений: " + loss);
    }


    static int[] randomDoors() {
        int[] doors = new int[3];
        int[] arr = {0, 0, 0, 1};
        Random random = new Random();

        for (int i = 0; i < arr.length - 1; i++) {
            int index = random.nextInt(i + 1, arr.length);
            int tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }

        System.arraycopy(arr, 0, doors, 0, doors.length);

        return doors;
    }
}