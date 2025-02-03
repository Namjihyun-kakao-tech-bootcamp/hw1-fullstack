package locker.repository;

import locker.model.Locker;
import locker.model.OccupiedLocker;

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
    public void replaceLocker(Locker locker) {
        lockers.replace(locker.getId(), locker);
    }

    @Override
    public List<Locker> getOccupiedLockers() {
        return lockers.values().stream().filter(locker -> !(locker instanceof OccupiedLocker)).toList();
    }
}
