package locker;

import locker.util.DateTimeGenerator;
import locker.util.PasswordGenerator;

public class LockerService {

    private final PasswordGenerator passwordGenerator;
    private final DateTimeGenerator dateTimeGenerator;

    public LockerService(PasswordGenerator passwordGenerator, DateTimeGenerator dateTimeGenerator) {
        this.passwordGenerator = passwordGenerator;
        this.dateTimeGenerator = dateTimeGenerator;
    }
}
