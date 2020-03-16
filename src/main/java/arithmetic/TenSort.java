package arithmetic;

import java.util.Arrays;

/**
 * 十种排序方法
 *
 * @Author RubyJing
 * @Date 2019/9/30 17:24
 * @Version 1.0
 */
public class TenSort {
    public static void main(String[] args) {
        long oneTime = System.currentTimeMillis();
        int[] arrays = {5, 6, 3};

//        System.out.println(Arrays.toString(bubbleSort(arrays)));
//        System.out.println(Arrays.toString(selectionSort(arrays)));
        System.out.println(Arrays.toString(insertionSort(arrays)));

        System.out.println(System.currentTimeMillis() - oneTime);
    }
/**
 * 稳定：如果a原本在b前面，而a=b，排序之后a仍然在b的前面；
 * 不稳定：如果a原本在b的前面，而a=b，排序之后a可能会出现在b的后面；
 * 内排序：所有排序操作都在内存中完成；
 * 外排序：由于数据太大，因此把数据放在磁盘中，而排序通过磁盘和内存的数据传输才能进行；
 * 时间复杂度： 一个算法执行所耗费的时间。
 * 空间复杂度：运行完一个程序所需内存的大小。
 */

    /**
     * 冒泡排序-->两两比对
     * 时间复杂度:O(n^2) -->* 最好情况：O(n) ; 最坏情况：O(n^2)
     * 空间复杂度：O(1)
     * 排序方式:In-place
     * 稳定性：稳定
     *
     * @param array
     * @return 从小到大排序
     */
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                num++;
                if (array[j] > array[j + 1]) {
                    int mid = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = mid;
//                    System.out.println(Arrays.toString(array));
                }
            }
        }
        System.out.println("冒泡排序--循环次数：" + num);
        return array;
    }

    /**
     * 选择排序-->每次遍历将最小（大）的放在前面
     * 时间复杂度:O(n^2) -->* 最好情况：O(n^2) ; 最坏情况：O(n^2)
     * 空间复杂度：O(1)
     * 排序方式:In-place
     * 稳定性：不稳定
     * 另外：数据规模越小越好。唯一的好处可能就是不占用额外的内存空间了吧
     *
     * @param array
     * @return 从小到大排序
     */
    public static int[] selectionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                num++;
                //找到当前遍历中最小的数
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            //把最小数移到当前最前面
            int mid = array[minIndex];
            array[minIndex] = array[i];
            array[i] = mid;
        }
        System.out.println("选择排序--循环次数：" + num);
        return array;
    }

    /**
     * 插入排序--通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入
     * 时间复杂度:O(n^2) -->* 最好情况：O(n) ; 最坏情况：O(n^2)
     * 空间复杂度：O(1)
     * 排序方式:In-place
     * 稳定性：稳定
     * @param array
     * @return 从小到大
     */
    public static int[] insertionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int num = 0;
        int inNum = 0;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            //默认第一个是已经好的序列,current表示正在拿出来对比的数
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                //只要比当前数字大，往右挪一步
                System.out.println(current);
                array[preIndex + 1] = array[preIndex];
                preIndex--;
                inNum ++;
            }
            array[preIndex + 1] = current;
            num++;
        }
        System.out.println("插入排序--外循环次数：" + num+"；内循环次数："+inNum);
        return array;
    }
}
