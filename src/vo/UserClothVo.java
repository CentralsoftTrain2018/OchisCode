package vo;

import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import domain.SizeEnum;

public class UserClothVo
{
    private int clothid;
    private CategoryEnum category;
    private ColorEnum color;
    private PatternEnum pattern;
    private SizeEnum size;

    //コンストラクタ
    public UserClothVo(int clothid, CategoryEnum category, ColorEnum color, PatternEnum pattern, SizeEnum size)
    {
        this.clothid = clothid;
        this.category = category;
        this.color = color;
        this.pattern = pattern;
        this.size = size;
    }



    public int getClothid() {
        return clothid;
    }



    public void setClothid(int clothid) {
        this.clothid = clothid;
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

    @Override
    //プルダウン表示用文字列を生成
    public String toString()
    {
        return color.name() + "-" + pattern.name() + "-" + category.name() + "-" + size.name();
    }


}
