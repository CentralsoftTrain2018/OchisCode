package dao;

import java.sql.Connection;

public class SaveCodeDao {

    private Connection connection;

    public SaveCodeDao(Connection connection)
    {
        super();
        this.connection = connection;
    }
}
