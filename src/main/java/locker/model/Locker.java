package locker.model;

public class Locker {

    private final Long id;
    private final Size size;

    public Locker(Long id, Size size) {
        this.id = id;
        this.size = size;
    }

    public Long getId() {
        return id;
    }
}
