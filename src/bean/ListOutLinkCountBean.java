package bean;

import java.util.ArrayList;
import java.util.List;

//管理者用クリック数表示画面用Bean
//作成：功刀
public class ListOutLinkCountBean
{
    private List<SaleClothBean> list = new ArrayList<>();
    public ListOutLinkCountBean()
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
}
