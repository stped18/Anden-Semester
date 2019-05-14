package Data_layer;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class DatabaseHandler {

    private DatabaseConnection dc;
    private static Statement statement = null;

    public DatabaseHandler() {
        dc.connectToDB();
    }

    public boolean update(String emne, Map<String, String> coloumn, Map<String, String> value) {

        try {

            DatabaseMetaData metadata = dc.dbConnection.getMetaData();
            ResultSet resultSet;
            resultSet = metadata.getTables(null, null, "tablename", null);
            if (resultSet.next()) 
            {
                // Table exists
                resultSet = metadata.getColumns(null, null, "tablename", coloumn.get(dc));
            }
            if (resultSet.next()) {
                // Column exists
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Exception at update:DatabaseHandler"
                    + "database access error occured" + e.getLocalizedMessage());
            return false;
        }
        return false;
    

    }
}

