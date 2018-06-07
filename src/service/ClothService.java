package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import bean.ListOutUserClothBean;
import bean.UserClothLineBean;
import dao.Dao;
import dao.UserClothDao;
import vo.UserClothVo;

public class ClothService
{
    //持ち服一覧
    public ListOutUserClothBean userCloth(int userId)
    {
        UserClothLineBean bean;
        ListOutUserClothBean listbean;
        try (
                Connection con = Dao.getConnection();)
        {
            UserClothDao ucdao = new UserClothDao( con );
            //ユーザーの持ち服一覧をDBから取得
            Collection<UserClothVo> list = ucdao.getAllUserCloth( userId );
            listbean = new ListOutUserClothBean();

            List<UserClothLineBean> clothlist = new ArrayList<UserClothLineBean>();
            for (UserClothVo uvo : list)
            {
                bean = new UserClothLineBean();
                bean.setCategory( uvo.getCategory() );
                bean.setColor( uvo.getColor() );
                bean.setPattern( uvo.getPattern() );
                bean.setSize( uvo.getSize() );
                clothlist.add( bean );
            }
            listbean.setList( clothlist );

            return listbean;//

        } catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }
    }

    /*//持ち服登録
    public RegistUserClothBean registcloth()
    {
        try (
                Connection con = Dao.getConnection();
                )

        {
            UserClothDao ucdao = new UserClothDao( con );

        }
        catch(SQLException | ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        return null;

    }*/
}
