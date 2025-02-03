package locker.view;

import java.util.List;
import java.util.Scanner;

public abstract class LockerView extends View {

    private static final String DIVIDER = "=====================";

    public static final String passwordSuccess = "보관함이 열렸습니다.\n";

    public int readMenuInput() {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        validateMenuInput(answer);
        return Integer.parseInt(answer);
    }

    private void validateMenuInput(String input) {
        int number = Integer.parseInt(input);
        if (number < 1 || number > 3) {
            throw new IllegalArgumentException("올바른 선택지가 아닙니다.");
        }
    }

    public String readPasswordInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void writeGreeting() {
        this.show("\n안녕하세요.\n물품 보관함 서비스입니다.\n");
    }

    public void writeMenu() {
        this.show(DIVIDER + "\n1. 물품 보관\n2. 물품 회수\n3. 종료\n" + DIVIDER + "\n");
    }

    public void writeExit() {
        this.show(DIVIDER + "\n서비스를 종료합니다.\n감사합니다.\n");
    }

    public void writeMenuCommand() {
        this.show("원하는 동작을 선택하세요 >> ");
    }

    public void writePasswordInputCommand() {
        this.show("암호를 입력하세요 >> ");
    }

    public abstract String status(Long col, List<Long> occupiedLockerIds);
}
