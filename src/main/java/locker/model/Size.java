package locker.model;

public enum Size {

    SMALL("45*30*60", new Condition(2, 1000, 1, 500)),
    MEDIUM("45*60*60", new Condition(2, 2000, 1, 1000)),
    LARGE("45*90*60", new Condition(2, 3000, 1, 1500));

    private final String description;
    private final Condition condition;

    Size(String description, Condition condition) {
        this.description = description;
        this.condition = condition;
    }

    public Long calculateFee(Long totalMinutes) {
        return this.condition.getFee(totalMinutes);
    }

    private record Condition(Integer baseMinutes, Integer baseFee, Integer unitMinutes, Integer feePerUnit) {

        private Long getFee(Long totalMinutes) {
            long extraMinutes = (totalMinutes > baseMinutes)? totalMinutes - baseMinutes : 0L;
            return baseFee + feePerUnit * (long) Math.ceil( 1.0 * extraMinutes / unitMinutes);
        }
    }
}
