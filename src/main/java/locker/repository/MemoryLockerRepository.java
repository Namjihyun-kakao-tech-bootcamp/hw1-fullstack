package locker.repository;

import locker.model.Locker;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

public class MemoryLockerRepository implements LockerRepository {

    private final Map<Long, Locker> lockers = new ConcurrentSkipListMap<>(Comparator.comparingLong(id -> id));

    @Override
    public Locker getLocker(Long id) {
        return lockers.get(id);
    }

    @Override
    public Long saveLocker(Locker locker) {
        return lockers.put(locker.getId(), locker).getId();
    }

    @Override
    public List<Locker> getOccupiedLockers() {
        return List.of();
    }
}
