package functionalModule.simpler_text_editor;

import java.awt.*;

/**
 * 文件样式
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/20 11:07
 */
public class CharacterStyle {
    private Font font;
    private int size;
    private int colorRGB;

    public CharacterStyle(Font font, int size, int colorRGB) {
        this.font = font;
        this.size = size;
        this.colorRGB = colorRGB;
    }

    @Override
    public boolean equals(Object o) {
        CharacterStyle otherStyle = (CharacterStyle) o;
        return font.equals(otherStyle.font)
                && size == otherStyle.size
                && colorRGB == otherStyle.colorRGB;
    }
}
