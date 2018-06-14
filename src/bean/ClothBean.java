package bean;

import domain.CategoryEnum;
import domain.ColorEnum;
import domain.JougeEnum;
import domain.PatternEnum;
import domain.SizeEnum;
//
/*服のBean
 *持ち服、販売服はこれを継承して使用する
 *作成：功刀
 */

public class ClothBean {
    protected SizeEnum size;
    protected CategoryEnum category;
    protected ColorEnum color;
    protected PatternEnum pattern;
    protected JougeEnum jouge;

    public ClothBean() {

    }

    public SizeEnum getSize()
    {
        return size;
    }

    public void setSize(SizeEnum size)
    {
        this.size = size;
    }

    public CategoryEnum getCategory()
    {
        return category;
    }

    public void setCategory(CategoryEnum category)
    {
        this.category = category;
    }

    public ColorEnum getColor()
    {
        return color;
    }

    public void setColor(ColorEnum color)
    {
        this.color = color;
    }

    public PatternEnum getPattern()
    {
        return pattern;
    }

    public void setPattern(PatternEnum pattern)
    {
        this.pattern = pattern;
    }

    public JougeEnum getJouge() {
        return jouge;
    }

    public void setJouge(JougeEnum jouge) {
        this.jouge = jouge;
    }


}
