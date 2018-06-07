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
import vo.RecomClothVo;

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

    public List<RecomClothVo> getRecomClothList(int userid) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet userClothSet = null;

        List<RecomClothVo> recomClothList = new ArrayList<RecomClothVo>();

        /* ユーザーの持ち服にお勧めできる服のデザインを取得 */
        stmt = connection.prepareStatement(
                "  select"
                        + "    clothid"
                        + " from "
                        + "   user_cloth"
                        + " where"
                        + "   userid = ?");
        stmt.setInt(1, userid);

        userClothSet = stmt.executeQuery();

        while (userClothSet.next()) {
            List<RecomClothVo> recomCloth = getRecomCloth(userClothSet.getInt(1));
            recomClothList.addAll(recomCloth);
        }

        System.out.println(recomClothList);

        return recomClothList;
    }

    public List<RecomClothVo> getRecomCloth(int clothid) throws SQLException {
        List<RecomClothVo> recomClothList = new ArrayList<RecomClothVo>();
        PreparedStatement stmt = connection.prepareStatement(
                "  select"
                        + "  sale_cloth.*"
                        + "  from"
                        + "   sale_cloth,"
                        + "   recommend,"
                        + "   user_cloth"
                        + " where"
                        + "  user_cloth.clothid = ? and"
                        + "  user_cloth.color = recommend.color and"
                        + "  sale_cloth.color = recommend.rec_color and"
                        + "  sale_cloth.clothid in "
                        + "  (select"
                        + "  sale_cloth.clothid"
                        + "  from"
                        + "   sale_cloth,"
                        + "   recommend,"
                        + "   user_cloth"
                        + " where"
                        + "  user_cloth.clothid = ? and"
                        + "  user_cloth.pattern = recommend.pattern and"
                        + "  sale_cloth.pattern = recommend.rec_pattern)"
                        + " and"
                        + "  sale_cloth.clothid in "
                        + "  (select"
                        + "  sale_cloth.clothid"
                        + "  from"
                        + "   sale_cloth,"
                        + "   recommend,"
                        + "   user_cloth"
                        + " where"
                        + "  user_cloth.clothid = ? and"
                        + "  user_cloth.category = recommend.category and"
                        + "  sale_cloth.category = recommend.rec_category)");

        //持ち服の指定
        stmt.setInt(1, clothid);
        stmt.setInt(2, clothid);
        stmt.setInt(3, clothid);

        /* ｓｑｌ実行 */
        ResultSet recomClothSet = stmt.executeQuery();

        while (recomClothSet.next()) {
            RecomClothVo recomCloth = new RecomClothVo(
                    CategoryEnum.valueOf(recomClothSet.getString(6)),
                    ColorEnum.valueOf(recomClothSet.getString(4)),
                    PatternEnum.valueOf(recomClothSet.getString(5)),
                    SizeEnum.valueOf(recomClothSet.getString(2)));

            recomClothList.add(recomCloth);
        }
        return recomClothList;
    }
}
