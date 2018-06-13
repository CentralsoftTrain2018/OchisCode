package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    //登録
    public void put(UserVo vo) throws SQLException
    {
        try (
                PreparedStatement stmt = con.prepareStatement( REGISTUSERSQL );)
        {
            System.out.println( "Dao" );
            //stmtに値をセット
            stmt.setString( 1, vo.getUserId() );
            stmt.setString( 2, vo.getPassword() );
            stmt.setInt( 3, vo.getUserHeight() );
            stmt.setString( 4, vo.getSize().name() );
            stmt.setInt( 5, vo.getBudget() );
            stmt.setString( 6, vo.getSex().name() );
            int i = stmt.executeUpdate();
        } catch (SQLException e)
        {
            throw e;
        }
    }

    //変更
    public void update() throws SQLException
    {

    }
}
