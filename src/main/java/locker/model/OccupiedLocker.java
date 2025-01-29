package locker.model;

import java.time.LocalDateTime;

public class OccupiedLocker extends Locker {

    private final LocalDateTime createdAt;
    private final String password;

    public OccupiedLocker(Long id, Size size, LocalDateTime createdAt, String password) {
        super(id, size);
        this.createdAt = createdAt;
        this.password = password;
    }
}
