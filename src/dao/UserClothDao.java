package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import domain.SizeEnum;
import vo.UserClothVo;

public class UserClothDao extends Dao
{
    public UserClothDao(Connection con)
    {
        super( con );
    }

    //持ち服抽出用SQL文
    private static final String LISTUSERCLOTHES_SQL = "select"
            + "   clothid"
            + "  ,category "
            + "  ,color "
            + "  ,pattern "
            + "  ,size "
            + " from   "
            + " user_cloth "
            + " where"
            + " user_cloth.userid = ? ";

    //持ち服追加SQL文
    private static final String REGIIST_SQL =
            "insert "
                    + "into user_cloth( "
                    + "  userid"
                    + "  ,size"
                    + "  ,color"
                    + "  ,pattern"
                    + "  ,category"
                    + "  ,jouge"
                    + " ) "
                    + " values("
                    + "	   ?,"
                    + "    ?, "
                    + "    ?, "
                    + "    ?, "
                    + "    ?, "
                    + "    ? "
                    +") ";

    private static final String DELETE_SQL = "delete "
            + " from"
            + " user_cloth"
            + " where"
            + " clothid = ?";

    //ユーザーの持ち服一覧をDBから取得し、Listで返す
    public Collection<UserClothVo> getAllUserCloth(String id, String narrow, String limit, String offset) throws SQLException
    {
        List<UserClothVo> list = new ArrayList<>();
        try (
                PreparedStatement stmt = con.prepareStatement( LISTUSERCLOTHES_SQL + narrow);)
        {
            stmt.setString( 1, id );
            ResultSet rset = stmt.executeQuery();

            //レコードがなくなるまでVoを生成してArrayListに追加
            while (rset.next())
            {
                UserClothVo user = new UserClothVo(
                        rset.getInt(1),
                        CategoryEnum.valueOf( rset.getString( 2 ) ),
                        ColorEnum.valueOf( rset.getString( 3 ) ),
                        PatternEnum.valueOf( rset.getString( 4 ) ),
                        SizeEnum.valueOf( rset.getString( 5 ) ) );

                list.add( user );
            }
        } catch (SQLException e)
        {
            throw e;
        }
        return list;
    }

    //持ち服登録 作成：野間
    public void doRegist(UserClothVo user) throws SQLException
    {
        try(
                PreparedStatement stmt = con.prepareStatement(REGIIST_SQL
                       /* java.sql.Statement.RETURN_GENERATED_KEYS*/);)
        {
            stmt.setString(1, user.getUserid());
            stmt.setString(2, user.getSize().name());
            stmt.setString(3,user.getColor().name());
            stmt.setString(4,user.getPattern().name());
            stmt.setString(5,user.getCategory().name());
            stmt.setString(6, user.getCategory().getJouge().name());

            stmt.executeUpdate();
        }catch(SQLException e)
        {
            throw e;
        }

    }

    //持ち服削除
    public void doDelete(int clothid) throws SQLException {
        try (
                PreparedStatement stmt = con.prepareStatement( DELETE_SQL);)
        {
            stmt.setInt(1, clothid);

            stmt.executeUpdate();

        }catch (SQLException e)
        {
            throw e;
        }
    }
}
