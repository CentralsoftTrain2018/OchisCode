package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import bean.LineRecomClothBean;
import bean.ListOutRecomClothBean;

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
                    + "   clothid "
                    + "  ,size "
                    + "  ,price "
                    + "  ,colorid "
                    + "  ,patternid "
                    + "  ,categoryid "
                    + "from   "
                    + "   sale_cloth ";


    public LineRecomClothBean doList()throws SQLException
    {

        PreparedStatement stmt = null;
        ResultSet rset = null;
        LineRecomClothBean bean = new LineRecomClothBean();
        List<ListOutRecomClothBean> list = new ArrayList<ListOutRecomClothBean>();

            /* Statementの作成 */
 /*           stmt = this.connection.prepareStatement(SALECLOTHLIST_SQL);

            rset = stmt.executeQuery();

            while(rset.next())
            {
                ListOutRecomClothBean recom = new ListOutRecomClothBean();

            }
        bean.setList(list);
        return bean;*/
        return null;
    }
}
