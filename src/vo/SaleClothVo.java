package vo;

import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import domain.SizeEnum;

public class SaleClothVo extends ClothVo
{
    private int Price;
   public SaleClothVo(CategoryEnum category, ColorEnum color, PatternEnum pattern, SizeEnum size,int Price) {
        super(category, color, pattern, size);
        this.Price=Price;
    }

    public int getPrice()
{
    return Price;
}


public void setPrice(int price)
{
    Price = price;
}


    public String toString() {
        return "色：" + color + "　柄：" + pattern + "　カテゴリー：" + category + "\n";
    }
}
