package bean;

//持ち服一覧表示用Bean
import java.util.ArrayList;
import java.util.List;

public class ListOutUserClothBean
{

    private List<UserClothBean> list = new ArrayList<UserClothBean>();
    private int page;

    public ListOutUserClothBean()
    {

    }

    public List<UserClothBean> getList()
    {
        return list;
    }

    public void setList(List<UserClothBean> list)
    {
        this.list = list;
    }

    public UserClothBean getSelectedCloth(int clothid)
    {
        for (UserClothBean uc : list)
        {
            if (uc.getClothid() == clothid)
            {
                return uc;
            }
        }
        return null;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }



}
