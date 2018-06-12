package bean;

import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import domain.SizeEnum;

public class UserClothLineBean
{

    private int clothid;
    private String userid;
    private SizeEnum size;
    private CategoryEnum category;
    private ColorEnum color;
    private PatternEnum pattern;

    public int getClothid()
    {
        return clothid;
    }

    public void setClothid(int clothid)
    {
        this.clothid = clothid;
    }

    public String getUserid()
    {
        return userid;
    }

    public void setUserid(String userid)
    {
        this.userid = userid;
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

    public String toString()
    {

        return getColor().name() + "色　" + getPattern().name() + "　" + getCategory().name() + "  " + getSize().name()
                + "サイズ";
    }
}
