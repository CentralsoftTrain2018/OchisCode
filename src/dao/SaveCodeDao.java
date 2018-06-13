package dao;

import java.sql.Connection;

public class SaveCodeDao {

    private Connection connection;

    public SaveCodeDao(Connection connection)
    {
        super();
        this.connection = connection;
    }

    //作成者<野間>
    //登録したコーデの服情報を全て取り出す
    private static final String CoordinateOut_SQL =
            "select "
                    +" ,code_number"
                    + " ,userid"
                    + " ,tops_color"
                    + " ,bottoms_color"
                    + " ,tops_pattern"
                    + " ,botoms_pattern"
                    + " ,tops_category"
                    + " ,botoms_category"
                    + "from"
                    + " save_code";
}
