package vo;

import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import domain.SizeEnum;

public class RecomClothVo
{
    private CategoryEnum category;
    private ColorEnum color;
    private PatternEnum pattern;
    private SizeEnum size;


   public RecomClothVo(CategoryEnum category, ColorEnum color, PatternEnum pattern, SizeEnum size) {
        super();
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

    public String toString() {
        return "色：" + color + "　柄：" + pattern + "　カテゴリー：" + category + "\n";
    }
}
