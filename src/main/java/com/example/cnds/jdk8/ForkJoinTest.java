package com.example.cnds.jdk8;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * 要想使用Fark—Join，类必须继承
 * RecursiveAction（无返回值）
 * Or
 * RecursiveTask（有返回值）
 *
 */
public class ForkJoinTest extends RecursiveTask<Long> {
    private static final long serialVersionUID = 23423422L;
    private long start;
    private long end;

    public ForkJoinTest() {
    }

    public ForkJoinTest(long start, long end) {
        this.start = start;
        this.end = end;
    }

    // 定义阙值
    private static final long THRESHOLD = 10000L;



    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (long i = start; i < end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (end - start) / 2;
            ForkJoinTest left = new ForkJoinTest(start, middle);
            //拆分子任务，压入线程队列
            left.fork();
            ForkJoinTest right = new ForkJoinTest(middle + 1, end);
            right.fork();

            //合并并返回
            return left.join() + right.join();
        }
    }




    /**
     * 实现数的累加
     */
    public void test1() {
        //开始时间
        Instant start = Instant.now();

        //这里需要一个线程池的支持
        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask<Long> task = new ForkJoinTest(0L, 10000000000L);
        // 没有返回值     pool.execute();
        // 有返回值
        long sum = pool.invoke(task);

        //结束时间
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).getSeconds());
    }

    /**
     * java8 并行流 parallel()
     */
    public void test2() {
        //开始时间
        Instant start = Instant.now();

        // 并行流计算    累加求和
        LongStream.rangeClosed(0, 10000000000L).parallel()
                .reduce(0, Long :: sum);

        //结束时间
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).getSeconds());
    }

    public void test3(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream().forEach(System.out::print);

        list.parallelStream()
                .forEach(System.out::print);
    }
}  