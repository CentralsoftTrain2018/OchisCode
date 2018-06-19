package bean;

import java.util.ArrayList;
import java.util.List;

public class UserSaleClothBean
{
    private List<UserClothBean> topclothlist = new ArrayList<>();
    private List<UserClothBean> bottomclothlist = new ArrayList<>();

    public List<UserClothBean> getTopclothlist()
    {
        return topclothlist;
    }

    public void setTopclothlist(List<UserClothBean> topclothlist)
    {
        this.topclothlist = topclothlist;
    }

    public List<UserClothBean> getBottomclothlist()
    {
        return bottomclothlist;
    }

    public void setBottomclothlist(List<UserClothBean> bottomclothlist)
    {
        this.bottomclothlist = bottomclothlist;
    }

    @Override
    public String toString()
    {
        return "UserSaleClothBean [topclothlist=" + topclothlist + ", bottomclothlist=" + bottomclothlist + "]";
    }

}
