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
            + "   categoryname "
            + "  ,colorname "
            + "  ,patternname "
            + "  ,size "
            + " from   "
            + " user_cloth "
            + " ,pattern"
            + " ,color"
            + " ,category"
            + " where"
            + " user_cloth.colorid = color.colorid"
            + " AND"
            + " user_cloth.patternid = pattern.patternid"
            + " AND"
            + " user_cloth.categoryid = category.categoryid"
            + " AND"
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
                    + ") "
                    + " valuse("
                    +  "	?,"
                    + "    ?, "
                    + "    ?, "
                    + "    ?, "
                    + "    ? "
                    +")";

    //ユーザーの持ち服一覧をDBから取得し、Listで返す
    public Collection<UserClothVo> getAllUserCloth(int id) throws SQLException
    {
        List<UserClothVo> list = new ArrayList<>();
        try (
                PreparedStatement stmt = con.prepareStatement( LISTUSERCLOTHES_SQL );)
        {
            stmt.setInt( 1, id );
            ResultSet rset = stmt.executeQuery();
            //レコードがなくなるまでVoを生成してArrayListに追加
            while (rset.next())
            {
                UserClothVo user = new UserClothVo(
                        CategoryEnum.valueOf( rset.getString( 1 ) ),
                        ColorEnum.valueOf( rset.getString( 2 ) ),
                        PatternEnum.valueOf( rset.getString( 3 ) ),
                        SizeEnum.valueOf( rset.getString( 4 ) ) );

                list.add( user );
            }
        } catch (SQLException e)
        {
            throw e;
        }
        return list;
    }
}
