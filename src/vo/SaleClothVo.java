package vo;

import domain.CategoryEnum;
import domain.ColorEnum;
import domain.JougeEnum;
import domain.PatternEnum;
import domain.SizeEnum;

public class SaleClothVo extends ClothVo
{
    private int Price;
    private String Url;
    private int clothid;

    public SaleClothVo(CategoryEnum category, ColorEnum color, PatternEnum pattern, SizeEnum size, int Price,
            String Url)
    {
        super( category, color, pattern, size );

        this.Price = Price;
        this.Url = Url;

    }

    public SaleClothVo(CategoryEnum category, ColorEnum color, PatternEnum pattern, SizeEnum size, JougeEnum jouge,
            int Price, String Url, int clothid)
    {
        super( category, color, pattern, size );

        this.jouge = jouge;
        this.Price = Price;
        this.Url = Url;
        this.clothid = clothid;
    }

    public int getPrice()
    {
        return Price;
    }

    public void setPrice(int price)
    {
        Price = price;
    }

    public String getUrl()
    {
        return Url;
    }

    public void setUrl(String url)
    {
        Url = url;
    }

    public int getClothid()
    {
        return clothid;
    }

    public void setClothid(int clothid)
    {
        this.clothid = clothid;
    }

    public String toString()
    {
        return "色：" + color + "　柄：" + pattern + "　カテゴリー：" + category + "\n";
    }
}
