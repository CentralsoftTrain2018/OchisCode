package vo;

import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import domain.SizeEnum;

public class ClothVo {
    protected CategoryEnum category;
    protected ColorEnum color;
    protected PatternEnum pattern;
    protected SizeEnum size;

  //コンストラクタ
    public ClothVo(CategoryEnum category, ColorEnum color, PatternEnum pattern, SizeEnum size)
    {
        this.category = category;
        this.color = color;
        this.pattern = pattern;
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

    public SizeEnum getSize()
    {
        return size;
    }

    public void setSize(SizeEnum size)
    {
        this.size = size;
    }

}
