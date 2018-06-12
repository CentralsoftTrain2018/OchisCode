package bean;

/* 持ち服のBean
 * 作成：功刀
 */
public class UserClothBean extends ClothBean
{
    private int clothid;

    public UserClothBean()
    {
        super();
    }

    public int getClothid()
    {
        return clothid;
    }

    public void setClothid(int clothid)
    {
        this.clothid = clothid;
    }

    public String toString() {
        return getColor().name() + "色　" + getPattern().name() + "　" + getCategory().name() + "  " + getSize().name()
        + "サイズ";
    }
}
