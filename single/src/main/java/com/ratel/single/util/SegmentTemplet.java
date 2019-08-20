package com.ratel.single.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 分段执行模板
 * <p>
 *
 * @author niexiang
 * @version 1.0.0
 * @date 2019/3/20
 */
public interface SegmentTemplet<T,K> {
    ExecutorService threadPool = new ThreadPoolExecutor(10, 20000,
            60L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>());

    /**
     * 将数据分段
     * @param list
     * @param batchSize
     * @return
     */
    default List<K> batch(List<T> list, Integer batchSize){
        List<K> result = new ArrayList<>();
        int size = list.size();
        if (size == 0 || batchSize == 0) {
            return result;
        }
        //循环次数
        int ceil = (int) Math.ceil(size / (double)batchSize);
        CountDownLatch countDownLatch = new CountDownLatch(ceil);
        for (int i = 0; i < ceil ; i++) {
            List<T> currentList;
            //当次循环的参数
            int startIndex = batchSize * i;
            if (i == ceil - 1){
                currentList = list.subList(startIndex,size);
            }else{
                currentList = list.subList(startIndex,startIndex + batchSize);
            }
            if (currentList == null || currentList.isEmpty()) {
                continue;
            }
            List<K> execute = null;
            try {
                threadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("\n\n\n------------------------" + Thread.currentThread().getName());
                        execute(currentList);
                        countDownLatch.countDown();
                    }
                });
            }catch (Exception e){
                e.printStackTrace();
            }
            if (execute == null || execute.isEmpty()) {
                continue;
            }
            result.addAll(execute);
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 执行体
     * @return
     */
    public List<K> execute(List<T> list);





}
