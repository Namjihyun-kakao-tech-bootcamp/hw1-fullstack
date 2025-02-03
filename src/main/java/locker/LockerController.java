package locker;

import locker.view.LockerView;

public class LockerController {

    private final LockerView lockerView;
    private final LockerService lockerService;

    public LockerController(LockerView lockerView, LockerService lockerService) {
        this.lockerView = lockerView;
        this.lockerService = lockerService;
    }

    public void play() {
        while (true) {
            lockerView.writeGreeting();
            int choice = selectMenu();

            if (choice == 1) {
                lock();
            } else if (choice == 2) {
                unlock();
            } else if (choice == 3) {
                exit();
                break;
            }
        }
    }

    private int selectMenu() {
        try {
            lockerView.writeMenu();
            lockerView.writeMenuCommand();
            return lockerView.readMenuInput();
        } catch (RuntimeException e) {
            lockerView.show("\n" + e.getMessage() + "\n");
            return selectMenu();
        }
    }

    private void lock() {
        lockerView.show(lockerView.status(lockerService.getEmptyLockerIds()));
        readUntilValid();
    }

    private void readUntilValid() {
        try {
            lockerView.writeLockerNumberCommand();
            //
            lockerService.lock(1L);
        } catch (RuntimeException e) {
            lockerView.show("\n" + e.getMessage() + "\n");
            readUntilValid();
        }
    }

    private void unlock() {
        //
    }

    private void exit() {
        lockerView.writeExit();
    }
}
