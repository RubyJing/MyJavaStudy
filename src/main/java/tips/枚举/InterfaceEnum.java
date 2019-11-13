package tips.枚举;

/** 实现接口
 * @Author RubyJing
 * @Date 2019/11/13 11:52
 * @Version 1.0
 */

interface Behaviour {
    void print();
    String getInfo();
}
public enum  InterfaceEnum implements Behaviour{
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);

    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private InterfaceEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public void print() {
        System.out.println(this.index+":"+this.name);
    }

    @Override
    public String getInfo() {
        return this.name;
    }
}
