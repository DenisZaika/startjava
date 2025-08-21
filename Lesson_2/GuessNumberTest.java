import java.util.Scanner;

public class GuessNumberTest {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите имя первого игрока: ");
        String name1 = scan.nextLine();
        Player player1 = new Player(name1);

        System.out.print("Введите имя второго игрока: ");
        String name2 = scan.nextLine();
        Player player2 = new Player(name2);

        GuessNumber game = new GuessNumber(player1, player2);
        String playerAnswer;

        do {
            game.start();
            do {
                System.out.print("Хотите продолжить игру? [yes/no]: ");
                playerAnswer = scan.nextLine();
            } while (!"yes".equals(playerAnswer) && !"no".equals(playerAnswer));
        } while ("yes".equals(playerAnswer));
    }
}