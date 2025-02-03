package locker;

import locker.model.Locker;
import locker.model.OccupiedLocker;
import locker.repository.LockerRepository;
import locker.util.DateTimeGenerator;
import locker.util.PasswordGenerator;

import java.time.Duration;

public class LockerService {

    private final PasswordGenerator passwordGenerator;
    private final DateTimeGenerator dateTimeGenerator;
    private final LockerRepository lockerRepository;

    public LockerService(PasswordGenerator passwordGenerator, DateTimeGenerator dateTimeGenerator, LockerRepository lockerRepository) {
        this.passwordGenerator = passwordGenerator;
        this.dateTimeGenerator = dateTimeGenerator;
        this.lockerRepository = lockerRepository;
    }

    public String lock(Long lockerId) {
        Locker existingLocker = lockerRepository.getLocker(lockerId);
        lockerRepository.replaceLocker(new OccupiedLocker(
                lockerId, existingLocker.getSize(), dateTimeGenerator.generate(), passwordGenerator.generate()
        ));
        return passwordGenerator.generate();
    }

    public Long unlock(Long lockerId, String passwordInput) {
        OccupiedLocker existingLocker = (OccupiedLocker) lockerRepository.getLocker(lockerId);
        if (!existingLocker.matchPassword(passwordInput)) {
            throw new IllegalStateException("틀린 암호입니다.");
        }
        Long fee = existingLocker.calculateFee(Duration.between(existingLocker.getCreatedAt(), dateTimeGenerator.generate()).toMinutes());
        lockerRepository.replaceLocker(new Locker(lockerId, existingLocker.getSize()));
        return fee;
    }
}
