package com.ratel.single.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 分段执行模板
 * <p>
 *
 * @author niexiang
 * @version 1.0.0
 * @date 2019/3/20
 */
public interface SegmentTemplet<T,K> {

    /**
     * 将数据分段
     * @param list
     * @param batchSize
     * @return
     */
    default List<K> batch(List<T> list,Integer batchSize){
        List<K> result = new ArrayList<>();
        int size = list.size();
        if (size == 0 || batchSize == 0) {
            return result;
        }
        int ceil = (int) Math.ceil(size / (double)batchSize);
        for (int i = 0; i < ceil ; i++) {
            List<T> currentList;
            //当次循环的参数
            int startIndex = batchSize * i;
            if (i == ceil - 1){
                currentList = list.subList(startIndex,startIndex + (size == batchSize ? batchSize : size % batchSize));
            }else{
                currentList = list.subList(startIndex,startIndex + batchSize);
            }
            if (currentList == null || currentList.isEmpty()) {
                continue;
            }
            List<K> execute = execute(currentList);
            if (execute == null || execute.isEmpty()) {
                continue;
            }
            result.addAll(execute);
        }
        return result;
    }

    /**
     * 执行体
     * @return
     */
    public List<K> execute(List<T> list);





}
