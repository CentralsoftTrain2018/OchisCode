package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import bean.ListOutSaleClothBean;
import bean.ListOutUserClothBean;
import bean.SaleClothBean;
import bean.UserClothBean;
import bean.UserSaleClothBean;
import bean.UserSaleClothLineBean;
import dao.Dao;
import dao.SaleClothDao;
import dao.UserClothDao;
import dao.UserSaleClothDao;
import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import domain.SizeEnum;
import vo.SaleClothVo;
import vo.UserClothVo;
import vo.UserSaleClothVo;

public class ClothService
{
    //持ち服一覧
    public ListOutUserClothBean userCloth(String userId)
    {
        UserClothBean bean;
        ListOutUserClothBean listbean;
        try (
                Connection con = Dao.getConnection();)
        {
            UserClothDao ucdao = new UserClothDao( con );
            //ユーザーの持ち服一覧をDBから取得
            Collection<UserClothVo> list = ucdao.getAllUserCloth( userId );
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

        } catch (ClassNotFoundException | SQLException e)
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
        }
        catch(SQLException | ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }


    public ListOutSaleClothBean getRecommendCloth(String userid, int min, int max)
    {
        try (
                Connection con = Dao.getConnection();)
        {
            SaleClothDao rcdao = new SaleClothDao( con );
            List<SaleClothVo> rcvolist = rcdao.getRecomClothList( userid, min, max );

            ListOutSaleClothBean listoutrcbean = new ListOutSaleClothBean();
            List<SaleClothBean> rcbeanlist = new ArrayList<SaleClothBean>();
            for (SaleClothVo rcvo : rcvolist)
            {
                SaleClothBean linercbean = new SaleClothBean();
                linercbean.setColor( rcvo.getColor() );
                linercbean.setPattern( rcvo.getPattern() );
                linercbean.setCategory( rcvo.getCategory() );
                linercbean.setPrice(rcvo.getPrice());//金額の取得
                linercbean.setURL(rcvo.getUrl());//URLの取得

                rcbeanlist.add( linercbean );
            }

            listoutrcbean.setList( rcbeanlist );

            System.out.println( listoutrcbean );

            return listoutrcbean;
        } catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }

    }

    public ListOutSaleClothBean getSelectedRecommendCloth(int clothid, int min, int max)
    {
        try (
                Connection con = Dao.getConnection();)
        {
            SaleClothDao rcdao = new SaleClothDao( con );
            List<SaleClothVo> rcvolist = rcdao.getRecomCloth( clothid, min, max );

            ListOutSaleClothBean listoutrcbean = new ListOutSaleClothBean();
            List<SaleClothBean> rcbeanlist = new ArrayList<SaleClothBean>();
            for (SaleClothVo rcvo : rcvolist)
            {
                SaleClothBean linercbean = new SaleClothBean();
                linercbean.setColor( rcvo.getColor() );
                linercbean.setPattern( rcvo.getPattern() );
                linercbean.setCategory( rcvo.getCategory() );
                linercbean.setPrice(rcvo.getPrice());//金額の取得
                linercbean.setURL(rcvo.getUrl());//URLの取得

                rcbeanlist.add( linercbean );
            }

            listoutrcbean.setList( rcbeanlist );

            System.out.println( listoutrcbean );

            return listoutrcbean;
        } catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }

    }


   public UserSaleClothBean userSaleCloth(String userId)
    {
        UserSaleClothLineBean bean;
        UserSaleClothBean listbean;
        Collection<UserSaleClothVo> list;
        List<UserSaleClothLineBean> clothlist;
        try (
                Connection con = Dao.getConnection();)
        {
            //持ち服上のみ取得
            UserSaleClothDao uscdao = new UserSaleClothDao( con );
            list = uscdao.getTopUserCloth( userId );
            listbean = new UserSaleClothBean();

            clothlist = new ArrayList<>();
            for (UserSaleClothVo uscvo : list)
            {
                bean = new UserSaleClothLineBean();

                bean.setCategory( uscvo.getCategory() );
                bean.setColor( uscvo.getColor() );
                bean.setPattern( uscvo.getPattern() );
                bean.setSize( uscvo.getSize() );
                clothlist.add( bean );
            }

            //販売服上のみ取得
            list = uscdao.getTopSaleCloth();

            for (UserSaleClothVo uscvo : list)
            {
                bean = new UserSaleClothLineBean();

                bean.setCategory( uscvo.getCategory() );
                bean.setColor( uscvo.getColor() );
                bean.setPattern( uscvo.getPattern() );
                bean.setSize( uscvo.getSize() );
                clothlist.add( bean );
            }
            listbean.setTopclothlist( clothlist );

            //持ち服下のみ取得
            list = uscdao.getBottomUserCloth( userId );

            clothlist = new ArrayList<>();
            for (UserSaleClothVo uscvo : list)
            {
                bean = new UserSaleClothLineBean();

                bean.setCategory( uscvo.getCategory() );
                bean.setColor( uscvo.getColor() );
                bean.setPattern( uscvo.getPattern() );
                bean.setSize( uscvo.getSize() );
                clothlist.add( bean );
            }

            //販売服下のみ取得
            list = uscdao.getBottomSaleCloth();
            for (UserSaleClothVo uscvo : list)
            {
                bean = new UserSaleClothLineBean();

                bean.setCategory( uscvo.getCategory() );
                bean.setColor( uscvo.getColor() );
                bean.setPattern( uscvo.getPattern() );
                bean.setSize( uscvo.getSize() );
                clothlist.add( bean );
            }
            listbean.setBottomclothlist( clothlist );

            System.out.println( listbean );
            return listbean;//

        } catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }

    }

}
