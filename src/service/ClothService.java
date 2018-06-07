package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import bean.LineRecomClothBean;
import bean.ListOutRecomClothBean;
import bean.ListOutUserClothBean;
import bean.UserClothLineBean;
import dao.Dao;
import dao.RecomClothDao;
import dao.UserClothDao;
import vo.RecomClothVo;
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
                bean.setClothid(uvo.getClothid());
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

    public ListOutRecomClothBean getRecommendCloth(int userid) {
        try
        (
            Connection con = Dao.getConnection();
        )
        {
            RecomClothDao rcdao = new RecomClothDao(con);
            List<RecomClothVo> rcvolist = rcdao.getRecomClothList(userid);

            ListOutRecomClothBean listoutrcbean = new ListOutRecomClothBean();
            List<LineRecomClothBean> rcbeanlist = new ArrayList<LineRecomClothBean>();
            for(RecomClothVo rcvo : rcvolist) {
                LineRecomClothBean linercbean = new LineRecomClothBean();
                linercbean.setColor(rcvo.getColor());
                linercbean.setPattern(rcvo.getPattern());
                linercbean.setCategory(rcvo.getCategory());

                rcbeanlist.add(linercbean);
            }

            listoutrcbean.setList(rcbeanlist);

            System.out.println(listoutrcbean);

            return listoutrcbean;
        }catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }

    }

    public ListOutRecomClothBean getSelectedRecommendCloth(int clothid) {
        try
        (
            Connection con = Dao.getConnection();
        )
        {
            RecomClothDao rcdao = new RecomClothDao(con);
            List<RecomClothVo> rcvolist = rcdao.getRecomCloth(clothid);

            ListOutRecomClothBean listoutrcbean = new ListOutRecomClothBean();
            List<LineRecomClothBean> rcbeanlist = new ArrayList<LineRecomClothBean>();
            for(RecomClothVo rcvo : rcvolist) {
                LineRecomClothBean linercbean = new LineRecomClothBean();
                linercbean.setColor(rcvo.getColor());
                linercbean.setPattern(rcvo.getPattern());
                linercbean.setCategory(rcvo.getCategory());

                rcbeanlist.add(linercbean);
            }

            listoutrcbean.setList(rcbeanlist);

            System.out.println(listoutrcbean);

            return listoutrcbean;
        }catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }

    }
}
