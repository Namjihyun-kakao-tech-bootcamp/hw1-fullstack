package locker.repository;

import locker.model.Locker;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentSkipListMap;

public class MemoryLockerRepository implements LockerRepository {

    private final Map<Long, Locker> lockers = new ConcurrentSkipListMap<>(Comparator.comparingLong(id -> id));

    @Override
    public Locker getLocker(Long id) {
        return lockers.get(id);
    }

    @Override
    public Long saveLocker(Locker locker) {
        return Objects.requireNonNull(lockers.put(locker.getId(), locker)).getId();
    }

    @Override
    public List<Locker> getOccupiedLockers() {
        // TODO : 사용 중인 Locker의 List를 반환하는 메서드 구현
        return List.of();
    }
}
