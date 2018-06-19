package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import bean.ListOutUserClothBean;
import bean.ListSaleClothBean;
import bean.SaleClothBean;
import bean.UserClothBean;
import bean.UserSaleClothBean;
import dao.Dao;
import dao.SaleClothDao;
import dao.UserClothDao;
import domain.CategoryEnum;
import domain.ColorEnum;
import domain.JougeEnum;
import domain.PatternEnum;
import domain.SizeEnum;
import vo.SaleClothVo;
import vo.UserClothVo;

public class ClothService
{
    //持ち服一覧
    public ListOutUserClothBean userCloth(String userId, String narrow)
    {
        UserClothBean bean;
        ListOutUserClothBean listbean;
        try (
                Connection con = Dao.getConnection();)
        {
            UserClothDao ucdao = new UserClothDao( con );
            //ユーザーの持ち服一覧をDBから取得
            Collection<UserClothVo> list = ucdao.getAllUserCloth( userId, narrow );
            listbean = new ListOutUserClothBean();

            List<UserClothBean> clothlist = new ArrayList<UserClothBean>();
            for (UserClothVo uvo : list)
            {
                bean = new UserClothBean();
                bean.setClothid( uvo.getClothid() );
                bean.setCategory( uvo.getCategory() );
                bean.setColor( uvo.getColor() );
                bean.setPattern( uvo.getPattern() );
                bean.setSize( uvo.getSize() );
                clothlist.add( bean );
            }
            listbean.setList( clothlist );

            return listbean;//

        } catch ( SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }
    }

    //持ち服登録
    public void registCloth(String id, SizeEnum size,ColorEnum color,PatternEnum pattern, CategoryEnum category )
    {
        try (
                Connection con = Dao.getConnection();)
        {
            UserClothDao ucdao = new UserClothDao( con );
            UserClothVo user = new UserClothVo( id, category,  color,  pattern,  size);
            ucdao.doRegist(user);
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public ListSaleClothBean getSaleCloth(String userid, String minmax, String order)
    {
        try (
                Connection con = Dao.getConnection();)
        {
            SaleClothDao rcdao = new SaleClothDao( con );
            List<SaleClothVo> rcvolist = rcdao.getSaleClothList( userid, minmax, order );

            ListSaleClothBean listoutrcbean = new ListSaleClothBean();
            List<SaleClothBean> rcbeanlist = new ArrayList<SaleClothBean>();
            for (SaleClothVo rcvo : rcvolist)
            {
                SaleClothBean linercbean = new SaleClothBean();
                linercbean.setColor( rcvo.getColor() );
                linercbean.setPattern( rcvo.getPattern() );
                linercbean.setCategory( rcvo.getCategory() );
                linercbean.setJouge( rcvo.getJouge() );
                linercbean.setPrice(rcvo.getPrice());//金額の取得
                linercbean.setURL(rcvo.getUrl());//URLの取得
                linercbean.setSize(rcvo.getSize());//サイズの取得

                rcbeanlist.add( linercbean );
            }

            listoutrcbean.setList( rcbeanlist );


            return listoutrcbean;
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }

    }

    public ListSaleClothBean getSelectedSaleCloth(int clothid, String minmax, String order)
    {
        try (
                Connection con = Dao.getConnection();)
        {
            SaleClothDao rcdao = new SaleClothDao( con );

            List<SaleClothVo> rcvolist = rcdao.getRecomCloth( clothid, minmax, order );

            ListSaleClothBean listoutrcbean = new ListSaleClothBean();
            List<SaleClothBean> rcbeanlist = new ArrayList<SaleClothBean>();
            for (SaleClothVo rcvo : rcvolist)
            {
                SaleClothBean linercbean = new SaleClothBean();
                linercbean.setColor( rcvo.getColor() );
                linercbean.setPattern( rcvo.getPattern() );
                linercbean.setCategory( rcvo.getCategory() );
                linercbean.setJouge( rcvo.getJouge() );
                linercbean.setPrice(rcvo.getPrice());//金額の取得
                linercbean.setURL(rcvo.getUrl());//URLの取得
                linercbean.setSize(rcvo.getSize());//サイズの取得

                rcbeanlist.add( linercbean );
            }

            listoutrcbean.setList( rcbeanlist );


            return listoutrcbean;
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }

    }

    //持ち服を上下に分けて取得
    //更新：功刀
   public UserSaleClothBean userSaleCloth(String userId)
    {
        UserClothBean bean;
        UserSaleClothBean listbean;
        try (
                Connection con = Dao.getConnection();)
        {
            UserClothDao ucdao = new UserClothDao( con );
            //ユーザーの持ち服一覧をDBから取得
            Collection<UserClothVo> list = ucdao.getAllUserCloth( userId, "" );
            listbean = new UserSaleClothBean();
            //上下で分けて入れるList
            List<UserClothBean> topClothList = new ArrayList<UserClothBean>();
            List<UserClothBean> bottomClothList = new ArrayList<UserClothBean>();
            //すべての服に対して上下を確認し上下に応じて入れるListを変更して入れる
            for (UserClothVo uvo : list)
            {
                bean = new UserClothBean();
                if (uvo.getCategory().getJouge() == JougeEnum.上)
            {
                    bean.setClothid( uvo.getClothid() );
                    bean.setCategory( uvo.getCategory() );
                    bean.setColor( uvo.getColor() );
                    bean.setPattern( uvo.getPattern() );
                    bean.setSize( uvo.getSize() );
                    topClothList.add( bean );
                } else
            {
                    bean.setClothid( uvo.getClothid() );
                    bean.setCategory( uvo.getCategory() );
                    bean.setColor( uvo.getColor() );
                    bean.setPattern( uvo.getPattern() );
                    bean.setSize( uvo.getSize() );
                    bottomClothList.add( bean );
            }
            }
            listbean.setBottomclothlist( bottomClothList );
            listbean.setTopclothlist( topClothList );

            return listbean;//

        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }

    }

   //持ち服の削除
   //作成者：中村
   public void deleteUserCloth(int clothid) {
       try (
               Connection con = Dao.getConnection();)
       {
           UserClothDao ucdao = new UserClothDao( con );
           ucdao.doDelete(clothid);

       } catch (SQLException e)
       {
           e.printStackTrace();
           throw new RuntimeException( e );
       }
   }
}
