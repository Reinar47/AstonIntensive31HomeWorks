package hw2.Utils;

import java.sql.ResultSet;

public interface DBResult {
    ResultSet getResultSet(String query);
}
