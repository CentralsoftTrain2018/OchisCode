package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.Dao;
import domain.SexEnum;
import domain.SizeEnum;

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
            //TODO 処理を追加
            System.out.println( userId +"-"+ password +"-"+ userHeight +"-"+size+"-"+budget+"-"+sex );
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
