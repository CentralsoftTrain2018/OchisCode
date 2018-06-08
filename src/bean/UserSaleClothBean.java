package bean;

import java.util.ArrayList;
import java.util.List;

public class UserSaleClothBean
{
     private List<UserSaleClothLineBean> topclothlist = new ArrayList<>();
     private List<UserSaleClothLineBean> bottomclothlist = new ArrayList<>();

    public List<UserSaleClothLineBean> getTopclothlist()
    {
        return topclothlist;
    }
    public void setTopclothlist(List<UserSaleClothLineBean> topclothlist)
    {
        this.topclothlist = topclothlist;
    }
    public List<UserSaleClothLineBean> getBottomclothlist()
    {
        return bottomclothlist;
    }
    public void setBottomclothlist(List<UserSaleClothLineBean> bottomclothlist)
    {
        this.bottomclothlist = bottomclothlist;
    }
    @Override
    public String toString()
    {
        return "UserSaleClothBean [topclothlist=" + topclothlist + ", bottomclothlist=" + bottomclothlist + "]";
    }

}
