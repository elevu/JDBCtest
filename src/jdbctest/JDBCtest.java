package jdbctest;

import java.sql.SQLException;

public class JDBCtest {

    public static void main(String[] args) throws SQLException {

        OperationsOnArtist.openConnection();

        UI.MainMenu();

    }

}
