package locker.repository;

import locker.model.Locker;

import java.util.List;

public interface LockerRepository {

    Locker getLocker(Long id);
    Long saveLocker(Locker locker);
    List<Locker> getOccupiedLockers();
}
