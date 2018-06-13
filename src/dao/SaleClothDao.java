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
import vo.SaleClothVo;

public class SaleClothDao extends Dao
{

    public SaleClothDao(Connection con)
    {
        super(con);
    }

    //販売服の情報全てを取り出す
    private static final String SALECLOTHLIST_SQL =
            "select "
                    + "  ,size "
                    + "  ,color "
                    + "  ,pattern "
                    + "  ,category "
                    +"   ,price "
                    + "  ,url "
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

    //販売服をすべて
    public List<SaleClothVo> getRecomCloth()throws SQLException
    {
        List<SaleClothVo> list = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rset = null;

            /* Statementの作成 */
            stmt = con.prepareStatement(SALECLOTHLIST_SQL);

            rset = stmt.executeQuery();

            while(rset.next())
            {
                SaleClothVo recomvo = new SaleClothVo(
                        CategoryEnum.valueOf(rset.getString(1)),
                        ColorEnum.valueOf(rset.getString(2)),
                        PatternEnum.valueOf(rset.getString(3)),
                        SizeEnum.valueOf(rset.getString(4)),
                        rset.getInt(5),
                       rset.getString(6)

                        );
                list.add(recomvo);
            }
            return list;
    }

    //ユーザーの全持ち服を取得し、それぞれの持ち服に対するお勧め服を取得する
    public List<SaleClothVo> getSaleClothList(String userid, String minmax, String order) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet userClothSet = null;

        List<SaleClothVo> recomClothList = new ArrayList<SaleClothVo>();

        /* ユーザーの持ち服をすべて取得 */
        stmt = con.prepareStatement(
                "  select"
                        + "    clothid"
                        + " from "
                        + "   user_cloth"
                        + " where"
                        + "   userid = ?");
        stmt.setString(1, userid);

        userClothSet = stmt.executeQuery();

        //持ち服一つに対するお勧め服を取得(全持ち服分繰り返す)
        while (userClothSet.next()) {
            List<SaleClothVo> recomCloth = getRecomCloth(userClothSet.getInt(1), minmax, order);
            recomClothList.addAll(recomCloth);
        }

        System.out.println(recomClothList);

        return recomClothList;
    }

    //持ち服を指定して、お勧めの服を取得する
    public List<SaleClothVo> getRecomCloth(int clothid, String minmax,String order ) throws SQLException {
        List<SaleClothVo> recomClothList = new ArrayList<SaleClothVo>();
        PreparedStatement stmt = con.prepareStatement(
                "  select"
                //指定した持ち服の色に対するお勧めの色の服を取得
                        + "  sale_cloth.*"
                        + "  from"
                        + "   sale_cloth,"
                        + "   recommend,"
                        + "   user_cloth"
                        + " where"
                        + "  user_cloth.clothid = ? and"
                        + "  user_cloth.color = recommend.color and"
                        + "  sale_cloth.color = recommend.rec_color and"
                //持ち服の柄に対するお勧めの柄の服を取得
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
               //持ち服のカテゴリーに対するお勧めのカテゴリーの服を取得
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
                        + "  sale_cloth.category = recommend.rec_category) and"
               //金額によって絞込みを行う
                        + minmax
               //並び替え
                        + " order by "
                        + order
                );
        //持ち服の指定
        stmt.setInt(1, clothid);
        stmt.setInt(2, clothid);
        stmt.setInt(3, clothid);
        //絞込みの範囲を決定

        //stmt.setInt(4, min);
        //stmt.setInt(5, max);
        //並び替えの指定　新古と金額の昇順降順
        //stmt.setString(6, order);

        /* SQL実行 */
        ResultSet recomClothSet = stmt.executeQuery();

        while (recomClothSet.next()) {
            SaleClothVo recomCloth = new SaleClothVo(
                    CategoryEnum.valueOf(recomClothSet.getString(6)),
                    ColorEnum.valueOf(recomClothSet.getString(4)),
                    PatternEnum.valueOf(recomClothSet.getString(5)),
                    SizeEnum.valueOf(recomClothSet.getString(2)),
                    recomClothSet.getInt(3),
                    recomClothSet.getString(8));

            recomClothList.add(recomCloth);
        }

        return recomClothList;
    }
}
