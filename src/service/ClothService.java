package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import Vo.UserClothVo;
import bean.ListOutUserClothBean;
import dao.Dao;
import dao.UserClothDao;

public class ClothService
{
    //持ち服一覧
    public ListOutUserClothBean UserCloth(int userId)
    {
        try (
                Connection con = Dao.getConnection();)
        {
            UserClothDao ucdao = new UserClothDao( con );
            //ユーザーの持ち服一覧をDBから取得
            Collection<UserClothVo> list = ucdao.getAllUserCloth( userId );

            //TODO Beanが違うため要変更
            //とりあえず直書き   本来はDBから取り出したデータ
            ListOutUserClothBean bean = new ListOutUserClothBean();
            return bean;
        } catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }
    }

}
