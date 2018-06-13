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
import vo.SaveCodeVo;

public class SaveCodeDao extends Dao{

    public SaveCodeDao(Connection con)
    {
        super(con);
    }

    //作成者<野間>
    //登録したコーデの服情報を全て取り出す
    private static final String CoordinateOut_SQL =
            "select "
                    +" code_number"
                    + " ,userid"
                    + " ,tops_color"
                    + " ,bottoms_color"
                    + " ,tops_pattern"
                    + " ,botoms_pattern"
                    + " ,tops_category"
                    + " ,botoms_category"
                    + " ,tops_size"
                    + " ,botoms_size"
                    + "from"
                    + " save_code";

    private static final String RegistCoordinate_SQL =
            "insert "
                    + "into save_code( "
                    + "  userid"
                    + "  ,tops_color"
                    + "  ,bottoms_color"
                    + "  ,tops_pattern"
                    + "  ,bottoms_pattern"
                    + "  ,tops_category"
                    + "  ,bottoms_category"
                    + "  ,tops_size"
                    + "  ,bottoms_size"
                    + " ) "
                    + " values("
                    + "	   ?, "
                    + "    ?, "
                    + "    ?, "
                    + "    ?, "
                    + "    ?, "
                    + "    ?, "
                    + "    ?, "
                    + "    ?, "
                    + "    ? "
                    +")";


    //コーデの服情報の取り出し
    public List<SaveCodeVo> getRecomCloth()throws SQLException
    {
        List<SaveCodeVo> list = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rset = null;

            /* Statementの作成 */
            stmt = con.prepareStatement(CoordinateOut_SQL);

            rset = stmt.executeQuery();

            while(rset.next())
            {
                SaveCodeVo recomvo = new SaveCodeVo(
                        rset.getInt(1),
                        rset.getString(2),
                        ColorEnum.valueOf(rset.getString(3)),
                        ColorEnum.valueOf(rset.getString(4)),
                        CategoryEnum.valueOf(rset.getString(5)),
                        CategoryEnum.valueOf(rset.getString(6)),
                        PatternEnum.valueOf(rset.getString(7)),
                        PatternEnum.valueOf(rset.getString(8)),
                        SizeEnum.valueOf(rset.getString(9)),
                        SizeEnum.valueOf(rset.getString(10))
                        );
                list.add(recomvo);
            }

            return list;
    }

    public void registCode(SaveCodeVo savecode) throws SQLException {
        PreparedStatement stmt = null;

        /* Statementの作成 */
        stmt = con.prepareStatement(RegistCoordinate_SQL);
        stmt.setString(1, savecode.getUserid());
        stmt.setString(2, savecode.getTopscolor().name());
        stmt.setString(3, savecode.getBottomscolor().name());
        stmt.setString(4, savecode.getTopspattern().name());
        stmt.setString(5, savecode.getBottomspattern().name());
        stmt.setString(6, savecode.getTopscategory().name());
        stmt.setString(7, savecode.getBottomscategory().name());
        stmt.setString(8, savecode.getTopssize().name());
        stmt.setString(9, savecode.getBottomssize().name());

        System.out.println("確認");
        int i =stmt.executeUpdate();
        System.out.println("確認1");
    }
}
