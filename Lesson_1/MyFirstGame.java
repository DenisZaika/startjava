import java.util.Random;

public class MyFirstGame {
    public static void main(String[] args) {
        Random random = new Random();
        int secretNumber = random.nextInt(1, 101);
        int playerAnswer = 0;
        int start = 1;
        int rangeLimit = 101;
        while (secretNumber != playerAnswer) {
            playerAnswer = random.nextInt(start, rangeLimit);
            System.out.printf("Ответ игрока: %d%n", playerAnswer);
            if (playerAnswer < secretNumber) {
                System.out.printf("%d меньше того, что загадал компьютер%n%n", playerAnswer);
                start = playerAnswer + 1;
            } else if (playerAnswer > secretNumber) {
                System.out.printf("%d больше того, что загадал компьютер%n%n", playerAnswer);
                rangeLimit = playerAnswer;
            }
        }
        System.out.println("Вы победили!");
    }
}