package locker.view;

import java.util.List;

public abstract class OutputView {

    public void show(String message) {
        System.out.println(message);
    }

    public String greet() {
        return "안녕하세요. 물품 보관함 서비스입니다.";
    }

    public String menu() {
        return "\n메뉴를 선택해 주세요.\n===================\n1. 물품 보관\n2. 물품 회수\n3. 종료\n===================\n";
    }

    public abstract String status(Long col, List<Long> occupiedLockerIds);
}
