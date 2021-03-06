package tips.泛型;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型数组
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/7/7 11:42
 */
public class GenericArray {
    public static void main(String[] args) {
//        List<String>[] lists1 = new ArrayList<String>[10];//编译错误，非法创建
//        List<String>[] lists2 = new ArrayList<?>[10]; //编译错误，需要强转类型
//        List<String>[] lists3 = (List<String>[])new ArrayList<?>[10]; //OK,但是会有警告
//        List<?>[] lists4 = new ArrayList<String>[10]; //编译错误，非法创建
//        List<?>[] lists5 = new ArrayList<?>[10]; //OK
//        List<String>[] lists6 = new ArrayList[10]; // OK ,但是会有警告

//        List<String>[] lsa = new List<String>[10];

        ArrayWithTypeToken<Integer> arrayToken = new ArrayWithTypeToken<>(Integer.class,100);
        Integer[] array = arrayToken.create();
    }

    /**
     * ==================讨巧的使用场景================
     **/

    @SafeVarargs
    public static <T> T[] fun1(T... arg) {
        return arg;
    }

    public static <T> void fun2(T[] param) {
        System.out.println("接收泛型数组：");
        for (T t : param) {
            System.out.println(t + "、");
        }
    }

}

/** 最佳方案 **/
class ArrayWithTypeToken<T> {
    private T[] array;

    public ArrayWithTypeToken(Class<T> type, int size) {
        array = (T[]) Array.newInstance(type, size);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] create() {
        return array;
    }
}