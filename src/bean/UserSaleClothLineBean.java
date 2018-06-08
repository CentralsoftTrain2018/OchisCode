package bean;

import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import domain.SizeEnum;

public class UserSaleClothLineBean
{
       private CategoryEnum category;
       private ColorEnum color;
       private PatternEnum pattern;
       private SizeEnum size;
       private boolean isSale;  //true=販売服

    public UserSaleClothLineBean()
    {

    }

    public UserSaleClothLineBean(CategoryEnum category, ColorEnum color,
            PatternEnum pattern, SizeEnum size, boolean isSale)
    {
        super();
        this.category = category;
        this.color = color;
        this.pattern = pattern;
        this.size = size;
        this.isSale = isSale;
    }

    public boolean isSale()
    {
        return isSale;
    }

    public void setSale(boolean isSale)
    {
        this.isSale = isSale;
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
        return   color + "-" + pattern + "-" + category + "-"+size;
    }

}
