package Programs.Sorting;

public abstract class BaseClass {
    protected long[] keyCompare;
    protected long[] timeTaken;
    protected int testCases;
    protected int testID;

    protected static int totalTest = 0;

    public long[] getKeyCompare() {
        return this.keyCompare;
    }
    public long[] getTimeTaken() {
        return this.timeTaken;
    }

    public abstract void printDetails();
    public abstract void runTest(int[] array);
    public abstract void printAverage();
}
