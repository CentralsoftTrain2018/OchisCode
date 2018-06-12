package vo;

import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import domain.SizeEnum;

public class UserClothVo extends ClothVo
{
    protected int clothid;
    protected String userid;

    //コンストラクタ
    public UserClothVo(String userid, CategoryEnum category, ColorEnum color, PatternEnum pattern, SizeEnum size)
    {
        super(category, color, pattern, size);
        this.userid = userid;
    }



    public String getUserid() {
        return userid;
    }



    public void setUserid(String userid) {
        this.userid = userid;
    }



    public int getClothid() {
        return clothid;
    }



    public void setClothid(int clothid) {
        this.clothid = clothid;
    }

    @Override
    //プルダウン表示用文字列を生成
    public String toString()
    {
        return color.name() + "-" + pattern.name() + "-" + category.name() + "-" + size.name();
    }


}
