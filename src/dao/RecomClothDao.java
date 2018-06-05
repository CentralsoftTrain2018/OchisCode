package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecomClothDao
{

    private Connection connection;

    public KaiinManager(Connection connection)
    {
        super();
        this.connection = connection;
    }

    private static final String KAIINNLIST_SQL =
            "select "
                    + "   id "
                    + "  ,name "
                    + "  ,date "
                    + "  ,sex "
                    + "from   "
                    + "   member ";

    private static final String KAIINN_SQL =
            "select "
                    + "   id "
                    + "  ,name "
                    + "  ,date "
                    + "  ,sex "
                    + "from   "
                    + "   member "
                    + "WHERE "
                    + " id = ? ";

    private static final String REGIIST_SQL =
            "insert "
                    + "into member( "
                    +  "	id, "
                    +  "    name ,"
                    +"      date, "
                    +"      sex "
                    + ") "
                    + "values ("
                    +  "	?, "
                    + "    ?, "
                    + "    ?, "
                    + "    ? "
                    +")";

    public boolean doRegist(KaiinVo kaiin) throws SQLException
    {
        SearchBean existKaiin = doSearch(kaiin.getId());

        if(existKaiin.getName() == null) {
            PreparedStatement stmt = null;

            /* Statementの作成 */
            stmt = this.connection.prepareStatement(REGIIST_SQL);

            stmt.setInt(1, kaiin.getId());
            stmt.setString(2, kaiin.getName());
            stmt.setDate(3, kaiin.getDate());
            stmt.setString(4, kaiin.getSex().toString());

            stmt.executeUpdate();

            return true;
        }
        return false;
    }

    public SearchBean doSearch(int id) throws SQLException
    {
        PreparedStatement stmt = null;
        ResultSet rset = null;
        SearchBean bean = new SearchBean();

        /* Statementの作成 */
        stmt = this.connection.prepareStatement(KAIINN_SQL);

        stmt.setInt(1, id);

        rset = stmt.executeQuery();

        while (rset.next())
        {
            bean.setId(rset.getInt(1));
            bean.setName(rset.getString(2));
            bean.setDate(rset.getDate(3));
            bean.setSex(rset.getString(4));
            bean.setMessege("検索しました");
        }

        return bean;
    }

    public ListoutBean doList()throws SQLException
    {

        PreparedStatement stmt = null;
        ResultSet rset = null;
        ListoutBean bean = new ListoutBean();
        List<KaiinBean> list = new ArrayList<KaiinBean>();

            /* Statementの作成 */
            stmt = this.connection.prepareStatement(KAIINNLIST_SQL);

            rset = stmt.executeQuery();

            while(rset.next())
            {
                KaiinBean kaiin = new KaiinBean();

                kaiin.setId(rset.getInt(1));
                kaiin.setName(rset.getString(2));
                kaiin.setDate(rset.getDate(3));
                kaiin.setSex(rset.getString(4));

                list.add(kaiin);
            }
        bean.setList(list);
        return bean;
    }
}
