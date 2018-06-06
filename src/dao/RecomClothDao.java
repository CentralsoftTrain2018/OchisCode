package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Vo.RecomClothVo;
import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import domain.SizeEnum;

public class RecomClothDao
{
    private Connection connection;

    public RecomClothDao(Connection connection)
    {
        super();
        this.connection = connection;
    }

    //服の情報全てを取り出す
    private static final String SALECLOTHLIST_SQL =
            "select "
                    + "  ,size "
                    + "  ,color "
                    + "  ,pattern "
                    + "  ,category "
                    + "from   "
                    + "   sale_cloth "
                    + "Join "
                    + "   color"
                    + "On "
                    + " sale_cloth.colorid = color.colorid"
                    + "Join "
                    + " category"
                    + "On"
                    + " sale_cloth.categoryid = category.categoryid"
                    + "Join "
                    + " pattern"
                    + " On"
                    + " sale_cloth.patternid = pattern.patternid";

    public List<RecomClothVo> getRecomCloth()throws SQLException
    {
        List<RecomClothVo> list = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rset = null;

            /* Statementの作成 */
            stmt = this.connection.prepareStatement(SALECLOTHLIST_SQL);

            rset = stmt.executeQuery();

            while(rset.next())
            {
                RecomClothVo recomvo = new RecomClothVo(
                        CategoryEnum.valueOf(rset.getString(1)),
                        ColorEnum.valueOf(rset.getString(2)),
                        PatternEnum.valueOf(rset.getString(3)),
                        SizeEnum.valueOf(rset.getString(4))
                        );
                list.add(recomvo);
            }
            return list;
    }

    public void getRecomCloth(Connection con) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rset = null;

        /* ユーザーの持ち服にお勧めできる服のデザインを取得 */
        stmt =  con.prepareStatement(
                          "select "
                        + "   reccolor"
                        + " from"
                        + "   usercloth"
                        + "  ,salecloth"
                        + "  ,recommend"
                        + " where "
                        + "   userid = 1 and"
                        + "  (usercloth.color = recommend.color or"
                        + "   usercloth.pattern  = recommend.pattern or"
                        + "   usercloth.category = recommend.category) and"
                        + "  (salecloth.color = recommend.rec_color or"
                        + "   salecloth.pattern = salecloth.rec_pattern or"
                        + "   salecloth.category = salecloth.reccategory)");

        /* ｓｑｌ実行 */
        rset = stmt.executeQuery();

        /* 取得したデータを表示します。 */
        /*
        while (rset.next())
            {
                em.setEmployeeid(		rset.getInt(1) );
                em.setEmployeename( 	rset.getString(2));
                em.setHeight( 			rset.getBigDecimal(3));
                em.setEmail(			rset.getString(4));
                em.setWeight(			rset.getBigDecimal(5));
                em.setHirefiscalyear(	rset.getInt(6));
                em.setBirthday(			rset.getDate(7));
                em.setBloodtype(		rset.getString(4));
            }
            */
    }
}
