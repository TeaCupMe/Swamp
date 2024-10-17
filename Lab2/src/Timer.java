/**
 * by Aleksey &lt;TeaCupMe&gt; Gilenko.<br/>
 * Moscow 2024<br/>
 * Simple timer written for course "Algorithms and data structures" in BMSTU.
 */
public class Timer {
    final FormatterOptions taskNameFormat = new FormatterOptions("BU", "G");
    private long lastCheckpointTime = 0;
    private long restartTime = 0;
    private int checkpointCount = 0;
    private String taskTitle = "Task";
    private String nextCheckpoint = null;

    /**
     * Starts the timer. Next checkpoint() and getTime() times are calculated relative to the moment this method is called.
     */
    public void start() {
        lastCheckpointTime = System.nanoTime();
        restartTime = lastCheckpointTime;
        System.out.println("Timer started");
    }

    /**
     * Resets timer. Next call to checkpoint() will return time passed after this call, rather than after previous checkpoint.
     * Next call to getTime() will return time passed after this call, rather than after timer start time
     */
    public void reset() {
        lastCheckpointTime = System.nanoTime();
        restartTime = lastCheckpointTime;
        checkpointCount = 0;
    }

    /**
     * Resets current checkpoint. Next call to checkpoint() will return time passed after this call, rather than after previous checkpoint
     */
    public void resetCheckpoint() {
        lastCheckpointTime = System.nanoTime();
    }

    /**
     * Resets all checkpoints. Next call to checkpoint() will return time passed since last timer restart.
     */
    public void resetCheckpoints() {
        lastCheckpointTime = restartTime;
    }

    /**
     * Calculates and outputs time passed since last checkpoint. Uses checkpoint index as checkpoint name
     */
    public double checkpoint() {
        if (nextCheckpoint == null) return checkpoint(Integer.toString(checkpointCount));
        String checkpointName = nextCheckpoint;
        nextCheckpoint = null;
        return checkpoint(checkpointName);

    }

    /**
     * Calculates and outputs time passed since last checkpoint. Uses provided string as checkpoint name
     *
     * @param _id checkpoint name
     */
    public double checkpoint(String _id) {
        long time = System.nanoTime() - lastCheckpointTime;
//        System.out.print(InitializePrinter);
        System.out.printf(Formatter.format("%s", taskNameFormat) + ": Checkpoint " + Formatter.format("%s", "U") + " time: %.5fs%n", taskTitle, _id, time / 1000000000.0);
        lastCheckpointTime = System.nanoTime();
        checkpointCount++;
        return time;
    }

    /**
     * Prints time passed since last timer restart
     *
     * @return time since last restart
     */
    public double getTime() {
        double time = (System.nanoTime() - restartTime) / 1000000000.0;
        System.out.printf("Time since restart: %.5f", time);
        return time;
    }

    /**
     * Sets internal Task Title to be used in checkpoint output
     *
     * @param _title new Task Title
     */
    public void setTaskTitle(String _title) {
        if (_title.equals(taskTitle)) return;
        taskTitle = _title;
        System.out.println("\nNew task: "+ String.format(Formatter.format("%s", taskNameFormat), taskTitle));
    }

    public void setNextCheckpoint(String _nextCheckpoint) {
        nextCheckpoint = _nextCheckpoint;
        resetCheckpoint();
    }
}
