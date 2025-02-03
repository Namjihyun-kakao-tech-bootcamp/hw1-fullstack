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
    public void replaceLocker(Locker locker) {
        lockers.replace(locker.getId(), locker);
    }

    @Override
    public List<Locker> getOccupiedLockers() {
        // TODO : 사용 중인 Locker의 List를 반환하는 메서드 구현
        return List.of();
    }
}
