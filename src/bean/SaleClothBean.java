package bean;

public class SaleClothBean extends ClothBean
{
    private int price;
    private String URL;

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
    
    
}
