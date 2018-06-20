package bean;

/* 販売服のBean
 * 作成：功刀
 */
public class SaleClothBean extends ClothBean
{
    private int price;
    private String URL;
    private int clothid;
    private int clickcount;

    public SaleClothBean()
    {
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public String getURL()
    {
        return URL;
    }

    public void setURL(String uRL)
    {
        URL = uRL;
    }

    public int getClothid()
    {
        return clothid;
    }

    public void setClothid(int clothid)
    {
        this.clothid = clothid;
    }

    public int getClickcount()
    {
        return clickcount;
    }

    public void setClickcount(int clickcount)
    {
        this.clickcount = clickcount;
    }

    public String toString()
    {
        return price + "円" + color + " " + pattern + " " + category + " " + size;
    }
}
