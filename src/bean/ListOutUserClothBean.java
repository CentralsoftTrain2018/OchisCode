package bean;

//持ち服一覧表示用Bean
import java.util.ArrayList;
import java.util.List;

public class ListOutUserClothBean
{

       private  List<UserClothLineBean> list =new ArrayList<UserClothLineBean>();

        public ListOutUserClothBean()
        {

        }

        public List<UserClothLineBean> getList()
        {
            return list;
        }

        public void setList(List<UserClothLineBean> list)
        {
            this.list = list;
        }



    }
