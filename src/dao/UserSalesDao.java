package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import domain.SizeEnum;
import vo.UserSaleClothVo;

public class UserSalesDao extends Dao
{
    public UserSalesDao(Connection con)
    {
        super( con );
    }
    //販売服のSQL
    private static final String TOPSALECLOTHLIST_SQL =
            "select "
                    + "   category "
                    + "  ,color "
                    + "  ,pattern "
                    + "  ,size "
                    +"   from   "
                    +"   sale_cloth "
                    +" where "
                    +" jouge=\"上\"";

    private static final String BOTTOMSALECLOTHLIST_SQL =
            "select "
                    + "   category "
                    + "  ,color "
                    + "  ,pattern "
                    + "  ,size "
                    +"   from   "
                    +"   sale_cloth "
                    +" where "
                    +" jouge=\"下\" ";

    //持ち服取得のSQL
    private static final String TOPLISTUSERCLOTHES_SQL = "select"
            + "   category "
            + "  ,color "
            + "  ,pattern "
            + "  ,size "
            + " from   "
            + " user_cloth "
            + " where"
            + " user_cloth.userid = ? "
            + " AND"
            + " jouge =\"上\"";

    private static final String BOTTOMLISTUSERCLOTHES_SQL = "select"
            + "   category "
            + "  ,color "
            + "  ,pattern "
            + "  ,size "
            + " from   "
            + " user_cloth "
            + " where"
            + " user_cloth.userid = ? "
            + " AND"
            + " jouge = \"下\" ";


    //販売服上一覧を取得する
    public List<UserSaleClothVo>getTopSaleCloth()throws SQLException
    {
        List<UserSaleClothVo> list = new ArrayList<>();

        ResultSet rset = null;

        /* Statementの作成 */
        try(
                PreparedStatement stmt = con.prepareStatement(TOPSALECLOTHLIST_SQL);
                )
        {
            rset = stmt.executeQuery();

            while(rset.next())
            {
                UserSaleClothVo recomvo = new UserSaleClothVo(
                        CategoryEnum.valueOf(rset.getString(1)),
                        ColorEnum.valueOf(rset.getString(2)),
                        PatternEnum.valueOf(rset.getString(3)),
                        SizeEnum.valueOf(rset.getString(4)),
                        true
                        );
                list.add(recomvo);
            }

        }
        catch (SQLException e)
        {
            throw e;
        }
        return list;
    }
    //販売服下一覧を取得
    public List<UserSaleClothVo>getBottomSaleCloth()throws SQLException
    {
        List<UserSaleClothVo> list = new ArrayList<>();

        ResultSet rset = null;

        /* Statementの作成 */
        try(
                PreparedStatement stmt = con.prepareStatement(TOPSALECLOTHLIST_SQL);
                )
        {
            rset = stmt.executeQuery();

            while(rset.next())
            {
                UserSaleClothVo recomvo = new UserSaleClothVo(
                        CategoryEnum.valueOf(rset.getString(1)),
                        ColorEnum.valueOf(rset.getString(2)),
                        PatternEnum.valueOf(rset.getString(3)),
                        SizeEnum.valueOf(rset.getString(4)),
                        true
                        );
                list.add(recomvo);
            }

        }
        catch (SQLException e)
        {
            throw e;
        }
        return list;
    }


    //持ち服一覧上を取得
    public List<UserSaleClothVo>getTopUserCloth(int id)throws SQLException
    {
        List<UserSaleClothVo> list = new ArrayList<>();

        ResultSet rset = null;

        /* Statementの作成 */
        try(
                PreparedStatement stmt = con.prepareStatement( TOPLISTUSERCLOTHES_SQL);
                )
        {
            stmt.setInt( 1, id );
            rset = stmt.executeQuery();

            while(rset.next())
            {
                UserSaleClothVo recomvo = new UserSaleClothVo(
                        CategoryEnum.valueOf(rset.getString(1)),
                        ColorEnum.valueOf(rset.getString(2)),
                        PatternEnum.valueOf(rset.getString(3)),
                        SizeEnum.valueOf(rset.getString(4)),
                        false
                        );
                list.add(recomvo);
            }

        }
        catch (SQLException e)
        {
            throw e;
        }
        return list;
    }
    //持ち服一覧上を取得
    public List<UserSaleClothVo>getBottomUserCloth(int id)throws SQLException
    {
        List<UserSaleClothVo> list = new ArrayList<>();

        ResultSet rset = null;

        /* Statementの作成 */
        try(
                PreparedStatement stmt = con.prepareStatement( TOPLISTUSERCLOTHES_SQL);
                )
        {
            stmt.setInt( 1, id );
            rset = stmt.executeQuery();

            while(rset.next())
            {
                UserSaleClothVo recomvo = new UserSaleClothVo(
                        CategoryEnum.valueOf(rset.getString(1)),
                        ColorEnum.valueOf(rset.getString(2)),
                        PatternEnum.valueOf(rset.getString(3)),
                        SizeEnum.valueOf(rset.getString(4)),
                        false
                        );
                list.add(recomvo);
            }

        }
        catch (SQLException e)
        {
            throw e;
        }
        return list;
    }
}


