package designpatterns.适配器模式;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/3/23 10:37
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        //什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println();
    }
}
