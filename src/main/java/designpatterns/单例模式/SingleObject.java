package designpatterns.单例模式;

public class SingleObject {

    /** 创建SingleObject对象 **/
    private static SingleObject instance = new SingleObject();

    /** 让构造函数为 private，这样该类就不会被实例化 **/
    private SingleObject() {}

    /** 获取唯一可用的对象 **/
    public static SingleObject getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }
}
