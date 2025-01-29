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

    public Integer calculateFee(Integer totalMinutes) {
        return this.condition.calculateFee(totalMinutes);
    }

    private record Condition(Integer baseMinutes, Integer baseFee, Integer unitMinutes, Integer feePerUnit) {

        private Integer calculateFee(Integer totalMinutes) {
            return baseFee + feePerUnit * (int) Math.ceil( 1.0 * (totalMinutes - baseMinutes) / unitMinutes);
        }
    }
}
