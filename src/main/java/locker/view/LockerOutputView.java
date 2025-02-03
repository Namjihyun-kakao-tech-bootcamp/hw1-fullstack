package locker.view;

import java.util.List;

public class LockerOutputView extends OutputView {

    public String status(Long col, List<Long> occupiedLockerIds) {
        StringBuilder message = new StringBuilder("\n보관함의 현재 상태는 다음과 같습니다.\n");
        Long idx = 1L;

        addHorizontalLine(col, message);
        message.append("\n|");

        idx = addIdIfEmpty(col, occupiedLockerIds, idx, message);
        message.append("\n");

        addHorizontalLine(col-2, message);
        message.append("|").append("       |".repeat(2)).append("\n|");

        idx = addIdIfEmpty(col-2, occupiedLockerIds, idx, message);
        addVerticalLines(2L, message);
        message.append("\n");

        addHorizontalLine(col, message);
        message.append("\n|");

        idx = addIdIfEmpty(col, occupiedLockerIds, idx, message);
        message.append("\n");

        addHorizontalLine(col-2, message);
        message.append("|").append("       |".repeat(2)).append("\n|");

        addIdIfEmpty(col-2, occupiedLockerIds, idx, message);
        addVerticalLines(2L, message);
        message.append("\n|");

        addVerticalLines(col, message);
        message.append("\n|");

        addVerticalLines(col, message);
        message.append("\n");

        addHorizontalLine(col, message);
        message.append("\n");

        return message.toString();
    }

    private Long addIdIfEmpty(Long count, List<Long> occupiedLockerIds, Long idx, StringBuilder message) {
        for (int i = 0; i < count; i++) {
            if (occupiedLockerIds.contains(idx)) {
                message.append("  ").append(String.format("%2s", "X")).append("   |");
            } else {
                message.append("  ").append(String.format("%2d", idx)).append("   |");
            }
            idx++;
        }
        return idx;
    }

    private void addVerticalLines(Long count, StringBuilder message) {
        for (int i=0; i<count; i++) {
            message.append("       |");
        }
    }

    private void addHorizontalLine(Long count, StringBuilder message) {
        for (int i = 0; i< count; i++) {
            message.append(" ------ ");
        }
    }
}
