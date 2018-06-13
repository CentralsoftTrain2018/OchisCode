package bean;

import java.util.ArrayList;
import java.util.List;

public class ListOutSaleClothBean
{
    private List<SaleClothBean> list =new ArrayList<>();
    private List<String> userClothList = new ArrayList<>();

    public ListOutSaleClothBean()
    {
    }

    public List<SaleClothBean> getList()
    {
        return list;
    }

    public void setList(List<SaleClothBean> list)
    {
        this.list = list;
    }

    public List<String> getUserClothList()
    {
        return userClothList;
    }

    public void setUserClothList(List<String> userClothList)
    {
        this.userClothList = userClothList;
    }

    @Override
    public String toString() {
        return "ListOutRecomClothBean [list=" + list + "]";
    }
}
