package service;

import java.sql.Connection;
import java.sql.SQLException;

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
    public void registUser(String userId,String password,int userHeight,SizeEnum size,int budget,SexEnum sex)
    {
        try (
                Connection con = Dao.getConnection();)
        {
            UserVo userVo =new UserVo(userId, password, userHeight, size, budget, sex);
            UserDao userDao =new UserDao(con);
            System.out.println( "サービス：登録開始" );
            userDao.put(userVo);
            System.out.println( "サービス：登録完了" );
        } catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }
    }

    //ユーザー登録情報変更
    public void updateUser()
    {
        try (
                Connection con = Dao.getConnection();)
        {
            //TODO 処理を追加
        } catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }
    }
}
