package bean;

import java.util.ArrayList;
import java.util.List;

public class ListOutRecomClothBean
{
    List<LineRecomClothBean> list =new ArrayList<>();

    public ListOutRecomClothBean()
    {
    }

    public List<LineRecomClothBean> getList()
    {
        return list;
    }

    public void setList(List<LineRecomClothBean> list)
    {
        this.list = list;
    }
}
