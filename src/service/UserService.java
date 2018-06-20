package service;

import java.sql.Connection;
import java.sql.SQLException;

import bean.UserInfoBean;
import dao.Dao;
import dao.UserDao;
import domain.SexEnum;
import domain.SizeEnum;
import vo.UserVo;

//ユーザー情報関係のサービス
//作成：功刀
public class UserService
{
    //ユーザー登録
    public boolean registUser(String userId, String password, int userHeight, SizeEnum size, int budget, SexEnum sex)
    {
        try (
                Connection con = Dao.getConnection();)
        {
            UserVo userVo = new UserVo( userId, password, userHeight, size, budget, sex );
            UserDao userDao = new UserDao( con );

            //登録を実行し登録結果の有無を返す
            return userDao.put( userVo );
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }
    }

    //ユーザー登録情報変更
    public void updateUser(UserInfoBean userBean)
    {
        try (
                Connection con = Dao.getConnection();)
        {
            UserDao userdao = new UserDao(con);

            userdao.update(userBean);
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }
    }

    //ユーザー情報削除
    public void deleteUser(String userId)
    {
        try (
                Connection con = Dao.getConnection();)
        {
            UserDao userDao = new UserDao( con );
            userDao.deleteUser( userId );

        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }
    }
    //ユーザーのIDとpasswordが正しいか確認する。
    public UserInfoBean checkUser(String user,String password)
    {
        try (
                Connection con = Dao.getConnection();)
        {

            UserDao userDao =new UserDao(con);
            UserVo uvo=userDao.checkUser(user,password);

            UserInfoBean bean=new UserInfoBean();

            //ID,PASSが一致していた場合
            if(uvo != null) {
                bean.setUserid(uvo.getUserId());
                bean.setPassword(uvo.getPassword());
                bean.setUserheight(uvo.getUserHeight());
                bean.setSize(uvo.getSize());
                bean.setBudget(uvo.getBudget());
                bean.setSex(uvo.getSex());
                bean.setUserExist(true);

            return bean;
            }

            bean.setUserExist(false);
            return bean;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }
    }

}
