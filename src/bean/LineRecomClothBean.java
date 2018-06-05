package bean;

import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;

public class LineRecomClothBean
{
    private CategoryEnum category;
    private ColorEnum color;
    private PatternEnum pattern;

    public LineRecomClothBean()
    {
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


}
