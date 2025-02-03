package locker;

import locker.model.Locker;
import locker.model.OccupiedLocker;
import locker.repository.LockerRepository;
import locker.util.DateTimeGenerator;
import locker.util.PasswordGenerator;

public class LockerService {

    private final PasswordGenerator passwordGenerator;
    private final DateTimeGenerator dateTimeGenerator;
    private final LockerRepository lockerRepository;

    public LockerService(PasswordGenerator passwordGenerator, DateTimeGenerator dateTimeGenerator, LockerRepository lockerRepository) {
        this.passwordGenerator = passwordGenerator;
        this.dateTimeGenerator = dateTimeGenerator;
        this.lockerRepository = lockerRepository;
    }

    public Long lock(Long lockerId) {
        Locker existingLocker = lockerRepository.getLocker(lockerId);
        lockerRepository.replaceLocker(new OccupiedLocker(
                lockerId, existingLocker.getSize(), dateTimeGenerator.generate(), passwordGenerator.generate()
        ));
        return lockerId;
    }

    public Long unlock(Long lockerId) {
        Locker existingLocker = lockerRepository.getLocker(lockerId);
        lockerRepository.replaceLocker(new Locker(lockerId, existingLocker.getSize()));
        return lockerId;
    }
}
