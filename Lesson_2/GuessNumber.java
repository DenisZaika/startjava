import java.util.Scanner;

public class GuessNumber {

    private Player player1;
    private Player player2;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        Scanner scan = new Scanner(System.in);
        int secretNumber = (int) (Math.random() * 100 + 1);
        Player currPlayer = player1;
        do {
            int answer;
            do {
                System.out.printf("%s угадывает число: ", currPlayer.getName());
                answer = scan.nextInt();
            } while (!currPlayer.setNumber(answer));
            if (currPlayer.getNumber() == secretNumber) {
                System.out.printf("Игрок %s победил!%n", currPlayer.getName());
                return;
            }
            System.out.printf("Игрок %s не угадал число. Ход переходит к следующему игроку%n",
                    currPlayer.getName());
            currPlayer = currPlayer == player1 ? player2 : player1;
        } while (true);
    }
}