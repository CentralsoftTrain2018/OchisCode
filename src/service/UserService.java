package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.Dao;

public class UserService
{
    //ユーザー登録
    public void registUser()
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
