package locker.view;

import java.util.List;
import java.util.Scanner;

public abstract class LockerView extends View {

    public String greet() {
        return "===================\n안녕하세요.\n물품 보관함 서비스입니다.\n";
    }

    public String menu() {
        return "===================\n1. 물품 보관\n2. 물품 회수\n3. 종료\n===================\n";
    }

    public String selectionCommand() {
        return "원하는 동작을 선택하세요 >> ";
    }

    public int readMenuSelection() {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        validateMenuSelection(answer);
        return Integer.parseInt(answer);
    }

    private void validateMenuSelection(String selection) {
        int number = Integer.parseInt(selection);
        if (number < 1 || number > 3) {
            throw new IllegalArgumentException("올바른 선택지가 아닙니다.");
        }
    }

    public String passwordCommand() {
        return "암호를 입력하세요 >> ";
    }

    public String readPasswordInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public abstract String status(Long col, List<Long> occupiedLockerIds);
}
