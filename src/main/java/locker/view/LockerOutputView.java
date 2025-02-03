package locker.view;

import java.util.List;

public final class LockerOutputView extends LockerView {

    private StringBuilder message;
    private Long idx;

    public String status(Long col, List<Long> occupiedLockerIds) {
        this.idx = 1L;
        this.message = new StringBuilder("\n보관함의 현재 상태는 다음과 같습니다.\n\n");

        addHorizontalLine(col);
        message.append("\n|");

        addIdIfEmpty(col, occupiedLockerIds);
        message.append("\n");

        addHorizontalLine(col-2);
        message.append("|");
        addVerticalLines(2L);
        message.append("\n|");

        addIdIfEmpty(col-2, occupiedLockerIds);
        addVerticalLines(2L);
        message.append("\n");

        addHorizontalLine(col);
        message.append("\n|");

        addIdIfEmpty(col, occupiedLockerIds);
        message.append("\n");

        addHorizontalLine(col-2);
        message.append("|");
        addVerticalLines(2L);
        message.append("\n|");

        addIdIfEmpty(col-2, occupiedLockerIds);
        addVerticalLines(2L);
        message.append("\n|");

        addVerticalLines(col);
        message.append("\n|");

        addVerticalLines(col);
        message.append("\n");

        addHorizontalLine(col);
        message.append("\n");

        return message.toString();
    }

    private void addIdIfEmpty(Long count, List<Long> occupiedLockerIds) {
        for (int i = 0; i < count; i++) {
            if (occupiedLockerIds.contains(idx)) {
                message.append("  ").append(String.format("%2s", "X")).append("   |");
            } else {
                message.append("  ").append(String.format("%2d", idx)).append("   |");
            }
            idx++;
        }
    }

    private void addVerticalLines(Long count) {
        for (int i=0; i<count; i++) {
            message.append("       |");
        }
    }

    private void addHorizontalLine(Long count) {
        for (int i = 0; i< count; i++) {
            message.append(" ------ ");
        }
    }
}
