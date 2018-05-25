package Chapter1_4Text;

public class Stopwatch {
    private final long start;
    public Stopwatch(){
        start = System.currentTimeMillis();
    }

    //流逝的时间
    public double elapsedTime(){
        long end = System.currentTimeMillis();
        return (end - start) / 1000.0;
    }
}
