package bean;

import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;

public class LineRecomClothBean
{
    private CategoryEnum category;
    private ColorEnum color;
    private PatternEnum pattern;
    private int price;
    private String url;

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


    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }


    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String toString() {
        return  "金額:"+price+"　"+color + "　" + pattern + "　" + category ;
    }

}
