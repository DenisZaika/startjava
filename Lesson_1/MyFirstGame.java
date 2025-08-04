import java.util.Random;

public class MyFirstGame {
    public static void main(String[] args) {
        Random random = new Random();
        int secretNumber = random.nextInt(1, 101);
        int playerAnswer = 0;
        int lowerLimit = 1;
        int upperLimit = 101;
        while (secretNumber != playerAnswer) {
            playerAnswer = random.nextInt(lowerLimit, upperLimit);
            System.out.printf("Ответ игрока: %d%n", playerAnswer);
            if (playerAnswer < secretNumber) {
                System.out.printf("%d меньше того, что загадал компьютер%n%n", playerAnswer);
                lowerLimit = playerAnswer + 1;
            } else if (playerAnswer > secretNumber) {
                System.out.printf("%d больше того, что загадал компьютер%n%n", playerAnswer);
                upperLimit = playerAnswer;
            }
        }
        System.out.println("Вы победили!");
    }
}