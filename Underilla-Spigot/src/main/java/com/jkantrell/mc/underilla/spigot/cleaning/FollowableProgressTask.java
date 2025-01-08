package com.jkantrell.mc.underilla.spigot.cleaning;

import java.time.Duration;
import com.jkantrell.mc.underilla.spigot.Underilla;
import com.jkantrell.mc.underilla.spigot.io.UnderillaConfig.IntegerKeys;
import com.jkantrell.mc.underilla.spigot.selector.Selector;

public abstract class FollowableProgressTask {
    protected final Selector selector;
    protected final int taskID;
    protected final int tasksCount;
    protected long printTime;
    protected long printTimeEachXMs;
    protected boolean stop;

    public FollowableProgressTask(int taskID, int tasksCount, Selector selector) {
        this.taskID = taskID;
        this.tasksCount = tasksCount;
        this.selector = selector;
        printTime = 0;
        printTimeEachXMs = 1000 * Underilla.getUnderillaConfig().getInt(IntegerKeys.PRINT_PROGRESS_EVERY_X_SECONDS);
        stop = false;
    }
    public FollowableProgressTask(int taskID, int tasksCount) { this(taskID, tasksCount, Underilla.getUnderillaConfig().getSelector()); }

    abstract public void run();

    public Selector stop() {
        stop = true;
        return selector;
    }

    protected void printProgress(long processed, long startTime) {
        printProgress(processed, startTime, selector.progress(), taskID, tasksCount, null);
    }
    protected void printProgressIfNeeded(long processed, long startTime) {
        if (printTime + printTimeEachXMs < System.currentTimeMillis()) {
            printTime = System.currentTimeMillis();
            printProgress(processed, startTime);
        }
    }

    public static void printProgress(long processed, long startTime, double progress, int taskID, int tasksCount, String extraString) {
        long timeForFullProgress = (long) ((System.currentTimeMillis() - startTime) / progress);
        long timeForFullProgressLeft = timeForFullProgress - (System.currentTimeMillis() - startTime);
        extraString = extraString == null ? "" : " " + extraString;
        Underilla.info("Task " + taskID + "/" + tasksCount + " Progress: " + processed + "   " + doubleToPercent(progress) + " ETA: "
                + Duration.ofMillis(timeForFullProgressLeft) + extraString);
    }
    private static String doubleToPercent(double d) { return String.format("%.4f", d * 100) + "%"; }
}
