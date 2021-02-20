package homework;

import org.junit.Test;

import java.util.concurrent.*;

/**
 *  本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 *      异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 *      写出你的方法，越多越好，提交到github。
 * @author ohYoung
 * @date 2021/2/1 21:08
 */
public class Homework03 {



    /**
     *  示例
     */
    @Test
    public void example01() {
        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        int result = sum(); //这是得到的返回值

        // 确保拿到result 并输出
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }

    /**
     *  使用Future + Callable
     */
    @Test
    public void example02() throws Exception {
        long start=System.currentTimeMillis();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> submit = executorService.submit(new CallableImpl());
        // 确保拿到result 并输出
        System.out.println("异步计算结果为：" + submit.get());
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

    /**
     *  使用FutureTask + Callable
     */
    @Test
    public void example03() throws Exception {
        long start=System.currentTimeMillis();
        FutureTask<Integer> task = new FutureTask<>(new CallableImpl());
        new Thread(task).start();
        Integer result = task.get();
        // 确保拿到result 并输出
        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

    /**
     *  使用FutureTask + Callable
     */
    @Test
    public void example04() throws Exception {
        long start=System.currentTimeMillis();
        FutureTask<Integer> task = new FutureTask<>(new CallableImpl());
        new Thread(task).start();
        while (!task.isDone()) {

        }
        // 确保拿到result 并输出
        System.out.println("异步计算结果为：" + task.get());
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

    /**
     *  使用CompletableFuture.completedFuture
     */
    @Test
    public void example05() throws Exception {
        long start=System.currentTimeMillis();
        // 确保拿到result 并输出
        System.out.println("异步计算结果为：" + CompletableFuture.completedFuture(sum()).get());
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

    /**
     *  使用CompletableFuture.supplyAsync
     */
    @Test
    public void example06() throws Exception {
        long start=System.currentTimeMillis();
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(Homework03::sum);
        // 确保拿到result 并输出
        System.out.println("异步计算结果为：" + future.get());
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

    /**
     *  使用CompletableFuture.supplyAsync
     */
    @Test
    public void example07() throws Exception {
        long start=System.currentTimeMillis();
        //创建分治任务线程池
        ForkJoinPool fjp = new ForkJoinPool(4);
        //创建分治任务
        Fibonacci fib = new Fibonacci(36);
        //启动分治任务
        Integer result = fjp.invoke(fib);
        //输出结果
        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

    static class Fibonacci extends RecursiveTask<Integer>{
        final int n;
        Fibonacci(int n){this.n = n;}
        protected Integer compute(){
            if (n <= 1)
                return 1;
            Fibonacci f1 = new Fibonacci(n - 1);
            //创建⼦任务
            f1.fork();
            Fibonacci f2 = new Fibonacci(n - 2);
            //等待⼦任务结果，并合并结果
            return f2.compute() + f1.join();
        }
    }



    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2) {
            return 1;
        }
        return fibo(a-1) + fibo(a-2);
    }

    class RunnableImpl implements Runnable {

        @Override
        public void run() {
           // sum();
        }
    }


    class CallableImpl implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return sum();
        }
    }

}
