package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.UserInfoBean;
import vo.UserVo;

//ユーザー関連のDao
//作成：功刀
public class UserDao extends Dao
{
    public UserDao(Connection con)
    {
        super( con );
    }

    //ユーザー登録用SQL文
    private static final String REGISTUSERSQL = " INSERT INTO"
            + " user("
            + " userid,"
            + " password,"
            + " height,"
            + " size,"
            + " budget,"
            + " sex"
            + " )"
            + " values("
            + " ?,"
            + " ?,"
            + " ?,"
            + " ?,"
            + " ?,"
            + " ? )";

    //ユーザー検索用SQL文
    private static final String SEARCHUSERSQL = "SELECT "
            + "* "
            + "FROM "
            + "user "
            + "where "
            + "userid = ?";

    //ユーザ変更用SQL文
    private static final String UPDATEUSERSQL = "UPDATE "
            + " user"
            + " SET"
            + " height = ?,"
            + " size = ?,"
            + " budget = ?,"
            + " sex = ?"
            + " WHERE"
            + " userid = ?";

    //登録
    public boolean put(UserVo vo) throws SQLException
    {
        try (
                PreparedStatement stmt = con.prepareStatement( REGISTUSERSQL );)
        {
            System.out.println( "Dao" );

            if (this.isDup( vo ))
            {
                System.out.println( "重複あり、登録失敗" );
                return false;
            }
            //stmtに値をセット
            stmt.setString( 1, vo.getUserId() );
            stmt.setString( 2, vo.getPassword() );
            stmt.setInt( 3, vo.getUserHeight() );
            stmt.setString( 4, vo.getSize().name() );
            stmt.setInt( 5, vo.getBudget() );
            stmt.setString( 6, vo.getSex().name() );

            stmt.executeUpdate();
            System.out.println( "重複なし、登録" );
            return true;
        } catch (SQLException e)
        {
            throw e;
        }
    }

    //変更
    public void update(UserInfoBean userBean) throws SQLException
    {
        try (
                PreparedStatement stmt = con.prepareStatement( UPDATEUSERSQL );)
        {
            stmt.setInt(1, userBean.getUserheight());
            stmt.setString(2, userBean.getSize().name());
            stmt.setInt(3, userBean.getBudget());
            stmt.setString(4, userBean.getSex().name());

            stmt.setString(5, userBean.getUserid());
            int numline = stmt.executeUpdate();
            //numlineの値が1かを確認
            if(numline != 1)
            {
                 //1以外の場合RunTimeExceptionをnewしてthrow
                RuntimeException run = new RuntimeException("userIDがヒットしませんでした。");
                throw run;
            }

        }


    }

    //ユーザー検索
    private boolean isDup(UserVo vo) throws SQLException
    {
        try (
                PreparedStatement stmt = con.prepareStatement( SEARCHUSERSQL );)
        {
            System.out.println( "検索" );
            stmt.setString( 1, vo.getUserId() );
            System.out.println("検索ID："+vo.getUserId());
            ResultSet rset = stmt.executeQuery();

            String userId = null;

            while (rset.next())
            {
            userId = rset.getString( 1 );
            }

            if (userId != null)
            {
                System.out.println("重複");
                return true;
            }

            System.out.println("重複なし");
            return false;
        } catch (SQLException e)
        {
            throw e;
        }
    }
}
