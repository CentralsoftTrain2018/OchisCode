package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.SexEnum;
import domain.SizeEnum;
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

    private static final String GETUSERIDPASSSQL= "SELECT "
            + " *"
            + "FROM "
            + "user "
            + "where "
            + "userid = ?"
            + " AND"
            + " password = ?";

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
    public void update() throws SQLException
    {

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

    //ユーザー情報の取得
    public UserVo checkUser(String user, String password) throws SQLException
    {
         try (
                    PreparedStatement stmt = con.prepareStatement( GETUSERIDPASSSQL );)
            {
                stmt.setString( 1, user );
                stmt.setString(2, password);
               // System.out.println("検索ID："+user);
                ResultSet rset = stmt.executeQuery();//sql実行

                UserVo uvo = null;

                while (rset.next())
                {
                    System.out.println("a"+rset.getString(1));
                    uvo=new UserVo(
                          rset.getString( 1 ),
                          rset.getString( 2 ),
                          rset.getInt( 3 ),
                          SizeEnum.valueOf(rset.getString(4)),
                          rset.getInt(5),
                          SexEnum.valueOf(rset.getString(6))
                        );

                }

                return uvo;
            }
             catch (SQLException e)
            {
                throw e;
            }


    }
}
