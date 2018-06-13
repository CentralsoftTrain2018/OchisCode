package bean;

import java.util.ArrayList;
import java.util.List;

//販売服のリスト
public class ListSaleClothBean
{
    private List<SaleClothBean> list =new ArrayList<>();

    public ListSaleClothBean()
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


    @Override
    public String toString() {
        return "ListOutRecomClothBean [list=" + list + "]";
    }
}
