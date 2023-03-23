public class Task {
    private final long ID;
    private final String DESCRIPTION;
    private final int DURATION;
    private final int MAX_WINDOW;

    public Task(long ID, String DESCRIPTION, int DURATION, int MAX_WINDOW) throws IllegalArgumentException {
        if (ID == 0 || DESCRIPTION == null || DURATION == 0 || MAX_WINDOW == 0) {
            throw new IllegalArgumentException("All fields must be filled out");
        }
        this.ID = ID;
        this.DESCRIPTION = DESCRIPTION;
        this.DURATION = DURATION;
        this.MAX_WINDOW = MAX_WINDOW;
    }

    public long getID() {
        return ID;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public int getDURATION() {
        return DURATION;
    }

    public int getMAX_WINDOW() {
        return MAX_WINDOW;
    }
}
