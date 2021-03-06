package functionalModule.alert;

import java.util.Arrays;

/**
 * 单例类：负责 Alert 的创建、组装（alertRule 和 notification 的依赖注入）、初始化（添加 handlers）工
 * @author RubyJing
 * @version 1.0
 * @date 2020/10/30 10:48
 */
public class ApplicationContext {
    private AlertRule alertRule;
    private Notification notification;
    private Alert alert;

    public void initializeBeans(){
        alertRule = new AlertRule();
        alert = new Alert();
        alert.addAlertHandler(new TpsAlertHandler(alertRule,
                new SevereNotification(new TelephoneMsgSender(Arrays.asList("123","465")))));
        alert.addAlertHandler(new ErrorAlertHandler(alertRule
                ,new UrgencyNotification(new WechatMsgSender(Arrays.asList("微信1","微信2")))));
    }

    public Alert getAlert() {
        return alert;
    }

    //饿汉式单例

    private static final ApplicationContext instance = new ApplicationContext();

    public ApplicationContext() {
        initializeBeans();
    }

    public static ApplicationContext getInstance(){
        return instance;
    }
}
