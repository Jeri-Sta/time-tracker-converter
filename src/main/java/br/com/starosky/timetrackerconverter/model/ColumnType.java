package br.com.starosky.timetrackerconverter.model;

public enum ColumnType {
    MONTH(0),
    USER(1),
    DAY(2),
    HCM_HOURS(3),
    JIRA_HOURS(4),
    ACHIEVEMENT(5);

    private final int value;

    ColumnType(int value) {
        this.value = value;
    }

    public static ColumnType valueOf(int value) {
        for (ColumnType type : ColumnType.values()) {
            if (type.value == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("No ColumnType found for value: " + value);
    }
}
