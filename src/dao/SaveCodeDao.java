package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.SaleClothVo;
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

    //コーデの服情報の取り出し
    public List<SaleClothVo> getRecomCloth()throws SQLException
    {
        List<SaveCodeVo> list = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rset = null;

            /* Statementの作成 */
            stmt = con.prepareStatement(CoordinateOut_SQL);

            rset = stmt.executeQuery();

            return null;
    }
}
