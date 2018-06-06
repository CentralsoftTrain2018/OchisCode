package bean;

import java.util.ArrayList;
import java.util.List;

public class ListOutRecomClothBean
{
    List<LineRecomClothBean> list =new ArrayList<>();
    List<String> userClothList = new ArrayList<>();

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

    public List<String> getUserClothList()
    {
        return userClothList;
    }

    public void setUserClothList(List<String> userClothList)
    {
        this.userClothList = userClothList;
    }

}
