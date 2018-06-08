package vo;

import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import domain.SizeEnum;

public class RecomClothVo extends ClothVo
{
   public RecomClothVo(CategoryEnum category, ColorEnum color, PatternEnum pattern, SizeEnum size) {
        super(category, color, pattern, size);
    }

    public String toString() {
        return "色：" + color + "　柄：" + pattern + "　カテゴリー：" + category + "\n";
    }
}
